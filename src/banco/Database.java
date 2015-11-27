/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;
import java.sql.*;
class Database {
    private String dbUri = "jdbc:mysql://";
    private String dbDriver = "com.mysql.jdbc.Driver";
    private Connection connection;

    public boolean connect()  {
       try {
            Class.forName(dbDriver);
            String uri = dbUri + "localhost:3306" + '/' + "Banco";
            connection = DriverManager.getConnection(uri, "root", "");
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
            // Could not find the database driver
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
            // Could not connect to the database
        }
    }

    public Connection getConnection() {
        return connection;
    }
    
}
