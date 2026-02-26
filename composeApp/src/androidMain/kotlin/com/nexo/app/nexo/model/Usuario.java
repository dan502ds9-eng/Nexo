package com.nexo.app.nexo.model;

public class Usuario {

    private int idUsuario;
    private String nombre;
    private String correo;
    private String pinAcceso;

    public Usuario(String nombre, String correo, String pinAcceso) {
        this.nombre = nombre;
        this.correo = correo;
        this.pinAcceso = pinAcceso;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPinAcceso() {
        return pinAcceso;
    }
}