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

import com.restaurante.modelo.Producto;
import com.restaurante.utilidades.Lista;
import com.restaurante.utilidades.ListaLinkedList;
import com.restaurante.utilidades.Mensajes;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cyber
 */
public class ControlProducto implements Controlador, Serializable {

    private static Lista<Producto> listadoProductos;
    private static final String ruta = "../ProyectoDeAulaRestaurante/datos/Productos.txt/";

    public ControlProducto() {
        listadoProductos = null;
    }

    public static void setListadoProductos(Lista<Producto> listado) {
        listadoProductos = listado;
    }

    public static Lista<Producto> getListaClientes() {
        return ControlProducto.listadoProductos;
    }

    public void inicializar() {
        try {
            listadoProductos = ControlArchivo.leerArchivo("Productos");
            if (listadoProductos == null) {
                listadoProductos = new ListaLinkedList<>();
            }
        } catch (IOException | ClassNotFoundException ex) {
            Mensajes.mostrarMensajeError("Error al leer el archivo: " + ex.getMessage(), "Error");
        }
    }

    //Método para escribir en el fichero
    @Override
    public void escribir() {
        FileWriter fichero = null;
        PrintWriter escribir = null;
        try {
            fichero = new FileWriter(ruta);
            escribir = new PrintWriter(fichero);
            for (int i = 0; i < listadoProductos.tamanio(); i++) {
                escribir.println(listadoProductos.obtener(i).toString());
            }
        } catch (Exception ex) {
            Mensajes.mostrarMensajeError("Fichero NO Encontrado: " + ex.getMessage(), "Error");
            ex.printStackTrace();
        } finally {
            try {
                if (fichero != null) {
                    fichero.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    //Método para cargar los datos del fichero a la lista
    @Override
    public void cargarDatos() {
        File fichero = null;
        FileReader leer = null;
        BufferedReader bufLeer;
        try {
            fichero = new File(ruta);
            leer = new FileReader(fichero);
            bufLeer = new BufferedReader(leer);

            String linea;
            String aux;
            int posicion;

            String codigo;
            String nombre;
            String descripcion;
            int precio;
            int cantidad;

            while ((linea = bufLeer.readLine()) != null) {
                //Código
                posicion = linea.indexOf('|');
                aux = linea.substring(0, posicion);
                codigo = aux;
                linea = linea.substring(posicion + 1);
                //Nombre
                posicion = linea.indexOf('|');
                aux = linea.substring(0, posicion);
                nombre = aux;
                linea = linea.substring(posicion + 1);
                //Descripción
                posicion = linea.indexOf('|');
                aux = linea.substring(0, posicion);
                descripcion = aux;
                linea = linea.substring(posicion + 1);
                //Precio
                posicion = linea.indexOf('|');
                aux = linea.substring(0, posicion);
                precio = Integer.parseInt(aux);
                linea = linea.substring(posicion + 1);
                //Cantidad
                posicion = linea.indexOf('|');
                aux = linea.substring(0, posicion);
                cantidad = Integer.parseInt(aux);
                linea = linea.substring(posicion + 1);

            }

        } catch (Exception ex) {
            Mensajes.mostrarMensajeError("Fichero NO Encontrado: " + ex.getMessage(), "Error");
            ex.printStackTrace();
        } finally {
            try {
                if (leer != null) {
                    leer.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void registrar(Object objeto) {
        try {
            if (objeto instanceof Producto) {
                this.inicializar();
                Producto producto = (Producto) objeto;
                if (!this.existe(producto.getCodigo())) {
                    listadoProductos.agregar(producto);
                    ControlArchivo.guardarArchivo(ControlProducto.listadoProductos, "Productos");
                    this.escribir();
                    Mensajes.mostrarMensajeInformativo("Producto registrado con éxito", "Información");
                } else {
                    Mensajes.mostrarMensajeAdvertencia("Este producto ya existe", "Advertencia");
                }
            }
        } catch (IOException ex) {
            Mensajes.mostrarMensajeError("Error al registrar el producto: " + ex.getMessage(), "Error");
        }
    }

    @Override
    public Producto buscar(String codigo) {
        this.inicializar();
        String c = codigo;
        Producto producto = null;
        for (int i = 0; i < listadoProductos.tamanio(); i++) {
            if (listadoProductos.obtener(i).getCodigo().equals(c));
            producto = listadoProductos.obtener(i);
        }
        return producto;
    }

    @Override
    public boolean existe(String codigo) {
        this.inicializar();
        boolean estado = false;
        Producto producto = this.buscar(codigo);
        for (int i = 0; i < listadoProductos.tamanio(); i++) {
            if (listadoProductos.obtener(i).getCodigo().equals(codigo)) {
                estado = true;
            }
        }
        if (producto != null) {
            if (producto.getCodigo().equals(codigo)) {
                estado = true;
            }
        }
        return estado;
    }

    @Override
    public Producto consultar(String codigo) {
        Producto producto = null;
        try {
            this.inicializar();
            producto = this.buscar(codigo);
            for (int i = 0; i < listadoProductos.tamanio(); i++) {
                if (listadoProductos.obtener(i).getCodigo().equals(codigo) && producto != null) {
                    producto = listadoProductos.obtener(i);
                } else {
                    Mensajes.mostrarMensajeAdvertencia("Este producto no existe", "Advertencia");
                }
            }
        } catch (NullPointerException ex) {
            Mensajes.mostrarMensajeError("Error al consultar el producto: " + ex.getMessage(), "Error");
        }
        return producto;
    }

    @Override
    public void listar(JTable tabla) {
        try {
            this.inicializar();
            ((DefaultTableModel) tabla.getModel()).setNumRows(0);
            for (int i = 0; i < listadoProductos.tamanio(); i++) {
                Producto producto = listadoProductos.obtener(i);
                ((DefaultTableModel) tabla.getModel()).addRow(new Object[]{producto.getCodigo(), producto.getNombre(), producto.getDescripcion(), producto.getPrecio(), producto.getCantidad(), producto.getFechaRegistro()});
            }
        } catch (NullPointerException ex) {
            Mensajes.mostrarMensajeError("Error al listar el producto: " + ex.getMessage(), "Error");
        }
    }

    @Override
    public Lista<Producto> listar() {
        return listadoProductos;
    }

    @Override
    public void modificar(Object objeto) {
        try {
            if (objeto instanceof Producto) {
                this.inicializar();
                Producto producto = (Producto) objeto;
                for (int i = 0; i < listadoProductos.tamanio(); i++) {
                    if (listadoProductos.obtener(i).getCodigo().equals(producto.getCodigo())) {
                        listadoProductos.remover(i);
                        listadoProductos.agregar(producto);
                        ControlArchivo.guardarArchivo(listadoProductos, "Productos");
                        this.escribir();
                        Mensajes.mostrarMensajeInformativo("Producto modificado con éxito", "Información");
                    } else {
                        Mensajes.mostrarMensajeAdvertencia("Este producto no existe", "Advertencia");
                    }
                }
            }
        } catch (IOException ex) {
            Mensajes.mostrarMensajeError("Error al modificar el producto: " + ex.getMessage(), "Error");
        }
    }

    @Override
    public void eliminar(String codigo) {
        Producto producto = null;
        try {
            this.inicializar();
            producto = this.buscar(codigo);
            for (int i = 0; i < listadoProductos.tamanio(); i++) {
                if (listadoProductos.obtener(i).getCodigo().equals(codigo) && producto != null) {
                    int opcion = Mensajes.mostrarMensajeOpcion("¿Está seguro que desea eliminar este producto llamado " + producto.getNombre() + " ? ", "Confirmar Eliminación");
                    if (opcion != -1) {
                        if ((opcion + 1) == 1) {
                            listadoProductos.remover(producto);
                            ControlArchivo.guardarArchivo(listadoProductos, "Productos");
                            this.escribir();
                            Mensajes.mostrarMensajeInformativo("Producto eliminado con éxito", "Información");
                        }
                    }
                } else {
                    Mensajes.mostrarMensajeAdvertencia("Este producto no existe", "Advertencia");
                }
            }
        } catch (IOException ex) {
            Mensajes.mostrarMensajeError("Error al eliminar el producto: " + ex.getMessage(), "Error");
        }
    }
}
