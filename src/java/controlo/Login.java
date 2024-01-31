/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlo;

import daofuncionario.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelofuncionario.Administrador;
import modelofuncionario.Funcionario;

/**
 *
 * @author chags
 */
public class Login {
    private Connection con;

	public Login() throws ClassNotFoundException {
		con = Conexao.getConnection();
	}
    public int loginentrar(Administrador ad)
    { 
           int id=0;  
           
           try {
           ResultSet rs=null;
            String sql="select * from adminstrador where email=? and senha=?;";
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, ad.getEmail());
            p.setString(2,ad.getSenha());
            
            rs=p.executeQuery();
            
             
            while(rs.next())
            {
                id=rs.getInt("id");
            }
         
        
            
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
           return id;
    }
    
        public void cad_admin(Administrador f)
    { 
           int id=0;  
           
           try {
           ResultSet rs=null;
            String sql="insert into adminstrador (email,nome,senha) values (?,?,?);";
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, f.getEmail());
            p.setString(2,f.getNome());
            p.setString(3,f.getSenha());
            
            p.execute();
            
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
    }
}
