package com.maxi.gestaoServico.dtos;

import com.maxi.gestaoServico.domains.Usuario;
import com.maxi.gestaoServico.enums.UserPerfil;
import com.maxi.gestaoServico.enums.UserStatus;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class UsuarioViewDTO {

    private Long id;

    private String userName;
    private String email;

    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    @Enumerated(EnumType.STRING)
    private UserPerfil userPerfil;

    public UsuarioViewDTO() {
    }

    public UsuarioViewDTO(Usuario obj) {
        this.userName = obj.getUserName();
        this.email = obj.getEmail();
        this.userPerfil = obj.getUserPerfil();
        this.userStatus = obj.getUserStatus();
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

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public UserPerfil getUserPerfil() {
        return userPerfil;
    }

    public void setUserPerfil(UserPerfil userPerfil) {
        this.userPerfil = userPerfil;
    }

}
