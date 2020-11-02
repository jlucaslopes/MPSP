package com.goobot.apiMPSP.model;


import javax.persistence.*;

@Entity
@Table(name = "CHAT")
public class Chat {

    Long id;
    Chamado chamado;
    String texto;
    String usuarioEnvio;
    Long dataEnvio;

    @Id
    @Column(name = "idChat")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CHAT_SEQ")
    @SequenceGenerator(name = "CHAT_SEQ", sequenceName = "CHAT_SEQ", allocationSize = 1)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne()
    @JoinColumn(name = "idChamado", nullable = false)
    public Chamado getChamado() {
        return chamado;
    }

    public void setChamado(Chamado chamado) {
        this.chamado = chamado;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getUsuarioEnvio() {
        return usuarioEnvio;
    }

    public void setUsuarioEnvio(String usuarioEnvio) {
        this.usuarioEnvio = usuarioEnvio;
    }

    public Long getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(Long dataEnvio) {
        this.dataEnvio = dataEnvio;
    }
}
