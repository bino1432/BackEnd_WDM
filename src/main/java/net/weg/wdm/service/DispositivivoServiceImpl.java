package net.weg.wdm.service;

import lombok.AllArgsConstructor;
import net.weg.wdm.entity.Dispositivo;
import net.weg.wdm.repository.DispositivoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class DispositivivoServiceImpl implements DispositivoServiceInt{

    private DispositivoRepository dispositivoRepository;

    @Override
    public List<Dispositivo> buscarDispositivosPorId(List<Long> ids) {
        return dispositivoRepository.findAllById(ids);

    }
}
