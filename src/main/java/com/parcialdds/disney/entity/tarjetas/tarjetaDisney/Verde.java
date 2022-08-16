package com.parcialdds.disney.entity.tarjetas.tarjetaDisney;

public class Verde extends Estado{
    @Override
    public Integer efectuarPago(TarjetaDisney tarjetaDisney, Integer montoAPagar) {
        tarjetaDisney.setSaldo(tarjetaDisney.getSaldo() - montoAPagar);
        actualizarEstado(tarjetaDisney);
        return 1;
    }

    @Override
    public void actualizarEstado(TarjetaDisney tarjetaDisney) {
        if(tarjetaDisney.getSaldo() < 0){
            tarjetaDisney.setEstado(new Rojo());
        } else if (tarjetaDisney.getSaldo() < 1500) {
            tarjetaDisney.setEstado(new Amarillo());
        }
        tarjetaDisney.setNombreEstado(tarjetaDisney.getEstado().getDescripcion());
    }

    @Override
    public String getDescripcion() {
        return "VERDE";
    }
}
