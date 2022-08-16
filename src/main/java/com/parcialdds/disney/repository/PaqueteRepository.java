package com.parcialdds.disney.repository;

import com.parcialdds.disney.entity.paquete.Paquete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaqueteRepository extends JpaRepository<Paquete, Long> {
    public Iterable<Paquete> findByEsPrototipoTrue();
}
