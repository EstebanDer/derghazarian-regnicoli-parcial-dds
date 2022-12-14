package com.parcialdds.disney.entity.personaje;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Personaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30)
    private String nombre;

    private Integer idApi;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "idPersonaje")
    private List<Atraccion> atraccion = new ArrayList<>();

    //region getters y setters
    public Personaje() {
    }

    public Personaje(Long id, String nombre, Integer idApi, ArrayList<Atraccion> atraccion) {
        this.id = id;
        this.nombre = nombre;
        this.idApi = idApi;
        this.atraccion = atraccion;
    }

    public Personaje(String nombre, Integer idApi, ArrayList<Atraccion> atraccion) {
        this.nombre = nombre;
        this.idApi = idApi;
        this.atraccion = atraccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdApi() {
        return idApi;
    }

    public void setIdApi(Integer idApi) {
        this.idApi = idApi;
    }

    public List<Atraccion> getAtraccion() {
        return atraccion;
    }

    public void setAtraccion(ArrayList<Atraccion> atraccion) {
        this.atraccion = atraccion;
    }

    @Override
    public String toString() {
        return "Personaje{" +
                " nombre='" + nombre + '\'' +
                '}';
    }
    //endregion
}
