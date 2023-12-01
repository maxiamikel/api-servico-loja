package com.maxi.gestaoServico.domains;

import java.io.Serializable;

import com.maxi.gestaoServico.enums.StatusServicio;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "servicos")
public class Servico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long servicioId;

    @NotBlank(message = "A descrião é obligatoria")
    // @NotEmpty(message = "Descricao required")
    private String descricao;

    @Enumerated(EnumType.STRING)
    private StatusServicio status;

    private double preco;

    private Integer prazo;

    public Servico() {
    }

    public Servico(String descricao, StatusServicio status, double preco, Integer prazo) {
        this.descricao = descricao;
        this.status = status;
        this.preco = preco;
        this.prazo = prazo;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((servicioId == null) ? 0 : servicioId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Servico other = (Servico) obj;
        if (servicioId == null) {
            if (other.servicioId != null)
                return false;
        } else if (!servicioId.equals(other.servicioId))
            return false;
        return true;
    }

}
