/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package daofuncionario;


import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Santos
 */
public class FuncionarioCadastrar {
    public static void main(String[] args) throws SQLException, 
            ClassNotFoundException, 
            InstantiationException, 
            IllegalAccessException {
        Connection connection = new Conexao().getConnection();
        System.out.println("Conexão aberta!");
        connection.close();
        
    }
    
}
