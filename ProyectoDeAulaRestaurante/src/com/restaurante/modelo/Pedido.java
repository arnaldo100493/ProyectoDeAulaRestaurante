package com.restaurante.modelo;

import java.io.Serializable;

public class Pedido implements Serializable {

    private String codigo;
    private String fechaRegistro;

    public Pedido() {
        this.codigo = "";
        this.fechaRegistro = "";
    }

    public Pedido(String codigo) {
        this.codigo = codigo;
        this.fechaRegistro = "";
    }

    public Pedido(String codigo, String fechaRegistro) {
        this.codigo = codigo;
        this.fechaRegistro = fechaRegistro;
    }

    public String mostrarPedido() {
        return "Codigo: " + this.codigo + "Fecha Registro: " + this.fechaRegistro;
    }

    @Override
    public String toString() {
        return this.codigo + "|" + this.fechaRegistro;
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
}
