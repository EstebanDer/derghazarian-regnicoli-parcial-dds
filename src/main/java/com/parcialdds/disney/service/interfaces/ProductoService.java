package com.parcialdds.disney.service.interfaces;


import com.parcialdds.disney.entity.producto.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProductoService {

    public Iterable<Producto> findAll();

    public Page<Producto> findAll(Pageable pageable);

    public Optional<Producto> findById(Long id);

    public Producto save(Producto producto);

    public void deleteById(Long id);
}
