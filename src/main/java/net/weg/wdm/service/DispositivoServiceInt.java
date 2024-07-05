package net.weg.wdm.service;

import net.weg.wdm.entity.Dispositivo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DispositivoServiceInt {

    List<Dispositivo> buscarDispositivosPorId(List<Long> id);

}
