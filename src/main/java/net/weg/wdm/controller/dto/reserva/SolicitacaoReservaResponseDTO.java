package net.weg.wdm.controller.dto.reserva;

import net.weg.wdm.entity.Reserva;

import javax.swing.*;
import java.util.List;

public record SolicitacaoReservaResponseDTO(
        Long id,
        List<ReservaResponseDTO> reservas) { }