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
import com.parcialdds.disney.entity.tarjetas.TarjetaCredito;
import com.parcialdds.disney.repository.PaqueteRepository;
import com.parcialdds.disney.service.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

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
    private AtraccionService atraccionService;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private TuristaService turistaService;

    @Autowired
    private PersonajeService personajeService;
    // endregion

    public void realizar(Usuario usuario) {

        producto.setPaquete(this.elegirPaquete());
        producto.setAtraccion(elegirPersonaje().getAtraccion());
        this.efectuarCompra();
    }

    public Paquete elegirPaquete() {
        Paquete paqueteElegido = new Paquete();
        Iterable<Paquete> paquetes = paqueteService.findByEsPrototipoTrue();
        System.out.println("Seleccion uno de nuestros paquetes disponibles: \n");
        int i = 1;
        for(Paquete p : paquetes){
            System.out.println("Ingrese" + i + " - Paquete \n" + p.toString());
            i++;
        }
        int codigoPaqueteElegido = scanner.nextInt();
        for(Paquete p : paquetes){
            if(p.getId() == codigoPaqueteElegido){
                try {
                    paqueteElegido = p.clone();
                } catch(CloneNotSupportedException e){
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Desea modificar el paquete? (S/N)");
        String respuesta = scanner.next();
        if(respuesta.equalsIgnoreCase("S"))
            this.modificarPaquete(paqueteElegido);
        else
            System.out.println("Paquete sin modificaciones");
        paqueteElegido.setEsPrototipo(false);
        return paqueteElegido;
    }

    public void modificarPaquete(Paquete paqueteElegido) {
        System.out.println("De cuantos dias sera el paquete?");
        paqueteElegido.setCantidadDias(scanner.nextInt());
        System.out.println("Quiere menu incluido? (S/N)");
        String respuesta = scanner.next();

        if(respuesta.equalsIgnoreCase("S"))
            paqueteElegido.setMenuIncluido(true);
        else
            paqueteElegido.setMenuIncluido(false);
    }

    public Personaje elegirPersonaje(){
        Personaje personajeFavorito = new Personaje();
        System.out.println("Personajes disponibles");
        Iterable<Personaje> personajes = personajeService.findAll();
        int i = 1;
        for(Personaje p : personajes) {
            System.out.println(i + " " + p.toString());
        }
        System.out.println("Seleccione algun personaje");
        String personajeElegido = scanner.next();
        for(Personaje p : personajes){
            if(p.getNombre().equalsIgnoreCase(personajeElegido))
                personajeFavorito = p;
        }
        return personajeFavorito;
    }

    public void efectuarCompra(){
        this.agregarTuristas();
        this.pagar();
    }

    private void agregarTuristas() {
        ArrayList<Turista> turistas = new ArrayList<>();
        System.out.println("Cuantas personas se hospedaran");
        int cantPersonas = scanner.nextInt();
        for(int i = 0; i < cantPersonas; i++){
            System.out.println("Ingrese el nombre de el/la turista");
            String nombre = scanner.next();
            System.out.println("Ingrese el apellido de el/la turista");
            String apellido = scanner.next();
            System.out.println("Ingrese el dni de el/la turista");
            String dni = scanner.next();
            Turista turista = new Turista(nombre, apellido, dni);
            turistas.add(turista);
        }
        producto.setTurista(turistas);
    }

    private void pagar() {
        System.out.println("Seleccionar medio de pago");
        System.out.println("Ingrese 1 para tarjeta Disney\n" + "Ingrese 2 para tarjeta de credito");
        int accion = scanner.nextInt();
        switch(accion){
            case 1: {
                producto.setMedioDePago(new EstrategiaDisney());
                producto.setMontoFinal(producto.getMedioDePago().calcularMontoFinal(producto.getMonto(), producto.getTurista()));
                int codigoOperacion = usuario.getTarjetaDisney().getEstado().efectuarPago(usuario.getTarjetaDisney(), producto.getMontoFinal());
                if(codigoOperacion == 1){
                    System.out.println("Compra realizada");
                    usuario.getProducto().add(producto);
                    productoService.save(producto);
                    usuarioService.save(usuario);
                }
                else {
                    System.out.println("Error: Recargue su tarjeta");
                }
            } break;
            case 2: {
                producto.setMedioDePago(new EstrategiaCredito());
                producto.setMontoFinal(producto.getMedioDePago().calcularMontoFinal(producto.getMonto(), producto.getTurista()));
                System.out.println("Ingrese el numero de su tarjeta de credito");
                String nroTarjeta = scanner.next();
                TarjetaCredito tarjetaCredito = usuario.buscarTarjeta(nroTarjeta);
                if(tarjetaCredito != null) {
                    int codigoOperacion = tarjetaCredito.efectuarPago(producto.getMontoFinal());
                    if(codigoOperacion == 1){
                        System.out.println("Compra realizada");
                        usuario.getProducto().add(producto);
                        productoService.save(producto);
                        usuarioService.save(usuario);
                    } else {
                        System.out.println("Error: Limite insuficiente");
                    }
                }
                else{
                    System.out.println("Error: No se encontro una tarjeta con ese numero");
                }
            } break;
            default: {
                throw new IllegalStateException("Operacion desconocida: " + accion);
            }
        }
    }

}
