package com.restaurante.vista;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class VistaIniciarSesion extends JFrame {

    public VistaIniciarSesion() {
        initComponents();
        this.setTitle("Iniciar Sesión");
        this.setLocationRelativeTo(null);
        this.setExtendedState(3);
    }

    public void limpiarCampos() {
        this.usuario.setText("");
        this.contrasenia.setText("");
        this.lista.setSelectedIndex(0);
    }

    public boolean validarCampos() {
        return this.usuario.getText().isEmpty() || this.contrasenia.getText().isEmpty();
    }

    public void ingresar() {
        if (this.validarCampos()) {
            JOptionPane.showMessageDialog(null, "No debe dejar campos vacíos", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else if (this.lista.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de cuenta", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else if (this.usuario.getText().equalsIgnoreCase("arnaldo100493") && this.contrasenia.getText().equalsIgnoreCase("100493")) {
            VistaPrincipal vp = new VistaPrincipal();
            vp.setVisible(true);
            this.dispose();
            JOptionPane.showMessageDialog(null, "Bienvenido", "Restaurante", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña son incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
            limpiarCampos();
        }
    }

    public void salir() {
        try {
            int opcion = JOptionPane.showOptionDialog(null, "¿Está seguro que desea salir?", "Confirmar Salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Si", "No"}, "Si");
            if (opcion != -1) {
                if ((opcion + 1) == 1) {
                    this.dispose();
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al salir", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlIniciarSesion = new javax.swing.JLabel();
        jlUsuario = new javax.swing.JLabel();
        jlContrasenia = new javax.swing.JLabel();
        jlTipoCuenta = new javax.swing.JLabel();
        usuario = new javax.swing.JTextField();
        contrasenia = new javax.swing.JPasswordField();
        lista = new javax.swing.JComboBox();
        ingresar = new javax.swing.JButton();
        salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlIniciarSesion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jlIniciarSesion.setText("Iniciar Sesión");

        jlUsuario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jlUsuario.setText("Usuario:");

        jlContrasenia.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jlContrasenia.setText("Contraseña:");

        jlTipoCuenta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jlTipoCuenta.setText("Tipo de cuenta");

        lista.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lista.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ingresar como", "Administrador", "Empleado", "Vendedor" }));

        ingresar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        ingresar.setText("Ingresar");
        ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarActionPerformed(evt);
            }
        });

        salir.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlContrasenia)
                            .addComponent(jlUsuario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ingresar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                                .addComponent(salir))
                            .addComponent(usuario)
                            .addComponent(contrasenia))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlTipoCuenta)
                            .addComponent(lista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jlIniciarSesion)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jlIniciarSesion)
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlUsuario)
                    .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlTipoCuenta))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlContrasenia)
                        .addComponent(contrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ingresar)
                    .addComponent(salir))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresarActionPerformed
        this.ingresar();
    }//GEN-LAST:event_ingresarActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        this.salir();
    }//GEN-LAST:event_salirActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaIniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaIniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaIniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaIniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaIniciarSesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField contrasenia;
    private javax.swing.JButton ingresar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlContrasenia;
    private javax.swing.JLabel jlIniciarSesion;
    private javax.swing.JLabel jlTipoCuenta;
    private javax.swing.JLabel jlUsuario;
    private javax.swing.JComboBox lista;
    private javax.swing.JButton salir;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}
