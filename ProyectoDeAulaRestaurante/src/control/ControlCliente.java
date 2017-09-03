package control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;

public class ControlCliente implements Controlador, Serializable {

    private static List<Cliente> listadoClientes;
    private static final String ruta = "../ProyectoDeAulaRestaurante/datos/Clientes.txt/";

    public ControlCliente() {
        listadoClientes = null;
    }

    public static void setListadoClientes(List<Cliente> listado) {
        listadoClientes = listado;
    }

    public static List<Cliente> getListadoClientes() {
        return listadoClientes;
    }

    public void inicializar() {
        try {
            listadoClientes = ControlArchivo.leerArchivo("Clientes");
            if (listadoClientes == null) {
                listadoClientes = new LinkedList<>();
            }
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para escribir en el fichero
    @Override
    public void escribir() {
        FileWriter fichero = null;
        PrintWriter escribir = null;
        try {
            fichero = new FileWriter(ruta);
            escribir = new PrintWriter(fichero);
            for (int i = 0; i < listadoClientes.size(); i++) {
                escribir.println(listadoClientes.get(i).toString());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Fichero NO Encontrado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

    // Método para cargar los datos del fichero a la lista
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
                // Identificación
                posicion = linea.indexOf('|');
                aux = linea.substring(0, posicion);
                identificacion = aux;
                linea = linea.substring(posicion + 1);
                // Nombre
                posicion = linea.indexOf('|');
                aux = linea.substring(0, posicion);
                nombre = aux;
                linea = linea.substring(posicion + 1);
                // Apellido
                posicion = linea.indexOf('|');
                aux = linea.substring(0, posicion);
                apellido = aux;
                linea = linea.substring(posicion + 1);
                // Sexo
                posicion = linea.indexOf('|');
                aux = linea.substring(0, posicion);
                sexo = aux;
                linea = linea.substring(posicion + 1);
                // Teléfono
                posicion = linea.indexOf('|');
                aux = linea.substring(0, posicion);
                telefono = aux;
                linea = linea.substring(posicion + 1);
                // Dirección y Email
                posicion = linea.indexOf('|');
                aux = linea.substring(0, posicion);
                direccion = aux;
                linea = linea.substring(posicion + 1);
                email = linea;

            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Fichero NO Encontrado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
                    listadoClientes.add(cliente);
                    ControlArchivo.guardarArchivo(listadoClientes, "Clientes");
                    this.escribir();
                    JOptionPane.showMessageDialog(null, "Cliente registrado con éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Este cliente ya existe", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al registrar el cliente: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public Cliente buscar(String identificacion) {
        this.inicializar();
        String id = identificacion;
        Cliente cliente = null;
        for (Cliente c : listadoClientes) {
            if (c.getIdentificacion().equals(id)) {
                cliente = c;
            }
        }
        return cliente;
    }

    @Override
    public boolean existe(String identificacion) {
        this.inicializar();
        boolean estado = false;
        Cliente cliente = this.buscar(identificacion);
        for (int i = 0; i < listadoClientes.size(); i++) {
            if (listadoClientes.get(i).getIdentificacion().equals(identificacion)) {
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
            for (int i = 0; i < listadoClientes.size(); i++) {
                if (listadoClientes.get(i).getIdentificacion().equals(identificacion) && cliente != null) {
                    cliente = listadoClientes.get(i);
                } else {
                    JOptionPane.showMessageDialog(null, "Este cliente no existe", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Error al consultar el cliente: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return cliente;
    }

    @Override
    public void listar(JTable tabla) {
        try {
            this.inicializar();
            ((DefaultTableModel) tabla.getModel()).setNumRows(0);
            for (Cliente cliente : listadoClientes) {
                ((DefaultTableModel) tabla.getModel()).addRow(new Object[]{cliente.getIdentificacion(), cliente.getNombre(), cliente.getApellido(), cliente.getDireccion(), cliente.getTelefono(), cliente.getCorreoElectronico(), cliente.getSexo(), cliente.getFechaRegistro()});
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar el empleado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public List<Cliente> listar() {
        return listadoClientes;
    }

    @Override
    public void modificar(Object objeto) {
        try {
            if (objeto instanceof Cliente) {
                this.inicializar();
                Cliente cliente = (Cliente) objeto;
                for (int i = 0; i < listadoClientes.size(); i++) {
                    if (listadoClientes.get(i).getIdentificacion().equals(cliente.getIdentificacion())) {
                        listadoClientes.remove(i);
                        listadoClientes.add(cliente);
                        ControlArchivo.guardarArchivo(listadoClientes, "Clientes");
                        this.escribir();
                        JOptionPane.showMessageDialog(null, "Cliente modificado con éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Este cliente no existe", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar el cliente: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void eliminar(String identificacion) {
        Cliente cliente = null;
        try {
            this.inicializar();
            cliente = this.buscar(identificacion);
            for (int i = 0; i < listadoClientes.size(); i++) {
                if (listadoClientes.get(i).getIdentificacion().equals(identificacion) && cliente != null) {
                    int opcion = JOptionPane.showOptionDialog(null, "¿Está seguro que desea eliminar este cliente llamado " + cliente.getNombre() + " " + cliente.getApellido() + " ? ", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"SI", "NO"}, "SI");
                    if (opcion != -1) {
                        if ((opcion + 1) == 1) {
                            listadoClientes.remove(cliente);
                            ControlArchivo.guardarArchivo(listadoClientes, "Clientes");
                            this.escribir();
                            JOptionPane.showMessageDialog(null, "Empleado eliminado con éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Este empleado no existe", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el empleado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
