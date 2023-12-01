package com.maxi.gestaoServico.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.maxi.gestaoServico.domains.Usuario;
import com.maxi.gestaoServico.dtos.UsuarioCreateDTO;
import com.maxi.gestaoServico.dtos.UsuarioUpdateDTO;
import com.maxi.gestaoServico.dtos.UsuarioViewDTO;
import com.maxi.gestaoServico.repositories.UsuarioRepository;
import com.maxi.gestaoServico.services.exceptions.DataIntegrityViolationException;
import com.maxi.gestaoServico.services.exceptions.NoSuchElementException;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    private BCryptPasswordEncoder passwordEncoder;

    public List<UsuarioViewDTO> findAll() {
        List<Usuario> list = repo.findAll();
        List<UsuarioViewDTO> listDTO = list.stream().map(obj -> new UsuarioViewDTO(obj)).collect(Collectors.toList());
        return listDTO;
    }

    public Usuario findById(Long id) {
        Optional<Usuario> obj = repo.findById(id);
        return obj.orElseThrow(
                () -> new NoSuchElementException("O id informado [" + id + "] não existe no banco do sistema"));
    }

    private Usuario findUserExistByEmail(String email) {
        Usuario usuario = repo.findUserByEmail(email);
        if (usuario != null) {
            return usuario;
        }
        return null;
    }

    public Usuario createNew(UsuarioCreateDTO obj) {
        this.passwordEncoder = new BCryptPasswordEncoder();
        Usuario usuario = repo.findUserByEmail(obj.getEmail());
        if (usuario != null) {
            throw new DataIntegrityViolationException("O email informado já existe no banco");
        } else {
            Usuario usr = new Usuario(obj.getUserName(), obj.getEmail(), passwordEncoder.encode(obj.getPassword()));
            usr = repo.saveAndFlush(usr);
            return usr;
        }
    }

    public Usuario updateUsuario(UsuarioUpdateDTO obj, Long id) {
        Usuario usuario = findUserExistByEmail(obj.getEmail());
        this.passwordEncoder = new BCryptPasswordEncoder();

        if (usuario != null) {
            if (usuario.getId() == obj.getId()) {

            } else {
                throw new DataIntegrityViolationException(
                        "O ID [" + id + "] informado não corresponde ao seu cadastro. Você não pode modificar o ID");
            }
            usuario.setUserName(obj.getUserName());
            usuario.setPassword(passwordEncoder.encode(obj.getPassword()));
            return repo.saveAndFlush(usuario);
        } else {
            throw new DataIntegrityViolationException("O e-mail [" + obj.getEmail()
                    + "] informado não está cadastrado no sistema. Você não pode modificar o email");
        }
    }

    public void deleteUser(Long id) {
        Usuario obj = this.findById(id);
        if (obj != null) {
            repo.deleteById(id);
        } else {
            throw new NoSuchElementException("O ID [" + id + "] informado não se encontra disponivel no sistema");
        }
    }
}
