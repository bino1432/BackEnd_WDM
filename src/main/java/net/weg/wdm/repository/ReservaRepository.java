package net.weg.wdm.repository;

import net.weg.wdm.entity.Dispositivo;
import net.weg.wdm.entity.Reserva;
import net.weg.wdm.entity.StatusReserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    // exists
    // delete
    // find
    // count
    List<Reserva> findAllByTurma_IdAndStatusOrderByDia(Long idTurma, StatusReserva statusReserva);

}
