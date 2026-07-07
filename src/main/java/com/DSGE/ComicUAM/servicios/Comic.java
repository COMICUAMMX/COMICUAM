package com.dsge.comicuam.servicios;

public class Comic {
    public String titulo;
    public String genero;
    public String autor;

    public Comic(String titulo, String genero, String autor) {
        this.titulo = titulo;
        this.genero = genero;
        this.autor = autor;
    }

    private void agregarAFavoritos() {
        System.out.println("'" + titulo + "' agregado a favoritos.");
    }

    private void actualizarInfo(String titulo, String genero, String autor) {
        this.titulo = titulo;
        this.genero = genero;
        this.autor = autor;
    }

}