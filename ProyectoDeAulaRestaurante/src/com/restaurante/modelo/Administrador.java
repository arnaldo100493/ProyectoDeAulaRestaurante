package com.restaurante.modelo;

import java.io.Serializable;

public class Administrador extends Persona implements Serializable {

    private String usuario;
    private String contrasenia;

    public Administrador() {
        super();
        this.usuario = "";
        this.contrasenia = "";
    }

    public Administrador(String identificacion) {
        super(identificacion);
        this.usuario = "";
        this.contrasenia = "";
    }

    public Administrador(String usuario, String contrasenia) {
        super();
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public Administrador(String identificacion, String nombre, String apellido, String direccion, String telefono, String correoElectronico, String sexo, String usuario, String contrasenia) {
        super(identificacion, nombre, apellido, direccion, telefono, correoElectronico, sexo);
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public Administrador(String identificacion, String nombre, String apellido, String direccion, String telefono, String correoElectronico, String sexo, String fechaRegistro, String usuario, String contrasenia) {
        super(identificacion, nombre, apellido, direccion, telefono, correoElectronico, sexo, fechaRegistro);
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public Administrador(Persona persona, String usuario, String contrasenia) {
        super(persona);
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public Administrador(Administrador administrador) {
        super();
        this.identificacion = administrador.getIdentificacion();
        this.usuario = administrador.getUsuario();
        this.contrasenia = administrador.getContrasenia();
    }

    public String mostrarAdministrador() {
        return super.mostrarPersona() + "Usuario: " + this.usuario + "Contraseña: " + this.contrasenia;
    }

    @Override
    public String toString() {
        return super.toString() + "|" + this.usuario + "|" + this.contrasenia;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getContrasenia() {
        return this.contrasenia;
    }
}
