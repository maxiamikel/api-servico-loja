package com.maxi.gestaoServico.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maxi.gestaoServico.domains.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "select u from Usuario u")
    List<Usuario> findAll();

    // @Query(value = "select u from Usuario u where u.email =: email")
    Usuario findUserByEmail(String email);
}
