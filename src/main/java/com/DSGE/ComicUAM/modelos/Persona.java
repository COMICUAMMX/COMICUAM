package com.dsge.comicuam.modelos;

public class Persona {
    private int isUsuario;
    private String nombre;
    private String correo;
    private String contraseña;
    private Boolean Suscrito;
    private Boolean status;
    private String tarjeta;

    public Persona(int isUsuario, String nombre, String correo, String contraseña, Boolean suscrito, Boolean status,
            String tarjeta) {
        this.isUsuario = isUsuario;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        Suscrito = suscrito;
        this.status = status;
        this.tarjeta = tarjeta;
    }

    public boolean IniciarSesion(String correo, String contraseña) {
        if (this.correo.equals(correo) && this.contraseña.equals(contraseña)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean VerificarSuscripcion() {
        return this.Suscrito;
    }

}
