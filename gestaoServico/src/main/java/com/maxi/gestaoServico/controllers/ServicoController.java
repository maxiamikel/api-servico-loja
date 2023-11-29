package com.maxi.gestaoServico.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxi.gestaoServico.domains.Servico;
import com.maxi.gestaoServico.dtos.ServicoDTO;
import com.maxi.gestaoServico.services.ServicoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/loja/servicos")
public class ServicoController {

    @Autowired
    private ServicoService objService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findBiId(@PathVariable Long id) {
        Servico obj = objService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok().body(objService.findAll());
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@Valid @RequestBody ServicoDTO servicoDTO) {
        Servico servico = objService.createNew(servicoDTO);
        return ResponseEntity.ok().body(servico);
    }

}
