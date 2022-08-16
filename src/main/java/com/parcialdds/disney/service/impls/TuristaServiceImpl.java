package com.parcialdds.disney.service.impls;

import com.parcialdds.disney.entity.producto.Turista;
import com.parcialdds.disney.repository.TuristaRepository;
import com.parcialdds.disney.service.interfaces.TuristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TuristaServiceImpl implements TuristaService {

    @Autowired
    private TuristaRepository turistaRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Turista> findAll() {
        return turistaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Turista> findAll(Pageable pageable) {
        return turistaRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Turista> findById(Long id) {
        return turistaRepository.findById(id);
    }

    @Override
    @Transactional
    public Turista save(Turista turista) {
        return turistaRepository.save(turista);
    }

    public Iterable<Turista> saveAll(Iterable<Turista> turistas) { return turistaRepository.saveAll(turistas);}

    @Override
    @Transactional
    public void deleteById(Long id) {
        turistaRepository.deleteById(id);
    }
}
