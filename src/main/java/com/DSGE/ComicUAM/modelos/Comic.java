package com.dsge.comicuam.modelos;

public class Comic {
    // Atributos privados para mantener el encapsulamiento
    private Long id; // ID que viene de la base de datos
    private String titulo;
    private String genero;
    private String autor;

    // Constructor completo
    public Comic(Long id, String titulo, String genero, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.autor = autor;
    }

    // Constructor vacío (Esencial si luego usas frameworks como Spring o Hibernate)
    public Comic() {
    }

    // MÉTODOS PÚBLICOS (Ahora sí se pueden usar desde fuera)
    
    public void agregarAFavoritos() {
        // Aquí eventualmente conectarás con tu tabla intermedia 'usuario_comics'
        System.out.println("'" + this.titulo + "' agregado a favoritos.");
    }

    public void actualizarInfo(String titulo, String genero, String autor) {
        this.titulo = titulo;
        this.genero = genero;
        this.autor = autor;
    }

    // GETTERS Y SETTERS (Para leer y modificar los datos de forma segura)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}