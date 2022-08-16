package com.parcialdds.disney.service.interfaces;


import com.parcialdds.disney.entity.personaje.Atraccion;
import com.parcialdds.disney.entity.producto.Turista;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface AtraccionService {

    public Iterable<Atraccion> findAll();

    public Page<Atraccion> findAll(Pageable pageable);

    public Optional<Atraccion> findById(Long id);

    public Atraccion save(Atraccion atraccion);

    public Iterable<Atraccion> saveAll(Iterable<Atraccion> atraccion);

    public void deleteById(Long id);
}
