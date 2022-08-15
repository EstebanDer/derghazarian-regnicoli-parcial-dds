package com.parcialdds.disney.entity.tarjetas;

import java.time.LocalDate;

public class Tarjeta {
    private String nroTarjeta;
    private String titular;
    private LocalDate fechaVencimiento;

    //region getters y setters
    public Tarjeta() {
    }

    public Tarjeta(String nroTarjeta, String titular, LocalDate fechaVencimiento) {
        this.nroTarjeta = nroTarjeta;
        this.titular = titular;
        this.fechaVencimiento = fechaVencimiento;
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

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public String toString() {
        return "Tarjeta{" +
                "nroTarjeta='" + nroTarjeta + '\'' +
                ", titular='" + titular + '\'' +
                ", fechaVencimiento=" + fechaVencimiento +
                '}';
    }

    //endregion
}
