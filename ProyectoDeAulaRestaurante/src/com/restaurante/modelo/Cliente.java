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
public class Cliente extends Persona implements Serializable {

    public Cliente() {
        super();
    }

    public Cliente(String identificacion) {
        super(identificacion);
    }

    public Cliente(String direccion, String telefono, String correoElectronico) {
        super();
    }

    public Cliente(String identificacion, String nombre, String apellido, String direccion, String telefono, String correoElectronico, String sexo) {
        super(identificacion, nombre, apellido, direccion, telefono, correoElectronico, sexo, telefono);
    }

    public Cliente(String identificacion, String nombre, String apellido, String sexo, String fechaRegistro, String direccion, String telefono, String correoElectronico) {
        super(identificacion, nombre, apellido, direccion, telefono, correoElectronico, sexo, fechaRegistro);

    }

    public String mostrarCliente() {
        return super.mostrarPersona();
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
