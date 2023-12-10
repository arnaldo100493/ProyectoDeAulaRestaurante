package com.restaurante.control;

import com.restaurante.utilidades.Lista;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.ObjectOutput;

public class ControlArchivo implements Serializable {

    private static final String ruta = "../ProyectoDeAulaRestaurante/src/archivos/";

    public ControlArchivo() {

    }

    public static void guardarArchivo(Lista listado, String archivo) throws IOException {
        ObjectOutput output = null;
        try {
            File file = new File(ruta, archivo);
            if (!file.exists()) {
                file.createNewFile();
            }
            if (file.exists()) {
                output = new ObjectOutputStream(new FileOutputStream(file));
                output.writeObject(listado);
            }
        } finally {
            if (output != null) {
                output.close();
            }
        }
    }

    public static Lista leerArchivo(String archivo) throws IOException, ClassNotFoundException {
        Lista<Object> listado = null;
        ObjectInputStream input = null;
        try {
            File file = new File(ruta, archivo);
            if (file.exists()) {
                input = new ObjectInputStream(new FileInputStream(file));
                listado = (Lista<Object>) input.readObject();
            }
        } finally {
            if (input != null) {
                input.close();
            }

        }
        return listado;
    }

    public static void escribirObjeto(Object objeto, String archivo) throws IOException {
        ObjectOutput output = null;
        try {
            File file = new File(ruta, archivo);
            if (!file.exists()) {
                file.createNewFile();
            }
            if (file.exists()) {
                output = new ObjectOutputStream(new FileOutputStream(file));
                output.writeObject(objeto);
            }
        } finally {
            if (output != null) {
                output.close();
            }
        }
    }

    public static Object leerObjeto(String archivo) throws IOException, ClassNotFoundException {
        Object objeto = null;
        ObjectInputStream input = null;
        try {
            File file = new File(ruta, archivo);
            if (file.exists()) {
                input = new ObjectInputStream(new FileInputStream(file));
                objeto = input.readObject();
            }

        } finally {
            if (input != null) {
                input.close();
            }
        }
        return objeto;
    }
}
