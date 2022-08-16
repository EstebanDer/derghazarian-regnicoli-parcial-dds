package com.parcialdds.disney.entity.tarjetas.tarjetaDisney;

public class Rojo extends Estado {
    @Override
    public Integer efectuarPago(TarjetaDisney tarjetaDisney, Integer montoAPagar) {
        return -1;
        //System.out.println("No puede realizar el pago, cargue su tarjeta");
    }

    public void actualizarEstado(TarjetaDisney tarjetaDisney){
        if(tarjetaDisney.getSaldo() >= 1500){
            tarjetaDisney.setEstado(new Verde());
        } else if (tarjetaDisney.getSaldo() >= 0) {
            tarjetaDisney.setEstado(new Amarillo());
        }
        tarjetaDisney.setNombreEstado(tarjetaDisney.getEstado().getDescripcion());
    }
    @Override
    public String getDescripcion() {
        return "ROJO";
    }
}
