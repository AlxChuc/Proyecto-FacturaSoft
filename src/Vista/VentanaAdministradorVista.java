/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author sam33
 */
public class VentanaAdministradorVista extends javax.swing.JFrame {

    /**
     * Creates new form VentanaAdministradorVista
     */
    public VentanaAdministradorVista() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        lbNombreUsuario = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        mPerfil = new javax.swing.JMenu();
        mModificarPerfil = new javax.swing.JMenuItem();
        mCambiarContrasenia = new javax.swing.JMenuItem();
        mEmpleado = new javax.swing.JMenu();
        mNuevoEmpleado = new javax.swing.JMenuItem();
        mInformacionEmpleado = new javax.swing.JMenuItem();
        mProducto = new javax.swing.JMenu();
        mNuevoProducto = new javax.swing.JMenuItem();
        mStock = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("Bienvenido");

        btnSalir.setText("Salir");

        lbNombreUsuario.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lbNombreUsuario.setForeground(new java.awt.Color(204, 0, 0));
        lbNombreUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNombreUsuario.setText("jLabel2");

        mPerfil.setText("Perfil");

        mModificarPerfil.setText("Modificar perfil");
        mPerfil.add(mModificarPerfil);

        mCambiarContrasenia.setText("Cambiar contraseña");
        mCambiarContrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mCambiarContraseniaActionPerformed(evt);
            }
        });
        mPerfil.add(mCambiarContrasenia);

        menuBar.add(mPerfil);

        mEmpleado.setText("Empleado");

        mNuevoEmpleado.setText("Nuevo empleado");
        mEmpleado.add(mNuevoEmpleado);

        mInformacionEmpleado.setText("Informacion empleados");
        mInformacionEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mInformacionEmpleadoActionPerformed(evt);
            }
        });
        mEmpleado.add(mInformacionEmpleado);

        menuBar.add(mEmpleado);

        mProducto.setText("Producto");

        mNuevoProducto.setText("Nuevo producto");
        mNuevoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mNuevoProductoActionPerformed(evt);
            }
        });
        mProducto.add(mNuevoProducto);

        mStock.setText("Stock");
        mStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mStockActionPerformed(evt);
            }
        });
        mProducto.add(mStock);

        menuBar.add(mProducto);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addGap(54, 54, 54))
            .addGroup(layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(lbNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mInformacionEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mInformacionEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mInformacionEmpleadoActionPerformed

    private void mNuevoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mNuevoProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mNuevoProductoActionPerformed

    private void mStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mStockActionPerformed

    private void mCambiarContraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mCambiarContraseniaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mCambiarContraseniaActionPerformed
    //Metodos get y set 
    public JButton getBtnSalir() {
        return btnSalir;
    }

    public void setBtnSalir(JButton btnSalir) {
        this.btnSalir = btnSalir;
    }

    public JLabel getLbNombreUsuario() {
        return lbNombreUsuario;
    }

    public void setLbNombreUsuario(String lbNombreUsuario) {
        this.lbNombreUsuario.setText(lbNombreUsuario);
    }

    public JMenu getmEmpleado() {
        return mEmpleado;
    }

    public void setmEmpleado(JMenu mEmpleado) {
        this.mEmpleado = mEmpleado;
    }

    public JMenuItem getmInformacionEmpleado() {
        return mInformacionEmpleado;
    }

    public void setmInformacionEmpleado(JMenuItem mInformacionEmpleado) {
        this.mInformacionEmpleado = mInformacionEmpleado;
    }

    public JMenuItem getmNuevoEmpleado() {
        return mNuevoEmpleado;
    }

    public void setmNuevoEmpleado(JMenuItem mNuevoEmpleado) {
        this.mNuevoEmpleado = mNuevoEmpleado;
    }

    public JMenuItem getmNuevoProducto() {
        return mNuevoProducto;
    }

    public void setmNuevoProducto(JMenuItem mNuevoProducto) {
        this.mNuevoProducto = mNuevoProducto;
    }

    public JMenu getmPerfil() {
        return mPerfil;
    }

    public void setmPerfil(JMenu mPerfil) {
        this.mPerfil = mPerfil;
    }

    public JMenu getmProducto() {
        return mProducto;
    }

    public void setmProducto(JMenu mProducto) {
        this.mProducto = mProducto;
    }

    public JMenuItem getmStock() {
        return mStock;
    }

    public void setmStock(JMenuItem mStock) {
        this.mStock = mStock;
    }

    public void setMenuBar(JMenuBar menuBar) {
        this.menuBar = menuBar;
    }

    public JMenuItem getmModificarPerfil() {
        return mModificarPerfil;
    }

    public void setmModificarPerfil(JMenuItem mModificarPerfil) {
        this.mModificarPerfil = mModificarPerfil;
    }

    public JMenuItem getmCambiarContrasenia() {
        return mCambiarContrasenia;
    }

    public void setmCambiarContrasenia(JMenuItem mCambiarContrasenia) {
        this.mCambiarContrasenia = mCambiarContrasenia;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(VentanaAdministradorVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAdministradorVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAdministradorVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAdministradorVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaAdministradorVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbNombreUsuario;
    private javax.swing.JMenuItem mCambiarContrasenia;
    private javax.swing.JMenu mEmpleado;
    private javax.swing.JMenuItem mInformacionEmpleado;
    private javax.swing.JMenuItem mModificarPerfil;
    private javax.swing.JMenuItem mNuevoEmpleado;
    private javax.swing.JMenuItem mNuevoProducto;
    private javax.swing.JMenu mPerfil;
    private javax.swing.JMenu mProducto;
    private javax.swing.JMenuItem mStock;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables
}
