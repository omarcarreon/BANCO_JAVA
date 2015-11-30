/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package banco;

import java.awt.HeadlessException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * 
 */
public class Nivel_Acceso extends javax.swing.JFrame {

    /**
     * Creates new form Nivel_Acceso
     */
    int numcols; // guarda numero de columnas de query
    List <List <String> > res = new ArrayList<>(); // guarda respuesta de query
    int editar = 0; // edita o graba registro
    // inicializa componentes y llama funcion para obtener niveles de acceso
    public Nivel_Acceso() {
        initComponents();
        getNivelesAcceso();
        jButton2.setVisible(false);
        jButton3.setVisible(false);
        jButton5.setVisible(false);
    }
    // Funcion para hacer query y obtener todos los niveles de acceso
    private void getNivelesAcceso() {
        Database db = new Database();
        ResultSet resultset = null;
        Statement stmt = null;
                
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
            jComboBox1.addItem(res.get(i).get(1));
        }
        jComboBox1.setSelectedIndex(-1);
        jTextField1.setEditable(false);
        jTextField2.setEditable(false);
        
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nivel de Acceso");

        jLabel1.setText("Descripción");

        jLabel2.setText("Nivel");

        jLabel3.setText("Descripción");

        jComboBox1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox1PopupMenuWillBecomeVisible(evt);
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton1.setText("Nuevo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Borrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Grabar");
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

        jButton5.setText("Editar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Salir");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                            .addComponent(jTextField2))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton1)
                    .addComponent(jButton6)
                    .addComponent(jButton2)
                    .addComponent(jButton5))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // borra un registro de nivel de acceso
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try
        {
          // create the mysql database connection
          String myDriver = "com.mysql.jdbc.Driver";
          String myUrl = "jdbc:mysql://localhost:3306/Banco";
          Class.forName(myDriver);
          int selectedindex;
            try (Connection conn = DriverManager.getConnection(myUrl, "root", "")) {
                selectedindex = jComboBox1.getSelectedIndex();
                String idnivel = res.get(selectedindex).get(0);
                String query = "delete from Nivel_Acceso where idNivel = ?";
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString(1, idnivel);
                // execute the preparedstatement
                preparedStmt.execute();
            }
          JOptionPane.showMessageDialog(null, "Borrado.");
          jTextField1.setText("");
          jTextField2.setText("");
          jTextField1.setEditable(false);
          jTextField2.setEditable(false);
          jComboBox1.setSelectedIndex(-1);
          jComboBox1.removeItemAt(selectedindex);
          editar = 0;


        }
        catch (ClassNotFoundException | SQLException | HeadlessException e)
        {
          System.err.println("Got an exception! ");
          System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    // Boton guardar, permite guardar en base de datos o editar un registro
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int selectedindex = jComboBox1.getSelectedIndex();
        if (!"".equals(jTextField1.getText()) && !"".equals(jTextField2.getText())){
            if (editar==0 && jTextField1.isEditable() && jTextField2.isEditable()){
                Connection con=null;
                PreparedStatement s;
                String url="jdbc:mysql://localhost:3306/Banco";
                String dbDriver = "com.mysql.jdbc.Driver";
                String user="root";
                String pass="";
                try{
                        Class.forName(dbDriver);
                        con=(Connection) DriverManager.getConnection(url,user,pass);
                        s=con.prepareStatement("insert into Nivel_Acceso values(?,?)");
                        s.setString(1,jTextField1.getText());
                        s.setString(2,jTextField2.getText());


                        s.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Guardado.");
                        editar = 0;
                        this.dispose();
                }
                catch (SQLException | ClassNotFoundException e) {
                    System.out.println(e);
                      }
            } else if (editar == 1){
                try
                {
                  // create the mysql database connection
                  String myDriver = "com.mysql.jdbc.Driver";
                  String myUrl = "jdbc:mysql://localhost:3306/Banco";
                  Class.forName(myDriver);
                    try (Connection conn = DriverManager.getConnection(myUrl, "root", "")) {
                        String idnivel = res.get(selectedindex).get(0);
                        String query = "update Nivel_Acceso set idNivel = ? , Nivel = ? where idNivel = ?";
                        PreparedStatement preparedStmt = conn.prepareStatement(query);
                        preparedStmt.setString(1, jTextField1.getText());
                        preparedStmt.setString(2, jTextField2.getText());
                        preparedStmt.setString(3, idnivel);

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
        }
        else 
        {
            JOptionPane.showMessageDialog(null, "Faltan campos por completar.");
        }
    }//GEN-LAST:event_jButton3ActionPerformed
    // Boton Editar, permite editar campos
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        jTextField1.setEditable(true);
        jTextField2.setEditable(true);
        editar = 1;
        jButton3.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed
    // Salir de ventana
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox1PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        int selectedindex = jComboBox1.getSelectedIndex();
        if (selectedindex != -1){
            jTextField1.setText(res.get(selectedindex).get(0));
            jTextField2.setText(jComboBox1.getSelectedItem().toString());
            jTextField1.setEditable(false);
            jTextField2.setEditable(false);
            editar = 0;
            jButton2.setVisible(true);
            jButton3.setVisible(false);
            jButton5.setVisible(true);
        }
    }//GEN-LAST:event_jComboBox1PopupMenuWillBecomeInvisible

    private void jComboBox1PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox1PopupMenuWillBecomeVisible
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1PopupMenuWillBecomeVisible
    // Acciones para boton de Nuevo, limpia campos y permite escribir en ellos
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField1.setEditable(true);
        jTextField2.setEditable(true);
        
        jButton2.setVisible(false);
        jButton5.setVisible(false);
        jButton3.setVisible(true);
        editar = 0;
    }//GEN-LAST:event_jButton1ActionPerformed
    // Boton cancelar, pone en blanco los campos
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField1.setEditable(false);
        jTextField2.setEditable(false);
        editar = 0;
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Nivel_Acceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Nivel_Acceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Nivel_Acceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Nivel_Acceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Nivel_Acceso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
