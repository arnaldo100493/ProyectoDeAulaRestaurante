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
public class Producto implements Serializable {

    protected String codigo;
    protected String nombre;
    protected String descripcion;
    protected int precio;
    protected int cantidad;
    protected String fechaRegistro;

    public Producto() {
        this.codigo = "";
        this.nombre = "";
        this.descripcion = "";
        this.precio = 0;
        this.cantidad = 0;
        this.fechaRegistro = "";
    }

    public Producto(String codigo) {
        this.codigo = codigo;
        this.nombre = "";
        this.descripcion = "";
        this.precio = 0;
        this.cantidad = 0;
        this.fechaRegistro = "";
    }

    public Producto(String codigo, String nombre, String descripcion, int precio, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.fechaRegistro = null;
    }

    public Producto(String codigo, String nombre, String descripcion, int precio, int cantidad, String fechaRegistro) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.fechaRegistro = fechaRegistro;
    }

    public Producto(Producto producto) {
        this.codigo = producto.getCodigo();
        this.nombre = producto.getNombre();
        this.descripcion = producto.getDescripcion();
        this.precio = producto.getPrecio();
        this.cantidad = producto.getCantidad();
        this.fechaRegistro = producto.getFechaRegistro();
    }

    public String mostrarProducto() {
        return "Código: " + this.codigo + "Nombre: " + this.nombre + "Descripción: " + this.descripcion + "Cantidad: " + this.cantidad + "Fecha Registro: " + this.fechaRegistro;
    }

    @Override
    public String toString() {
        return this.codigo + "|" + this.nombre + "|" + this.descripcion + "|" + this.precio + "|" + this.cantidad + "|" + this.fechaRegistro;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getPrecio() {
        return this.precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getFechaRegistro() {
        return this.fechaRegistro;
    }
}
