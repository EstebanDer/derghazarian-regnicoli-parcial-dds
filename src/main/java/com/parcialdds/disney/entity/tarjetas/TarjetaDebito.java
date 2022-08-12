package com.parcialdds.disney.entity.tarjetas;

import javax.persistence.*;

@Entity
@Table(name = "TARJETASDEBITO")
public class TarjetaDebito extends Tarjeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer saldo;

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }
}
