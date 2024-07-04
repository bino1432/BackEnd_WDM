package net.weg.wdm.controller.dto.reserva;

import java.time.LocalDate;
import java.util.List;

public class ReservaRequestPostDTO {
    private Long idUsuario;
    private Long idTurma;
    private List<Long> idDispositivos;
    private List<PeriodoReservaRequestPostDTO> Periodos;
    private LocalDate inicio;
    private LocalDate fim;
}
