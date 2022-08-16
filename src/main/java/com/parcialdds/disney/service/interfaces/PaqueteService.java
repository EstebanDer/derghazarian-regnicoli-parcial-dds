package com.parcialdds.disney.service.interfaces;

import com.parcialdds.disney.entity.paquete.Paquete;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PaqueteService {
    public Iterable<Paquete> findAll();

    public Iterable<Paquete> findByEsPrototipoTrue();

    public Page<Paquete> findAll(Pageable pageable);

    public Optional<Paquete> findById(Long id);

    public Paquete save(Paquete paquete);

    public void deleteById(Long id);
}
