package com.parcialdds.disney.controller;

import com.parcialdds.disney.entity.Usuario;
import com.parcialdds.disney.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Crear usuario
    @PostMapping
    public ResponseEntity<?> create (@RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
    }

    // Leer usuario
    @GetMapping("/{id}")
    public ResponseEntity<?> read (@PathVariable Long id){
        Optional<Usuario> oUsuario = usuarioService.findById(id);

        if(!oUsuario.isPresent()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(oUsuario);
    }

    // Actualizar usuario
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar (@RequestBody Usuario infoUsuario, @PathVariable Long id){
        Optional<Usuario> usuario = usuarioService.findById(id);

        if(!usuario.isPresent()){
            return ResponseEntity.notFound().build();
        }

        usuario.get().setNombre(infoUsuario.getNombre());
        usuario.get().setContrasenia(infoUsuario.getContrasenia());
        usuario.get().setCuil(infoUsuario.getCuil());

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario.get()));
    }

    // Eliminar usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar (@PathVariable Long id){
        if(usuarioService.findById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }

        usuarioService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    // Leer todos los usuarios
    @GetMapping
    public List<Usuario> leerTodos () {
        List<Usuario> usuarios = StreamSupport.stream(usuarioService.findAll().spliterator(), false).collect(Collectors.toList());

        return usuarios;
    }


}
