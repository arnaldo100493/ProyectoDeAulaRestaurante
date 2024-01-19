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

import com.restaurante.modelo.Proveedor;
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
public class ControlProveedor implements Controlador, Serializable {

    private static Lista<Proveedor> listadoProveedores;
    private static final String ruta = "../ProyectoDeAulaRestaurante/datos/Proveedores.txt/";

    public ControlProveedor() {
        listadoProveedores = null;
    }

    public static void setListadoProveedores(Lista<Proveedor> lista) {
        listadoProveedores = lista;
    }

    public static Lista<Proveedor> getListadoProveedores() {
        return listadoProveedores;
    }

    public void inicializar() {
        try {
            listadoProveedores = ControlArchivo.leerArchivo("Proveedores");
            if (listadoProveedores == null) {
                listadoProveedores = new ListaLinkedList<>();
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
            for (int i = 0; i < listadoProveedores.tamanio(); i++) {
                escribir.println(listadoProveedores.obtener(i).toString());
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

            String identificacion;
            String nombre;
            String apellido;
            String sexo;
            String empresa;
            String nitEmpresa;

            while ((linea = bufLeer.readLine()) != null) {
                //Identificación
                posicion = linea.indexOf('|');
                aux = linea.substring(0, posicion);
                identificacion = aux;
                linea = linea.substring(posicion + 1);
                //Nombre
                posicion = linea.indexOf('|');
                aux = linea.substring(0, posicion);
                nombre = aux;
                linea = linea.substring(posicion + 1);
                //Apellido
                posicion = linea.indexOf('|');
                aux = linea.substring(0, posicion);
                apellido = aux;
                linea = linea.substring(posicion + 1);
                //Sexo
                posicion = linea.indexOf('|');
                aux = linea.substring(0, posicion);
                sexo = aux;
                linea = linea.substring(posicion + 1);
                //Empresa
                posicion = linea.indexOf('|');
                aux = linea.substring(0, posicion);
                empresa = aux;
                linea = linea.substring(posicion + 1);
                //Nit Empresa
                posicion = linea.indexOf('|');
                aux = linea.substring(0, posicion);
                nitEmpresa = aux;
                linea = linea.substring(posicion + 1);

            }

        } catch (Exception ex) {
            Mensajes.mostrarMensajeError("Fichero NO Encontrado: " + ex.getMessage(), "Error");
        } finally {
            try {
                if (leer != null) {
                    leer.close();
                }
            } catch (Exception ex) {
            }
        }
    }

    @Override
    public void registrar(Object objeto) {
        try {
            if (objeto instanceof Proveedor) {
                this.inicializar();
                Proveedor proveedor = (Proveedor) objeto;
                if (!this.existe(proveedor.getIdentificacion())) {
                    listadoProveedores.agregar(proveedor);
                    ControlArchivo.guardarArchivo(listadoProveedores, "Proveedores");
                    this.escribir();
                    Mensajes.mostrarMensajeInformativo("Proveedor registrado con éxito", "Información");
                } else {
                    Mensajes.mostrarMensajeAdvertencia("Este proveedor ya existe", "Advertencia");
                }
            }
        } catch (IOException ex) {
            Mensajes.mostrarMensajeError("Error al registrar el proveedor: " + ex.getMessage(), "Error");
        }
    }

    @Override
    public Proveedor buscar(String identificacion) {
        this.inicializar();
        String id = identificacion;
        Proveedor proveedor = null;
        for (int i = 0; i < listadoProveedores.tamanio(); i++) {
            if (listadoProveedores.obtener(i).getIdentificacion().equals(id));
            proveedor = listadoProveedores.obtener(i);
        }
        return proveedor;
    }

    @Override
    public boolean existe(String identificacion) {
        this.inicializar();
        boolean estado = false;
        Proveedor proveedor = this.buscar(identificacion);
        for (int i = 0; i < listadoProveedores.tamanio(); i++) {
            if (listadoProveedores.obtener(i).getIdentificacion().equals(identificacion)) {
                estado = true;
            }
        }
        if (proveedor != null) {
            if (proveedor.getIdentificacion().equals(identificacion)) {
                estado = true;
            }
        }
        return estado;
    }

    @Override
    public Proveedor consultar(String identificacion) {
        Proveedor proveedor = null;
        try {
            this.inicializar();
            proveedor = this.buscar(identificacion);
            for (int i = 0; i < listadoProveedores.tamanio(); i++) {
                if (listadoProveedores.obtener(i).getIdentificacion().equals(identificacion) && proveedor != null) {
                    proveedor = listadoProveedores.obtener(i);
                } else {
                    Mensajes.mostrarMensajeAdvertencia("Este proveedor no existe", "Advertencia");
                }
            }
        } catch (NullPointerException ex) {
            Mensajes.mostrarMensajeError("Error al consultar el proveedor: " + ex.getMessage(), "Error");
        }
        return proveedor;
    }

    @Override
    public void listar(JTable tabla) {
        try {
            this.inicializar();
            ((DefaultTableModel) tabla.getModel()).setNumRows(0);
            for (int i = 0; i < listadoProveedores.tamanio(); i++) {
                Proveedor proveedor = listadoProveedores.obtener(i);
                ((DefaultTableModel) tabla.getModel()).addRow(new Object[]{proveedor.getIdentificacion(), proveedor.getNombre(), proveedor.getApellido(), proveedor.getSexo(), proveedor.getEmpresa(), proveedor.getNitEmpresa()});
            }
        } catch (NullPointerException ex) {
            Mensajes.mostrarMensajeError("Error al listar el proveedor: " + ex.getMessage(), "Error");
        }
    }

    @Override
    public Lista<Proveedor> listar() {
        return listadoProveedores;
    }

    @Override
    public void modificar(Object objeto) {
        try {
            if (objeto instanceof Proveedor) {
                this.inicializar();
                Proveedor proveedor = (Proveedor) objeto;
                for (int i = 0; i < listadoProveedores.tamanio(); i++) {
                    if (listadoProveedores.obtener(i).getIdentificacion().equals(proveedor.getIdentificacion())) {
                        listadoProveedores.remover(i);
                        listadoProveedores.agregar(proveedor);
                        ControlArchivo.guardarArchivo(listadoProveedores, "Proveedores");
                        this.escribir();
                        Mensajes.mostrarMensajeInformativo("Proveedor modificado con éxito", "Información");
                    } else {
                        Mensajes.mostrarMensajeAdvertencia("Este proveedor no existe", "Advertencia");
                    }
                }
            }
        } catch (IOException ex) {
            Mensajes.mostrarMensajeError("Error al modificar el proveedor: " + ex.getMessage(), "Error");
        }
    }

    @Override
    public void eliminar(String identificacion) {
        Proveedor proveedor = null;
        try {
            this.inicializar();
            proveedor = this.buscar(identificacion);
            for (int i = 0; i < listadoProveedores.tamanio(); i++) {
                if (listadoProveedores.obtener(i).getIdentificacion().equals(identificacion) && proveedor != null) {
                    int opcion = Mensajes.mostrarMensajeOpcion("¿Está seguro que desea eliminar este empleado llamado " + proveedor.getNombre() + " " + proveedor.getApellido() + " ? ", "Confirmar Eliminación");
                    if (opcion != -1) {
                        if ((opcion + 1) == 1) {
                            listadoProveedores.remover(proveedor);
                            ControlArchivo.guardarArchivo(listadoProveedores, "Proveedores");
                            this.escribir();
                            Mensajes.mostrarMensajeInformativo("Proveedor eliminado con éxito", "Información");
                        }
                    }
                } else {
                    Mensajes.mostrarMensajeAdvertencia("Este empleado no existe", "Advertencia");
                }
            }
        } catch (IOException ex) {
            Mensajes.mostrarMensajeError("Error al eliminar el empleado: " + ex.getMessage(), "Error");
        }
    }
}
