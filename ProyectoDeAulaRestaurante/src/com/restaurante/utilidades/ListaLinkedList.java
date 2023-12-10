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

import java.util.LinkedList;

/**
 *
 * @author cyber
 * @param <E> elemento
 */
public class ListaLinkedList<E> implements Lista<E> {
    
    private final LinkedList<E> listaEnlazadaElementos;
    
    public ListaLinkedList() {
        this.listaEnlazadaElementos = new LinkedList<>();
    }
    
    @Override
    public boolean estaVacia() {
        return this.listaEnlazadaElementos.isEmpty();
    }
    
    @Override
    public int tamanio() {
        return this.listaEnlazadaElementos.size();
    }
    
    @Override
    public boolean agregar(E elemento) {
        return this.listaEnlazadaElementos.add(elemento);
    }
    
    @Override
    public void agregar(int indice, E elemento) {
        this.listaEnlazadaElementos.add(indice, elemento);
    }
    
    public void agregarPrimero(E elemento) {
        this.listaEnlazadaElementos.addFirst(elemento);
    }
    
    public void agregarUltimo(E elemento) {
        this.listaEnlazadaElementos.addLast(elemento);
    }
    
    @Override
    public E modificar(int indice, E elemento) {
        return this.listaEnlazadaElementos.set(indice, elemento);
    }
    
    public void empujar(E elemento) {
        this.listaEnlazadaElementos.push(elemento);
    }
    
    public boolean ofrecer(E elemento) {
        return this.listaEnlazadaElementos.offer(elemento);
    }
    
    public boolean ofrecerPrimero(E elemento) {
        return this.listaEnlazadaElementos.offerFirst(elemento);
    }
    
    public boolean ofrecerUltimo(E elemento) {
        return this.listaEnlazadaElementos.offerLast(elemento);
    }
    
    @Override
    public E obtener(int indice) {
        return this.listaEnlazadaElementos.get(indice);
    }
    
    public E obtenerPrimero() {
        return this.listaEnlazadaElementos.getFirst();
    }
    
    public E obtenerUltimo() {
        return this.listaEnlazadaElementos.getLast();
    }
    
    public E elemento() {
        return this.listaEnlazadaElementos.element();
    }
    
    public E ojear() {
        return this.listaEnlazadaElementos.peek();
    }
    
    public E ojearPrimero() {
        return this.listaEnlazadaElementos.peekFirst();
    }
    
    public E ojearUltimo() {
        return this.listaEnlazadaElementos.peekLast();
    }
    
    public E encuestar() {
        return this.listaEnlazadaElementos.poll();
    }
    
    public E encuestarPrimero() {
        return this.listaEnlazadaElementos.pollFirst();
    }
    
    public E encuestarUltimo() {
        return this.listaEnlazadaElementos.pollLast();
    }
    
    @Override
    public boolean remover(Object objeto) {
        return this.listaEnlazadaElementos.remove(objeto);
    }
    
    @Override
    public E remover(int indice) {
        return this.listaEnlazadaElementos.remove(indice);
    }
    
    public E remover() {
        return this.listaEnlazadaElementos.remove();
    }
    
    public E removerPrimero() {
        return this.listaEnlazadaElementos.removeFirst();
    }
    
    public E removerUltimo() {
        return this.listaEnlazadaElementos.removeLast();
    }
    
    public boolean removerPrimeraOcurrencia(Object objeto) {
        return this.listaEnlazadaElementos.removeFirstOccurrence(objeto);
    }
    
    public boolean removerUltimaOcurrencia(Object objeto) {
        return this.listaEnlazadaElementos.removeLastOccurrence(objeto);
    }
    
    public E sacar() {
        return this.listaEnlazadaElementos.pop();
    }
    
    @Override
    public void limpiar() {
        this.listaEnlazadaElementos.clear();
    }
    
    @Override
    public boolean esIgual(Object objeto) {
        return this.listaEnlazadaElementos.equals(objeto);
    }
    
    @Override
    public boolean contiene(Object objeto) {
        return this.listaEnlazadaElementos.contains(objeto);
    }
    
    @Override
    public int indiceDe(Object objeto) {
        return this.listaEnlazadaElementos.indexOf(objeto);
    }
    
    @Override
    public int ultimoIndiceDe(Object objeto) {
        return this.listaEnlazadaElementos.lastIndexOf(objeto);
    }
}
