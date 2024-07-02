package net.weg.wdm.controller.dto;

import java.time.LocalDate;
import java.util.List;

public class ReservaCadastro {
    private Long idUsuario;
    private Long idTurma;
    private List<Long> idDispositivos;
    private List<PeriodoReservaCadastro> Periodos;
    private LocalDate inicio;
    private LocalDate fim;
}
