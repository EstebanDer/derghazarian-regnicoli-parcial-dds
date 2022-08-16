package com.parcialdds.disney.service.interfaces;


import com.parcialdds.disney.entity.tarjetas.tarjetaDisney.TarjetaDisney;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TarjetaDisneyService {

    public boolean existsByNroTarjeta(String nroTarjeta);

    public Iterable<TarjetaDisney> findAll();

    public Page<TarjetaDisney> findAll(Pageable pageable);

    public Optional<TarjetaDisney> findById(Long id);

    public TarjetaDisney getById(Long id);

    public TarjetaDisney save(TarjetaDisney tarjetaDisney);

    public void deleteById(Long id);
}
