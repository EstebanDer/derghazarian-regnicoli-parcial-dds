package com.parcialdds.disney.service.interfaces;

import com.parcialdds.disney.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.parcialdds.disney.entity.producto.Turista;

import java.util.Optional;

public interface TuristaService {

    public Iterable<Turista> findAll();

    public Page<Turista> findAll(Pageable pageable);

    public Optional<Turista> findById(Long id);

    public Turista save(Turista turista);

    public void deleteById(Long id);
}

