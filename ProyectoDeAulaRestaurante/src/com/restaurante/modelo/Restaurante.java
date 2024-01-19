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
public class Restaurante implements Serializable {

    private String correoElectronico;
    private String telefono;

    public Restaurante() {
        this.correoElectronico = "";
        this.telefono = "";
    }

    public Restaurante(String correoElectronico, String telefono) {
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
    }

    public String mostrarRestaurante() {
        return "Correo Electrónico: " + this.correoElectronico + "Teléfono: " + this.telefono;
    }

    @Override
    public String toString() {
        return this.correoElectronico + "|" + this.telefono;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getCorreoElectronico() {
        return this.correoElectronico;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return this.telefono;
    }
}
