package modelo;

import java.io.Serializable;

public class Cliente extends Persona implements Serializable {

    public Cliente() {
        super();
    }

    public Cliente(String identificacion) {
        super(identificacion);
    }

    public Cliente(String direccion, String telefono, String correoElectronico) {
        super();
    }

    public Cliente(String identificacion, String nombre, String apellido, String direccion, String telefono, String correoElectronico, String sexo) {
        super(identificacion, nombre, apellido, direccion, telefono, correoElectronico, sexo, telefono);
    }

    public Cliente(String identificacion, String nombre, String apellido, String sexo, String fechaRegistro, String direccion, String telefono, String correoElectronico) {
        super(identificacion, nombre, apellido, direccion, telefono, correoElectronico, sexo, fechaRegistro);

    }

    public Cliente(Persona persona) {
        super(persona);

    }

    public Cliente(Cliente cliente) {
        super();
        this.identificacion = cliente.getIdentificacion();
        this.nombre = cliente.getNombre();
        this.apellido = cliente.getApellido();
        this.direccion = cliente.getDireccion();
        this.telefono = cliente.getTelefono();
        this.correoElectronico = cliente.getCorreoElectronico();
        this.sexo = cliente.getSexo();
        this.fechaRegistro = cliente.getFechaRegistro();
    }

    public String mostrarCliente() {
        return super.mostrarPersona();
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
