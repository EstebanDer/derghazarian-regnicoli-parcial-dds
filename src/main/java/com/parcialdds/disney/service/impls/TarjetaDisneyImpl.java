package com.parcialdds.disney.service.impls;

import com.parcialdds.disney.entity.tarjetas.tarjetaDisney.TarjetaDisney;
import com.parcialdds.disney.repository.TarjetaDisneyRepository;
import com.parcialdds.disney.service.interfaces.TarjetaDisneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TarjetaDisneyImpl implements TarjetaDisneyService {

    @Autowired
    private TarjetaDisneyRepository tarjetaDisneyRepository;


    @Override
    public boolean existsByNroTarjeta(String nroTarjeta) { return tarjetaDisneyRepository.existsByNroTarjeta(nroTarjeta); }

    @Override
    @Transactional(readOnly = true)
    public Iterable<TarjetaDisney> findAll() {
        return tarjetaDisneyRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<TarjetaDisney> findAll(Pageable pageable) {
        return tarjetaDisneyRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TarjetaDisney> findById(Long id) {
        return tarjetaDisneyRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    @Deprecated
    public TarjetaDisney getById(Long id) { return tarjetaDisneyRepository.getById(id); }

    @Override
    @Transactional
    public TarjetaDisney save(TarjetaDisney tarjetaDisney) {
        return tarjetaDisneyRepository.save(tarjetaDisney);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        tarjetaDisneyRepository.deleteById(id);
    }
}
