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
public class frmProductos extends javax.swing.JFrame {

    DefaultTableModel modelo;
    Statement stm;
    Connection conection;
    public frmProductos() {
        initComponents();
        this.setLocationRelativeTo(null);
        CargarCategoria();
        CargarProductos();
        configTabla();
        this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
        txtdescripcion.setEditable(false);
        txtpreciocosto.setEditable(false);
        txtprecioventa.setEditable(false);
        btnactualizar.setEnabled(false);
        btnguardar.setEnabled(false);
    }
    
    private void Limpiar(){
        txtdescripcion.setText(null);
        txtpreciocosto.setText(null);
        txtprecioventa.setText(null);
        txtdescripcion.requestFocus();
    }
    private void Habilitar(){
        txtdescripcion.setEditable(true);
        txtpreciocosto.setEditable(true);
        txtprecioventa.setEditable(true);
        txtdescripcion.requestFocus();
    }
    private void configTabla(){
        jtproductos.setAutoResizeMode(0);
        TableColumnModel columnModel = jtproductos.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(400);
        columnModel.getColumn(2).setPreferredWidth(100);
        columnModel.getColumn(3).setPreferredWidth(100);
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        jtproductos.getColumnModel().getColumn(0).setCellRenderer(tcr);
        jtproductos.getColumnModel().getColumn(2).setCellRenderer(tcr);
        jtproductos.getColumnModel().getColumn(3).setCellRenderer(tcr);
    }
    
    
    
    private int BuscoIDCategoria(String nombre){
        int idcategoria=0;
        try {
             String sql = "SELECT idcategoria FROM categorias WHERE descripcion='"+nombre+"'";
            stm = conection.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            rs.next();
            idcategoria =rs.getInt("idcategoria");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return idcategoria;
    }
    
    private void CargarProductos(){
        jtproductos.setAutoResizeMode(0);
        
        
        try {
            conection=MySql.getConection();
            String[] titulos ={"ID Producto", "Descripción", "Precio Costo","Precio Venta"};
            String sql="SELECT * FROM producto";
            modelo= new DefaultTableModel(null, titulos);
            stm = conection.createStatement();
            ResultSet rs =stm.executeQuery(sql);
            
            String[] fila = new String[5];
            
            while(rs.next()){
                fila[0]=rs.getString("idproducto");
                fila[1]=rs.getString("descripcion");
                fila[2]=rs.getString("preciocosto");
                fila[3]=rs.getString("precioventa");
                fila[4]=rs.getString("categoria");
                modelo.addRow(fila);
            }
            jtproductos.setModel(modelo);
            configTabla();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }   
    void CargarCategoria(){
        try {
            conection=MySql.getConection();
            String sql = "SELECT * FROM categorias";
            stm = conection.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                rs.getString("descripcion");
                cmbcategoria.addItem(rs.getString("descripcion"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnsalir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtpreciocosto = new javax.swing.JTextField();
        txtprecioventa = new javax.swing.JTextField();
        txtdescripcion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnguardar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        cmbcategoria = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtproductos = new javax.swing.JTable();
        btnnew = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1481329786_restart-1.png"))); // NOI18N
        btnsalir.setText("Volver");
        btnsalir.setToolTipText("Menú Principal");
        btnsalir.setBorder(null);
        btnsalir.setBorderPainted(false);
        btnsalir.setContentAreaFilled(false);
        btnsalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnsalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnsalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 480, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tekton Pro Cond", 0, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Formulario  de Productos");
        jLabel2.setBorder(new javax.swing.border.MatteBorder(null));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 540, 60));

        txtpreciocosto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtpreciocosto.setNextFocusableComponent(txtprecioventa);
        getContentPane().add(txtpreciocosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 190, 40));

        txtprecioventa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtprecioventa.setNextFocusableComponent(cmbcategoria);
        getContentPane().add(txtprecioventa, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 190, 40));

        txtdescripcion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtdescripcion.setNextFocusableComponent(txtpreciocosto);
        getContentPane().add(txtdescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 440, 40));

        jLabel1.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        jLabel1.setText("Precio Costo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 130, 40));

        jLabel3.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        jLabel3.setText("Categoría");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 130, 40));

        jLabel4.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        jLabel4.setText("Descripción");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 130, 40));

        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnguardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnguardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnguardar.setNextFocusableComponent(btnactualizar);
        btnguardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 260, 70, 60));

        btnactualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/actualizar.png"))); // NOI18N
        btnactualizar.setText("Actualizar");
        btnactualizar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnactualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnactualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnactualizar.setNextFocusableComponent(btnsalir);
        btnactualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnactualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 260, 70, 60));

        cmbcategoria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbcategoria.setNextFocusableComponent(btnguardar);
        getContentPane().add(cmbcategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 200, 40));

        jLabel5.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        jLabel5.setText("Precio Venta");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 130, 40));

        jtproductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtproductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtproductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtproductos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 730, 130));

        btnnew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevo.png"))); // NOI18N
        btnnew.setText("Nuevo");
        btnnew.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnnew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnnew.setMaximumSize(new java.awt.Dimension(43, 47));
        btnnew.setMinimumSize(new java.awt.Dimension(43, 47));
        btnnew.setPreferredSize(new java.awt.Dimension(43, 47));
        btnnew.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnewActionPerformed(evt);
            }
        });
        getContentPane().add(btnnew, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, 70, 60));

        jButton1.setText("Cargar Informe");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        new frmPrincipal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        try {
            String sql = "INSERT INTO productoo (descripcion,preciocosto, precioventa,categoria) VALUES (?,?,?,?)";
            PreparedStatement ps =conection.prepareCall(sql);
            ps.setString(1, txtdescripcion.getText());
            ps.setFloat(2, Float.parseFloat(txtpreciocosto.getText()));
            ps.setFloat(3, Float.parseFloat(txtprecioventa.getText()));
            ps.setInt(4, BuscoIDCategoria(cmbcategoria.getSelectedItem().toString()));
            int n=ps.executeUpdate();

            if(n>0){
                JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
            }
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar, verifique "+e.getMessage());
        }
        CargarProductos();
        Limpiar();
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        try {
           int fila;
           String sql;
           
           if (JOptionPane.showConfirmDialog(rootPane, "¿Desea actualizar los datos del registro?",
                "Registro actualizado", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                    fila =jtproductos.getSelectedRow();
                    sql="UPDATE producto SET descripcion='"+txtdescripcion.getText()+"',preciocosto='"+txtpreciocosto.getText()+
                        "',precioventa='"+txtprecioventa.getText()+
                        "'WHERE idproducto='"+jtproductos.getValueAt(fila, 0)+"'";
                    PreparedStatement ps = conection.prepareCall(sql);
                    int n= ps.executeUpdate();
                if(n>0){
                    CargarProductos();
                    JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
                }
            }    
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "ERROR  "+e.getMessage());
        }
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void jtproductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtproductosMouseClicked
        Habilitar();
        btnactualizar.setEnabled(true);
        btnguardar.setEnabled(false);
        if(evt.getButton()==1){
            int fila = jtproductos.getSelectedRow();
            try {
                String sql = "SELECT * FROM producto WHERE idproducto="+jtproductos.getValueAt(fila, 0);
                stm=conection.createStatement();
                ResultSet rs= stm.executeQuery(sql);
                rs.next();
                txtdescripcion.setText(rs.getString("descripcion"));
                txtpreciocosto.setText(rs.getString("preciocosto"));
                txtprecioventa.setText(rs.getString("precioventa"));
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_jtproductosMouseClicked

    private void btnnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnewActionPerformed
            txtdescripcion.setText(null);
            txtpreciocosto.setText(null);
            txtprecioventa.setText(null);
            Habilitar();
            btnguardar.setEnabled(true);
    }//GEN-LAST:event_btnnewActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JasperPrint jasperPrintWindow = null;
        try {
            jasperPrintWindow = JasperFillManager.fillReport(
                    "C:\\Users\\alepinato\\Dropbox\\Almacen\\src\\Informes\\ListadoProductos.jasper", null,
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
            java.util.logging.Logger.getLogger(frmProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnew;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox cmbcategoria;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtproductos;
    private javax.swing.JTextField txtdescripcion;
    private javax.swing.JTextField txtpreciocosto;
    private javax.swing.JTextField txtprecioventa;
    // End of variables declaration//GEN-END:variables
}
