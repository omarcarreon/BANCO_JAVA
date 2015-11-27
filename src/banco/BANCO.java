/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package banco;

import java.sql.*;
/**
 *
 * @author omarcarreon
 */
public class BANCO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        /*Connection conn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        
        String user= "root";
        String pass = "";
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Banco", user, pass);
            myStmt = conn.createStatement();
            myRs = myStmt.executeQuery("select * from GrupoAlim");
            while (myRs.next()){
                System.out.println(myRs.getString("GrupoAlim"));
            }
        } catch (Exception exc){
            exc.printStackTrace();
            
        }
                */
       new Captura_Proveedores().setVisible(true);
       
    }    
}
