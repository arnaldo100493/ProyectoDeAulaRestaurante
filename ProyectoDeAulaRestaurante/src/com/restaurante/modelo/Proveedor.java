package com.restaurante.modelo;

import java.io.Serializable;

public class Proveedor extends Persona implements Serializable {

    private String empresa;
    private String nitEmpresa;

    public Proveedor() {
        super();
        this.empresa = "";
        this.nitEmpresa = "";
    }

    public Proveedor(String identificacion) {
        super(identificacion);
        this.empresa = "";
        this.nitEmpresa = "";
    }

    public Proveedor(String empresa, String nitEmpresa) {
        super();
        this.empresa = empresa;
        this.nitEmpresa = nitEmpresa;
    }

    public Proveedor(String identificacion, String nombre, String apellido, String direccion, String telefono, String correoElectronico, String sexo, String empresa, String nitEmpresa) {
        super(identificacion, nombre, apellido, direccion, telefono, correoElectronico, sexo);
        this.empresa = empresa;
        this.nitEmpresa = nitEmpresa;
    }

    public Proveedor(String identificacion, String nombre, String apellido, String direccion, String telefono, String correoElectronico, String sexo, String fechaRegistro, String empresa, String nitEmpresa) {
        super(identificacion, nombre, apellido, direccion, telefono, correoElectronico, sexo, fechaRegistro);
        this.empresa = empresa;
        this.nitEmpresa = nitEmpresa;
    }

    public Proveedor(Persona persona, String empresa, String nitEmpresa) {
        super(persona);
        this.empresa = empresa;
        this.nitEmpresa = nitEmpresa;
    }

    public Proveedor(Proveedor proveedor) {
        super();
        this.identificacion = proveedor.getIdentificacion();
        this.nombre = proveedor.getNombre();
        this.apellido = proveedor.getApellido();
        this.direccion = proveedor.getDireccion();
        this.telefono = proveedor.getTelefono();
        this.correoElectronico = proveedor.getCorreoElectronico();
        this.sexo = proveedor.getSexo();
        this.fechaRegistro = proveedor.getFechaRegistro();
        this.empresa = proveedor.getEmpresa();
        this.nitEmpresa = proveedor.getNitEmpresa();
    }

    public String mostrarProveedor() {
        return super.mostrarPersona() + "Empresa: " + this.empresa + "Nit Empresa: " + this.nitEmpresa;
    }

    @Override
    public String toString() {
        return super.toString() + "|" + this.empresa + "|" + this.nitEmpresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getEmpresa() {
        return this.empresa;
    }

    public void setNitEmpresa(String nitEmpresa) {
        this.nitEmpresa = nitEmpresa;
    }

    public String getNitEmpresa() {
        return this.nitEmpresa;
    }
}
