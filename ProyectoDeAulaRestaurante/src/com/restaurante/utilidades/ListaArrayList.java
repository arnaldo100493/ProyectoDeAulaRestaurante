/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurante.utilidades;

import java.util.ArrayList;

/**
 *
 * @author cyber
 * @param <E> elemento
 */
public class ListaArrayList<E> implements Lista<E> {

    private final ArrayList<E> listaArregloElementos;

    public ListaArrayList() {
        this.listaArregloElementos = new ArrayList<>();
    }

    public ListaArrayList(int capacidadInicial) {
        this.listaArregloElementos = new ArrayList<>(capacidadInicial);
    }

    @Override
    public boolean estaVacia() {
        return this.listaArregloElementos.isEmpty();
    }

    @Override
    public int tamanio() {
        return this.listaArregloElementos.size();
    }

    public void asegurarCapacidad(int capacidadMinima) {
        this.listaArregloElementos.ensureCapacity(capacidadMinima);
    }

    @Override
    public boolean agregar(E elemento) {
        return this.listaArregloElementos.add(elemento);
    }

    @Override
    public void agregar(int indice, E elemento) {
        this.listaArregloElementos.add(indice, elemento);
    }

    @Override
    public E modificar(int indice, E elemento) {
        return this.listaArregloElementos.set(indice, elemento);
    }

    @Override
    public E obtener(int indice) {
        return this.listaArregloElementos.get(indice);
    }

    @Override
    public boolean remover(Object objeto) {
        return this.listaArregloElementos.remove(objeto);
    }

    @Override
    public E remover(int indice) {
        return this.listaArregloElementos.remove(indice);
    }

    @Override
    public void limpiar() {
        this.listaArregloElementos.clear();
    }

    @Override
    public boolean esIgual(Object objeto) {
        return this.listaArregloElementos.equals(objeto);
    }

    @Override
    public boolean contiene(Object objeto) {
        return this.listaArregloElementos.contains(objeto);
    }

    @Override
    public int indiceDe(Object objeto) {
        return this.listaArregloElementos.indexOf(objeto);
    }

    @Override
    public int ultimoIndiceDe(Object objeto) {
        return this.listaArregloElementos.lastIndexOf(objeto);
    }
}
