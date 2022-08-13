package com.parcialdds.disney.entity;

import javax.persistence.*;

@Entity
@Table(name = "USUARIOS")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String nombre;

    private String contrasenia;

    private String cuil;

    //region getters, setters y constructores
    public Usuario(Long id, String nombre, String contrasenia, String cuil) {
        this.id = id;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.cuil = cuil;
    }

    public Usuario(String nombre, String contrasenia, String cuil) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.cuil = cuil;
    }

    public Usuario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }
    //endregion
}
