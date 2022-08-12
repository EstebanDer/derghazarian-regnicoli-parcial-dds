package com.parcialdds.disney.entity.tarjetas.tarjetaDisney;

import com.parcialdds.disney.entity.tarjetas.Tarjeta;

import javax.persistence.*;

@Entity
@Table(name = "TARJETASDISNEY")
public class TarjetaDisney extends Tarjeta {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer saldo;

    private String estado;

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


}
