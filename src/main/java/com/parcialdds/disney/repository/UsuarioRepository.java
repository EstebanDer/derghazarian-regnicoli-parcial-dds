package com.parcialdds.disney.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.parcialdds.disney.entity.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
