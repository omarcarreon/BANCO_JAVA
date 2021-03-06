package banco;

import java.awt.HeadlessException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * 
 */
public class Empresas extends javax.swing.JFrame {

    /**
     * Creates new form Empresas
     */
    int numcols; // guarda numero de columnas generadas en query
    List <List <String> > res = new ArrayList<>(); // guarda respuesta de query
    int editar = 0; // indica si edita o graba
    
    // Inicializa campos y obtiene empresas
    public Empresas() {
        initComponents();
        getEmpresas();
        jButton1.setVisible(false);
        jButton2.setVisible(false);
    }
    // Funcion para hacer query de obtener empresas existentes
    private void getEmpresas() {
        Database db = new Database();
        ResultSet resultset = null;
        Statement stmt = null;
                
        if (db.connect()) {
            final Connection conn = db.getConnection();
            try {
                stmt = conn.createStatement();
                resultset = stmt.executeQuery("select * from Empresas");
                    
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
            jComboBox1.addItem(res.get(i).get(0));
        }
        jComboBox1.setSelectedIndex(-1);
        jTextField1.setEditable(false);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Empresas");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Empresa"));
        jPanel1.setToolTipText("");

        jComboBox1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1)
                    .addComponent(jComboBox1, 0, 414, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jButton1.setText("Grabar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Cancelar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Nuevo");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton4)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton5))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Salir de pantalla
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed
    // Acciones de cuando selecciona una empres
    private void jComboBox1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox1PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        int selectedindex = jComboBox1.getSelectedIndex();
        if (selectedindex != -1){
            jTextField1.setText(jComboBox1.getSelectedItem().toString());
            editar = 0;
            jTextField1.setEditable(false);
            jButton2.setVisible(true);
            jButton1.setVisible(false);
            
        }
    }//GEN-LAST:event_jComboBox1PopupMenuWillBecomeInvisible
    // acciones de boton editar, permite editar campos
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jTextField1.setEditable(true);
        editar = 1;
        jButton1.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed
    // Funciones para grabar registro en base de datos y editar registro
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int selectedindex = jComboBox1.getSelectedIndex();
        if (!"".equals(jTextField1.getText())){
            if (editar==0 && jTextField1.isEditable()){
                Connection con=null;
                PreparedStatement s;
                String url="jdbc:mysql://localhost:3306/Banco";
                String dbDriver = "com.mysql.jdbc.Driver";
                String user="root";
                String pass="";
                try{
                        Class.forName(dbDriver);
                        con=(Connection) DriverManager.getConnection(url,user,pass);
                        s=con.prepareStatement("insert into Empresas values(?)");
                        s.setString(1,jTextField1.getText());

                        s.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Guardado.");
                        editar = 0;
                        this.dispose();
                }
                catch (SQLException | ClassNotFoundException e) {
                    System.out.println(e);
                }
            }
            else if (editar == 1) {
                try
                {
                  // create the mysql database connection
                  String myDriver = "com.mysql.jdbc.Driver";
                  String myUrl = "jdbc:mysql://localhost:3306/Banco";
                  Class.forName(myDriver);
                    try (Connection conn = DriverManager.getConnection(myUrl, "root", "")) {
                        String idempresa = res.get(selectedindex).get(0);
                        String query = "update Empresas set idEmpresa = ? where idEmpresa = ?";
                        PreparedStatement preparedStmt = conn.prepareStatement(query);
                        preparedStmt.setString(1, jTextField1.getText());
                        preparedStmt.setString(2, idempresa);

                        // execute the preparedstatement
                        preparedStmt.execute();
                    }
                  JOptionPane.showMessageDialog(null, "Editado.");
                  editar = 0;
                  this.dispose();

                }
                catch (ClassNotFoundException | SQLException | HeadlessException e)
                {
                  System.err.println("Got an exception! ");
                  System.err.println(e.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Faltan campos por completar.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    // Acciones de boton cancelar, borra campos
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        jTextField1.setText("");
        jTextField1.setEditable(false);
        editar = 0;
    }//GEN-LAST:event_jButton4ActionPerformed
    // acciones de boton Nuevo
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        jTextField1.setText("");
        jTextField1.setEditable(true);
        
        jButton2.setVisible(false);
        jButton1.setVisible(true);
        editar = 0;
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(Empresas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Empresas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Empresas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Empresas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Empresas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
