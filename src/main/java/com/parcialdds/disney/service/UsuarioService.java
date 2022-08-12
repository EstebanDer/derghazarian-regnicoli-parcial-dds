package com.parcialdds.disney.service;

import java.util.Optional;

import com.parcialdds.disney.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UsuarioService {

    public Iterable<Usuario> findAll();

    public Page<Usuario> findAll(Pageable pageable);

    public Optional<Usuario> findById(Long id);

    public Usuario save(Usuario usuario);

    public void deleteById(Long id);
}
