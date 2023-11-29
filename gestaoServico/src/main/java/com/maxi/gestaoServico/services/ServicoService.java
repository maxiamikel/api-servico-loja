package com.maxi.gestaoServico.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.maxi.gestaoServico.domains.Servico;
import com.maxi.gestaoServico.dtos.ServicoDTO;
import com.maxi.gestaoServico.repositories.ServicoRepository;
import com.maxi.gestaoServico.services.exceptions.NoSuchElementException;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ServicoService {

    @Autowired
    private ServicoRepository repo;

    public Servico findById(Long id) {
        Optional<Servico> obj = repo.findById(id);
        return obj.orElseThrow(() -> new NoSuchElementException("O codigo informado " + id + " não existe"));
    }

    /*
     * public List<Servico> findAll() {
     * // List<Servico> list = repo.findAll();
     * // List<ServicoDTO> listDTO = list.stream().map(obj -> new
     * // ServicoDTO()).collect(Collectors.toList());
     * // return listDTO;
     * // list.stream().map(obj -> new ProductDto()).collect(Collectors.toList());
     * return repo.findAll();
     * 
     * }
     */

    public Page<Servico> findAll() {
        Pageable pageable = PageRequest.of(0, 5);
        return repo.findAll(pageable);
    }

    public Servico createNew(ServicoDTO obj) {
        Servico servico = new Servico(obj.getDescricao(), obj.getStatus(), obj.getPreco(), obj.getPrazo());
        servico = repo.save(servico);
        return servico;
    }
}
