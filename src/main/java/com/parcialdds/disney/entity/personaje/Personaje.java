package com.parcialdds.disney.entity.personaje;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Personaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String nombre;
    
    private Integer idApi;

    @OneToMany
    @JoinColumn(name = "idAtraccion")
    private List<Atraccion> atraccion;
}
