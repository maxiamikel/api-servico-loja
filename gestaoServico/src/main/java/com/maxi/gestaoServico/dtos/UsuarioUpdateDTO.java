package com.maxi.gestaoServico.dtos;

import com.maxi.gestaoServico.domains.Usuario;

public class UsuarioUpdateDTO {

    private Long id;
    private String email;
    private String userName;
    private String password;

    public UsuarioUpdateDTO() {
    }

    public UsuarioUpdateDTO(Usuario obj) {
        this.id = obj.getId();
        this.email = obj.getEmail();
        this.userName = obj.getUserName();
        this.password = obj.getPassword();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
