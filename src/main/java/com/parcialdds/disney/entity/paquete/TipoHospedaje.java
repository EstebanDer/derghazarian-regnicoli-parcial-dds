package com.parcialdds.disney.entity.paquete;

public enum TipoHospedaje {
    UNAHABITACION(100), DOSHABITACIONES(200), SUITE(300);

    private int costo;

    private TipoHospedaje(int costo){
        this.costo = costo;
    }

    public int getCosto() {
        return costo;
    }


}
