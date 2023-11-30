package com.restaurante.modelo;

import java.io.Serializable;

public class Empleado extends Persona implements Serializable {

    private int sueldo;

    public Empleado() {
        super();
        this.sueldo = 0;
    }

    public Empleado(String identificacion) {
        super(identificacion);
        this.sueldo = 0;
    }

    public Empleado(int sueldo) {
        super();
        this.sueldo = sueldo;
    }

    public Empleado(String identificacion, String nombre, String apellido, String direccion, String telefono, String correoElectronico, String sexo, int sueldo) {
        super(identificacion, nombre, apellido, direccion, telefono, correoElectronico, sexo);
        this.sueldo = sueldo;
    }

    public Empleado(String identificacion, String nombre, String apellido, String direccion, String telefono, String correoElectronico, String sexo, String fechaRegistro, int sueldo) {
        super(identificacion, nombre, apellido, direccion, telefono, correoElectronico, sexo, fechaRegistro);
        this.sueldo = sueldo;
    }

    public Empleado(Persona persona, int sueldo) {
        super(persona);
        this.sueldo = sueldo;
    }

    public Empleado(Empleado empleado) {
        super();
        this.identificacion = empleado.getIdentificacion();
        this.nombre = empleado.getNombre();
        this.apellido = empleado.getApellido();
        this.direccion = empleado.getDireccion();
        this.telefono = empleado.getTelefono();
        this.correoElectronico = empleado.getCorreoElectronico();
        this.sexo = empleado.getSexo();
        this.fechaRegistro = empleado.getFechaRegistro();
        this.sueldo = empleado.getSueldo();
    }

    public String mostrarEmpleado() {
        return super.mostrarPersona() + "Sueldo: " + this.sueldo;
    }

    @Override
    public String toString() {
        return super.toString() + this.sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public int getSueldo() {
        return this.sueldo;
    }

}
