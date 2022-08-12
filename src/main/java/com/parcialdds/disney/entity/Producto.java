package com.parcialdds.disney.entity;

import javax.persistence.*;

@Entity
@Table
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer montoFinal;

    // generar getters y setters
}
