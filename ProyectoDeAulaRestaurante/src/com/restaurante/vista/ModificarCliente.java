/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurante.vista;

import com.restaurante.control.Controlador;
import com.restaurante.control.ControlCliente;
import com.restaurante.modelo.Cliente;
import com.restaurante.utilidades.Mensajes;

/**
 *
 * @author cyber
 */
public class ModificarCliente extends javax.swing.JInternalFrame {

    private final Controlador<Cliente> controladorCliente;

    /**
     * Creates new form ModificarCliente
     */
    public ModificarCliente() {
        initComponents();
        this.controladorCliente = new ControlCliente();
        this.controladorCliente.cargarDatos();
    }

    private void validarIdentificacion(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            getToolkit().beep();
            evt.consume();
        }
    }

    private void validarNombre(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if ((c < 'A' || c > 'Z') && (c < 'a' || c > 'z') && (c != (char) java.awt.event.KeyEvent.VK_SPACE)) {
            getToolkit().beep();
            evt.consume();
        }
    }

    private void validarApellido(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if ((c < 'A' || c > 'Z') && (c < 'a' || c > 'z') && (c != (char) java.awt.event.KeyEvent.VK_SPACE)) {
            getToolkit().beep();
            evt.consume();
        }
    }

    private void validarTelefono(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            getToolkit().beep();
            evt.consume();
        }
    }

    private void limpiar() {
        this.txtDigiteIdentificacion.setText("");
        this.txtIdentificacion.setText("");
        this.txtNombre.setText("");
        this.txtApellido.setText("");
        this.txtDireccion.setText("");
        this.txtTelefono.setText("");
        this.txtCorreoElectronico.setText("");
        this.txtFechaRegistro.setText("");
        this.cbxSexo.setSelectedIndex(0);

    }

    private void consultar() {
        Cliente busquedaCliente = null;
        if (this.txtDigiteIdentificacion.getText().isEmpty()) {
            Mensajes.mostrarMensajeAdvertencia("No ha escrito ninguna identificación", "Advertencia");
        } else {
            busquedaCliente = this.controladorCliente.consultar(this.txtDigiteIdentificacion.getText());
            if (busquedaCliente != null) {
                this.txtIdentificacion.setText(String.valueOf(busquedaCliente.getIdentificacion()));
                this.txtNombre.setText(busquedaCliente.getNombre());
                this.txtApellido.setText(busquedaCliente.getApellido());
                this.txtDireccion.setText(busquedaCliente.getDireccion());
                this.txtTelefono.setText(busquedaCliente.getTelefono());
                this.txtCorreoElectronico.setText(busquedaCliente.getCorreoElectronico());
                this.cbxSexo.setSelectedItem(busquedaCliente.getSexo());
                this.txtFechaRegistro.setText(busquedaCliente.getFechaRegistro());
            } else {
                this.limpiar();
            }
        }
    }

    private void cancelar() {
        this.dispose();
    }

    private void modificar() {
        Cliente busquedaCliente = null;
        if (this.txtDigiteIdentificacion.getText().isEmpty() || this.txtIdentificacion.getText().isEmpty() || this.txtNombre.getText().isEmpty() || this.txtApellido.getText().isEmpty() || this.txtDireccion.getText().isEmpty() || this.txtTelefono.getText().isEmpty() || this.txtCorreoElectronico.getText().isEmpty() || this.cbxSexo.getSelectedIndex() == 0) {
            Mensajes.mostrarMensajeAdvertencia("No se ha consultado el cliente", "Advertencia");
            this.limpiar();
        } else {
            busquedaCliente = this.controladorCliente.consultar(this.txtDigiteIdentificacion.getText());
            if (busquedaCliente != null) {
                busquedaCliente.setIdentificacion(this.txtIdentificacion.getText());
                busquedaCliente.setNombre(this.txtNombre.getText());
                busquedaCliente.setApellido(this.txtApellido.getText());
                busquedaCliente.setDireccion(this.txtDireccion.getText());
                busquedaCliente.setTelefono(this.txtTelefono.getText());
                busquedaCliente.setCorreoElectronico(this.txtCorreoElectronico.getText());
                busquedaCliente.setSexo(this.cbxSexo.getSelectedItem().toString());
                this.controladorCliente.modificar(busquedaCliente);
                this.limpiar();
            } else {
                this.limpiar();
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDatos = new javax.swing.JPanel();
        lblDigiteIdentificacion = new javax.swing.JLabel();
        lbIdentificacion = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblCorreoElectronico = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        lblFechaRegistro = new javax.swing.JLabel();
        txtDigiteIdentificacion = new javax.swing.JTextField();
        txtIdentificacion = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtCorreoElectronico = new javax.swing.JTextField();
        txtFechaRegistro = new javax.swing.JTextField();
        cbxSexo = new javax.swing.JComboBox();
        btnConsultar = new javax.swing.JButton();
        btnConsultaCancelar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Modificar Clientes");

        lblDigiteIdentificacion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblDigiteIdentificacion.setText("Digíte Identificación:");

        lbIdentificacion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbIdentificacion.setText("Identificación:");

        lblNombre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblNombre.setText("Nombre:");

        lblApellido.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblApellido.setText("Apellido:");

        lblDireccion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblDireccion.setText("Dirección:");

        lblTelefono.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblTelefono.setText("Teléfono:");

        lblCorreoElectronico.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblCorreoElectronico.setText("Correo Electrónico:");

        lblSexo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblSexo.setText("Sexo:");

        lblFechaRegistro.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblFechaRegistro.setText("Fecha Registro:");

        txtDigiteIdentificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDigiteIdentificacionKeyTyped(evt);
            }
        });

        txtIdentificacion.setEditable(false);
        txtIdentificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdentificacionKeyTyped(evt);
            }
        });

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        txtFechaRegistro.setEditable(false);

        cbxSexo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbxSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "Masculino", "Femenino" }));

        btnConsultar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnConsultaCancelar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnConsultaCancelar.setText("Cancelar");
        btnConsultaCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaCancelarActionPerformed(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDatosLayout = new javax.swing.GroupLayout(pnlDatos);
        pnlDatos.setLayout(pnlDatosLayout);
        pnlDatosLayout.setHorizontalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addComponent(lblSexo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosLayout.createSequentialGroup()
                                    .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblDigiteIdentificacion)
                                        .addComponent(lblNombre)
                                        .addComponent(lblApellido)
                                        .addComponent(lblDireccion)
                                        .addComponent(lblTelefono))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                .addGroup(pnlDatosLayout.createSequentialGroup()
                                    .addComponent(btnModificar)
                                    .addGap(39, 39, 39)))
                            .addGroup(pnlDatosLayout.createSequentialGroup()
                                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCorreoElectronico)
                                    .addComponent(lbIdentificacion)
                                    .addComponent(lblFechaRegistro))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlDatosLayout.createSequentialGroup()
                                .addComponent(btnLimpiar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCancelar))
                            .addComponent(txtDigiteIdentificacion)
                            .addGroup(pnlDatosLayout.createSequentialGroup()
                                .addComponent(btnConsultar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addComponent(btnConsultaCancelar))
                            .addComponent(txtIdentificacion)
                            .addComponent(txtNombre)
                            .addComponent(txtApellido)
                            .addComponent(txtDireccion)
                            .addComponent(txtTelefono)
                            .addComponent(txtFechaRegistro)
                            .addComponent(txtCorreoElectronico))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        pnlDatosLayout.setVerticalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDigiteIdentificacion)
                    .addComponent(txtDigiteIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsultar)
                    .addComponent(btnConsultaCancelar))
                .addGap(18, 18, 18)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbIdentificacion)
                    .addComponent(txtIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblApellido)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDireccion)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTelefono)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCorreoElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addComponent(lblCorreoElectronico)
                        .addGap(18, 18, 18)
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFechaRegistro)
                            .addComponent(txtFechaRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(25, 25, 25)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSexo)
                    .addComponent(cbxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar)
                    .addComponent(btnLimpiar)
                    .addComponent(btnCancelar))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDigiteIdentificacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDigiteIdentificacionKeyTyped
        // TODO add your handling code here:
        this.validarIdentificacion(evt);
    }//GEN-LAST:event_txtDigiteIdentificacionKeyTyped

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        // TODO add your handling code here:
        this.consultar();
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnConsultaCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaCancelarActionPerformed
        // TODO add your handling code here:
        this.limpiar();
    }//GEN-LAST:event_btnConsultaCancelarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        this.modificar();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        this.limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.cancelar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtIdentificacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdentificacionKeyTyped
        // TODO add your handling code here:
        this.validarIdentificacion(evt);
    }//GEN-LAST:event_txtIdentificacionKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
        this.validarNombre(evt);
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyTyped
        // TODO add your handling code here:
        this.validarApellido(evt);
    }//GEN-LAST:event_txtApellidoKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        // TODO add your handling code here:
        this.validarTelefono(evt);
    }//GEN-LAST:event_txtTelefonoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConsultaCancelar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox cbxSexo;
    private javax.swing.JLabel lbIdentificacion;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCorreoElectronico;
    private javax.swing.JLabel lblDigiteIdentificacion;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblFechaRegistro;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCorreoElectronico;
    private javax.swing.JTextField txtDigiteIdentificacion;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtFechaRegistro;
    private javax.swing.JTextField txtIdentificacion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
