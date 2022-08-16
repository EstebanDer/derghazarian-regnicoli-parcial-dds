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

    public Integer efectuarPago(Integer monto) {
        if(limite < monto)
            return -1;
        else {
            setLimite(limite - monto);
            return 1;
        }
    }

    //region getters y setters
    public TarjetaCredito() {
    }

    public TarjetaCredito(Long id, String nroTarjeta, String titular, Integer limite) {
        super(nroTarjeta, titular);
        this.id = id;
        this.limite = limite;
    }

    public TarjetaCredito(String nroTarjeta, String titular, Integer limite) {
        super(nroTarjeta, titular);
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
