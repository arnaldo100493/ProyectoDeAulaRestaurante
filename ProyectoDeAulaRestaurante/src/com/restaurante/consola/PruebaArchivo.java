/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurante.consola;

/**
 *
 * @author cyber
 *
 */
public class PruebaArchivo {

    public PruebaArchivo() {

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Instancio un archivo para lectura  
        Archivo archivoLectura = new Archivo("PruebaArchivo.java");

        // Verifico que sea posible leerlo
        if (!archivoLectura.reset()) {
            System.out.println("No se puede abrir el archivo :(");
        } else {

            // String donde ira quedando el archivo linea por linea
            String line;

            // Contador para saber en que linea voy..
            int contador = 0;

            // Mientras pueda leer desde archivo imprimo su contenido
            while ((line = archivoLectura.readLine()) != null) {
                System.out.println(contador++ + ":" + line);
            }
            archivoLectura.close();
        }

        // Instancio un archivo para escritura
        Archivo archivoEscritura = new Archivo("escritura.txt");
        if (!archivoEscritura.rewrite()) {
            System.out.println("No se puede crear el archivo de salida");
        } else {
            for (int i = 0; i < 100; i++) {
                archivoEscritura.writeLine("Linea Numero " + i);
            }
            archivoEscritura.close();
        }

    }

}
