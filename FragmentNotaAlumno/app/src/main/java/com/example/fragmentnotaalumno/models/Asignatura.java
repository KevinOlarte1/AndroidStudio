package com.example.fragmentnotaalumno.models;

public class Asignatura {


    private final String codAsig;
    private final String nomAsig;

    public Asignatura(String codAsig, String nomAsig){
        this.codAsig = codAsig;
        this.nomAsig  = nomAsig;
    }

    public String getCodAsig() {
        return codAsig;
    }

    public String getNomAsig() {
        return nomAsig;
    }

    @Override
    public String toString() {
        return "Asignatura{" +
                "codAsig='" + codAsig + '\'' +
                ", nomAsig='" + nomAsig + '\'' +
                '}';
    }
}
