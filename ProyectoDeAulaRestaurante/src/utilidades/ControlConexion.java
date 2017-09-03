package utilidades;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ControlConexion implements Serializable {

    private static transient Connection conexion;

    public ControlConexion() {
        ControlConexion.conexion = null;
    }

    public ControlConexion(Connection con) {
        ControlConexion.conexion = con;
    }

    public static void setConexion(Connection con) {
        ControlConexion.conexion = con;
    }

    public static Connection getConexion() {
        return ControlConexion.conexion;
    }

    private static final String password = "CLAVE DE LA BASE DE DATOS";
    private static final String login = "postgres";
    private static final String url = "jdbc:postgresql://localhost:5432/NOMBRE DE LA BASE DE DATOS SIN ESPACIOS";
    private static final String driver = "org.postgresql.Driver";

    public static void conectar() throws SQLException {
        try {
            Class.forName(ControlConexion.driver);
            ControlConexion.conexion = DriverManager.getConnection(ControlConexion.url, ControlConexion.login, ControlConexion.password);
            System.out.println("Conectado...!!!");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("SQL Exception...!!!");
        } catch (Exception ex) {
            System.out.println("Error al conectar...!!!");
        }
    }
}
