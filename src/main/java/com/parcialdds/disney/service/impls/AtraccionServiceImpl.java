package com.parcialdds.disney.service.impls;

import com.parcialdds.disney.entity.personaje.Atraccion;
import com.parcialdds.disney.repository.AtraccionRepository;
import com.parcialdds.disney.service.interfaces.AtraccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AtraccionServiceImpl implements AtraccionService {

    @Autowired
    private AtraccionRepository atraccionRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Atraccion> findAll() {
        return atraccionRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Atraccion> findAll(Pageable pageable) {
        return atraccionRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Atraccion> findById(Long id) {
        return atraccionRepository.findById(id);
    }

    @Override
    @Transactional
    public Atraccion save(Atraccion atraccion) {
        return atraccionRepository.save(atraccion);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        atraccionRepository.deleteById(id);
    }

}
