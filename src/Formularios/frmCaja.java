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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import ncMySql.MySql;

/**
 *
 * @author Alejandro Pinato
 */
public class frmCaja extends javax.swing.JFrame {

    DefaultTableModel modelo;
    Statement stm;
    Connection conection;
    String vtipo;
    public frmCaja() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        CargarCaja();
        configTabla();
        Bloquear();
        this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
    }
    private void configTabla(){
        jtcaja.setAutoResizeMode(0);
        TableColumnModel columnModel = jtcaja.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(50);
        columnModel.getColumn(2).setPreferredWidth(500);
        columnModel.getColumn(3).setPreferredWidth(100);
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        jtcaja.getColumnModel().getColumn(1).setCellRenderer(tcr);
    }          
    
    private void Habilitar(){
        txtdetalle.setEnabled(true);
        txtimporte.setEnabled(true);
        cmbtipo.setEnabled(true);
        jcalendario.setEnabled(true);
    }
    
    private void Bloquear(){
        txtdetalle.setEnabled(false);
        txtimporte.setEnabled(false);
        cmbtipo.setEnabled(false);
        jcalendario.setEnabled(false);
        btnguardar.setEnabled(false);
    }
    private void CargarCaja(){
         try {
            conection=MySql.getConection();
            String[] titulos ={"Fecha", "Tipo", "Detalle","Importe"};
            String sql="SELECT * FROM caja";
            modelo= new DefaultTableModel(null, titulos);
            stm = conection.createStatement();
            ResultSet rs =stm.executeQuery(sql);
            
            String[] fila = new String[4];
            
            while(rs.next()){
                fila[0]=rs.getString("fecha");
                fila[1]=rs.getString("tipo");
                fila[2]=rs.getString("detalle");
                fila[3]=rs.getString("importe");
                modelo.addRow(fila);
            }
            jtcaja.setModel(modelo);
            configTabla();
            
        } catch (Exception e) {
        }
     
    }

    public static String convertTostring(Date Date){
            DateFormat df;
            String fech = null;
            df = new SimpleDateFormat("yyyy-MM-d");
            fech = df.format(Date);
            return fech;
        }
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnguardar = new javax.swing.JButton();
        txtdetalle = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jcalendario = new com.toedter.calendar.JDateChooser();
        btnvolver = new javax.swing.JButton();
        cmbtipo = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtimporte = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtcaja = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tekton Pro Cond", 0, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Formulario Caja Diaria");
        jLabel2.setBorder(new javax.swing.border.MatteBorder(null));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 880, 60));

        jLabel1.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        jLabel1.setText("Fecha");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 50, 30));

        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        btnguardar.setText("Confirmar");
        btnguardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnguardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 450, -1, -1));

        txtdetalle.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        txtdetalle.setNextFocusableComponent(btnguardar);
        getContentPane().add(txtdetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 660, 35));

        jLabel3.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        jLabel3.setText("Detalle:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 60, -1));

        jcalendario.setDateFormatString("dd-MM-yyyy");
        jcalendario.setFont(new java.awt.Font("Tekton Pro", 0, 14)); // NOI18N
        jcalendario.setNextFocusableComponent(cmbtipo);
        jcalendario.setOpaque(false);
        getContentPane().add(jcalendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 169, 30));

        btnvolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1481329786_restart-1.png"))); // NOI18N
        btnvolver.setText("Volver");
        btnvolver.setToolTipText("Menú Principal");
        btnvolver.setBorder(null);
        btnvolver.setBorderPainted(false);
        btnvolver.setContentAreaFilled(false);
        btnvolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnvolver.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnvolver.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnvolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 440, -1, -1));

        cmbtipo.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        cmbtipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "Entrada", "Salida" }));
        cmbtipo.setNextFocusableComponent(txtimporte);
        cmbtipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbtipoActionPerformed(evt);
            }
        });
        getContentPane().add(cmbtipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(464, 90, 130, 30));

        jLabel4.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        jLabel4.setText("Tipo:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(401, 93, 60, -1));

        jLabel5.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        jLabel5.setText("Importe");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 70, -1));

        txtimporte.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        txtimporte.setNextFocusableComponent(txtdetalle);
        txtimporte.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtimporteFocusLost(evt);
            }
        });
        getContentPane().add(txtimporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 136, 170, 34));

        jScrollPane1.setBorder(null);

        jtcaja.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtcaja.setModel(new javax.swing.table.DefaultTableModel(
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
        jtcaja.setFocusTraversalPolicyProvider(true);
        jtcaja.setRequestFocusEnabled(false);
        jScrollPane1.setViewportView(jtcaja);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 240, 820, 180));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevo.png"))); // NOI18N
        jButton1.setText("Nuevo");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setMaximumSize(new java.awt.Dimension(79, 51));
        jButton1.setMinimumSize(new java.awt.Dimension(79, 51));
        jButton1.setPreferredSize(new java.awt.Dimension(79, 51));
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 450, -1, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconfinder_cash_register_17219(1).png"))); // NOI18N
        jButton3.setText("Consulta Caja");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 430, 100, 80));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolverActionPerformed
        new frmPrincipal().setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnvolverActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        btnguardar.setEnabled(true);
        if(cmbtipo.getSelectedItem()=="Entrada"){
            vtipo = "E";
        }else if(cmbtipo.getSelectedItem()=="Salida")
            vtipo = "S";           
        try {
            String sql = "INSERT INTO caja (fecha, tipo, detalle, importe) VALUES (?,?,?,?)";
            PreparedStatement ps =conection.prepareCall(sql);
            ps.setString(1, convertTostring(jcalendario.getDate()));
            ps.setString(2, vtipo);
            ps.setString(3, txtdetalle.getText());
            ps.setFloat(4, Float.parseFloat(txtimporte.getText()));
            int n=ps.executeUpdate();
                        
            if(n>0){
                JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
            }
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar, verifique "+e.getMessage());
        }
        CargarCaja();
        txtdetalle.setText(null);
        txtdetalle.requestFocus();
    }//GEN-LAST:event_btnguardarActionPerformed

    private void txtimporteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtimporteFocusLost
        if(cmbtipo.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "Seleccione un tipo: ENTRADA O SALIDA");
            cmbtipo.requestFocus();
        }
    }//GEN-LAST:event_txtimporteFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Habilitar();
        jcalendario.requestFocus();
        btnguardar.setEnabled(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmbtipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbtipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbtipoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new frmInfoCaja().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    
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
            java.util.logging.Logger.getLogger(frmCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCaja().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnvolver;
    private javax.swing.JComboBox cmbtipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jcalendario;
    private javax.swing.JTable jtcaja;
    private javax.swing.JTextField txtdetalle;
    private javax.swing.JTextField txtimporte;
    // End of variables declaration//GEN-END:variables
}
