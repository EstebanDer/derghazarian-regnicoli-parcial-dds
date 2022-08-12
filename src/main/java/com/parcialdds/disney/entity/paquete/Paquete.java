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

    //private Enum??

    private Boolean esPrototipo;

    private Boolean menuIncluido;
}
