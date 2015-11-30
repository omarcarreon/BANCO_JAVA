/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * 
 */
public class connect {
    Connection conn = null;
    public Connection conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/BANCO","root","");
            System.out.println("conexion establecida");
            JOptionPane.showMessageDialog(null,"conexion establecida");
        } catch(ClassNotFoundException | SQLException e){
            System.out.println("error de conexion");
            JOptionPane.showMessageDialog(null,"conexion establecida"+ e);
        }
        return conn;
    }
    
}
