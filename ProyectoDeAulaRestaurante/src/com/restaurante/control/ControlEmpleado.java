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
import com.restaurante.modelo.Empleado;
import com.restaurante.utilidades.Lista;
import com.restaurante.utilidades.ListaLinkedList;
import com.restaurante.utilidades.Mensajes;

public class ControlEmpleado implements Controlador, Serializable {

    private static Lista<Empleado> listadoEmpleados;
    private static final String ruta = "../ProyectoDeAulaRestaurante/datos/Empleados.txt/";

    public ControlEmpleado() {
        listadoEmpleados = null;
    }

    public static void setListadoEmpleados(Lista<Empleado> lista) {
        listadoEmpleados = lista;
    }

    public static Lista<Empleado> getListadoEmpleados() {
        return listadoEmpleados;
    }

    public void inicializar() {
        try {
            listadoEmpleados = ControlArchivo.leerArchivo("Empleados");
            if (listadoEmpleados == null) {
                listadoEmpleados = new ListaLinkedList<>();
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
            for (int i = 0; i < listadoEmpleados.tamanio(); i++) {
                escribir.println(listadoEmpleados.obtener(i).toString());
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
            int sueldo;

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
                // Sueldo
                posicion = linea.indexOf('|');
                aux = linea.substring(0, posicion);
                sueldo = Integer.parseInt(aux);
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
            if (objeto instanceof Empleado) {
                this.inicializar();
                Empleado empleado = (Empleado) objeto;
                if (!this.existe(empleado.getIdentificacion())) {
                    listadoEmpleados.agregar(empleado);
                    ControlArchivo.guardarArchivo(listadoEmpleados, "Empleados");
                    this.escribir();
                    Mensajes.mostrarMensajeInformativo("Empleado registrado con éxito", "Información");
                } else {
                    Mensajes.mostrarMensajeAdvertencia("Este empleado ya existe", "Advertencia");
                }
            }
        } catch (IOException ex) {
            Mensajes.mostrarMensajeError("Error al registrar el empleado: " + ex.getMessage(), "Error");
        }
    }

    @Override
    public Empleado buscar(String identificacion) {
        this.inicializar();
        String id = identificacion;
        Empleado empleado = null;
        for (int i = 0; i < listadoEmpleados.tamanio(); i++) {
            if (listadoEmpleados.obtener(i).getIdentificacion().equals(id));
            empleado = listadoEmpleados.obtener(i);
        }
        return empleado;
    }

    @Override
    public boolean existe(String identificacion) {
        this.inicializar();
        boolean estado = false;
        Empleado empleado = this.buscar(identificacion);
        for (int i = 0; i < listadoEmpleados.tamanio(); i++) {
            if (listadoEmpleados.obtener(i).getIdentificacion().equals(identificacion)) {
                estado = true;
            }
        }
        if (empleado != null) {
            if (empleado.getIdentificacion().equals(identificacion)) {
                estado = true;
            }
        }
        return estado;
    }

    @Override
    public Empleado consultar(String identificacion) {
        Empleado empleado = null;
        try {
            this.inicializar();
            empleado = this.buscar(identificacion);
            for (int i = 0; i < listadoEmpleados.tamanio(); i++) {
                if (listadoEmpleados.obtener(i).getIdentificacion().equals(identificacion) && empleado != null) {
                    empleado = listadoEmpleados.obtener(i);
                } else {
                    Mensajes.mostrarMensajeAdvertencia("Este empleado no existe", "Advertencia");
                }
            }
        } catch (NullPointerException ex) {
            Mensajes.mostrarMensajeError("Error al consultar el empleado: " + ex.getMessage(), "Error");
        }
        return empleado;
    }

    @Override
    public void listar(JTable tabla) {
        try {
            this.inicializar();
            ((DefaultTableModel) tabla.getModel()).setNumRows(0);
            for (int i = 0; i < listadoEmpleados.tamanio(); i++) {
                Empleado empleado = listadoEmpleados.obtener(i);
                ((DefaultTableModel) tabla.getModel()).addRow(new Object[]{empleado.getIdentificacion(), empleado.getNombre(), empleado.getApellido(), empleado.getDireccion(), empleado.getTelefono(), empleado.getCorreoElectronico(), empleado.getSexo(), empleado.getSueldo(), empleado.getFechaRegistro()});
            }
        } catch (NullPointerException ex) {
            Mensajes.mostrarMensajeError("Error al listar el empleado: " + ex.getMessage(), "Error");
        }
    }

    @Override
    public Lista<Empleado> listar() {
        return listadoEmpleados;
    }

    @Override
    public void modificar(Object objeto) {
        try {
            if (objeto instanceof Empleado) {
                this.inicializar();
                Empleado empleado = (Empleado) objeto;
                for (int i = 0; i < listadoEmpleados.tamanio(); i++) {
                    if (listadoEmpleados.obtener(i).getIdentificacion().equals(empleado.getIdentificacion())) {
                        listadoEmpleados.remover(i);
                        listadoEmpleados.agregar(empleado);
                        ControlArchivo.guardarArchivo(listadoEmpleados, "Empleado");
                        this.escribir();
                        Mensajes.mostrarMensajeInformativo("Empleado modificado con éxito", "Información");
                    } else {
                        Mensajes.mostrarMensajeAdvertencia("Este empleado no existe", "Advertencia");
                    }
                }
            }
        } catch (IOException ex) {
            Mensajes.mostrarMensajeError("Error al modificar el empleado: " + ex.getMessage(), "Error");
        }
    }

    @Override
    public void eliminar(String identificacion) {
        Empleado empleado = null;
        try {
            this.inicializar();
            empleado = this.buscar(identificacion);
            for (int i = 0; i < listadoEmpleados.tamanio(); i++) {
                if (listadoEmpleados.obtener(i).getIdentificacion().equals(identificacion) && empleado != null) {
                    int opcion = Mensajes.mostrarMensajeOpcion("¿Está seguro que desea eliminar este empleado llamado " + empleado.getNombre() + " " + empleado.getApellido() + " ? ", "Confirmar Eliminación");
                    if (opcion != -1) {
                        if ((opcion + 1) == 1) {
                            listadoEmpleados.remover(empleado);
                            ControlArchivo.guardarArchivo(listadoEmpleados, "Empleados");
                            this.escribir();
                            Mensajes.mostrarMensajeInformativo("Empleado eliminado con éxito", "Información");
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
