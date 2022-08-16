package com.parcialdds.disney.entity.producto;

import com.parcialdds.disney.entity.paquete.Paquete;
import com.parcialdds.disney.entity.personaje.Atraccion;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.*;

@Entity
@Table
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer montoFinal;

    @OneToMany
    @JoinColumn(name = "productoId")
    private List<Turista> turista = new ArrayList<>();

    @OneToOne
    private Paquete paquete;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "paseRapido",
            joinColumns = { @JoinColumn(name = "productoId")},
            inverseJoinColumns = { @JoinColumn(name = "atraccionId")})
    private List<Atraccion> atraccion = new ArrayList<>();

    @Transient
    private Estrategia medioDePago;

    @Transient
    private Integer monto;

    public void calcularMontoFinal(){
        montoFinal = medioDePago.calcularMontoFinal(monto, turista);
    }

    //region getters y setters
    public Integer getMontoFinal() {
        return montoFinal;
    }

    public void setMontoFinal(Integer montoFinal) {
        this.montoFinal = montoFinal;
    }

    public List<Turista> getTurista() {
        return turista;
    }

    public void setTurista(List<Turista> turista) {
        this.turista = turista;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public List<Atraccion> getAtraccion() {
        return atraccion;
    }

    public void setAtraccion(List<Atraccion> atraccion) {
        this.atraccion = atraccion;
    }

    public Estrategia getMedioDePago() {
        return medioDePago;
    }

    public void setMedioDePago(Estrategia medioDePago) {
        this.medioDePago = medioDePago;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public Producto() {
    }

    public Producto(Long id, List<Turista> turista, Paquete paquete, List<Atraccion> atraccion, Estrategia medioDePago) {
        this.id = id;
        this.turista = turista;
        this.paquete = paquete;
        this.atraccion = atraccion;
        this.medioDePago = medioDePago;
        this.monto = paquete.getMonto() * turista.size();
    }

    public Producto(List<Turista> turista, Paquete paquete, List<Atraccion> atraccion, Estrategia medioDePago, Integer monto) {
        this.turista = turista;
        this.paquete = paquete;
        this.atraccion = atraccion;
        this.medioDePago = medioDePago;
        this.monto = paquete.getMonto() * turista.size();
    }

    @Override
    public String toString() {
        return "Producto{" +
                "montoFinal=" + montoFinal +
                '}';
    }

    //endregion
}
