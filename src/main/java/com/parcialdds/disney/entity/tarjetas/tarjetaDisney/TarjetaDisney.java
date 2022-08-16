package com.parcialdds.disney.entity.tarjetas.tarjetaDisney;

import com.parcialdds.disney.entity.Usuario;
import com.parcialdds.disney.entity.tarjetas.Tarjeta;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Optional;

@Entity
@Table(name = "TARJETASDISNEY")
public class TarjetaDisney extends Tarjeta {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer saldo;

    private String nombreEstado;

    @Transient
    private Estado estado;

    public void inicializarEstado() {
        switch (nombreEstado){
            case "VERDE":{
                estado = new Verde();
            } break;
            case "AMARILLO": {
                estado = new Amarillo();
            } break;
            case "ROJO": {
                estado = new Rojo();
            } break;
            default:
                throw new IllegalStateException("Operacion desconocida: " + nombreEstado);

        }

    }


    //region getters y setters
    public TarjetaDisney(String nroTarjeta, String titular, Long id, Integer saldo, Estado estado) {
        super(nroTarjeta, titular);
        this.id = id;
        this.saldo = saldo;
        this.nombreEstado = estado.getDescripcion();
        this.estado = estado;
    }

    public TarjetaDisney(String nroTarjeta, String titular, Integer saldo, Estado estado) {
        super(nroTarjeta, titular);
        this.saldo = saldo;
        this.nombreEstado = estado.getDescripcion();
        this.estado = estado;
    }

    public  TarjetaDisney(){

    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
        this.getEstado().actualizarEstado(this);
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    //endregion

}
