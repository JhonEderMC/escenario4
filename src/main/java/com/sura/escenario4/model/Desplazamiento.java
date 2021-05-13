package com.sura.escenario4.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Locale;

@Document
public class Desplazamiento {

    @Id
    private String id;
    private String placa;
    private String Origen;
    private String destino;
    private LocalDate fechaOrigen;
    private LocalDate fechaDestino;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id.toUpperCase(Locale.ROOT);
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa.toUpperCase(Locale.ROOT);
    }

    public String getOrigen() {
        return Origen;
    }

    public void setOrigen(String origen) {
        Origen = origen.toUpperCase(Locale.ROOT);
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino.toUpperCase(Locale.ROOT);
    }

    public LocalDate getFechaOrigen() {
        return fechaOrigen;
    }

    public void setFechaOrigen(LocalDate fechaOrigen) {
        this.fechaOrigen = fechaOrigen;
    }

    public LocalDate getFechaDestino() {
        return fechaDestino;
    }

    public void setFechaDestino(LocalDate fechaDestino) {
        this.fechaDestino = fechaDestino;
    }
}
