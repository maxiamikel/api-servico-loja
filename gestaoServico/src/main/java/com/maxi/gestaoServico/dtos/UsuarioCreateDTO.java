package com.maxi.gestaoServico.dtos;

import com.maxi.gestaoServico.domains.Usuario;

public class UsuarioCreateDTO {

    private Long id;

    private String userName;
    private String email;
    private String password;

    /*
     * @Enumerated(EnumType.STRING)
     * private UserStatus userStatus;
     * 
     * @Enumerated(EnumType.STRING)
     * private UserPerfil userPerfil;
     */

    public UsuarioCreateDTO() {
    }

    public UsuarioCreateDTO(Usuario obj) {
        this.userName = obj.getUserName();
        this.email = obj.getEmail();
        this.password = obj.getPassword();
    }

    public Long getId() {
        return id;
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
