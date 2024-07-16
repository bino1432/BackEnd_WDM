package net.weg.wdm.controller.dto.solicitacao;

import net.weg.wdm.controller.dto.periodo.PeriodoResponseDTO;
import net.weg.wdm.entity.Dispositivo;
import net.weg.wdm.entity.Turma;
import net.weg.wdm.entity.Usuario;

import java.time.LocalDate;
import java.util.List;

public record SolicitacaoResponseDTO(
        Usuario solicitante,
        Turma turma,
        List<Dispositivo> dispositivos,
        LocalDate inicio,
        LocalDate fim,
        List<PeriodoResponseDTO> periodos) {
}
