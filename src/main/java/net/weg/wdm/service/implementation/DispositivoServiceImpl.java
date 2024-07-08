package net.weg.wdm.service.implementation;

import lombok.AllArgsConstructor;
import net.weg.wdm.entity.Dispositivo;
import net.weg.wdm.entity.TipoDispositivo;
import net.weg.wdm.repository.DispositivoRepository;
import net.weg.wdm.service.interfaces.DispositivoServiceInt;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Service
public class DispositivoServiceImpl implements DispositivoServiceInt {

    private DispositivoRepository dispositivoRepository;

    private List<Dispositivo> buscarDispositivosPorId(List<Long> ids) {
        return dispositivoRepository.findAllById(ids);
    }

    @Override
    public Map<TipoDispositivo, List<Dispositivo>> buscarDispositivosPorIdSeparadosPorTipo(List<Long> id) {
        List<Dispositivo> dispositivos = buscarDispositivosPorId(id);

        Map<TipoDispositivo, List<Dispositivo>> dispositivosPorTipo = new HashMap<>();

        for(Dispositivo dispositivo : dispositivos) {
            List<Dispositivo> dispositivoList = dispositivosPorTipo.get(dispositivo.getTipo());
            dispositivoList.add(dispositivo);
            dispositivosPorTipo.put(dispositivo.getTipo(), dispositivoList);
        }
        return dispositivosPorTipo;
    }
}
