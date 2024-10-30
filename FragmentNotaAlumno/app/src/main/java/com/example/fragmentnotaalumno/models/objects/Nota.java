package com.example.fragmentnotaalumno.models.objects;

import java.io.Serializable;

public class Nota implements Serializable {
    private String codAsig;
    private float calificacion;

    public Nota(String codAsig, float calificacion) {
        this.codAsig = codAsig;
        this.calificacion = calificacion;
    }

    public String getCodAsig() { return codAsig; }
    public float getCalificacion() { return calificacion; }
}