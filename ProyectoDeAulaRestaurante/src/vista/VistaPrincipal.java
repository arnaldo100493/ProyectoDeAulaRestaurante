package vista;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class VistaPrincipal extends JFrame {

    public VistaPrincipal() {
        initComponents();
        this.setTitle("Vista Principal");
        this.setLocationRelativeTo(null);
        this.setExtendedState(3);
    }

    public void cliente() {
        VistaCliente vc = new VistaCliente();
        vc.setVisible(true);
        this.dispose();
    }

    public void empleado() {
        VistaEmpleado ve = new VistaEmpleado();
        ve.setVisible(true);
        this.dispose();
    }

    public void producto() {
        VistaProducto vp = new VistaProducto();
        vp.setVisible(true);
        this.dispose();
    }

    public void cerrarSesion() {
        try {
            int opcion = JOptionPane.showOptionDialog(null, "¿Está seguro que desea cerrar sesión ?", "Confirmar Salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Si", "No"}, "Si");
            if (opcion != -1) {
                if ((opcion + 1) == 1) {
                    VistaIniciarSesion vis = new VistaIniciarSesion();
                    vis.setVisible(true);
                    this.dispose();
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al cerrar sesión", "Error", JOptionPane.ERROR_MESSAGE);
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
        jToolBar1 = new javax.swing.JToolBar();
        cliente = new javax.swing.JButton();
        empleado = new javax.swing.JButton();
        proveedor = new javax.swing.JButton();
        producto = new javax.swing.JButton();
        insumo = new javax.swing.JButton();
        detalleVenta = new javax.swing.JButton();
        venta = new javax.swing.JButton();
        cerrarSesion = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        cliente.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cliente.setText("Cliente");
        cliente.setFocusable(false);
        cliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteActionPerformed(evt);
            }
        });
        jToolBar1.add(cliente);

        empleado.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        empleado.setText("Empleado");
        empleado.setFocusable(false);
        empleado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        empleado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empleadoActionPerformed(evt);
            }
        });
        jToolBar1.add(empleado);

        proveedor.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        proveedor.setText("Proveedor");
        proveedor.setFocusable(false);
        proveedor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        proveedor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(proveedor);

        producto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        producto.setText("Producto");
        producto.setFocusable(false);
        producto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        producto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productoActionPerformed(evt);
            }
        });
        jToolBar1.add(producto);

        insumo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        insumo.setText("Insumo");
        insumo.setFocusable(false);
        insumo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        insumo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(insumo);

        detalleVenta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        detalleVenta.setText("Detalle Venta");
        detalleVenta.setFocusable(false);
        detalleVenta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        detalleVenta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(detalleVenta);

        venta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        venta.setText("Venta");
        venta.setFocusable(false);
        venta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        venta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(venta);

        cerrarSesion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cerrarSesion.setText("Cerrar Sesión");
        cerrarSesion.setFocusable(false);
        cerrarSesion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cerrarSesion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarSesionActionPerformed(evt);
            }
        });
        jToolBar1.add(cerrarSesion);

        salir.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        salir.setText("Salir");
        salir.setFocusable(false);
        salir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        salir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        jToolBar1.add(salir);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 541, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
            .addComponent(jDesktopPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane1))
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

    private void clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteActionPerformed
        this.cliente();
    }//GEN-LAST:event_clienteActionPerformed

    private void cerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarSesionActionPerformed
        this.cerrarSesion();
    }//GEN-LAST:event_cerrarSesionActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        this.salir();
    }//GEN-LAST:event_salirActionPerformed

    private void empleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empleadoActionPerformed
        this.empleado();
    }//GEN-LAST:event_empleadoActionPerformed

    private void productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productoActionPerformed
        this.producto();
    }//GEN-LAST:event_productoActionPerformed

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
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cerrarSesion;
    private javax.swing.JButton cliente;
    private javax.swing.JButton detalleVenta;
    private javax.swing.JButton empleado;
    private javax.swing.JButton insumo;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton producto;
    private javax.swing.JButton proveedor;
    private javax.swing.JButton salir;
    private javax.swing.JButton venta;
    // End of variables declaration//GEN-END:variables
}
