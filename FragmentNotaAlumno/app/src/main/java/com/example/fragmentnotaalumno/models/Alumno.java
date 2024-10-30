package com.example.fragmentnotaalumno.models;

import java.util.HashMap;
import java.util.Map;

public class Alumno {
    private final int nia;
    private final String nombre;
    private final String apellido1;
    private final String apellido2;
    private final String fechaNacimiento;

    private final  String email;

    private final Map<String,Double> notas;


    public Alumno(int nia, String nombre, String apellido1, String apellido2,
                  String fechaNacimiento, String email,
                  Map<String, Double> notas){
        this.nia = nia;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.notas = notas;


    }

    public int getNia() {
        return nia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public Map<String, Double> getNotas() {
        return notas;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nia=" + nia +
                ", nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", email='" + email + '\'' +
                ", notas=" + notas +
                '}';
    }
}
