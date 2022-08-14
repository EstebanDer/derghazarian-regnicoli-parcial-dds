package com.parcialdds.disney.entity.tarjetas.tarjetaDisney;

import com.parcialdds.disney.entity.Usuario;
import com.parcialdds.disney.entity.tarjetas.Tarjeta;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name = "TARJETASDISNEY")
public class TarjetaDisney extends Tarjeta {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer saldo;

    private String estado;

    //region getters y setters
    public TarjetaDisney(Long id, Integer saldo, String estado) {
        this.id = id;
        this.saldo = saldo;
        this.estado = estado;
    }

    public TarjetaDisney(Integer saldo, String estado) {
        this.saldo = saldo;
        this.estado = estado;
    }

    public  TarjetaDisney(){

    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    //endregion

}
