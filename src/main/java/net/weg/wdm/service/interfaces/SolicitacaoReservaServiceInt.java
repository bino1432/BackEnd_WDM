package net.weg.wdm.service.interfaces;

import net.weg.wdm.controller.dto.reserva.SolicitacaoReservaRequestPostDTO;
import net.weg.wdm.entity.SolicitacaoReserva;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SolicitacaoReservaServiceInt {
    SolicitacaoReserva criarSolicitacaoReservas(SolicitacaoReservaRequestPostDTO reservaDTO);
    SolicitacaoReserva buscarSolicitacao(Long id);
    List<SolicitacaoReserva> buscarTodasSolicitacoes();
    Page<SolicitacaoReserva> buscarTodasSolicitacoesPage(Pageable pageable);
}
