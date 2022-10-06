/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import ncMySql.MySql;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Alejandro
 */
public class frmCategoria extends javax.swing.JFrame {

    DefaultTableModel modelo;
    Statement stm;
    Connection conection;
    public frmCategoria() {
        initComponents();
        this.setLocationRelativeTo(null);
        CargarCategoria();
        configTabla();
        btnactualizar.setEnabled(false);
        btneliminar.setEnabled(false);
        btnguardar.setEnabled(false);
        txtdetalle.setEditable(false);
        this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
        
    }
    
    private void configTabla(){
        jtcategorias.setAutoResizeMode(0);
        TableColumnModel columnModel = jtcategorias.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(340);
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        jtcategorias.getColumnModel().getColumn(0).setCellRenderer(tcr);
    }          

    private void CargarCategoria(){
        try {
            conection=MySql.getConection();
            String[] titulos ={"ID Categoría", "Descripción"};
            String sql="SELECT * FROM categorias";
            modelo= new DefaultTableModel(null, titulos);
            stm = conection.createStatement();
            ResultSet rs =stm.executeQuery(sql);
            
            String[] fila = new String[6];
            
            while(rs.next()){
                fila[0]=rs.getString("idcategoria");
                fila[1]=rs.getString("descripcion");
                modelo.addRow(fila);
            }
            jtcategorias.setModel(modelo);
            configTabla();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnvolver = new javax.swing.JButton();
        txtdetalle = new javax.swing.JTextField();
        btneliminar = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtcategorias = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnactualizar = new javax.swing.JButton();
        btnnew = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Categorías de Productos");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnvolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1481329786_restart-1.png"))); // NOI18N
        btnvolver.setText("Volver");
        btnvolver.setToolTipText("Menú Principal");
        btnvolver.setBorder(null);
        btnvolver.setBorderPainted(false);
        btnvolver.setContentAreaFilled(false);
        btnvolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnvolver.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnvolver.setNextFocusableComponent(txtdetalle);
        btnvolver.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnvolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(667, 324, -1, -1));

        txtdetalle.setFont(new java.awt.Font("Tekton Pro", 0, 24)); // NOI18N
        txtdetalle.setNextFocusableComponent(btnguardar);
        getContentPane().add(txtdetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 450, 40));

        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        btneliminar.setText("Eliminar");
        btneliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btneliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btneliminar.setMaximumSize(new java.awt.Dimension(79, 51));
        btneliminar.setMinimumSize(new java.awt.Dimension(79, 51));
        btneliminar.setNextFocusableComponent(btnactualizar);
        btneliminar.setPreferredSize(new java.awt.Dimension(79, 51));
        btneliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 80, -1));

        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnguardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnguardar.setMaximumSize(new java.awt.Dimension(79, 51));
        btnguardar.setMinimumSize(new java.awt.Dimension(79, 51));
        btnguardar.setNextFocusableComponent(btneliminar);
        btnguardar.setPreferredSize(new java.awt.Dimension(79, 51));
        btnguardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 80, -1));

        jLabel1.setFont(new java.awt.Font("Tekton Pro", 0, 24)); // NOI18N
        jLabel1.setText("Descripción");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 130, 40));

        jtcategorias.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtcategorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jtcategorias.setRowMargin(2);
        jtcategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtcategoriasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtcategorias);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 450, 140));

        jLabel2.setFont(new java.awt.Font("Tekton Pro Cond", 0, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Formulario Categorías de Productos");
        jLabel2.setBorder(new javax.swing.border.MatteBorder(null));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 740, 60));

        btnactualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/actualizar.png"))); // NOI18N
        btnactualizar.setText("Actualizar");
        btnactualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnactualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnactualizar.setNextFocusableComponent(btnvolver);
        btnactualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnactualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 150, -1, 50));

        btnnew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevo.png"))); // NOI18N
        btnnew.setText("Nuevo");
        btnnew.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnnew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnnew.setMaximumSize(new java.awt.Dimension(79, 51));
        btnnew.setMinimumSize(new java.awt.Dimension(79, 51));
        btnnew.setPreferredSize(new java.awt.Dimension(79, 51));
        btnnew.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnewActionPerformed(evt);
            }
        });
        getContentPane().add(btnnew, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, -1, -1));

        jButton1.setText("Generar Informe");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolverActionPerformed
        new frmPrincipal().setVisible(true);
        this.dispose();
                
    }//GEN-LAST:event_btnvolverActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        btnguardar.setEnabled(true);
        
        try {
            String sql = "INSERT INTO categorias (descripcion) VALUES (?)";
            PreparedStatement ps =conection.prepareCall(sql);
            ps.setString(1, txtdetalle.getText());
            int n=ps.executeUpdate();
                        
            if(n>0){
                JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
            }
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar, verifique "+e.getMessage());
        }
        CargarCategoria();
        txtdetalle.setText(null);
        txtdetalle.requestFocus();
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
       try {
           int fila=0;
           String sql;
           if (JOptionPane.showConfirmDialog(rootPane, "¿Desea realmente eliminar el registro?",
                "Eliminación Registro", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                fila =jtcategorias.getSelectedRow();
                sql = "DELETE FROM categorias WHERE idcategoria="+jtcategorias.getValueAt(fila, 0);
                stm=conection.createStatement();
                int n = stm.executeUpdate(sql);
                if(n>0){
                    CargarCategoria();
                    JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");
                }
           }
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "ERROR, VERIFIQUE:  "+e.getMessage());
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        try {
            int fila = jtcategorias.getSelectedRow();
            String sql="UPDATE categorias SET descripcion= '"+txtdetalle.getText()+"'WHERE idcategoria='"+jtcategorias.getValueAt(fila, 0)+"'";
            PreparedStatement ps = conection.prepareCall(sql);
            int n= ps.executeUpdate();
            if(n>0){
                CargarCategoria();
                JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
            }
                    
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "ERROR  "+e.getMessage());
        }
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void jtcategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtcategoriasMouseClicked
        btnactualizar.setEnabled(true);
        btneliminar.setEnabled(true);
        btnguardar.setEnabled(false);
        txtdetalle.setEditable(true);
        
        if(evt.getButton()==1){
            int fila = jtcategorias.getSelectedRow();
            try {
                String sql = "SELECT * FROM categorias WHERE idcategoria="+jtcategorias.getValueAt(fila, 0);
                stm=conection.createStatement();
                ResultSet rs= stm.executeQuery(sql);
                rs.next();
                txtdetalle.setText(rs.getString("descripcion"));
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_jtcategoriasMouseClicked

    private void btnnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnewActionPerformed
        btnguardar.setEnabled(true);
        txtdetalle.setEditable(true);
        txtdetalle.requestFocus();
    }//GEN-LAST:event_btnnewActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JasperPrint jasperPrintWindow = null;
        try {
            jasperPrintWindow = JasperFillManager.fillReport(
                    "C:\\Users\\alepinato\\Dropbox\\Almacen\\src\\Informes\\InfoCategorias.jasper", null,
                    MySql.getConection());
        } catch (JRException ex) {
            Logger.getLogger(frmProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
		JasperViewer jasperViewer = new JasperViewer(jasperPrintWindow);
		jasperViewer.setVisible(true);
                                         
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(frmCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCategoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnew;
    private javax.swing.JButton btnvolver;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtcategorias;
    private javax.swing.JTextField txtdetalle;
    // End of variables declaration//GEN-END:variables
}
