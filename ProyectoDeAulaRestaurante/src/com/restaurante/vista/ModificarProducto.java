package com.restaurante.vista;

import com.restaurante.control.Controlador;
import com.restaurante.control.ControlProducto;
import java.awt.event.KeyEvent;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import com.restaurante.modelo.Producto;

public class ModificarProducto extends JInternalFrame {

    Controlador<Producto> controladorProducto = new ControlProducto();
    Producto busquedaProducto = new Producto();

    public ModificarProducto() {
        initComponents();
        this.controladorProducto.cargarDatos();
    }

    public void limpiarCampos() {
        this.textDigiteCodigo.setText("");
        this.textCodigo.setText("");
        this.textNombre.setText("");
        this.textDescripcion.setText("");
        this.textPrecio.setText("");
        this.textCantidad.setText("");
        this.textFechaRegistro.setText("");
    }

    public void consultar() {
        if (this.textDigiteCodigo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No ha escrito ningún código", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            this.busquedaProducto = this.controladorProducto.consultar(this.textDigiteCodigo.getText());
            if (this.busquedaProducto != null) {
                this.textCodigo.setText(String.valueOf(this.busquedaProducto.getCodigo()));
                this.textNombre.setText(this.busquedaProducto.getNombre());
                this.textDescripcion.setText(this.busquedaProducto.getDescripcion());
                this.textPrecio.setText(String.valueOf(this.busquedaProducto.getPrecio()));
                this.textCantidad.setText(String.valueOf(this.busquedaProducto.getCantidad()));
                this.textFechaRegistro.setText(this.busquedaProducto.getFechaRegistro());
            } else {
                this.limpiarCampos();
            }
        }
    }

    public void cancelar() {
        this.dispose();
    }

    public void modificar() {
        if (this.textDigiteCodigo.getText().isEmpty() || this.textCodigo.getText().isEmpty() || this.textNombre.getText().isEmpty() || this.textDescripcion.getText().isEmpty() || this.textPrecio.getText().isEmpty() || this.textCantidad.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se ha consultado el producto", "Advertencia", JOptionPane.WARNING_MESSAGE);
            this.limpiarCampos();
        } else {
            this.busquedaProducto = this.controladorProducto.consultar(this.textDigiteCodigo.getText());
            if (this.busquedaProducto != null) {
                this.busquedaProducto.setCodigo(this.textCodigo.getText());
                this.busquedaProducto.setNombre(this.textNombre.getText());
                this.busquedaProducto.setDescripcion(this.textDescripcion.getText());
                this.busquedaProducto.setPrecio(Integer.parseInt(this.textPrecio.getText()));
                this.busquedaProducto.setCantidad(Integer.parseInt(this.textCantidad.getText()));
                this.controladorProducto.modificar(this.busquedaProducto);
                this.limpiarCampos();
            } else {
                this.limpiarCampos();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelDigiteCodigo = new javax.swing.JLabel();
        labelCodigo = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        labelDescripcion = new javax.swing.JLabel();
        labelPrecio = new javax.swing.JLabel();
        labelCantidad = new javax.swing.JLabel();
        labelFechaRegistro = new javax.swing.JLabel();
        textDigiteCodigo = new javax.swing.JTextField();
        textCodigo = new javax.swing.JTextField();
        textNombre = new javax.swing.JTextField();
        textDescripcion = new javax.swing.JTextField();
        textPrecio = new javax.swing.JTextField();
        textCantidad = new javax.swing.JTextField();
        textFechaRegistro = new javax.swing.JTextField();
        buttonConsultar = new javax.swing.JButton();
        buttonConsultaCancelar = new javax.swing.JButton();
        buttonModificar = new javax.swing.JButton();
        buttonEliminar = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Modificar Productos");

        labelDigiteCodigo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelDigiteCodigo.setText("Digíte Código:");

        labelCodigo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelCodigo.setText("Código:");

        labelNombre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelNombre.setText("Nombre:");

        labelDescripcion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelDescripcion.setText("Descripción:");

        labelPrecio.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelPrecio.setText("Precio:");

        labelCantidad.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelCantidad.setText("Cantidad:");

        labelFechaRegistro.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelFechaRegistro.setText("Fecha Registro:");

        textDigiteCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textDigiteCodigoKeyTyped(evt);
            }
        });

        textCodigo.setEditable(false);
        textCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textCodigoKeyTyped(evt);
            }
        });

        textNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textNombreKeyTyped(evt);
            }
        });

        textDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textDescripcionKeyTyped(evt);
            }
        });

        textPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textPrecioKeyTyped(evt);
            }
        });

        textCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textCantidadKeyTyped(evt);
            }
        });

        textFechaRegistro.setEditable(false);

        buttonConsultar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        buttonConsultar.setText("Consultar");
        buttonConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConsultarActionPerformed(evt);
            }
        });

        buttonConsultaCancelar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        buttonConsultaCancelar.setText("Cancelar");
        buttonConsultaCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConsultaCancelarActionPerformed(evt);
            }
        });

        buttonModificar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        buttonModificar.setText("Modificar");
        buttonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModificarActionPerformed(evt);
            }
        });

        buttonEliminar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        buttonEliminar.setText("Limpiar");
        buttonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEliminarActionPerformed(evt);
            }
        });

        buttonCancelar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        buttonCancelar.setText("Cancelar");
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCodigo)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(labelFechaRegistro)
                                    .addGap(36, 36, 36))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelDigiteCodigo)
                                        .addComponent(labelNombre)
                                        .addComponent(labelDescripcion)
                                        .addComponent(labelPrecio)
                                        .addComponent(labelCantidad))
                                    .addGap(47, 47, 47)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(buttonModificar)
                                .addGap(39, 39, 39)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(buttonEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonCancelar))
                            .addComponent(textDigiteCodigo)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(buttonConsultar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addComponent(buttonConsultaCancelar))
                            .addComponent(textCodigo)
                            .addComponent(textNombre)
                            .addComponent(textDescripcion)
                            .addComponent(textPrecio)
                            .addComponent(textCantidad)
                            .addComponent(textFechaRegistro))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDigiteCodigo)
                    .addComponent(textDigiteCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonConsultar)
                    .addComponent(buttonConsultaCancelar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCodigo)
                    .addComponent(textCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombre)
                    .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDescripcion))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPrecio))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCantidad))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelFechaRegistro)
                    .addComponent(textFechaRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonModificar)
                    .addComponent(buttonEliminar)
                    .addComponent(buttonCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void textDigiteCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textDigiteCodigoKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_textDigiteCodigoKeyTyped

    private void buttonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConsultarActionPerformed
        this.consultar();
    }//GEN-LAST:event_buttonConsultarActionPerformed

    private void buttonConsultaCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConsultaCancelarActionPerformed
        this.limpiarCampos();
    }//GEN-LAST:event_buttonConsultaCancelarActionPerformed

    private void buttonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModificarActionPerformed
        this.modificar();
    }//GEN-LAST:event_buttonModificarActionPerformed

    private void buttonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEliminarActionPerformed
        this.limpiarCampos();
    }//GEN-LAST:event_buttonEliminarActionPerformed

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_buttonCancelarActionPerformed

    private void textCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textCodigoKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_textCodigoKeyTyped

    private void textNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textNombreKeyTyped
        char c = evt.getKeyChar();
        if ((c < 'A' || c > 'Z') && (c < 'a' || c > 'z') && (c != (char) KeyEvent.VK_SPACE)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_textNombreKeyTyped

    private void textDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textDescripcionKeyTyped
        char c = evt.getKeyChar();
        if ((c < 'A' || c > 'Z') && (c < 'a' || c > 'z') && (c != (char) KeyEvent.VK_SPACE)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_textDescripcionKeyTyped

    private void textCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textCantidadKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_textCantidadKeyTyped

    private void textPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textPrecioKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_textPrecioKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonConsultaCancelar;
    private javax.swing.JButton buttonConsultar;
    private javax.swing.JButton buttonEliminar;
    private javax.swing.JButton buttonModificar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelCantidad;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JLabel labelDescripcion;
    private javax.swing.JLabel labelDigiteCodigo;
    private javax.swing.JLabel labelFechaRegistro;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelPrecio;
    private javax.swing.JTextField textCantidad;
    private javax.swing.JTextField textCodigo;
    private javax.swing.JTextField textDescripcion;
    private javax.swing.JTextField textDigiteCodigo;
    private javax.swing.JTextField textFechaRegistro;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textPrecio;
    // End of variables declaration//GEN-END:variables
}
