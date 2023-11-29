package com.maxi.gestaoServico.dtos;

import com.maxi.gestaoServico.domains.Servico;
import com.maxi.gestaoServico.enums.StatusServicio;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class ServicoDTO {

    private Long servicioId;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private StatusServicio status;

    private double preco;
    private Integer prazo;

    public ServicoDTO() {
    }

    public ServicoDTO(Servico obj) {
        this.descricao = obj.getDescricao();
        this.status = obj.getStatus();
        this.preco = obj.getPreco();
        this.prazo = obj.getPrazo();
    }

    public Long getServicioId() {
        return servicioId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public StatusServicio getStatus() {
        return status;
    }

    public void setStatus(StatusServicio status) {
        this.status = status;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Integer getPrazo() {
        return prazo;
    }

    public void setPrazo(Integer prazo) {
        this.prazo = prazo;
    }

}
