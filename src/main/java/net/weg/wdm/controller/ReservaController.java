package net.weg.wdm.controller;

import lombok.AllArgsConstructor;
import net.weg.wdm.controller.dto.reserva.ReservaRequestPostDTO;
import net.weg.wdm.entity.SolicitacaoReserva;
import net.weg.wdm.service.interfaces.ReservaServiceInt;
import net.weg.wdm.service.interfaces.SolicitacaoReservaServiceInt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/reserva")
public class ReservaController {

    private ReservaServiceInt reservaService;
    private SolicitacaoReservaServiceInt solicitacaoReservaService;

    @PostMapping
    public ResponseEntity<SolicitacaoReserva> cadastroReserva(
            @RequestBody ReservaRequestPostDTO reservaDTO){
        solicitacaoReservaService.criarReservas(reservaDTO);
        return new ResponseEntity<>(solicitacaoReservaService.criarReservas(reservaDTO), HttpStatus.OK);
//        return new ResponseEntity<>(new Reserva(), HttpStatus.OK);
    }
}
