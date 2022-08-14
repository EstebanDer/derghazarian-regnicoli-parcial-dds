package com.parcialdds.disney.service.impls;


import com.parcialdds.disney.entity.tarjetas.TarjetaCredito;
import com.parcialdds.disney.repository.TarjetaCreditoRepository;
import com.parcialdds.disney.service.interfaces.TarjetaCreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TarjetaCreditoServiceImpl implements TarjetaCreditoService {

    @Autowired
    private TarjetaCreditoRepository tarjetaCreditoRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<TarjetaCredito> findAll() {
        return tarjetaCreditoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<TarjetaCredito> findAll(Pageable pageable) {
        return tarjetaCreditoRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TarjetaCredito> findById(Long id) {
        return tarjetaCreditoRepository.findById(id);
    }

    @Override
    @Transactional
    public TarjetaCredito save(TarjetaCredito tarjetaCredito) {
        return tarjetaCreditoRepository.save(tarjetaCredito);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        tarjetaCreditoRepository.deleteById(id);
    }
}
