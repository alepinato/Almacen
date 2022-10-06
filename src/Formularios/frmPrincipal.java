/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class frmPrincipal extends javax.swing.JFrame {

    String hora, minuto, segundo;
    Thread hilo;
   
    Statement stm;
    Connection conection;
    
    public frmPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle(frmLogin.usugeneral);
        btnusuarios.setEnabled(false);
        btnlistados.setEnabled(false);
        this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
        String sn = DiskUtils.getSerialNumber("C");
        lblserialhdd.setText(sn); 
        String sFichero;
        sFichero = "C:\\83016amps.txt";
        File fichero = new File(sFichero);
        if (!fichero.exists()){
            JOptionPane.showMessageDialog(null, "Su equipo no está configurado, llame al 099600885");
            System.exit(0);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btncalculadora = new javax.swing.JButton();
        btnrespaldo = new javax.swing.JButton();
        btncategorias = new javax.swing.JButton();
        btnlistados = new javax.swing.JButton();
        btnusuarios = new javax.swing.JButton();
        btnprecios = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        btnbuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btncaja = new javax.swing.JButton();
        lblserialhdd = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(812, 500));
        setMinimumSize(new java.awt.Dimension(812, 500));
        setPreferredSize(new java.awt.Dimension(812, 500));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btncalculadora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1481325875_calculator.png"))); // NOI18N
        btncalculadora.setText("Calculadora");
        btncalculadora.setToolTipText("Calculadora del sistema");
        btncalculadora.setBorder(null);
        btncalculadora.setBorderPainted(false);
        btncalculadora.setContentAreaFilled(false);
        btncalculadora.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncalculadora.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btncalculadora.setMaximumSize(new java.awt.Dimension(65, 67));
        btncalculadora.setMinimumSize(new java.awt.Dimension(65, 67));
        btncalculadora.setPreferredSize(new java.awt.Dimension(65, 67));
        btncalculadora.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btncalculadora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncalculadoraActionPerformed(evt);
            }
        });
        getContentPane().add(btncalculadora, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 230, 90, 80));

        btnrespaldo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1481325195_db_update.png"))); // NOI18N
        btnrespaldo.setText("Respaldo");
        btnrespaldo.setToolTipText("Permite realizar un respaldo de la lista de precios");
        btnrespaldo.setBorder(null);
        btnrespaldo.setBorderPainted(false);
        btnrespaldo.setContentAreaFilled(false);
        btnrespaldo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnrespaldo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnrespaldo.setMaximumSize(new java.awt.Dimension(65, 67));
        btnrespaldo.setMinimumSize(new java.awt.Dimension(65, 67));
        btnrespaldo.setPreferredSize(new java.awt.Dimension(65, 67));
        btnrespaldo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnrespaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrespaldoActionPerformed(evt);
            }
        });
        getContentPane().add(btnrespaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 140, 90, 76));

        btncategorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1481325241_Product-documentation.png"))); // NOI18N
        btncategorias.setText("Categorias");
        btncategorias.setToolTipText("Permite crear categorías o familias de productos");
        btncategorias.setBorder(null);
        btncategorias.setBorderPainted(false);
        btncategorias.setContentAreaFilled(false);
        btncategorias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncategorias.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btncategorias.setMaximumSize(new java.awt.Dimension(65, 67));
        btncategorias.setMinimumSize(new java.awt.Dimension(65, 67));
        btncategorias.setPreferredSize(new java.awt.Dimension(65, 67));
        btncategorias.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btncategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncategoriasActionPerformed(evt);
            }
        });
        getContentPane().add(btncategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 100, 83));

        btnlistados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1481325470_project-plan.png"))); // NOI18N
        btnlistados.setText("Listados");
        btnlistados.setToolTipText("Listado para impresión de precios, productos, categorías, etc.");
        btnlistados.setBorder(null);
        btnlistados.setBorderPainted(false);
        btnlistados.setContentAreaFilled(false);
        btnlistados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnlistados.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnlistados.setMaximumSize(new java.awt.Dimension(65, 67));
        btnlistados.setMinimumSize(new java.awt.Dimension(65, 67));
        btnlistados.setPreferredSize(new java.awt.Dimension(65, 67));
        btnlistados.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnlistados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlistadosActionPerformed(evt);
            }
        });
        getContentPane().add(btnlistados, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 90, -1));

        btnusuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1481325574_people.png"))); // NOI18N
        btnusuarios.setText("Usuarios");
        btnusuarios.setToolTipText("Establece los usuarios para el programa");
        btnusuarios.setBorder(null);
        btnusuarios.setBorderPainted(false);
        btnusuarios.setContentAreaFilled(false);
        btnusuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnusuarios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnusuarios.setMaximumSize(new java.awt.Dimension(65, 67));
        btnusuarios.setMinimumSize(new java.awt.Dimension(65, 67));
        btnusuarios.setPreferredSize(new java.awt.Dimension(65, 67));
        btnusuarios.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnusuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnusuariosActionPerformed(evt);
            }
        });
        getContentPane().add(btnusuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 100, 70));

        btnprecios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1481325332_price.png"))); // NOI18N
        btnprecios.setText("Precios");
        btnprecios.setToolTipText("Consulta los precios de determinados productos o de todos");
        btnprecios.setBorder(null);
        btnprecios.setBorderPainted(false);
        btnprecios.setContentAreaFilled(false);
        btnprecios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnprecios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnprecios.setMaximumSize(new java.awt.Dimension(65, 67));
        btnprecios.setMinimumSize(new java.awt.Dimension(65, 67));
        btnprecios.setPreferredSize(new java.awt.Dimension(65, 67));
        btnprecios.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnprecios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpreciosActionPerformed(evt);
            }
        });
        getContentPane().add(btnprecios, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 90, 83));

        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1481325804_exit.png"))); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.setToolTipText("Salir del sistema");
        btnsalir.setBorder(null);
        btnsalir.setBorderPainted(false);
        btnsalir.setContentAreaFilled(false);
        btnsalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnsalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnsalir.setMaximumSize(new java.awt.Dimension(65, 67));
        btnsalir.setMinimumSize(new java.awt.Dimension(65, 67));
        btnsalir.setPreferredSize(new java.awt.Dimension(65, 67));
        btnsalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 350, 90, 70));

        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1481366369_search_find.png"))); // NOI18N
        btnbuscar.setText("Buscar Precio");
        btnbuscar.setToolTipText("Buscar precio producto");
        btnbuscar.setBorder(null);
        btnbuscar.setBorderPainted(false);
        btnbuscar.setContentAreaFilled(false);
        btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnbuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnbuscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 100, 70));

        jLabel2.setFont(new java.awt.Font("Tekton Pro Cond", 0, 60)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Sistema Control de Precios");
        jLabel2.setBorder(new javax.swing.border.MatteBorder(null));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 790, 60));

        btncaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1481659985_cash_register.png"))); // NOI18N
        btncaja.setText("Caja");
        btncaja.setToolTipText("Ingreso de entrada y salida de caja diaria");
        btncaja.setBorder(null);
        btncaja.setBorderPainted(false);
        btncaja.setContentAreaFilled(false);
        btncaja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncaja.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btncaja.setMaximumSize(new java.awt.Dimension(65, 67));
        btncaja.setMinimumSize(new java.awt.Dimension(65, 67));
        btncaja.setPreferredSize(new java.awt.Dimension(65, 67));
        btncaja.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btncaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncajaActionPerformed(evt);
            }
        });
        getContentPane().add(btncaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 80, 70));

        lblserialhdd.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        getContentPane().add(lblserialhdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 70, 20));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logoSistema.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 500, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
       if (JOptionPane.showConfirmDialog(rootPane, "¿Desea realmente salir del sistema?",
                "Salir del sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            System.exit(0);
 
    }//GEN-LAST:event_btnsalirActionPerformed

    private void btncalculadoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncalculadoraActionPerformed
        try        
            {
                Runtime rt = Runtime.getRuntime();           
                Process p = rt.exec("calc");            
                p.waitFor();        
            }        
            catch ( IOException ioe )       
            {            
                ioe.printStackTrace();
            }         
            catch ( InterruptedException ie )
            {            
                ie.printStackTrace();     
            }
    }//GEN-LAST:event_btncalculadoraActionPerformed

    private void btncategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncategoriasActionPerformed
        new frmCategoria().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btncategoriasActionPerformed

    private void btnusuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnusuariosActionPerformed
        new frmUsuarios().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnusuariosActionPerformed

    private void btnpreciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpreciosActionPerformed
        new frmProductos().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnpreciosActionPerformed

    private void btnlistadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlistadosActionPerformed
        new frmInformes().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnlistadosActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        new frmPrecios().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btnrespaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrespaldoActionPerformed
        new frmBackup().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnrespaldoActionPerformed

    private void btncajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncajaActionPerformed
        new frmCaja().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btncajaActionPerformed

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
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        //java.awt.EventQueue.invokeLater(() -> {
            new frmPrincipal().setVisible(true);
        //});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncaja;
    private javax.swing.JButton btncalculadora;
    private javax.swing.JButton btncategorias;
    private javax.swing.JButton btnlistados;
    private javax.swing.JButton btnprecios;
    private javax.swing.JButton btnrespaldo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JButton btnusuarios;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblserialhdd;
    // End of variables declaration//GEN-END:variables
}
