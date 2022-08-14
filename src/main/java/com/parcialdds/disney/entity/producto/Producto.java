package com.parcialdds.disney.entity.producto;

import com.parcialdds.disney.entity.paquete.Paquete;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer montoFinal;

    @OneToMany
    @JoinColumn(name = "turistaId")
    private List<Turista> turista;

    @OneToOne
    private Paquete paquete;

    //region getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMontoFinal() {
        return montoFinal;
    }

    public void setMontoFinal(Integer montoFinal) {
        this.montoFinal = montoFinal;
    }
    //endregion
}
