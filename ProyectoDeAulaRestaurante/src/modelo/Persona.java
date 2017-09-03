package modelo;

import java.io.Serializable;

public abstract class Persona implements Serializable {

    protected String identificacion;
    protected String nombre;
    protected String apellido;
    protected String direccion;
    protected String telefono;
    protected String correoElectronico;
    protected String sexo;
    protected String fechaRegistro;

    public Persona() {
        this.identificacion = "";
        this.nombre = "";
        this.apellido = "";
        this.direccion = "";
        this.telefono = "";
        this.correoElectronico = "";
        this.sexo = "";
        this.fechaRegistro = "";
    }

    public Persona(String identificacion) {
        this.identificacion = identificacion;
        this.nombre = "";
        this.apellido = "";
        this.direccion = "";
        this.telefono = "";
        this.correoElectronico = "";
        this.sexo = "";
        this.fechaRegistro = "";
    }

    public Persona(String identificacion, String nombre, String apellido, String direccion, String telefono, String correoElectronico, String sexo) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.sexo = sexo;
    }

    public Persona(String identificacion, String nombre, String apellido, String direccion, String telefono, String correoElectronico, String sexo, String fechaRegistro) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.sexo = sexo;
        this.fechaRegistro = fechaRegistro;
    }

    public Persona(Persona persona) {
        this.identificacion = persona.getIdentificacion();
        this.nombre = persona.getNombre();
        this.apellido = persona.getApellido();
        this.direccion = persona.getDireccion();
        this.telefono = persona.getTelefono();
        this.correoElectronico = persona.getCorreoElectronico();
        this.sexo = persona.getSexo();
        this.fechaRegistro = persona.getFechaRegistro();
    }

    public String mostrarPersona() {
        return "Identificación: " + this.identificacion + "Nombre: " + this.nombre + "Apellido: " + this.apellido + "Dirección: " + this.direccion + "Teléfono: " + this.telefono + "Correo Electrónico: " + this.correoElectronico + "Sexo: " + this.sexo + "Fecha Registro: " + this.fechaRegistro;
    }

    @Override
    public String toString() {
        return this.identificacion + "|" + this.nombre + "|" + this.apellido + "|" + this.direccion + "|" + this.telefono + "|" + this.correoElectronico + "|" + this.sexo + "|" + this.fechaRegistro;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getIdentificacion() {
        return this.identificacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getCorreoElectronico() {
        return this.correoElectronico;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSexo() {
        return this.sexo;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

}
