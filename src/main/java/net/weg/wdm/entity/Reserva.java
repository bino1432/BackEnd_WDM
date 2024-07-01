package net.weg.wdm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;
    private Usuario solicitante;
    private List<DispositivoReservado> dispositivoReservados;
    private StatusReserva status;
    private Ambiente ambiente;
    private Turma turma;
    private String comentario;
}
