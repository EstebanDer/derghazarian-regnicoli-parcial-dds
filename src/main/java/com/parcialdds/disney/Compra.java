package com.parcialdds.disney;

import com.parcialdds.disney.entity.Usuario;
import com.parcialdds.disney.entity.paquete.Paquete;
import com.parcialdds.disney.entity.personaje.ApiDisney;
import com.parcialdds.disney.entity.personaje.Atraccion;
import com.parcialdds.disney.entity.personaje.Personaje;
import com.parcialdds.disney.entity.producto.EstrategiaCredito;
import com.parcialdds.disney.entity.producto.EstrategiaDisney;
import com.parcialdds.disney.entity.producto.Producto;
import com.parcialdds.disney.entity.producto.Turista;
import com.parcialdds.disney.repository.PaqueteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import static com.parcialdds.disney.DisneyApplication.scanner;

public class Compra {

    private Usuario usuario;
    private Producto producto = new Producto();

    // region Servicios
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private PaqueteService paqueteService;

    @Autowired
    private PaqueteRepository catalogoPaquetes;


}
