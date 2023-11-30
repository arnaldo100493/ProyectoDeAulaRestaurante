package com.restaurante.consola;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Clase para la lectura y escritura de archivos
 */
public final class Archivo {

    /**
     * Clase utilizada para la lectura/escritura de archivo
     */
    private RandomAccessFile raf = null;

    /**
     * Flag para hacer que la clase imprima o no los errores a pantalla
     */
    private boolean debug;

    /**
     * Nombre del archivo actual
     */
    private String nombreArchivo;

    /**
     * Constructores de la Consola
     */
    public Archivo() {

    }

    public Archivo(boolean debug) {
        this.debug = false;
    }

    public Archivo(String nombreArchivo) {
        this.debug = false;
        this.nombreArchivo = nombreArchivo;
    }

    /**
     * Constructor de la clase archivo
     *
     * @param _nombreArchivo a leer/escribir
     * @param _debug flag para mostrar o no los errores en caso de haberlos
     */
    public Archivo(boolean debug, String nombreArchivo) {
        this.debug = debug;
        this.nombreArchivo = nombreArchivo;
    }

    /**
     * Método que abre un archivo para su lectura/escritura
     *
     * @param _archivo nombre del archivo a abrir
     * @return true/false en caso de poder o no abrir el archivo para lectura
     */
    public final boolean reset() {
        if (this.nombreArchivo == null) {
            return false;
        }
        File file = new File(this.nombreArchivo);
        if (!file.exists()) {
            if (this.debug) {
                System.out.println("ERROR: Archivo <" + this.nombreArchivo + "> no existe!");
            }
            return false;
        }
        if (!file.canRead()) {
            if (this.debug) {
                System.out.println("ERROR: Archivo <" + this.nombreArchivo + "> no se puede leer!");
            }
            return false;
        }
        try {
            this.raf = new RandomAccessFile(file, "rwd");
        } catch (FileNotFoundException ex) {
            if (this.debug) {
                System.out.println("ERROR: Archivo <" + this.nombreArchivo + "> no puede ser abierto para lectura.");
            }
        }
        return true;
    }

    /**
     * Método para preparar el archivo para escritura
     *
     * @return
     */
    public final boolean rewrite() {
        if (this.nombreArchivo == null) {
            return false;
        }

        File file = new File(this.nombreArchivo);

        // Si el archivo existe, lo borra
        if (file.exists()) {
            file.delete();
        }

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                if (this.debug) {
                    System.out.println("ERROR: Archivo <" + this.nombreArchivo + "> no puede ser creado!");
                }
                return false;
            }
        }

        if (!file.canWrite()) {
            if (this.debug) {
                System.out.println("ERROR: Archivo <" + this.nombreArchivo + "> no se puede escribir!");
            }
            return false;
        }

        try {
            this.raf = new RandomAccessFile(file, "rwd");
        } catch (FileNotFoundException ex) {
            if (this.debug) {
                System.out.println("ERROR: Archivo <" + this.nombreArchivo + "> no puede ser abierto para lectura.");
            }
        }
        return true;

    }

    /**
     * Método que lee una linea desde el archivo, requiere que previamente se
     * llame al metodo reset() para habilitar el acceso al archivo
     *
     * @return Cada vez que es llamado retorna el archivo linea a linea, en caso
     * de llegar al final del archivo retorna null.
     */
    public final String readLine() {
        if (this.raf == null) {
            if (this.debug) {
                System.out.println("ERROR: Archivo no ha sido inicializado!");
            }
            return null;
        }
        try {
            return this.raf.readLine();
        } catch (IOException e) {
            if (this.debug) {
                System.out.println("ERROR:" + e.getMessage());
            }
            return null;
        }
    }

    /**
     * Método que escribe una linea al archivo
     *
     * @param _linea a escribir en el archivo
     * @return false si se produjo algun error
     */
    public final boolean writeLine(String linea) {

        if (this.raf == null) {
            if (this.debug) {
                System.out.println("ERROR: Archivo no ha sido inicializado!");
            }
            return false;
        }

        try {
            this.raf.writeBytes(linea + "\n");
        } catch (IOException ex) {
            if (this.debug) {
                System.out.println("ERROR: " + ex.getMessage());
            }
            return false;
        }

        return true;
    }

    /**
     * Método que retorna el tamanio del archivo (en caracteres)
     *
     * @return long cantidad de caracteres
     */
    public final long getSize() {
        try {
            return this.raf.length();
        } catch (IOException ex) {
            return -1;
        }
    }

    /**
     * Método que cierra el archivo de lectura y libera la memoria asignadas
     */
    public final void close() {
        if (this.raf == null) {
            if (this.debug) {
                System.out.println("ERROR: Archivo no ha sido inicializado.");
            }
        }
        try {
            this.raf.close();
            this.raf = null;
        } catch (IOException e) {
            if (this.debug) {
                System.out.println("ERROR: Archivo no se puede cerrar," + e.getMessage());
            }
        }
    }

}
