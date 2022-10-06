/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Calendar;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Alejandro Pinato
 */
public class frmBackup extends javax.swing.JFrame {
JFileChooser RealizarBackupMySQL=new JFileChooser();
    /**
     * Creates new form frmBackup
     */
    public frmBackup() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
    }

   void GenerarBackupMySQL(){
        int resp;
        Calendar c = Calendar.getInstance();
        String fecha=String.valueOf(c.get(Calendar.DATE));
        fecha=fecha+"-"+String.valueOf(c.get(Calendar.MONTH));
      fecha=fecha+"-"+String.valueOf(c.get(Calendar.YEAR));
      String nombre="Almacen";
      String pass="";
        resp=RealizarBackupMySQL.showSaveDialog(this);//JFileChooser de nombre RealizarBackupMySQL
        if (resp==JFileChooser.APPROVE_OPTION) {//Si el usuario presiona aceptar; se genera el Backup
            try{
                Runtime runtime = Runtime.getRuntime();
                File backupFile = new File(String.valueOf(RealizarBackupMySQL.getSelectedFile().toString())
                        +"_"+fecha+".sql");
                FileWriter fw = new FileWriter(backupFile);
                Process child = runtime.exec("C:\\xampp\\mysql\\bin\\mysqldump --opt --password= --user=root "
                        + "--databases Almacen -R"); 
                InputStreamReader irs = new InputStreamReader(child.getInputStream());
                BufferedReader br = new BufferedReader(irs);

                String line;
                while( (line=br.readLine()) != null ) {
                    fw.write(line + "\n");
                }
                fw.close();
                irs.close();
                br.close();

                
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error no se genero el archivo por el siguiente motivo:"+e.getMessage(), "Verificar",JOptionPane.ERROR_MESSAGE);
            }
            JOptionPane.showMessageDialog(null, "Archivo generado","Verificar",JOptionPane.INFORMATION_MESSAGE);
        } else if (resp==JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null,"Ha sido cancelada la generacion del Backup");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnbackup = new javax.swing.JButton();
        btnvolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnbackup.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        btnbackup.setText("Realizar Respaldo de Almacen");
        btnbackup.setNextFocusableComponent(btnvolver);
        btnbackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackupActionPerformed(evt);
            }
        });
        getContentPane().add(btnbackup, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 67, 271, 55));

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
        getContentPane().add(btnvolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 60, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolverActionPerformed
        new frmPrincipal().setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnvolverActionPerformed

    private void btnbackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackupActionPerformed
        GenerarBackupMySQL();
    }//GEN-LAST:event_btnbackupActionPerformed

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
            java.util.logging.Logger.getLogger(frmBackup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmBackup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmBackup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmBackup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmBackup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbackup;
    private javax.swing.JButton btnvolver;
    // End of variables declaration//GEN-END:variables
}
