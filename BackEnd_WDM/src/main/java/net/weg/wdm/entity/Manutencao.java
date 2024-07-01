package net.weg.wdm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Manutencao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private Usuario solicitante;
    private Dispositivo dispositivo;
    private String descricao;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private StatusManutencao status;
}
