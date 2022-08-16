package com.parcialdds.disney;

import com.parcialdds.disney.entity.Usuario;
import com.parcialdds.disney.entity.paquete.Paquete;
import com.parcialdds.disney.entity.paquete.TipoHospedaje;
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

    public Producto realizar(Usuario usuario, Iterable<Paquete> catalogoPaquetes, Iterable<Personaje> personajes) {
        Producto producto = new Producto();
        producto.setPaquete(this.elegirPaquete(usuario, catalogoPaquetes));
        producto.setAtraccion(elegirPersonaje(personajes).getAtraccion());
        producto.setTurista(this.agregarTuristas());
        this.pagar(usuario, producto);
        return producto;
    }

    public Paquete elegirPaquete(Usuario usuario, Iterable<Paquete> paquetes) {
        Paquete paqueteElegido = new Paquete();
        System.out.println("Seleccion uno de nuestros paquetes disponibles: \n");
        int i = 1;
        for(Paquete p : paquetes){
            System.out.println("Ingrese " + i + "\n" + p.toString());
            i++;
        }
        int codigoPaqueteElegido = scanner.nextInt();
        for(Paquete p : paquetes){
            if(p.getId() == codigoPaqueteElegido){
                try {
                    paqueteElegido = p.clone();
                    paqueteElegido.setId(null);
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

    public Personaje elegirPersonaje(Iterable<Personaje> personajes){
        Personaje personajeFavorito = new Personaje();
        System.out.println("Personajes disponibles");
        int i = 1;
        for(Personaje p : personajes) {
            System.out.println("Ingrese " + i + " " + p.toString());
            i++;
        }
        System.out.println("Seleccione algun personaje");
        String personajeElegido = scanner.next();
        for(Personaje p : personajes){
            if(p.getNombre().equalsIgnoreCase(personajeElegido))
                personajeFavorito = p;
        }
        return personajeFavorito;
    }

    public ArrayList<Turista> agregarTuristas() {
        ArrayList<Turista> turistas = new ArrayList<>();
        System.out.println("Cuantas personas se hospedaran");
        int cantPersonas = scanner.nextInt();
        int nroPersona = 1;
        for(int i = 0; i < cantPersonas; i++){
            System.out.println("Turista numero: "+ nroPersona + " , ingrese el nombre del turista ");
            String nombre = scanner.next();
            System.out.println("Ingrese el apellido del turista");
            String apellido = scanner.next();
            System.out.println("Ingrese el dni del turista");
            String dni = scanner.next();
            Turista turista = new Turista(nombre, apellido, dni);
            turistas.add(turista);
            nroPersona++;
        }
        return turistas;
    }

    public void pagar(Usuario usuario, Producto producto) {
        System.out.println("Seleccionar medio de pago");
        System.out.println("Ingrese 1 para tarjeta Disney\n" + "Ingrese 2 para tarjeta de credito");
        int accion = scanner.nextInt();
        switch(accion){
            case 1: {
                producto.setMedioDePago(new EstrategiaDisney());
                producto.setMonto(producto.getPaquete().getMonto());
                producto.setMontoFinal(producto.getMedioDePago().calcularMontoFinal(producto.getMonto(), producto.getTurista()));
                int codigoOperacion = usuario.getTarjetaDisney().getEstado().efectuarPago(usuario.getTarjetaDisney(), producto.getMontoFinal());
                if(codigoOperacion == 1){
                    System.out.println("Compra realizada");
                    usuario.getProducto().add(producto);
                }
                else {
                    System.out.println("Error: Recargue su tarjeta");
                }
            } break;
            case 2: {
                producto.setMedioDePago(new EstrategiaCredito());
                producto.setMonto(producto.getPaquete().getMonto());
                producto.setMontoFinal(producto.getMedioDePago().calcularMontoFinal(producto.getMonto(), producto.getTurista()));
                System.out.println("Ingrese el numero de su tarjeta de credito");
                String nroTarjeta = scanner.next();
                if(usuario.buscarTarjeta(nroTarjeta) != null) {
                    int codigoOperacion = usuario.buscarTarjeta(nroTarjeta).efectuarPago(producto.getMontoFinal());
                    if(codigoOperacion == 1){
                        System.out.println("Compra realizada");
                        usuario.getProducto().add(producto);
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
