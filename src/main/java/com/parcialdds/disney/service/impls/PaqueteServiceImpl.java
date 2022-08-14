package com.parcialdds.disney.service.impls;

import com.parcialdds.disney.entity.paquete.Paquete;
import com.parcialdds.disney.repository.PaqueteRepository;
import com.parcialdds.disney.service.interfaces.PaqueteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PaqueteServiceImpl implements PaqueteService {

    @Autowired
    private PaqueteRepository paqueteRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Paquete> findAll() {
        return paqueteRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Paquete> findAll(Pageable pageable) {
        return paqueteRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Paquete> findById(Long id) {
        return paqueteRepository.findById(id);
    }

    @Override
    @Transactional
    public Paquete save(Paquete paquete) {
        return paqueteRepository.save(paquete);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        paqueteRepository.deleteById(id);
    }
}
