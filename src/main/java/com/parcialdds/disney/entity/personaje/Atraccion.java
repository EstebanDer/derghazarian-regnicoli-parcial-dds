package com.parcialdds.disney.entity.personaje;

import com.parcialdds.disney.entity.producto.Producto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Atraccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30)
    private String nombre;

    //region getters y setters
    public Atraccion(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Atraccion(String nombre) {
        this.nombre = nombre;
    }

    public Atraccion() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Atraccion{" +
                "nombre='" + nombre + '\'' +
                '}';
    }

    //endregion
}
