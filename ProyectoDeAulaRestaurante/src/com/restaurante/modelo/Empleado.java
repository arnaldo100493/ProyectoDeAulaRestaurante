/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurante.modelo;

import java.io.Serializable;

/**
 *
 * @author cyber
 */
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
