package vista;

import control.Controlador;
import control.ControlEmpleado;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import modelo.Empleado;

public class EliminarEmpleado extends JInternalFrame {

    Controlador<Empleado> controladorEmpleado = new ControlEmpleado();
    Empleado busquedaEmpleado = new Empleado();

    public EliminarEmpleado() {
        initComponents();
        this.controladorEmpleado.cargarDatos();
    }

    public void limpiarCampos() {
        this.textDigiteIdentificacion.setText("");
        this.textIdentificacion.setText("");
        this.textNombre.setText("");
        this.textApellido.setText("");
        this.textDireccion.setText("");
        this.textTelefono.setText("");
        this.textCorreoElectronico.setText("");
        this.textSexo.setText("");
        this.textSueldo.setText("");
        this.textFechaRegistro.setText("");

    }

    public void consultar() {
        if (this.textDigiteIdentificacion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No ha escrito ninguna identificación", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            this.busquedaEmpleado = this.controladorEmpleado.consultar(this.textDigiteIdentificacion.getText());
            if (this.busquedaEmpleado != null) {
                this.textIdentificacion.setText(String.valueOf(this.busquedaEmpleado.getIdentificacion()));
                this.textNombre.setText(this.busquedaEmpleado.getNombre());
                this.textApellido.setText(this.busquedaEmpleado.getApellido());
                this.textDireccion.setText(this.busquedaEmpleado.getDireccion());
                this.textTelefono.setText(this.busquedaEmpleado.getTelefono());
                this.textSexo.setText(this.busquedaEmpleado.getSexo());
                this.textSueldo.setText(String.valueOf(busquedaEmpleado.getSueldo()));
                this.textFechaRegistro.setText(this.busquedaEmpleado.getFechaRegistro());
            } else {
                this.limpiarCampos();
            }
        }
    }

    public void cancelar() {
        this.dispose();
    }

    public void eliminar() {
        if (this.textDigiteIdentificacion.getText().isEmpty() || this.textIdentificacion.getText().isEmpty() || this.textNombre.getText().isEmpty() || this.textApellido.getText().isEmpty() || this.textDireccion.getText().isEmpty() || this.textTelefono.getText().isEmpty() || this.textCorreoElectronico.getText().isEmpty() || this.textSexo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se ha consultado el empleado", "Advertencia", JOptionPane.WARNING_MESSAGE);
            this.limpiarCampos();
        } else {
            this.busquedaEmpleado = this.controladorEmpleado.consultar(this.textDigiteIdentificacion.getText());
            if (this.busquedaEmpleado != null) {
                this.busquedaEmpleado.setIdentificacion(this.textIdentificacion.getText());
                this.busquedaEmpleado.setNombre(this.textNombre.getText());
                this.busquedaEmpleado.setApellido(this.textApellido.getText());
                this.busquedaEmpleado.setDireccion(this.textDireccion.getText());
                this.busquedaEmpleado.setTelefono(this.textTelefono.getText());
                this.busquedaEmpleado.setCorreoElectronico(this.textCorreoElectronico.getText());
                this.busquedaEmpleado.setSexo(this.textSexo.getText());
                this.busquedaEmpleado.setFechaRegistro(this.textFechaRegistro.getText());
                this.controladorEmpleado.eliminar(this.busquedaEmpleado.getIdentificacion());
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
        labelDigiteIdentificacion = new javax.swing.JLabel();
        labelIdentificacion = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        labelApellido = new javax.swing.JLabel();
        labelDireccion = new javax.swing.JLabel();
        labelTelefono = new javax.swing.JLabel();
        labelCorreo = new javax.swing.JLabel();
        labelSexo = new javax.swing.JLabel();
        labelSueldo = new javax.swing.JLabel();
        labelFechaRegistro = new javax.swing.JLabel();
        textDigiteIdentificacion = new javax.swing.JTextField();
        textIdentificacion = new javax.swing.JTextField();
        textNombre = new javax.swing.JTextField();
        textApellido = new javax.swing.JTextField();
        textDireccion = new javax.swing.JTextField();
        textTelefono = new javax.swing.JTextField();
        textCorreoElectronico = new javax.swing.JTextField();
        textSexo = new javax.swing.JTextField();
        textSueldo = new javax.swing.JTextField();
        textFechaRegistro = new javax.swing.JTextField();
        buttonConsultar = new javax.swing.JButton();
        buttonConsultaCancelar = new javax.swing.JButton();
        buttonEliminar = new javax.swing.JButton();
        buttonLimpiar = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Eliminar Empleados");

        labelDigiteIdentificacion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelDigiteIdentificacion.setText("Digíte Identificación:");

        labelIdentificacion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelIdentificacion.setText("Identificación:");

        labelNombre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelNombre.setText("Nombre:");

        labelApellido.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelApellido.setText("Apellido:");

        labelDireccion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelDireccion.setText("Dirección:");

        labelTelefono.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelTelefono.setText("Teléfono:");

        labelCorreo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelCorreo.setText("Correo Electrónico:");

        labelSexo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelSexo.setText("Sexo:");

        labelSueldo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelSueldo.setText("Sueldo:");

        labelFechaRegistro.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelFechaRegistro.setText("Fecha Registro:");

        textDigiteIdentificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textDigiteIdentificacionKeyTyped(evt);
            }
        });

        textIdentificacion.setEditable(false);

        textNombre.setEditable(false);

        textApellido.setEditable(false);

        textDireccion.setEditable(false);

        textTelefono.setEditable(false);

        textCorreoElectronico.setEditable(false);

        textSexo.setEditable(false);

        textSueldo.setEditable(false);

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

        buttonEliminar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        buttonEliminar.setText("Eliminar");
        buttonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEliminarActionPerformed(evt);
            }
        });

        buttonLimpiar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        buttonLimpiar.setText("Limpiar");
        buttonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLimpiarActionPerformed(evt);
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
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(labelSexo)
                            .addGap(95, 95, 95)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(textSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(buttonLimpiar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(buttonCancelar))
                                    .addComponent(textFechaRegistro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(labelDigiteIdentificacion)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(textIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(buttonConsultar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(buttonConsultaCancelar))
                                    .addComponent(textDigiteIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addComponent(labelFechaRegistro)
                    .addComponent(labelSueldo)
                    .addComponent(labelNombre)
                    .addComponent(labelIdentificacion)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCorreo)
                            .addComponent(labelTelefono)
                            .addComponent(labelDireccion)
                            .addComponent(labelApellido))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textCorreoElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(buttonEliminar))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDigiteIdentificacion)
                    .addComponent(textDigiteIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonConsultar)
                    .addComponent(buttonConsultaCancelar))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelIdentificacion)
                    .addComponent(textIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombre)
                    .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelApellido)
                    .addComponent(textApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDireccion)
                    .addComponent(textDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTelefono)
                    .addComponent(textTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCorreo)
                    .addComponent(textCorreoElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSexo)
                    .addComponent(textSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelSueldo)
                    .addComponent(textSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelFechaRegistro)
                    .addComponent(textFechaRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonEliminar)
                    .addComponent(buttonLimpiar)
                    .addComponent(buttonCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textDigiteIdentificacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textDigiteIdentificacionKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_textDigiteIdentificacionKeyTyped

    private void buttonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConsultarActionPerformed
        this.consultar();
    }//GEN-LAST:event_buttonConsultarActionPerformed

    private void buttonConsultaCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConsultaCancelarActionPerformed
        this.limpiarCampos();
    }//GEN-LAST:event_buttonConsultaCancelarActionPerformed

    private void buttonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEliminarActionPerformed
        this.eliminar();
    }//GEN-LAST:event_buttonEliminarActionPerformed

    private void buttonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLimpiarActionPerformed
        this.limpiarCampos();
    }//GEN-LAST:event_buttonLimpiarActionPerformed

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_buttonCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonConsultaCancelar;
    private javax.swing.JButton buttonConsultar;
    private javax.swing.JButton buttonEliminar;
    private javax.swing.JButton buttonLimpiar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelApellido;
    private javax.swing.JLabel labelCorreo;
    private javax.swing.JLabel labelDigiteIdentificacion;
    private javax.swing.JLabel labelDireccion;
    private javax.swing.JLabel labelFechaRegistro;
    private javax.swing.JLabel labelIdentificacion;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelSexo;
    private javax.swing.JLabel labelSueldo;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JTextField textApellido;
    private javax.swing.JTextField textCorreoElectronico;
    private javax.swing.JTextField textDigiteIdentificacion;
    private javax.swing.JTextField textDireccion;
    private javax.swing.JTextField textFechaRegistro;
    private javax.swing.JTextField textIdentificacion;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textSexo;
    private javax.swing.JTextField textSueldo;
    private javax.swing.JTextField textTelefono;
    // End of variables declaration//GEN-END:variables
}
