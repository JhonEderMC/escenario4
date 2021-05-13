package com.sura.escenario4.model;

import java.util.Locale;
import java.util.UUID;

public class Conductor {

    private String id;
    private  String name;

    public Conductor(String id, String name) {
        this.id = id.toUpperCase(Locale.ROOT);
        this.name = name.toUpperCase(Locale.ROOT);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id.toUpperCase(Locale.ROOT);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.toUpperCase(Locale.ROOT);
    }
}
