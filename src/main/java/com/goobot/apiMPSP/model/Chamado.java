package com.goobot.apiMPSP.model;


import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "CHAMADO")
public class Chamado {

    Long id;
    String categoria;
    Long dataAbertura;
    Long dataFechamento;
    String status;
    String descricao;
    String loginResponsavel;
    String criadoPor;
    Long lastModified;

    public Chamado(Long id, String categoria, Long dataAbertura, Long dataFechamento, String status, String descricao,
                   String loginResponsavel, String criadoPor, Long lastModified) {
        this.id = id;
        this.categoria = categoria;
        this.dataAbertura = dataAbertura;
        this.dataFechamento = dataFechamento;
        this.status = status;
        this.descricao = descricao;
        this.loginResponsavel = loginResponsavel;
        this.criadoPor = criadoPor;
        this.lastModified = lastModified;
    }

    @Id
    @Column(name = "idChamado")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CHAMADO_SEQ")
    @SequenceGenerator(name = "CHAMADO_SEQ", sequenceName = "CHAMADO_SEQ", allocationSize = 1)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Long getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Long dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Long getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Long dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLoginResponsavel() {
        return loginResponsavel;
    }

    public void setLoginResponsavel(String loginResponsavel) {
        this.loginResponsavel = loginResponsavel;
    }

    public String getCriadoPor() {
        return criadoPor;
    }

    public void setCriadoPor(String criadoPor) {
        this.criadoPor = criadoPor;
    }

    public Long getLastModified() {
        return lastModified;
    }

    public void setLastModified(Long lastModified) {
        this.lastModified = lastModified;
    }

}
