package com.parcialdds.disney.repository;

import com.parcialdds.disney.entity.tarjetas.TarjetaCredito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TarjetaCreditoRepository extends JpaRepository<TarjetaCredito, Long> {
    public void deleteByNroTarjeta(String nroTarjeta);
    public Optional<TarjetaCredito> findByNroTarjeta(String nroTarjeta);
}
