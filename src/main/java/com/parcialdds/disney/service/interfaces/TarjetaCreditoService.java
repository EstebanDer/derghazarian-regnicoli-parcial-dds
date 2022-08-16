package com.parcialdds.disney.service.interfaces;

import com.parcialdds.disney.entity.tarjetas.TarjetaCredito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TarjetaCreditoService {

    public Iterable<TarjetaCredito> findAll();

    public Page<TarjetaCredito> findAll(Pageable pageable);

    public Optional<TarjetaCredito> findById(Long id);

    public TarjetaCredito save(TarjetaCredito tarjetaCredito);

    public void deleteById(Long id);

    public void deleteByNroTarjeta(String nroTarjeta);

    public Optional<TarjetaCredito> findByNroTarjeta(String nroTarjeta);
}
