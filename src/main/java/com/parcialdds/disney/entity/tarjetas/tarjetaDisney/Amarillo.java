package com.parcialdds.disney.entity.tarjetas.tarjetaDisney;

public class Amarillo extends Estado{
    @Override
    public Integer efectuarPago(Integer montoAPagar) {
        // TODO
        return montoAPagar;
    }

    @Override
    public String getDescripcion() {
        return "AMARILLO";
    }
}
