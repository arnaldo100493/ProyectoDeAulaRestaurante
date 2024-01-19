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

import com.restaurante.modelo.Cliente;
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
public class ControlCliente implements Controlador, Serializable {

    private static Lista<Cliente> listadoClientes;
    private static final String ruta = "../ProyectoDeAulaRestaurante/datos/Clientes.txt/";

    public ControlCliente() {
        listadoClientes = null;
    }

    public static void setListadoClientes(Lista<Cliente> listado) {
        listadoClientes = listado;
    }

    public static Lista<Cliente> getListadoClientes() {
        return listadoClientes;
    }

    public void inicializar() {
        try {
            listadoClientes = ControlArchivo.leerArchivo("Clientes");
            if (listadoClientes == null) {
                listadoClientes = new ListaLinkedList<>();
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
            for (int i = 0; i < listadoClientes.tamanio(); i++) {
                escribir.println(listadoClientes.obtener(i).toString());
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
            String direccion;
            String telefono;
            String email;

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
                //Teléfono
                posicion = linea.indexOf('|');
                aux = linea.substring(0, posicion);
                telefono = aux;
                linea = linea.substring(posicion + 1);
                //Dirección y Email
                posicion = linea.indexOf('|');
                aux = linea.substring(0, posicion);
                direccion = aux;
                linea = linea.substring(posicion + 1);
                email = linea;

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
            if (objeto instanceof Cliente) {
                this.inicializar();
                Cliente cliente = (Cliente) objeto;
                if (!this.existe(cliente.getIdentificacion())) {
                    listadoClientes.agregar(cliente);
                    ControlArchivo.guardarArchivo(listadoClientes, "Clientes");
                    this.escribir();
                    Mensajes.mostrarMensajeInformativo("Cliente registrado con éxito", "Información");
                } else {
                    Mensajes.mostrarMensajeAdvertencia("Este cliente ya existe", "Advertencia");
                }
            }
        } catch (IOException ex) {
            Mensajes.mostrarMensajeError("Error al registrar el cliente: " + ex.getMessage(), "Error");
        }
    }

    @Override
    public Cliente buscar(String identificacion) {
        this.inicializar();
        String id = identificacion;
        Cliente cliente = null;
        for (int i = 0; i < listadoClientes.tamanio(); i++) {
            if (listadoClientes.obtener(i).getIdentificacion().equals(id));
            cliente = listadoClientes.obtener(i);
        }
        return cliente;
    }

    @Override
    public boolean existe(String identificacion) {
        this.inicializar();
        boolean estado = false;
        Cliente cliente = this.buscar(identificacion);
        for (int i = 0; i < listadoClientes.tamanio(); i++) {
            if (listadoClientes.obtener(i).getIdentificacion().equals(identificacion)) {
                estado = true;
            }
        }
        if (cliente != null) {
            if (cliente.getIdentificacion().equals(identificacion)) {
                estado = true;
            }
        }
        return estado;
    }

    @Override
    public Cliente consultar(String identificacion) {
        Cliente cliente = null;
        try {
            this.inicializar();
            cliente = this.buscar(identificacion);
            for (int i = 0; i < listadoClientes.tamanio(); i++) {
                if (listadoClientes.obtener(i).getIdentificacion().equals(identificacion) && cliente != null) {
                    cliente = listadoClientes.obtener(i);
                } else {
                    Mensajes.mostrarMensajeAdvertencia("Este cliente no existe", "Advertencia");
                }
            }
        } catch (NullPointerException ex) {
            Mensajes.mostrarMensajeError("Error al consultar el cliente: " + ex.getMessage(), "Error");
        }
        return cliente;
    }

    @Override
    public void listar(JTable tabla) {
        try {
            this.inicializar();
            ((DefaultTableModel) tabla.getModel()).setNumRows(0);

            for (int i = 0; i < listadoClientes.tamanio(); i++) {
                Cliente cliente = listadoClientes.obtener(i);
                ((DefaultTableModel) tabla.getModel()).addRow(new Object[]{cliente.getIdentificacion(), cliente.getNombre(), cliente.getApellido(), cliente.getDireccion(), cliente.getTelefono(), cliente.getCorreoElectronico(), cliente.getSexo(), cliente.getFechaRegistro()});
            }
        } catch (NullPointerException ex) {
            Mensajes.mostrarMensajeError("Error al listar el cliente: " + ex.getMessage(), "Error");
        }
    }

    @Override
    public Lista<Cliente> listar() {
        return listadoClientes;
    }

    @Override
    public void modificar(Object objeto) {
        try {
            if (objeto instanceof Cliente) {
                this.inicializar();
                Cliente cliente = (Cliente) objeto;
                for (int i = 0; i < listadoClientes.tamanio(); i++) {
                    if (listadoClientes.obtener(i).getIdentificacion().equals(cliente.getIdentificacion())) {
                        listadoClientes.remover(i);
                        listadoClientes.agregar(cliente);
                        ControlArchivo.guardarArchivo(listadoClientes, "Clientes");
                        this.escribir();
                        Mensajes.mostrarMensajeInformativo("Cliente modificado con éxito", "Información");
                    } else {
                        Mensajes.mostrarMensajeAdvertencia("Este cliente no existe", "Advertencia");
                    }
                }
            }
        } catch (IOException ex) {
            Mensajes.mostrarMensajeError("Error al modificar el cliente: " + ex.getMessage(), "Error");
        }
    }

    @Override
    public void eliminar(String identificacion) {
        Cliente cliente = null;
        try {
            this.inicializar();
            cliente = this.buscar(identificacion);
            for (int i = 0; i < listadoClientes.tamanio(); i++) {
                if (listadoClientes.obtener(i).getIdentificacion().equals(identificacion) && cliente != null) {
                    int opcion = Mensajes.mostrarMensajeOpcion("¿Está seguro que desea eliminar este cliente llamado " + cliente.getNombre() + " " + cliente.getApellido() + " ? ", "Confirmar Eliminación");
                    if (opcion != -1) {
                        if ((opcion + 1) == 1) {
                            listadoClientes.remover(cliente);
                            ControlArchivo.guardarArchivo(listadoClientes, "Clientes");
                            this.escribir();
                            Mensajes.mostrarMensajeInformativo("Cliente eliminado con éxito", "Información");
                        }
                    }
                } else {
                    Mensajes.mostrarMensajeAdvertencia("Este cliente no existe", "Advertencia");
                }
            }
        } catch (IOException ex) {
            Mensajes.mostrarMensajeError("Error al eliminar el cliente: " + ex.getMessage(), "Error");
        }
    }
}
