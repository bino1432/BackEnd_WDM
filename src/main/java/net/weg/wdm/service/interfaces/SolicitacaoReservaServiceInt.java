package net.weg.wdm.service.interfaces;

import net.weg.wdm.controller.dto.reserva.ReservaRequestPostDTO;
import net.weg.wdm.entity.SolicitacaoReserva;
import org.springframework.stereotype.Service;

@Service
public interface SolicitacaoReservaServiceInt {
    SolicitacaoReserva criarSolicitacaoReservas(ReservaRequestPostDTO reservaDTO);
}
