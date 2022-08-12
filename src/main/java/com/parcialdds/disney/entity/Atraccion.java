package com.parcialdds.disney.entity;

import javax.persistence.*;

@Entity
@Table
public class Atraccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30)
    private String nombre;
}
