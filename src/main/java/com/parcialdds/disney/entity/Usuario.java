package com.parcialdds.disney.entity;

import com.parcialdds.disney.entity.producto.Producto;
import com.parcialdds.disney.entity.tarjetas.TarjetaCredito;
import com.parcialdds.disney.entity.tarjetas.tarjetaDisney.TarjetaDisney;

import javax.persistence.*;
import java.util.List;

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

    @OneToOne(cascade = {CascadeType.ALL})
    private TarjetaDisney tarjetaDisney;

    @OneToMany
    @JoinColumn(name = "usuarioId")
    private List<TarjetaCredito> tarjetaCredito;

    @OneToMany
    @JoinColumn(name = "productoId")
    private List<Producto> producto;


    //region getters y setters
    public Usuario(String nombre, String contrasenia, String cuil, TarjetaDisney tarjetaDisney, List<TarjetaCredito> tarjetaCredito) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.cuil = cuil;
        this.tarjetaDisney = tarjetaDisney;
        this.tarjetaCredito = tarjetaCredito;
    }

    public Usuario(Long id, String nombre, String contrasenia, String cuil, TarjetaDisney tarjetaDisney, List<TarjetaCredito> tarjetaCredito) {
        this.id = id;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.cuil = cuil;
        this.tarjetaDisney = tarjetaDisney;
        this.tarjetaCredito = tarjetaCredito;
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

    public TarjetaDisney getTarjetaDisney() {
        return tarjetaDisney;
    }

    public void setTarjetaDisney(TarjetaDisney tarjetaDisney) {
        this.tarjetaDisney = tarjetaDisney;
    }

    public List<TarjetaCredito> getTarjetasCredito() {
        return tarjetaCredito;
    }

    public void setTarjetasCredito(List<TarjetaCredito> tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                ", nombre='" + nombre + '\'' +
                ", cuil='" + cuil + '\'' +
                '}';
    }

    //endregion
}
