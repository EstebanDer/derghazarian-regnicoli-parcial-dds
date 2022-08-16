package com.parcialdds.disney.entity.tarjetas.tarjetaDisney;

public class Amarillo extends Estado{
    @Override
    public Integer efectuarPago(TarjetaDisney tarjetaDisney, Integer montoAPagar) {
        if(montoAPagar < 1500) {
            tarjetaDisney.setSaldo(tarjetaDisney.getSaldo() - montoAPagar);
            actualizarEstado(tarjetaDisney);
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public void actualizarEstado(TarjetaDisney tarjetaDisney) {
        if(tarjetaDisney.getSaldo() >= 1500 ){
            tarjetaDisney.setEstado(new Verde());
        } else if (tarjetaDisney.getSaldo() < 0) {
            tarjetaDisney.setEstado(new Rojo());
        }
        tarjetaDisney.setNombreEstado(tarjetaDisney.getEstado().getDescripcion());
    }


    @Override
    public String getDescripcion() {
        return "AMARILLO";
    }
}
