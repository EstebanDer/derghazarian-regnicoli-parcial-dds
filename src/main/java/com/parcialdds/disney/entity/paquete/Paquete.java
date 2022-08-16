package com.parcialdds.disney.entity.paquete;

import javax.persistence.*;
import java.util.Enumeration;

@Entity
@Table
public class Paquete implements Cloneable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer cantidadDias;

    private Integer costoFijoXDia;

    @Enumerated(EnumType.ORDINAL)
    private TipoHospedaje tipoHospedaje;

    private Boolean esPrototipo;

    private Boolean menuIncluido;

    @Override
    public Paquete clone() throws CloneNotSupportedException {
        return (Paquete) super.clone();
    }

    public Integer getMonto() {
        if(menuIncluido)
            return cantidadDias * (costoFijoXDia + tipoHospedaje.getCosto() + 50);
         else
            return cantidadDias * (costoFijoXDia + tipoHospedaje.getCosto());
    }

    public Paquete() {
    }

    public Paquete(Long id, Integer cantidadDias, Integer costoFijoXDia, TipoHospedaje tipoHospedaje, Boolean esPrototipo, Boolean menuIncluido) {
        this.id = id;
        this.cantidadDias = cantidadDias;
        this.costoFijoXDia = costoFijoXDia;
        this.tipoHospedaje = tipoHospedaje;
        this.esPrototipo = esPrototipo;
        this.menuIncluido = menuIncluido;
    }

    public Paquete(Integer cantidadDias, Integer costoFijoXDia, TipoHospedaje tipoHospedaje, Boolean esPrototipo, Boolean menuIncluido) {
        this.cantidadDias = cantidadDias;
        this.costoFijoXDia = costoFijoXDia;
        this.tipoHospedaje = tipoHospedaje;
        this.esPrototipo = esPrototipo;
        this.menuIncluido = menuIncluido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidadDias() {
        return cantidadDias;
    }

    public void setCantidadDias(Integer cantidadDias) {
        this.cantidadDias = cantidadDias;
    }

    public Integer getCostoFijoXDia() {
        return costoFijoXDia;
    }

    public void setCostoFijoXDia(Integer costoFijoXDia) {
        this.costoFijoXDia = costoFijoXDia;
    }

    public TipoHospedaje getTipoHospedaje() {
        return tipoHospedaje;
    }

    public void setTipoHospedaje(TipoHospedaje tipoHospedaje) {
        this.tipoHospedaje = tipoHospedaje;
    }

    public Boolean getEsPrototipo() {
        return esPrototipo;
    }

    public void setEsPrototipo(Boolean esPrototipo) {
        this.esPrototipo = esPrototipo;
    }

    public Boolean getMenuIncluido() {
        return menuIncluido;
    }

    public void setMenuIncluido(Boolean menuIncluido) {
        this.menuIncluido = menuIncluido;
    }

    @Override
    public String toString() {
        return "Paquete{" +
                "cantidadDias=" + cantidadDias +
                ", costoFijoXDia=" + costoFijoXDia +
                ", tipoHospedaje=" + tipoHospedaje.toString() +
                ", menuIncluido=" + menuIncluido +
                '}';
    }
}
