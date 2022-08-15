package com.parcialdds.disney.entity.tarjetas;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TARJETASCREDITO")
public class TarjetaCredito extends Tarjeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer limite;

    //region getters y setters
    public TarjetaCredito() {
    }

    public TarjetaCredito(Long id, String nroTarjeta, String titular, LocalDate fechaVencimiento, Integer limite) {
        super(nroTarjeta, titular, fechaVencimiento);
        this.id = id;
        this.limite = limite;
    }

    public TarjetaCredito(String nroTarjeta, String titular, LocalDate fechaVencimiento, Integer limite) {
        super(nroTarjeta, titular, fechaVencimiento);
        this.limite = limite;
    }

    public Integer getLimite() {
        return limite;
    }

    public void setLimite(Integer limite) {
        this.limite = limite;
    }
    //endregion
}
