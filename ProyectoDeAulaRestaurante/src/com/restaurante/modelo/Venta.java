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
public class Venta implements Serializable {

    private String codigo;
    private String fechaRegistro;
    private Producto producto;

    public Venta() {
        this.codigo = "";
        this.fechaRegistro = "";
        this.producto = null;
    }

    public Venta(String codigo) {
        this.codigo = codigo;
        this.fechaRegistro = "";
        this.producto = null;
    }

    public Venta(Producto producto) {
        this.codigo = "";
        this.fechaRegistro = "";
        this.producto = producto;
    }

    public Venta(String codigo, Producto producto) {
        this.codigo = codigo;
        this.producto = producto;
    }

    public Venta(String codigo, String fechaRegistro, Producto producto) {
        this.codigo = codigo;
        this.fechaRegistro = fechaRegistro;
        this.producto = producto;
    }

    public String mostrarVenta() {
        return "Código: " + this.codigo + "Fecha Registro: " + this.fechaRegistro + "Producto: " + this.producto;
    }

    @Override
    public String toString() {
        return this.codigo + "|" + this.fechaRegistro + "|" + this.producto;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getFechaRegistro() {
        return this.fechaRegistro;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Producto getProducto() {
        return this.producto;
    }
}
