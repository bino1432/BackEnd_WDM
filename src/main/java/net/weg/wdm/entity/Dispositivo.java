package net.weg.wdm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Dispositivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long numero;

    @ManyToOne
    @JoinColumn(nullable = false)
    private TipoDispositivo tipo;

    @Column(nullable = false, length = 50)
    private String marca;

    @Column(nullable = false, length = 50)
    private String modelo;

    @OneToMany(mappedBy = "dispositivo")
    private List<DispositivoReservado> reservasDoDispositivo;

    @OneToMany(mappedBy = "dispositivo")
    private List<Manutencao> manutencoes;

    private String descricao;
    private boolean habilitado = true;
}
