/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurante.jdbc;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.exceptions.MySQLDataException;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author FABAME
 */
public class ConexionMySQL {

    private static transient Connection conexion;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/dbproducto";
    private static final String user = "root";
    private static final String password = "";

    public ConexionMySQL() {
        conexion = null;
    }

    public ConexionMySQL(Connection con) {
        conexion = con;
    }

    public static void setConexion(Connection con) {
        conexion = con;
    }

    public static Connection getConexion() {
        return conexion;
    }

    public static boolean estaConectado() {
        return conexion != null;
    }

    public static void cerrarConexion() {
        try {
            if (estaConectado()) {
                conexion.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public static Connection conectar() {
        conexion = null;
        try {
            Class.forName(driver);
            conexion = (Connection) DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (MySQLDataException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            return conexion;
        }
    }
}
