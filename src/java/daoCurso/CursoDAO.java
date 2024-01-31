/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoCurso;

import daofuncionario.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelofuncionario.Curso;
import modelofuncionario.Estudante;

/**
 *
 * @author chags
 */
public class CursoDAO {
    private Connection con;

	public CursoDAO() throws ClassNotFoundException {
		con = Conexao.getConnection();
	}
    public void cadastrar(Curso cl){
    
        String sql = "INSERT INTO curso (nome, ano,faculdade) values (?,?,?)";
        
        try {
            PreparedStatement p = con.prepareStatement(sql);
           
            p.setString(1, cl.getCurso());
            p.setInt(2, cl.getAno());
            p.setString(3, cl.getFaculdade());
            p.executeUpdate();
           
           
            
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
    }
    
    public ResultSet buscaporid(int idd){     
     String sql = "select * from curso where id_curso=?";
     
   
     ResultSet rs=null;
     try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setInt(1, idd);
          rs = p.executeQuery();
            
        
        } catch (SQLException e) {
         System.out.println("erro no sql" + e.getMessage());  
        }
     
        return rs;
    }
    
        public void excluir(Curso cl){
    
        String sql = "DELETE FROM curso WHERE id_curso=?";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setInt(1, cl.getidCurso());
            
            p.execute();
            p.close();
            
           
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
        
    }    
    
      public ResultSet buscarTodos(){
    
        String sql = "select distinct nome,faculdade from curso;";
        
            ResultSet rs=null;
        try {
            
            PreparedStatement p = con.prepareStatement(sql);
            
            rs = p.executeQuery();
               
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
        
        return rs;
    }
          public ResultSet buscarTodosano(){
    
        String sql = "select  * from curso;";
        
            ResultSet rs=null;
        try {
            
            PreparedStatement p = con.prepareStatement(sql);
            
            rs = p.executeQuery();
               
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
        
        return rs;
    } 
          
     public ResultSet buscarTodosNome(String s){
    
        String sql = "select  * from curso where nome=?;";
        
            ResultSet rs=null;
        try {
            
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1,s);
            rs = p.executeQuery();
               
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
        
        return rs;
    } 
          
          public void alterar(Curso cl){
    
        String sql = "UPDATE curso SET nome=?,  faculdade=? WHERE nome=?";
        
        try {
            String nome=null;
            ResultSet rs=buscaporid(cl.getidCurso());
            while(rs.next())
            {
                nome=rs.getString("nome");
            }
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, cl.getCurso());
            p.setString(2, cl.getFaculdade());
            p.setString(3, nome);
           
            
            p.execute();
            
           
            
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
        
    }
    
}
