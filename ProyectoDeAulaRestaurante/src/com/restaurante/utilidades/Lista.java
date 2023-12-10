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

/**
 *
 * @author cyber
 * @param <E> elemento
 */
public interface Lista<E> {

    public boolean estaVacia();

    public int tamanio();

    public boolean agregar(E elemento);

    public void agregar(int indice, E elemento);

    public E modificar(int indice, E elemento);

    public E obtener(int indice);

    public boolean remover(Object objeto);

    public E remover(int indice);

    public void limpiar();

    public boolean esIgual(Object objeto);

    public boolean contiene(Object objeto);

    public int indiceDe(Object objeto);

    public int ultimoIndiceDe(Object objeto);
}
