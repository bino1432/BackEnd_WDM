package net.weg.wdm.controller.dto.reserva;

import net.weg.wdm.entity.DiaSemana;

public record PeriodoReservaRequestPostDTO(
         Long idPeriodo,
         Long idAmbiente,
         DiaSemana diaSemana) {}
