/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package banco;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.*;

/**
 *
 * @author diegoaleman
 */
public class AccesoUsuarios extends javax.swing.JFrame {

    /**
     * Creates new form AccesoUsuarios
     */
    int numcols; // Indica numero de columnas generadas en el query de select
    List <List <String> > res = new ArrayList<>(); // ArrayList para guardar los usuarios
    int editar = 0; // indica si está editando o grabando
    public AccesoUsuarios() {
        initComponents();
        getNivelesAcceso(); // obtiene accesos de usuarios
    }
    // funcion para obtener niveles de acceso e inicializar campos
    private void getNivelesAcceso() {
        Database db = new Database();
        ResultSet resultset = null;
        Statement stmt = null;
        // si la conexión a la base de datos es exitosa, se hace query select
        
        if (db.connect()) {
            final Connection conn = db.getConnection();
            try {
                stmt = conn.createStatement();
                resultset = stmt.executeQuery("select * from Nivel_Acceso");
                    
                numcols = resultset.getMetaData().getColumnCount();
                

                while (resultset.next()) {
                    List <String> row = new ArrayList<>(numcols); 

                    for (int i=1; i<= numcols; i++) {  // don't skip the last column, use <=
                        row.add(resultset.getString(i));
                        //System.out.print(resultset.getString(i) + "\t");
                    }
                    res.add(row); // add it to the result
                    //System.out.print("\n");
                }

            } catch (SQLException ex) {
                Logger.getLogger(Nivel_Acceso.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (resultset != null){
                    try {
                        resultset.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Nivel_Acceso.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (stmt != null){
                    try {
                        stmt.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Nivel_Acceso.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
  
        }
        for (int i=0; i< res.size(); i++) {  
            jComboBox2.addItem(res.get(i).get(1));
        }
        jComboBox2.setSelectedIndex(-1);
        
    }
    // Obtiene todos los formularios
    private void getFormularios() {
        Database db = new Database();
        ResultSet resultset2 = null;
        Statement stmt2 = null;
        List <List <String> > res2 = new ArrayList<>();

        int numcols2 = 0;       
        if (db.connect()) {
            final Connection conn = db.getConnection();
            try {
                stmt2 = conn.createStatement();
                resultset2 = stmt2.executeQuery("select * from Formularios");
                    
                numcols2 = resultset2.getMetaData().getColumnCount();

                while (resultset2.next()) {
                    List <String> row = new ArrayList<>(numcols2); 

                    for (int i=1; i<= numcols2; i++) {  // don't skip the last column, use <=
                        row.add(resultset2.getString(i));
                        //System.out.print(resultset.getString(i) + "\t");
                    }
                    res2.add(row); // add it to the result
                    //System.out.print("\n");
                }

            } catch (SQLException ex) {
                Logger.getLogger(Formularios.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (resultset2 != null){
                    try {
                        resultset2.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Formularios.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (stmt2 != null){
                    try {
                        stmt2.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Formularios.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
  
        }
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        for (int i=0; i< res2.size(); i++) { 
            String id = res2.get(i).get(0);
            String n = res2.get(i).get(1);
            
            model.insertRow(jTable1.getRowCount(), new Object[] {id,n});
        }
    }
    // Obtiene todos los menus existentes
    private void getMenus() {
        Database db = new Database();
        ResultSet resultset2 = null;
        Statement stmt2 = null;
        List <List <String> > res2 = new ArrayList<>();

        int numcols2 = 0;       
        if (db.connect()) {
            final Connection conn = db.getConnection();
            try {
                stmt2 = conn.createStatement();
                resultset2 = stmt2.executeQuery("select * from Menus");
                    
                numcols2 = resultset2.getMetaData().getColumnCount();

                while (resultset2.next()) {
                    List <String> row = new ArrayList<>(numcols2); 

                    for (int i=1; i<= numcols2; i++) {  // don't skip the last column, use <=
                        row.add(resultset2.getString(i));
                        //System.out.print(resultset.getString(i) + "\t");
                    }
                    res2.add(row); // add it to the result
                    //System.out.print("\n");
                }

            } catch (SQLException ex) {
                Logger.getLogger(Formularios.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (resultset2 != null){
                    try {
                        resultset2.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Formularios.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (stmt2 != null){
                    try {
                        stmt2.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Formularios.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
  
        }
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        for (int i=0; i< res2.size(); i++) { 
            String id = res2.get(i).get(0);
            String n = res2.get(i).get(1);
            
            model.insertRow(jTable1.getRowCount(), new Object[] {id,n});
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Acceso a Usuarios");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Formulario", "Formulario", "Nuevo", "Editar", "Borrar", "Grabar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Formularios", "Menús" }));
        jComboBox1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jComboBox2.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox2PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Acceso");

        jLabel2.setText(" Nivel de Usuario");

        jButton1.setText("Grabar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Cierra ventana al presionar boton Salir
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox2PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox2PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2PopupMenuWillBecomeInvisible

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed
    // Funcion de acciones cuando opcion del combobox acceso es seleccionado
    private void jComboBox1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox1PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        JTableHeader th = jTable1.getTableHeader();
        if (jComboBox1.getSelectedIndex() == 1) { // Si selecciona formularios
            TableColumnModel tcm = th.getColumnModel();
            TableColumn tc1 = tcm.getColumn(0);
            TableColumn tc2 = tcm.getColumn(1);
            tc1.setHeaderValue( "ID Formulario" );
            tc2.setHeaderValue( "Formulario" );
            th.repaint();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            getFormularios();
        } else if (jComboBox1.getSelectedIndex() == 2) { // si selecciona menu
            TableColumnModel tcm = th.getColumnModel();
            TableColumn tc1 = tcm.getColumn(0);
            TableColumn tc2 = tcm.getColumn(1);
            tc1.setHeaderValue( "ID Menú" );
            tc2.setHeaderValue( "Menú" );
            th.repaint();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            getMenus();
        }
    }//GEN-LAST:event_jComboBox1PopupMenuWillBecomeInvisible

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(AccesoUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccesoUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccesoUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccesoUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccesoUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
