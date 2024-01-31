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
import modelofuncionario.Disciplina;
import modelofuncionario.Professor;

/**
 *
 * @author chags
 */
public class DisciplinaDAO {
        private Connection con;
        public static int ano;
        public static int id;
        public static int idaluno;
	public  DisciplinaDAO() throws ClassNotFoundException {
		con = Conexao.getConnection();
	}
    public int cadastrar( Disciplina cl){
    
        String sql = "INSERT INTO disciplina (nome, ano) values (?,?)";
         int id=0;
        try {
           
            ResultSet rs=maxid();
            
            PreparedStatement p = con.prepareStatement(sql);
           
            p.setString(1, cl.getNome());
            p.setInt(2, cl.getAno());
            
            p.executeUpdate();
            
            while(rs.next())
            {
                id=rs.getInt("id");
            }
            
            
                 
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
        return id;
    }
    public void cadastrarCurso( Disciplina cl){
    
        String sql = "INSERT INTO curso_disci (is_disc, id_curso) values (?,?)";
        
        try {
            PreparedStatement p = con.prepareStatement(sql);
           
            p.setInt(1, cl.getIdDisc());
            p.setInt(2, cl.getidCurso());
            
            p.executeUpdate();
                 
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
    }
    
    public ResultSet buscaporid(int idd){     
     String sql = "select * from disciplina where id_disc=?";
     
   
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
    
        public ResultSet maxid(){     
     String sql = "select max(id_disc) as id from disciplina;";
     
   
     ResultSet rs=null;
     try {
            PreparedStatement p = con.prepareStatement(sql);
        
          rs = p.executeQuery();
            
        
        } catch (SQLException e) {
         System.out.println("erro no sql" + e.getMessage());  
        }
     
        return rs;
    }
        public void excluir( Disciplina cl){
    
        String sql = "DELETE FROM disciplina WHERE id_disc=?";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setInt(1, cl.getIdDisc());
            
            p.execute();
            p.close();
            excluirCurso(cl);
           
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
        
    }    
    public ResultSet buscarpornome(String cl){
      ResultSet rs=null;
        String sql = "select * from disciplina  WHERE nome=?";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, cl);
            rs=p.executeQuery();
            
            
           
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
        return rs;
    }   
    
     private void excluirCurso(Disciplina cl){
    
        String sql = "DELETE FROM curso_disci WHERE is_disc=?";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setInt(1, cl.getIdDisc());
            
            p.execute();
            p.close();
            
           
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
        
    } 
      public ResultSet buscarTodos(){
    
        String sql = "select d.id_disc,d.nome,curso.nome as curso,d.ano from disciplina as d join curso,curso_disci as cd\n" +
                      "where d.id_disc=cd.is_disc and cd.id_curso=curso.id_curso";
        
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
          
        public int cursoidano(String cl,Disciplina t){
        ResultSet rs=null;
        int id=0;
        String sql = "select * from curso where nome=? and ano=?;";
    
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, cl);
            p.setInt(2, t.getAno());
            
            rs=p.executeQuery();
          while(rs.next())
          {
              id=rs.getInt("id_curso");
          }
             
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
        return id;
    }
        
        public void alterar(Disciplina cl){
    
        String sql = "UPDATE disciplina SET nome=?, ano=? WHERE id_disc=?";
        
        try {
            PreparedStatement p = con.prepareStatement(sql);
            
            p.setString(1, cl.getNome());
            p.setInt(2, cl.getAno()); 
            p.setInt(3, cl.getIdDisc());
            
           // p.setString(8, cl.getCodigo());
           
            
            p.execute();
            
            alteraCurso(cl);
            System.out.println("ALTERADO COM SUCESSO");
            
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        } 
    }
       public ResultSet DisciplinaAnoCurso(Disciplina cl){
        ResultSet rs=null;
        String sql = "select d.nome from disciplina as d join curso,curso_disci as cd\n" +
         "where curso.id_curso=cd.id_curso and d.id_disc=cd.is_disc and d.ano=? and curso.id_curso=?;";
        try {
                    
            PreparedStatement p = con.prepareStatement(sql);
            p.setInt(1, cl.getAno());
            p.setInt(2, cl.getidCurso());
            rs=p.executeQuery();
            
           
            
              
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
      return rs;
    }
        
       private void alteraCurso(Disciplina cl){
        ResultSet rs=null;
        String sql = "update curso_disci set id_curso=? where is_disc=?;";
        try {
                    
            PreparedStatement p = con.prepareStatement(sql);
            p.setInt(1, cl.getidCurso());
            p.setInt(2, cl.getIdDisc());
            rs=p.executeQuery();
            
           
            p.close();
              
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
      
    }
}
