package com.parcialdds.disney.entity.tarjetas.tarjetaDisney;

public abstract class Estado {
    public abstract Integer efectuarPago(TarjetaDisney tarjetaDisney, Integer montoAPagar);

    public abstract void actualizarEstado(TarjetaDisney tarjetaDisney);

    public abstract String getDescripcion();
}
