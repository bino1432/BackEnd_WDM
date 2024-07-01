package net.weg.wdm.entity;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;

    @ManyToOne
    @Column(nullable = false)
    private Usuario solicitante;

    @OneToMany(mappedBy = "reserva")
    private List<DispositivoReservado> dispositivoReservados;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusReserva status;

    @ManyToOne
    private Ambiente ambiente;

    @ManyToOne
    @Column(nullable = false)
    private Turma turma;
    private String comentario;
}
