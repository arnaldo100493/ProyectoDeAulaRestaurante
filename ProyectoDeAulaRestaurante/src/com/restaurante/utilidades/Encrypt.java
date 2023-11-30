package com.restaurante.utilidades;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Clase para la encriptación de contraseñas
 *
 * @author Arnaldo Andrés Barrios Mena
 * @version 1.0
 */
public class Encrypt {

    public Encrypt() {

    }

    /**
     * Método estático para la encriptación de contraseñas
     *
     * @param cadena la cadena que se va a encriptar
     * @return la cadena encriptada
     */
    public static String sha512(String cadena) {
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(cadena.getBytes());
            byte[] mb = md.digest();
            for (int i = 0; i < mb.length; i++) {
                sb.append(Integer.toString((mb[i] & 0xff) + 0x100, 16).substring(1));
            }
        } catch (NoSuchAlgorithmException ex) {

        }
        return sb.toString();
    }

}
