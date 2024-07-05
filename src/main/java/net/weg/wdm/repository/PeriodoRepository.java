package net.weg.wdm.repository;

import net.weg.wdm.entity.Dispositivo;
import net.weg.wdm.entity.Periodo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodoRepository extends JpaRepository<Periodo, Long> {
}
