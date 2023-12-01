package com.maxi.gestaoServico.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.maxi.gestaoServico.domains.Usuario;
import com.maxi.gestaoServico.dtos.UsuarioCreateDTO;
import com.maxi.gestaoServico.dtos.UsuarioUpdateDTO;
import com.maxi.gestaoServico.dtos.UsuarioViewDTO;
import com.maxi.gestaoServico.services.UsuarioService;

@RestController
@RequestMapping(value = "/api/loja/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value = "/")
    public ResponseEntity<?> findAll() {
        List<UsuarioViewDTO> listUsuario = usuarioService.findAll();
        if (listUsuario.size() == 0) {
            return ResponseEntity.ok().body("Lista vazia, sem conteudos paea exibir");
        }
        return ResponseEntity.ok().body(listUsuario);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Usuario usuario = usuarioService.findById(id);
        return ResponseEntity.ok().body(usuario);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestBody UsuarioCreateDTO obj) {
        Usuario usuario = usuarioService.createNew(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(usuario);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> update(@RequestBody UsuarioUpdateDTO obj) {
        return ResponseEntity.ok().body(usuarioService.updateUsuario(obj, obj.getId()));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteUser(id);
        return ResponseEntity.ok().body("Cadastro [" + id + "] foi deletado com sucesso!");
    }
}
