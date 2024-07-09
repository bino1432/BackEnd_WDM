package net.weg.wdm.service.implementation;

import lombok.AllArgsConstructor;
import net.weg.wdm.controller.dto.reserva.PeriodoReservaRequestPostDTO;
import net.weg.wdm.controller.dto.reserva.ReservaRequestPostDTO;
import net.weg.wdm.entity.*;
import net.weg.wdm.repository.SolicitacaoReservaRepository;
import net.weg.wdm.service.interfaces.SolicitacaoReservaServiceInt;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
@AllArgsConstructor
public class SolicitacaoReservaServiceImpl implements SolicitacaoReservaServiceInt {

    private final DispositivoServiceImpl dispositivoService;
    private final SolicitacaoReservaRepository repository;

    @Override
    public SolicitacaoReserva criarSolicitacaoReservas(ReservaRequestPostDTO reservaDTO){
        SolicitacaoReserva solicitacaoReserva = new SolicitacaoReserva();

        Map<TipoDispositivo, List<Dispositivo>> dispositivos =
                dispositivoService.buscarDispositivosPorIdSeparadosPorTipo(
                reservaDTO.getIdDispositivos());

        Set<TipoDispositivo> tipos = dispositivos.keySet();

        List<Reserva> reservas = new ArrayList<>();

        LocalDate data = reservaDTO.getInicio();
        do {
            for(PeriodoReservaRequestPostDTO periodoDTO : reservaDTO.getPeriodos()){
                DayOfWeek diaDaSemana = data.getDayOfWeek();
                if (periodoDTO.getDiaSemana().ordinal() == diaDaSemana.ordinal()){
                    for(TipoDispositivo tipo : tipos){

                        reservas.add(criarReserva(reservaDTO, tipo, periodoDTO, data, dispositivos));

                    }
                }
            }

            data = data.plusDays(1);
        } while (data.isBefore(reservaDTO.getFim().plusDays(1)));
        solicitacaoReserva.setReservas(reservas);
        return repository.save(solicitacaoReserva);
    }

    private Reserva criarReserva(ReservaRequestPostDTO reservaDTO, TipoDispositivo tipo,
                                 PeriodoReservaRequestPostDTO periodoDTO, LocalDate data,
                                 Map<TipoDispositivo, List<Dispositivo>> dispositivos) {

        Reserva reserva = new Reserva();

        reserva.setSolicitante(new Usuario(reservaDTO.getIdUsuario()));

        reserva.setDia(data);

        reserva.setPeriodo(new Periodo (periodoDTO.getIdPeriodo()));

        reserva.setAmbiente(new Ambiente(periodoDTO.getIdAmbiente()));

        reserva.setTurma(new Turma(reservaDTO.getIdTurma()));

        reserva.setDispositivoReservados(dispositivos.get(tipo).stream().map(
                                                        DispositivoReservado::new).toList());

        return reserva;
    }
}
