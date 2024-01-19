/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurante.consecutivo;

import com.restaurante.control.ControlUtilidades;
import com.restaurante.utilidades.Mensajes;
import java.io.IOException;

/**
 *
 * @author cyber
 *
 */
public class ConsecutivoRestaurante {

    public ConsecutivoRestaurante() {

    }

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        System.out.println(ControlUtilidades.obtenerNumeroConsecutivo());
        Mensajes.mostrarMensaje(ControlUtilidades.obtenerNumeroConsecutivo());
        ControlUtilidades.guardarConsecutivo(ControlUtilidades.obtenerNumeroConsecutivo());
    }
}
