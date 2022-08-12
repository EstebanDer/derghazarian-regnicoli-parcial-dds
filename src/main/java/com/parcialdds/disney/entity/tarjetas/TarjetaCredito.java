package com.parcialdds.disney.entity.tarjetas;

import javax.persistence.*;

@Entity
@Table(name = "TARJETASCREDITO")
public class TarjetaCredito extends Tarjeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer limite;

    public Integer getLimite() {
        return limite;
    }

    public void setLimite(Integer limite) {
        this.limite = limite;
    }
}
