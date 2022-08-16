package com.parcialdds.disney.entity.personaje;

import java.io.*;
import java.net.*;
import java.net.http.*;
import java.util.ArrayList;
import java.util.List;

import com.parcialdds.disney.service.interfaces.PersonajeService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ApiDisney {

    @Autowired
    private PersonajeService personajeService;

    private Personaje personaje;

    static ApiDisney instance;

    public static ApiDisney getInstance(){
        if(instance != null){
            return instance;
        }
        else{
            instance = new ApiDisney();
            return instance;
        }
    }

    public Personaje buscarPersonaje(int id){
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(URI.create("https://api.disneyapi.dev/" + "characters/" + id)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject obj = new JSONObject(response.body());
            int idApi = obj.getInt("_id");
            JSONArray atracciones = obj.getJSONArray("parkAttractions");
            ArrayList<Atraccion> listaAtracciones = new ArrayList<>();
            int cantidadAtracciones = atracciones.length();
            for (int i = 0; i < cantidadAtracciones; i++) {
                Atraccion atraccion = new Atraccion(atracciones.getString(i));
                listaAtracciones.add(atraccion);
            }
            String nombre = obj.getString("name");
            personaje = new Personaje(nombre, idApi, listaAtracciones);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        } catch (InterruptedException e) {
            // this part is executed when an exception (in this example InterruptedException) occurs
        }
        return personaje;
    }

    @Scheduled(cron = "@weekly")
    public void actualizarPersonajes() {
        Personaje alice = buscarPersonaje(174);     // Alice
        Personaje aladdin = buscarPersonaje(156);   // Aladdin
        Personaje donald = buscarPersonaje(1947);   // Pato donald
        Personaje ariel = buscarPersonaje(309);     // Ariel
        Personaje garfio = buscarPersonaje(1044);   // Capitan Garfio
        Personaje baloo = buscarPersonaje(450);     // Baloo
        Personaje elsa = buscarPersonaje(2099);     // Elsa

        personajeService.save(alice);
        personajeService.save(aladdin);
        personajeService.save(donald);
        personajeService.save(ariel);
        personajeService.save(garfio);
        personajeService.save(baloo);
        personajeService.save(elsa);
    }
}
