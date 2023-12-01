package com.maxi.gestaoServico.enums;

public enum UserPerfil {

    ADMIN("Admin"),
    USER("User"),
    INVITADO("Invitado");

    private String status;

    private UserPerfil(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
