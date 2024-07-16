package net.weg.wdm.entity;

import com.fasterxml.jackson.databind.ser.std.UUIDSerializer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wdm.controller.dto.periodo.PeriodoReservaRequestPostDTO;
import net.weg.wdm.controller.dto.periodo.PeriodoResponseDTO;
import net.weg.wdm.controller.dto.reserva.ReservaResponseDTO;
import net.weg.wdm.controller.dto.solicitacao.SolicitacaoReservaRequestPostDTO;
import net.weg.wdm.controller.dto.solicitacao.SolicitacaoReservaResponseDTO;
import net.weg.wdm.controller.dto.solicitacao.SolicitacaoResponseDTO;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SolicitacaoReserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_solicitacao")
    private List<Reserva> reservas;

    @ManyToOne
    private Usuario solicitante;

    public SolicitacaoReserva(
            SolicitacaoReservaRequestPostDTO dto,
            Map<TipoDispositivo, List<Dispositivo>> dispositivos) {

        Set<TipoDispositivo> tipos = dispositivos.keySet();

        List<Reserva> reservas = new ArrayList<>();
        this.setReservas(reservas);

        this.solicitante = new Usuario(dto.idUsuario());

        LocalDate data = dto.inicio();
        do {
            for(PeriodoReservaRequestPostDTO periodoDTO : dto.periodos()){
                DayOfWeek diaDaSemana = data.getDayOfWeek();
                if (periodoDTO.diaSemana().ordinal() == diaDaSemana.ordinal()){
                    for(TipoDispositivo tipo : tipos){
                        List<DispositivoReservado> dispositivoReservados =
                                dispositivos.get(tipo).stream().map(
                                    DispositivoReservado::new).toList();

                        Reserva reserva = new Reserva(dto, periodoDTO, data, dispositivoReservados);
                        reservas.add(reserva);

                    }
                }
            }

            data = data.plusDays(1);
        } while (data.isBefore(dto.fim().plusDays(1)));
    }

    public SolicitacaoReservaResponseDTO toDTO() {

        List<ReservaResponseDTO> reservas = this.reservas.stream().map(
                reserva -> reserva.toDTO()).toList();

        return new SolicitacaoReservaResponseDTO(this.id, reservas);
    }

    public SolicitacaoResponseDTO toOtherDTO(){
        Reserva reserva = this.getReservas().get(0);
        Set<Dispositivo> dispositivos = new HashSet<>();
        LocalDate inicio = reserva.getDia();
        LocalDate fim = reserva.getDia();

        List<PeriodoResponseDTO> periodosDTO = new ArrayList<>();

        for(Reserva reserva1 : this.reservas){
            if(inicio.isAfter(reserva1.getDia())){
                inicio = reserva1.getDia();
            }
            if(fim.isBefore(reserva1.getDia())){
                fim = reserva1.getDia();
            }
            Periodo periodo;
            Ambiente ambiente;
            String diaSemana = "";

            for(DispositivoReservado dispositivoReservado : reserva1.getDispositivoReservados()){
                dispositivos.add(dispositivoReservado.getDispositivo());
            }
            periodo = reserva1.getPeriodo();
            ambiente = reserva1.getAmbiente();
            for(DiaSemana semana : DiaSemana.values()){
                if (semana.ordinal() == reserva1.getDia().getDayOfWeek().ordinal()){
                    diaSemana = semana.getNOME();
                    break;
                }
            }
            periodosDTO.add(new PeriodoResponseDTO(periodo, ambiente, diaSemana));
        }

        return new SolicitacaoResponseDTO(
                this.solicitante,
                reserva.getTurma(),
                new ArrayList<>(dispositivos),
                inicio,
                fim,
                periodosDTO
        );
    }
}
