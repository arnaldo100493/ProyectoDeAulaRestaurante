package com.restaurante.control;

import com.restaurante.utilidades.Lista;
import javax.swing.JTable;

public interface Controlador<E> {

    public void escribir();
    
    public void cargarDatos();
    
    public void registrar(E objeto);

    public E buscar(String identificacion);

    public boolean existe(String identificacion);

    public E consultar(String identificacion);

    public void listar(JTable tabla);

    public Lista<E> listar();

    public void modificar(E objeto);

    public void eliminar(String identificacion);
}
