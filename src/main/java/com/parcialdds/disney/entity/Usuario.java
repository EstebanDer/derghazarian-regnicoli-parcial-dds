package com.parcialdds.disney.entity;

import com.parcialdds.disney.entity.paquete.Paquete;
import com.parcialdds.disney.entity.personaje.Personaje;
import com.parcialdds.disney.entity.producto.Producto;
import com.parcialdds.disney.entity.tarjetas.TarjetaCredito;
import com.parcialdds.disney.entity.tarjetas.tarjetaDisney.TarjetaDisney;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
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

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "usuarioId")
    private List<TarjetaCredito> tarjetaCredito;

    @LazyCollection(LazyCollectionOption.FALSE)

    @OneToMany
    @JoinColumn(name = "usuarioId")
    private List<Producto> producto;

    @Transient
    private Personaje personajeElegido;

    @Transient
    private Paquete paqueteElegido;

    public void agregarTarjetaCredito(TarjetaCredito unaTarjetaCredito) {
        tarjetaCredito.add(unaTarjetaCredito);
    }

    public TarjetaCredito buscarTarjeta(String unNroTarjeta) {
        return tarjetaCredito.stream().filter(tarjeta -> unNroTarjeta.equals(tarjeta.getNroTarjeta())).findFirst().orElse(null);
    }

    public void borrarTarjeta(String unNroTarjeta){
        TarjetaCredito tarjeta = buscarTarjeta(unNroTarjeta);
        tarjetaCredito.remove(tarjeta);
    }

    public void agregarProducto(Producto unProducto){
        producto.add(unProducto);
    }

    public Integer cargarTarjetaDisney(Integer monto, TarjetaCredito tarjetaCredito) {
        int resultado = tarjetaCredito.efectuarPago(monto);
        if(resultado == 1){
            tarjetaDisney.setSaldo(tarjetaDisney.getSaldo() + monto);
            return 1;
        }
        else {
            return -1;
        }
    }

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

    public List<TarjetaCredito> getTarjetaCredito() {
        return tarjetaCredito;
    }

    public void setTarjetaCredito(List<TarjetaCredito> tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

    public List<Producto> getProducto() {
        return producto;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = producto;
    }

    public Personaje getPersonajeElegido() {
        return personajeElegido;
    }

    public void setPersonajeElegido(Personaje personajeElegido) {
        this.personajeElegido = personajeElegido;
    }

    public Paquete getPaqueteElegido() {
        return paqueteElegido;
    }

    public void setPaqueteElegido(Paquete paqueteElegido) {
        this.paqueteElegido = paqueteElegido;
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
