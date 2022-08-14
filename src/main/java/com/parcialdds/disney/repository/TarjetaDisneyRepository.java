package com.parcialdds.disney.repository;

import com.parcialdds.disney.entity.tarjetas.tarjetaDisney.TarjetaDisney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarjetaDisneyRepository extends JpaRepository<TarjetaDisney, Long> {
}
