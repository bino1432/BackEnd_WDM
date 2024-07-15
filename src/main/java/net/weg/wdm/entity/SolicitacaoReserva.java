package net.weg.wdm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wdm.controller.dto.reserva.PeriodoReservaRequestPostDTO;
import net.weg.wdm.controller.dto.reserva.ReservaResponseDTO;
import net.weg.wdm.controller.dto.reserva.SolicitacaoReservaRequestPostDTO;
import net.weg.wdm.controller.dto.reserva.SolicitacaoReservaResponseDTO;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    public SolicitacaoReserva(
            SolicitacaoReservaRequestPostDTO reservaDTO,
            Map<TipoDispositivo, List<Dispositivo>> dispositivos) {

        Set<TipoDispositivo> tipos = dispositivos.keySet();

        List<Reserva> reservas = new ArrayList<>();
        this.setReservas(reservas);

        LocalDate data = reservaDTO.inicio();
        do {
            for(PeriodoReservaRequestPostDTO periodoDTO : reservaDTO.periodos()){
                DayOfWeek diaDaSemana = data.getDayOfWeek();
                if (periodoDTO.diaSemana().ordinal() == diaDaSemana.ordinal()){
                    for(TipoDispositivo tipo : tipos){
                        List<DispositivoReservado> dispositivoReservados =
                                dispositivos.get(tipo).stream().map(
                                    DispositivoReservado::new).toList();

                        Reserva reserva = new Reserva(reservaDTO, periodoDTO, data, dispositivoReservados);
                        reservas.add(reserva);

                    }
                }
            }

            data = data.plusDays(1);
        } while (data.isBefore(reservaDTO.fim().plusDays(1)));
    }

    public SolicitacaoReservaResponseDTO toDTO() {

        List<ReservaResponseDTO> reservas = this.reservas.stream().map(
                reserva -> reserva.toDTO()).toList();

        return new SolicitacaoReservaResponseDTO(this.id, reservas);
    }
}
