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
public class Sucursales extends javax.swing.JFrame {

    /**
     * Creates new form Sucursales
     */
    int numcols; // guarda numero de columnas de query
    List <List <String> > res = new ArrayList<>();// guarda respuesta de query donantes
    List <List <String> > res2 = new ArrayList<>();// guarda respuesta de query sucursales
    int editar = 0;//indica si edita o graba
    // inicializa componentes y llama a funcion para obtener donantes
    public Sucursales() {
        initComponents();
        getDonantes();
        jButton1.setVisible(false);
        jButton2.setVisible(false);
        jButton3.setVisible(false);
        jButton5.setVisible(false);
        jButton6.setVisible(false);
    }
    // Funcion para obtener donantes, llama a la base de datos
    private void getDonantes() {
        Database db = new Database();
        ResultSet resultset = null;
        Statement stmt = null;
                
        if (db.connect()) {
            final Connection conn = db.getConnection();
            try {
                stmt = conn.createStatement();
                resultset = stmt.executeQuery("select * from Donantes");
                    
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
                Logger.getLogger(Sucursales.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (resultset != null){
                    try {
                        resultset.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Sucursales.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (stmt != null){
                    try {
                        stmt.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Sucursales.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
  
        }
        for (int i=0; i< res.size(); i++) {  
            jComboBox1.addItem(res.get(i).get(1));
        }
        jComboBox1.setSelectedIndex(-1);
        jPanel1.setVisible(false);
    }
    // obtiene sucursales
    private void getSucursales() {
        res2 = new ArrayList<>();
         try
            {
              // create the mysql database connection
              String myDriver = "com.mysql.jdbc.Driver";
              String myUrl = "jdbc:mysql://localhost:3306/Banco";
              Class.forName(myDriver);
                try (Connection conn = DriverManager.getConnection(myUrl, "root", "")) {
                    String query = "select * from Sucursales where idDonante = ? ";
                    PreparedStatement preparedStmt = conn.prepareStatement(query);
                    preparedStmt.setString(1,jComboBox1.getSelectedItem().toString());
                    
                    ResultSet resultset2 = preparedStmt.executeQuery();
                    numcols = resultset2.getMetaData().getColumnCount();
               
                while (resultset2.next()) {
                    
                    List <String> row = new ArrayList<>(numcols); 

                    for (int i=1; i<= numcols; i++) {  // don't skip the last column, use <=
                        row.add(resultset2.getString(i));
                        //System.out.print(resultset.getString(i) + "\t");
                    }
                    res2.add(row); // add it to the result
                    //System.out.print("\n");
                }
                
                }
              
            }
            catch (ClassNotFoundException | SQLException | HeadlessException e)
            {
              System.err.println("Got an exception! ");
              System.err.println(e.getMessage());
            }
        for (int i=0; i< res2.size(); i++) {  
            jComboBox2.addItem(res2.get(i).get(1));
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

        jPanel2 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Captura Sucursales");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Donantes"));

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Sucursal"));

        jLabel1.setText("Clave");

        jLabel2.setText("Direccion");

        jLabel3.setText("Colonia");

        jLabel4.setText("Ciudad");

        jLabel5.setText("Estado");

        jLabel6.setText("Teléfono");

        jLabel7.setText("Contacto");

        jLabel8.setText("Fax");

        jLabel9.setText("Mail");

        jLabel10.setText("Nombre");

        jComboBox2.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox2PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel11.setText("Sucursal");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField6)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField2)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField9)
                                            .addComponent(jTextField8)
                                            .addComponent(jTextField5)))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel11))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField10, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jButton1.setText("Borrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Grabar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Salir");
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

        jButton6.setText("Nuevo");
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 5, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // salir de ventana
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed
    // selecciona un donante
    private void jComboBox1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox1PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        int selectedindex = jComboBox1.getSelectedIndex();
        if (selectedindex != -1){
                
            int sucursales = Integer.parseInt(res.get(selectedindex).get(11));
            jComboBox2.removeAllItems();
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField4.setText("");
            jTextField5.setText("");
            jTextField6.setText("");
            jTextField7.setText("");
            jTextField8.setText("");
            jTextField9.setText("");
            jTextField10.setText("");
            if (sucursales == 0){
                JOptionPane.showMessageDialog(null, "No puede tener sucursales.");
                jPanel1.setVisible(false);
                jButton1.setVisible(false);
                jButton2.setVisible(false);
                jButton3.setVisible(false);
                jButton5.setVisible(false);
                jButton6.setVisible(false);
            } else {
                jPanel1.setVisible(true);
                getSucursales();
                jComboBox2.setSelectedIndex(-1);
                jButton3.setVisible(true);
                jButton6.setVisible(true);
                jTextField1.setEnabled(false);
                jTextField2.setEnabled(false);
                jTextField3.setEnabled(false);
                jTextField4.setEnabled(false);
                jTextField5.setEnabled(false);
                jTextField6.setEnabled(false);
                jTextField7.setEnabled(false);
                jTextField8.setEnabled(false);
                jTextField9.setEnabled(false);
                jTextField10.setEnabled(false);
                editar = 0;
            }
            
        }
        
    }//GEN-LAST:event_jComboBox1PopupMenuWillBecomeInvisible

    private void jComboBox1PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox1PopupMenuWillBecomeVisible
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1PopupMenuWillBecomeVisible
    // graba o edita una sucursal
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int selectedindex = jComboBox1.getSelectedIndex();
        if (!"".equals(jTextField1.getText()) && !"".equals(jTextField2.getText()) && !"".equals(jTextField3.getText())
                && !"".equals(jTextField4.getText()) && !"".equals(jTextField5.getText()) && !"".equals(jTextField6.getText())
                && !"".equals(jTextField7.getText()) && !"".equals(jTextField9.getText())
                && !"".equals(jTextField10.getText())){
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
                        s=con.prepareStatement("insert into Sucursales values(?,?,?,?,?,?,?,?,?,?,?)");
                        s.setString(1,jTextField1.getText());
                        s.setString(2,jTextField10.getText());
                        s.setString(3,jComboBox1.getSelectedItem().toString());
                        s.setString(4,jTextField2.getText());
                        s.setString(5,jTextField3.getText());
                        s.setString(6,jTextField4.getText());
                        s.setString(7,jTextField5.getText());
                        s.setString(8,jTextField6.getText());
                        s.setString(9,jTextField8.getText());
                        s.setString(10,jTextField7.getText());
                        s.setString(11,jTextField9.getText());


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
                        String query = "update Sucursales set idSucursales = ? , Sucursal = ? , idDonante = ? , Direccion = ? , Colonia = ? , Ciudad = ? , Estado = ? , Telefono = ? , Fax = ? , Contacto = ? , Mail = ? where idSucursales = ?";
                        PreparedStatement preparedStmt = conn.prepareStatement(query);
                        preparedStmt.setString(1,jTextField1.getText());
                        preparedStmt.setString(2,jTextField10.getText());
                        preparedStmt.setString(3,jComboBox1.getSelectedItem().toString());
                        preparedStmt.setString(4,jTextField2.getText());
                        preparedStmt.setString(5,jTextField3.getText());
                        preparedStmt.setString(6,jTextField4.getText());
                        preparedStmt.setString(7,jTextField5.getText());
                        preparedStmt.setString(8,jTextField6.getText());
                        preparedStmt.setString(9,jTextField8.getText());
                        preparedStmt.setString(10,jTextField7.getText());
                        preparedStmt.setString(11,jTextField9.getText());
                        preparedStmt.setString(12,jTextField1.getText());

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
    }//GEN-LAST:event_jButton2ActionPerformed
    // boton nuevo, limpia campos
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
        jTextField8.setText("");
        jTextField9.setText("");
        jTextField10.setText("");

        jTextField1.setEnabled(true);
        jTextField2.setEnabled(true);
        jTextField3.setEnabled(true);
        jTextField4.setEnabled(true);
        jTextField5.setEnabled(true);
        jTextField6.setEnabled(true);
        jTextField7.setEnabled(true);
        jTextField8.setEnabled(true);
        jTextField9.setEnabled(true);
        jTextField10.setEnabled(true);
        
        jButton1.setVisible(false);
        jButton5.setVisible(false);
        jButton2.setVisible(true);
        editar = 0;
    }//GEN-LAST:event_jButton6ActionPerformed
    // boton editar, permite editar campos
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        jTextField1.setEnabled(true);
        jTextField2.setEnabled(true);
        jTextField3.setEnabled(true);
        jTextField4.setEnabled(true);
        jTextField5.setEnabled(true);
        jTextField6.setEnabled(true);
        jTextField7.setEnabled(true);
        jTextField8.setEnabled(true);
        jTextField9.setEnabled(true);
        jTextField10.setEnabled(true);
        editar = 1;
        jButton2.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed
    // borra un registro de sucursal
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int selectedindex = jComboBox2.getSelectedIndex();
        if (selectedindex != -1){
            try
            {
              // create the mysql database connection
              String myDriver = "com.mysql.jdbc.Driver";
              String myUrl = "jdbc:mysql://localhost:3306/Banco";
              Class.forName(myDriver);
                try (Connection conn = DriverManager.getConnection(myUrl, "root", "")) {
                    selectedindex = jComboBox2.getSelectedIndex();
                    String idsucursal = res2.get(selectedindex).get(0);
                    String query = "delete from Sucursales where idSucursales = ?";
                    PreparedStatement preparedStmt = conn.prepareStatement(query);
                    preparedStmt.setString(1, idsucursal);
                    // execute the preparedstatement
                    preparedStmt.execute();
                }
                JOptionPane.showMessageDialog(null, "Borrado.");
                jTextField1.setText("");
                jTextField2.setText("");
                jTextField3.setText("");
                jTextField4.setText("");
                jTextField5.setText("");
                jTextField6.setText("");
                jTextField7.setText("");
                jTextField8.setText("");
                jTextField9.setText("");
                jTextField10.setText("");

                jTextField1.setEnabled(false);
                jTextField2.setEnabled(false);
                jTextField3.setEnabled(false);
                jTextField4.setEnabled(false);
                jTextField5.setEnabled(false);
                jTextField6.setEnabled(false);
                jTextField7.setEnabled(false);
                jTextField8.setEnabled(false);
                jTextField9.setEnabled(false);
                jTextField10.setEnabled(false);

                this.dispose();
                editar = 0;
            }
            catch (ClassNotFoundException | SQLException | HeadlessException e)
            {
              System.err.println("Got an exception! ");
              System.err.println(e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una sucursal válida.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    // boton cancelar,limpia campos
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
        jTextField8.setText("");
        jTextField9.setText("");
        jTextField10.setText("");
        
        jTextField1.setEnabled(false);
        jTextField2.setEnabled(false);
        jTextField3.setEnabled(false);
        jTextField4.setEnabled(false);
        jTextField5.setEnabled(false);
        jTextField6.setEnabled(false);
        jTextField7.setEnabled(false);
        jTextField8.setEnabled(false);
        jTextField9.setEnabled(false);
        jTextField10.setEnabled(false);
        
        editar = 0;
    }//GEN-LAST:event_jButton3ActionPerformed
    // selecciona una sucursal
    private void jComboBox2PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox2PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        int selectedindex = jComboBox2.getSelectedIndex();
        if (selectedindex != -1){
            jTextField1.setText(res2.get(selectedindex).get(0));
            jTextField2.setText(res2.get(selectedindex).get(3));
            jTextField3.setText(res2.get(selectedindex).get(4));
            jTextField4.setText(res2.get(selectedindex).get(5));
            jTextField5.setText(res2.get(selectedindex).get(6));
            jTextField6.setText(res2.get(selectedindex).get(7));
            jTextField7.setText(res2.get(selectedindex).get(9));
            jTextField8.setText(res2.get(selectedindex).get(8));
            jTextField9.setText(res2.get(selectedindex).get(10));
            jTextField10.setText(jComboBox2.getSelectedItem().toString());
            editar = 0;
            jTextField1.setEnabled(false);
            jTextField2.setEnabled(false);
            jTextField3.setEnabled(false);
            jTextField4.setEnabled(false);
            jTextField5.setEnabled(false);
            jTextField6.setEnabled(false);
            jTextField7.setEnabled(false);
            jTextField8.setEnabled(false);
            jTextField9.setEnabled(false);
            jTextField10.setEnabled(false);
            jButton5.setVisible(true);
            jButton1.setVisible(true);
            jButton2.setVisible(false);
        }
        
    }//GEN-LAST:event_jComboBox2PopupMenuWillBecomeInvisible

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
            java.util.logging.Logger.getLogger(Sucursales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sucursales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sucursales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sucursales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sucursales().setVisible(true);
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
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
