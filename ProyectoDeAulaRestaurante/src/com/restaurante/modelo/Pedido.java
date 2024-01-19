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
