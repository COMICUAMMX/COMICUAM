package com.dsge.comicuam.modelos;

public class Usuario {
    private String id;
    private String nombre;
    private boolean esSuscriptor;


    // Constructor
    public boolean isEsSuscriptor() {
        return esSuscriptor;
    }

    public void setEsSuscriptor(boolean esSuscriptor) {
        this.esSuscriptor = esSuscriptor;
    }
}
