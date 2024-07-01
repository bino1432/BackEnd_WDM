package net.weg.wdm.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Manutencao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private Usuario solicitante;
    private Dispositivo dispositivo;
    @Column(nullable = false)
    private String descricao;
    private String feedback;
    @Column(nullable = false)
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    @Column(nullable = false)
    private StatusManutencao status;
}
