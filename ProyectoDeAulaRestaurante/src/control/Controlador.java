package control;

import java.util.List;
import javax.swing.JTable;

public interface Controlador<T> {

    public void escribir();
    
    public void cargarDatos();
    
    public void registrar(T objeto);

    public T buscar(String identificacion);

    public boolean existe(String identificacion);

    public T consultar(String identificacion);

    public void listar(JTable tabla);

    public List<T> listar();

    public void modificar(T objeto);

    public void eliminar(String identificacion);
}
