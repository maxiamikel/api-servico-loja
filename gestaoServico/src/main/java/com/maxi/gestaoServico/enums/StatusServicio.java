package com.maxi.gestaoServico.enums;

public enum StatusServicio {

    ATIVO("Ativo"),
    INATIVO("Inativo"),
    SUSPENSO("Suspenso");

    private String status;

    private StatusServicio(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
