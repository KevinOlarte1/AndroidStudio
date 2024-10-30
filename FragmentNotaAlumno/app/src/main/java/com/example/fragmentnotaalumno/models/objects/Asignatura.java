package com.example.fragmentnotaalumno.models.objects;

import java.io.Serializable;

public class Asignatura implements Serializable {
    private String codAsig;
    private String nomAsig;

    public Asignatura(String codAsig, String nomAsig) {
        this.codAsig = codAsig;
        this.nomAsig = nomAsig;
    }

    public String getCodAsig() { return codAsig; }
    public String getNomAsig() { return nomAsig; }
}
