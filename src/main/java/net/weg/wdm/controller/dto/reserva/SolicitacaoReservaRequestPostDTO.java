package net.weg.wdm.controller.dto.reserva;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SolicitacaoReservaRequestPostDTO {
    private Long idUsuario;
    private Long idTurma;
    private List<Long> idDispositivos;
    private List<PeriodoReservaRequestPostDTO> periodos;
    private LocalDate inicio;
    private LocalDate fim;
}
