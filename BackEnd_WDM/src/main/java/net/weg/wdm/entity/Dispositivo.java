package net.weg.wdm.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Dispositivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long numero;
    private TipoDispositivo tipo;
    @Column(nullable = false, length = 50)
    private String marca;
    @Column(nullable = false, length = 50)
    private String modelo;
    private List<Reserva> reservas;
    private List<Manutencao> manutencoes;
    private String descricao;
    private boolean habilitado = true;
}
