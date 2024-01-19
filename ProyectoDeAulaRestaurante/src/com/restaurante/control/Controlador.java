/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurante.control;

import com.restaurante.utilidades.Lista;
import javax.swing.JTable;

/**
 *
 * @author cyber
 */
public interface Controlador<E> {

    public void escribir();

    public void cargarDatos();

    public void registrar(E objeto);

    public E buscar(String identificacion);

    public boolean existe(String identificacion);

    public E consultar(String identificacion);

    public void listar(JTable tabla);

    public Lista<E> listar();

    public void modificar(E objeto);

    public void eliminar(String identificacion);
}
