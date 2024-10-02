package com.william.pruebas;

public class Titular {

    private String titulo;
    private String subtitulo;

    public Titular(String titulo, String subtitulo){
        this.titulo = titulo;
        this.subtitulo = subtitulo;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getSubtitulo() {
        return this.subtitulo;
    }
}
