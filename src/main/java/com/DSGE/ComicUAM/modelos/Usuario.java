package com.dsge.comicuam.modelos;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("usuario")
public class Usuario {

    @Id
    private Long id;
    private String nombre;
    private boolean esSuscriptor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEsSuscriptor() {
        return esSuscriptor;
    }

    public void setEsSuscriptor(boolean esSuscriptor) {
        this.esSuscriptor = esSuscriptor;
    }
}