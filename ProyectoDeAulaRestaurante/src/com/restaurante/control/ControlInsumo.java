package com.restaurante.control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.restaurante.modelo.Insumo;
import com.restaurante.utilidades.Lista;
import com.restaurante.utilidades.ListaLinkedList;
import com.restaurante.utilidades.Mensajes;

public class ControlInsumo implements Controlador, Serializable {

    private static Lista<Insumo> listadoInsumos;
    private static final String ruta = "../ProyectoDeAulaRestaurante/datos/Insumos.txt/";

    public ControlInsumo() {
        listadoInsumos = null;
    }

    public static void setListadoInsumos(Lista<Insumo> listado) {
        listadoInsumos = listado;
    }

    public static Lista<Insumo> getListadoInsumos() {
        return listadoInsumos;
    }

    public void inicializar() {
        try {
            listadoInsumos = ControlArchivo.leerArchivo("Insumos");
            if (listadoInsumos == null) {
                listadoInsumos = new ListaLinkedList<>();
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
            for (int i = 0; i < listadoInsumos.tamanio(); i++) {
                escribir.println(listadoInsumos.obtener(i).toString());
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
            int cantidadMinima;
            int cantidadMaxima;

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

                //Cantidad Mínima
                posicion = linea.indexOf('|');
                aux = linea.substring(0, posicion);
                cantidadMinima = Integer.parseInt(aux);
                linea = linea.substring(posicion + 1);

                //Cantidad Máxima
                posicion = linea.indexOf('|');
                aux = linea.substring(0, posicion);
                cantidadMaxima = Integer.parseInt(aux);
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
            if (objeto instanceof Insumo) {
                this.inicializar();
                Insumo insumo = (Insumo) objeto;
                if (!this.existe(insumo.getCodigo())) {
                    listadoInsumos.agregar(insumo);
                    ControlArchivo.guardarArchivo(listadoInsumos, "Insumos");
                    this.escribir();
                    Mensajes.mostrarMensajeInformativo("Insumo registrado con éxito", "Información");
                } else {
                    Mensajes.mostrarMensajeAdvertencia("Este insumo ya existe", "Advertencia");
                }
            }
        } catch (IOException ex) {
            Mensajes.mostrarMensajeError("Error al registrar el insumo: " + ex.getMessage(), "Error");
        }
    }

    @Override
    public Insumo buscar(String codigo) {
        this.inicializar();
        String c = codigo;
        Insumo insumo = null;
        for (int i = 0; i < listadoInsumos.tamanio(); i++) {
            if (listadoInsumos.obtener(i).getCodigo().equals(c));
            insumo = listadoInsumos.obtener(i);
        }
        return insumo;
    }

    @Override
    public boolean existe(String codigo) {
        this.inicializar();
        boolean estado = false;
        Insumo insumo = this.buscar(codigo);
        for (int i = 0; i < listadoInsumos.tamanio(); i++) {
            if (listadoInsumos.obtener(i).getCodigo().equals(codigo)) {
                estado = true;
            }
        }
        if (insumo != null) {
            if (insumo.getCodigo().equals(codigo)) {
                estado = true;
            }
        }
        return estado;
    }

    @Override
    public Insumo consultar(String codigo) {
        Insumo insumo = null;
        try {
            this.inicializar();
            insumo = this.buscar(codigo);
            for (int i = 0; i < listadoInsumos.tamanio(); i++) {
                if (listadoInsumos.obtener(i).getCodigo().equals(codigo) && insumo != null) {
                    insumo = listadoInsumos.obtener(i);
                } else {
                    Mensajes.mostrarMensajeAdvertencia("Este insumo no existe", "Advertencia");
                }
            }
        } catch (NullPointerException ex) {
            Mensajes.mostrarMensajeError("Error al consultar el insumo: " + ex.getMessage(), "Error");
        }
        return insumo;
    }

    @Override
    public void listar(JTable tabla) {
        try {
            this.inicializar();
            ((DefaultTableModel) tabla.getModel()).setNumRows(0);
            for (int i = 0; i < listadoInsumos.tamanio(); i++) {
                Insumo insumo = listadoInsumos.obtener(i);
                ((DefaultTableModel) tabla.getModel()).addRow(new Object[]{insumo.getCodigo(), insumo.getNombre(), insumo.getDescripcion(), insumo.getPrecio(), insumo.getCantidad(), insumo.getCantidadMinima(), insumo.getCantidadMaxima()});
            }
        } catch (NullPointerException ex) {
            Mensajes.mostrarMensajeError("Error al listar el insumo: " + ex.getMessage(), "Error");
        }
    }

    @Override
    public Lista<Insumo> listar() {
        return listadoInsumos;
    }

    @Override
    public void modificar(Object objeto) {
        try {
            if (objeto instanceof Insumo) {
                this.inicializar();
                Insumo insumo = (Insumo) objeto;
                for (int i = 0; i < listadoInsumos.tamanio(); i++) {
                    if (listadoInsumos.obtener(i).getCodigo().equals(insumo.getCodigo())) {
                        listadoInsumos.remover(i);
                        listadoInsumos.agregar(insumo);
                        ControlArchivo.guardarArchivo(listadoInsumos, "Insumos");
                        this.escribir();
                        Mensajes.mostrarMensajeInformativo("Insumo modificado con éxito", "Información");
                    } else {
                        Mensajes.mostrarMensajeAdvertencia("Este insumo no existe", "Advertencia");
                    }
                }
            }
        } catch (IOException ex) {
            Mensajes.mostrarMensajeError("Error al modificar el insumo: " + ex.getMessage(), "Error");
        }
    }

    @Override
    public void eliminar(String codigo) {
        Insumo insumo = null;
        try {
            this.inicializar();
            insumo = this.buscar(codigo);
            for (int i = 0; i < listadoInsumos.tamanio(); i++) {
                if (listadoInsumos.obtener(i).getCodigo().equals(codigo) && insumo != null) {
                    int opcion = Mensajes.mostrarMensajeOpcion("¿Está seguro que desea eliminar este insumo llamado " + insumo.getNombre() + " ? ", "Confirmar Eliminación");
                    if (opcion != -1) {
                        if ((opcion + 1) == 1) {
                            listadoInsumos.remover(insumo);
                            ControlArchivo.guardarArchivo(listadoInsumos, "Insumos");
                            this.escribir();
                            Mensajes.mostrarMensajeInformativo("Insumo eliminado con éxito", "Información");
                        }
                    }
                } else {
                    Mensajes.mostrarMensajeAdvertencia("Este insumo no existe", "Advertencia");
                }
            }
        } catch (IOException ex) {
            Mensajes.mostrarMensajeError("Error al eliminar el insumo: " + ex.getMessage(), "Error");
        }
    }
}
