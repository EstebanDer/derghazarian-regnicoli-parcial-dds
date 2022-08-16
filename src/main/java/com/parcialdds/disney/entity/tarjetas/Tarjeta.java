package com.parcialdds.disney.entity.tarjetas;

import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
public class Tarjeta {
    private String nroTarjeta;
    private String titular;

    //region getters y setters
    public Tarjeta() {
    }

    public Tarjeta(String nroTarjeta, String titular) {
        this.nroTarjeta = nroTarjeta;
        this.titular = titular;
    }

    public String getNroTarjeta() {
        return nroTarjeta;
    }

    public void setNroTarjeta(String nroTarjeta) {
        this.nroTarjeta = nroTarjeta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    @Override
    public String toString() {
        return "Tarjeta{" +
                "nroTarjeta='" + nroTarjeta + '\'' +
                ", titular='" + titular + '\'' +
                '}';
    }

    //endregion
}
