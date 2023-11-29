package com.maxi.gestaoServico.services.exceptions;

public class StandardError {

    private Long tempo;
    private String mensaje;
    private Integer status;

    public StandardError() {
    }

    public StandardError(Long tempo, String mensaje, Integer status) {
        this.tempo = tempo;
        this.mensaje = mensaje;
        this.status = status;
    }

    public Long getTempo() {
        return tempo;
    }

    public void setTempo(Long tempo) {
        this.tempo = tempo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
