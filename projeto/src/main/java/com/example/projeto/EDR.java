package com.example.projeto;

import java.util.Observable;

public class EDR extends Observable {

    private Integer versao;
    private Integer sensor;
    private String nomeEDR;
    private String nomeVersao;

    public EDR(Integer versao, Integer sensor, String nomeEDR, String nomeVersao) {
        this.versao = versao;
        this.sensor = sensor;
        this.nomeEDR = nomeEDR;
        this.nomeVersao = nomeVersao;
    }

    public void atualizarSensor() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "EDR{" +
                "versao=" + versao +
                ", sensor=" + sensor +
                ", nomeEDR='" + nomeEDR + '\'' +
                ", nomeVersao='" + nomeVersao + '\'' +
                '}';
    }
}
