package net.weg.wdm.controller.dto.reserva;

import net.weg.wdm.entity.*;

import java.time.LocalDate;
import java.util.List;

public record ReservaResponseDTO(
        Long numero,
        String solicitante,
        List<DispositivoReservado> dispositivoReservados,
        String status,
        Ambiente ambiente,
        Turma turma,
        Periodo periodo,
        LocalDate dia,
        String comentario) { }