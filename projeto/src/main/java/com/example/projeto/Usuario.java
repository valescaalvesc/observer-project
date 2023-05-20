package com.example.projeto;

import java.util.Observable;
import java.util.Observer;

public class Usuario implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Usuario(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void atualizar(EDR edr) {
        edr.addObserver(this);
    }

    public void update(Observable edr, Object arg1) {
        this.ultimaNotificacao = this.nome + ", edr atualizado versao " + edr.toString();
        // System.out.println(this.ultimaNotificacao);
    }
}
