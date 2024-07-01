package net.weg.wdm.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class GrupoDispositivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String nome;
    private List<Dispositivo> dispositivos;
}
