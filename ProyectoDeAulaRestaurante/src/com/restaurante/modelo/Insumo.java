package com.restaurante.modelo;

import java.io.Serializable;

public class Insumo extends Producto implements Serializable {

    private int cantidadMinima;
    private int cantidadMaxima;

    public Insumo() {
        super();
        this.cantidadMinima = 0;
        this.cantidadMaxima = 0;
    }

    public Insumo(int cantidadMinima, int cantidadMaxima) {
        super();
        this.cantidadMinima = cantidadMinima;
        this.cantidadMaxima = cantidadMaxima;
    }

    public Insumo(String codigo, String nombre, String descripcion, int precio, int cantidad, int cantidadMinima, int cantidadMaxima) {
        super(codigo, nombre, descripcion, precio, cantidad);
        this.cantidadMinima = cantidadMinima;
        this.cantidadMaxima = cantidadMaxima;
    }

    public Insumo(String codigo, String nombre, String descripcion, int precio, int cantidad, String fechaRegistro, int cantidadMinima, int cantidadMaxima) {
        super(codigo, nombre, descripcion, precio, cantidad, fechaRegistro);
        this.cantidadMinima = cantidadMinima;
        this.cantidadMaxima = cantidadMaxima;
    }

    public Insumo(Producto producto, int cantidadMinima, int cantidadMaxima) {
        super(producto);
        this.cantidadMinima = cantidadMinima;
        this.cantidadMaxima = cantidadMaxima;
    }

    public Insumo(Insumo insumo) {
        super();
        this.codigo = insumo.getCodigo();
        this.nombre = insumo.getNombre();
        this.descripcion = insumo.getDescripcion();
        this.precio = insumo.getPrecio();
        this.cantidad = insumo.getCantidad();
        this.cantidadMinima = insumo.getCantidadMinima();
        this.cantidadMaxima = insumo.getCantidadMaxima();
    }

    public String mostrarInsumo() {
        return super.mostrarProducto() + "Cantidad Mínima: " + this.cantidadMinima + "Cantidad Máxima: " + this.cantidadMaxima;
    }

    @Override
    public String toString() {
        return super.toString() + "|" + this.cantidadMinima + "|" + this.cantidadMaxima;
    }

    public void setCantidadMinima(int cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    public int getCantidadMinima() {
        return this.cantidadMinima;
    }

    public void setCantidadMaxima(int cantidadMaxima) {
        this.cantidadMaxima = cantidadMaxima;
    }

    public int getCantidadMaxima() {
        return this.cantidadMaxima;
    }
}
