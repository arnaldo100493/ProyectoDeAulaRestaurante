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
