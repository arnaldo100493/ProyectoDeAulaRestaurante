/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurante.utilidades;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.exceptions.MySQLDataException;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author cyber
 *
 */
public class ConexionMySQL {

    private static transient Connection conexion;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/restaurante";
    private static final String user = "root";
    private static final String password = "";

    public ConexionMySQL() {

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
        } finally {
            return conexion;
        }
    }

    public static Connection conectar(String url) {
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
        } finally {
            return conexion;
        }
    }

    public static Connection conectar(String url, String user, String password) {
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
        } finally {
            return conexion;
        }
    }

    public static Connection conectar(String driver, String url, String user, String password) {
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
        } finally {
            return conexion;
        }
    }

    public static boolean estaConectado() {
        return conexion != null;
    }

}
