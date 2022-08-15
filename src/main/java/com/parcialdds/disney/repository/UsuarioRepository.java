package com.parcialdds.disney.repository;


import com.parcialdds.disney.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public boolean existsByNombreAndContrasenia(String nombre, String contrasenia);
}
