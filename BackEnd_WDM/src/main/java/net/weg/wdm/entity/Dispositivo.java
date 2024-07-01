package net.weg.wdm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Dispositivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private TipoDispositivo tipo;
    private List<Reserva> reservas;
    private List<Manutencao> manutencoes;
    private String descricao;
}
