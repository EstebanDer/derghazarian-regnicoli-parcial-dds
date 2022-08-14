package com.parcialdds.disney.service.interfaces;

import com.parcialdds.disney.entity.personaje.Personaje;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PersonajeService {

    public Iterable<Personaje> findAll();

    public Page<Personaje> findAll(Pageable pageable);

    public Optional<Personaje> findById(Long id);

    public Personaje save(Personaje personaje);

    public void deleteById(Long id);
}
