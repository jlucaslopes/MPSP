package com.goobot.apiMPSP.model;

import javax.persistence.*;

@Entity
@Table(name = "PARAMETRIZACAO")
public class Parametrizacao {

    String chave;
    String parametro;


    @Id
    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }
}
