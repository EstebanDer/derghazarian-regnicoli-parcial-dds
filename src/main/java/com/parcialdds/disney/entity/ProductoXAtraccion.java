package com.parcialdds.disney.entity;

import javax.persistence.*;

@Entity
@Table
public class ProductoXAtraccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
