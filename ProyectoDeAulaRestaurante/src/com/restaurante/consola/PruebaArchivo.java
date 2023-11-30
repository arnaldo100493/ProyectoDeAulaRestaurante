package com.restaurante.consola;

public class PruebaArchivo {

    public PruebaArchivo() {

    }

    public static void main(String[] args) {

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
