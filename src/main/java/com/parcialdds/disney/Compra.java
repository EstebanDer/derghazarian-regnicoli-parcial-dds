package com.parcialdds.disney;

import com.parcialdds.disney.entity.Usuario;
import com.parcialdds.disney.entity.paquete.Paquete;
import com.parcialdds.disney.entity.personaje.ApiDisney;
import com.parcialdds.disney.entity.producto.Producto;
import com.parcialdds.disney.entity.producto.Turista;
import com.parcialdds.disney.repository.PaqueteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class Compra {

    private Usuario usuario;
    private Paquete paqueteElegido;
    private Producto producto;
    private ApiDisney apiDisney;
    private List<Turista> turistas = new ArrayList<>();

    @Autowired
    private PaqueteRepository catalogoPaquetes;


}
