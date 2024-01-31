/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daofuncionario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Santos
 */
public class Conexao {
    
  
    
    public static Connection getConnection() throws ClassNotFoundException{
          Connection con=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/isppkilamba", "root","");
         System.out.println("Conectado com sucesso projectofinal");
        } catch (SQLException e) {
            
        System.out.println("Nao pode conectar" + e.getMessage());
        }
        return con;
    }
}
