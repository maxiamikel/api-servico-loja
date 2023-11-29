package com.maxi.gestaoServico.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maxi.gestaoServico.domains.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long> {

    @Query("SELECT s FROM Servico s")
    List<Servico> findAll();

    // List<Servico> findByName();

}
