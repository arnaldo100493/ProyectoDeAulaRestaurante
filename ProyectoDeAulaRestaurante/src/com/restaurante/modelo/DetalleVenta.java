package com.restaurante.modelo;

import java.io.Serializable;

public class DetalleVenta implements Serializable {

    private int cantidad;
    private int total;

    public DetalleVenta() {
        this.cantidad = 0;
        this.total = 0;
    }

    public DetalleVenta(int cantidad, int total) {
        this.cantidad = cantidad;
        this.total = total;
    }

    public DetalleVenta(DetalleVenta detalleVenta) {
        this.cantidad = detalleVenta.getCantidad();
        this.total = detalleVenta.getTotal();
    }

    public String mostrarDetalleVenta() {
        return "Cantidad: " + this.cantidad + "Total: " + this.total;
    }

    @Override
    public String toString() {
        return this.cantidad + "|" + this.total;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal() {
        return this.total;
    }

}
