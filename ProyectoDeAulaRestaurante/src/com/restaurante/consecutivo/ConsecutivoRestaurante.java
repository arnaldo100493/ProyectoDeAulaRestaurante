package com.restaurante.consecutivo;

import com.restaurante.control.ControlUtilidades;
import java.io.IOException;
import javax.swing.JOptionPane;

public class ConsecutivoRestaurante {
    
  public ConsecutivoRestaurante(){
      
  }  

    public static void main(String[] args) throws IOException {
        System.out.println(ControlUtilidades.numeroConsecutivo());
        JOptionPane.showMessageDialog(null, ControlUtilidades.numeroConsecutivo());
        ControlUtilidades.guardarConsecutivo(ControlUtilidades.numeroConsecutivo());
    }
}
