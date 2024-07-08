package net.weg.wdm.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@RequiredArgsConstructor
public class DispositivoReservado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NonNull
    @JoinColumn(nullable = false)
    private Dispositivo dispositivo;

    private LocalDateTime retirada;
    private LocalDateTime devolucao;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Reserva reserva;
}
