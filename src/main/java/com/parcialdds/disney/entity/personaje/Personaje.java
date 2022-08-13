package com.parcialdds.disney.entity.personaje;

import javax.persistence.*;

@Entity
@Table
public class Personaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String nombre;
}
