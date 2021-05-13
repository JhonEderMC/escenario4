package com.sura.escenario4.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Locale;

@Document
public class InformacionCarro {
    @Id
    private  String placa;
    private String marca;
    private String modelo;
    private  Conductor conductor;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa.toUpperCase(Locale.ROOT);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca.toUpperCase(Locale.ROOT);
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo.toUpperCase(Locale.ROOT);
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }
}
