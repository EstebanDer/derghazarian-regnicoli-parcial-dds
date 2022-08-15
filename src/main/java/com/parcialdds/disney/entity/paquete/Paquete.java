package com.parcialdds.disney.entity.paquete;

import javax.persistence.*;
import java.util.Enumeration;

@Entity
@Table
public class Paquete {
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
    public String toString() {
        return "Paquete{" +
                "cantidadDias=" + cantidadDias +
                ", costoFijoXDia=" + costoFijoXDia +
                ", tipoHospedaje=" + tipoHospedaje.toString() +
                ", menuIncluido=" + menuIncluido +
                '}';
    }
}
