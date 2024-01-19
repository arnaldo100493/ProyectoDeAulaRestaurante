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

import javax.swing.JOptionPane;

/**
 *
 * @author cyber
 */
public class Mensajes {

    public Mensajes() {

    }

    public static void mostrarMensaje(Object mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public static void mostrarMensajePlano(Object mensaje, String titulo) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.PLAIN_MESSAGE);
    }

    public static void mostrarMensajeInformativo(Object mensaje, String titulo) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void mostrarMensajeAdvertencia(Object mensaje, String titulo) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.WARNING_MESSAGE);
    }

    public static void mostrarMensajeError(Object mensaje, String titulo) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
    }

    public static void mostrarMensajeConfirmacion(Object mensaje) {
        JOptionPane.showConfirmDialog(null, mensaje);
    }

    public static int mostrarMensajeConfirmacion(Object mensaje, String titulo) {
        return JOptionPane.showConfirmDialog(null, mensaje, titulo, JOptionPane.YES_NO_CANCEL_OPTION);
    }

    public static String mostrarMensajeEntrada(Object mensaje) {
        return JOptionPane.showInputDialog(null, mensaje);
    }

    public static String mostrarMensajeEntrada(Object mensaje, String titulo) {
        return JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE);
    }

    public static int mostrarMensajeOpcion(Object mensaje, String titulo) {
        return JOptionPane.showOptionDialog(null, mensaje, titulo, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"SI", "NO"}, "SI");
    }

    public static int mostrarMensajeOpcionYCancelar(Object mensaje, String titulo) {
        return JOptionPane.showOptionDialog(null, mensaje, titulo, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"SI", "NO"}, "SI");
    }
}
