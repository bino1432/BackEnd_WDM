package net.weg.wdm.service;

import net.weg.wdm.controller.dto.reserva.PeriodoReservaRequestPostDTO;
import net.weg.wdm.controller.dto.reserva.ReservaRequestPostDTO;
import net.weg.wdm.entity.Reserva;
import net.weg.wdm.entity.SolicitacaoReserva;

import java.time.LocalDate;

public class SolicitacaoReservaServiceImpl implements SolicitacaoReservaServiceInt{
    @Override
    public SolicitacaoReserva criarReservas(ReservaRequestPostDTO reservaDTO) {
        SolicitacaoReserva solicitacaoReserva = null;

        LocalDate data = reservaDTO.getInicio();
        do {

            for(PeriodoReservaRequestPostDTO periodoDTO : reservaDTO.getPeriodos()){
                for(Long idDispositivo : reservaDTO.getIdDispositivos()){

                }
            }

            data = data.plusDays(1);
        } while (data.isBefore(reservaDTO.getFim().plusDays(1)));

        return solicitacaoReserva;
    }
}
