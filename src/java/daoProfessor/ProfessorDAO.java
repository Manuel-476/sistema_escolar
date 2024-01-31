/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoProfessor;

import daofuncionario.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelofuncionario.Estudante;
import modelofuncionario.Professor;

/**
 *
 * @author chags
 */
public class ProfessorDAO {
     private Connection con;

	public ProfessorDAO() throws ClassNotFoundException {
		con = Conexao.getConnection();
	}
       public ResultSet disciplina(){
        ResultSet rs=null;
        int id=0;
        String sql = "select * from disciplina;";
    
        try {
            PreparedStatement p = con.prepareStatement(sql);
           
            
            rs=p.executeQuery();
         
             
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
        return rs;
    }
       
       public int disciplinaid(String cl){
        ResultSet rs=null;
        int id=0;
        String sql = "select * from disciplina where nome=?;";
    
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, cl);
            
            rs=p.executeQuery();
          while(rs.next())
          {
              id=rs.getInt("id_disc");
          }
             
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
        return id;
    }
        public ResultSet maxid(){
        ResultSet rs=null;
        int id=0;
        String sql = "select max(numero_fun ) as numero from professor ;";
    
        try {
            PreparedStatement p = con.prepareStatement(sql);
            
            rs=p.executeQuery();
         
             
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
        return rs;
    }
       public int cursoid(String cl){
        ResultSet rs=null;
        int id=0;
        String sql = "select * from curso where nome=?;";
    
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, cl);
            
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

       
      public ResultSet selcurso(){
        
        String sql = "select * from curso";
         ResultSet rs=null;
        try {
            PreparedStatement p = con.prepareStatement(sql);  
            rs=p.executeQuery();
            
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
        return rs;
    } 
       
    public void cadastrar(Professor cl){
    
        String sql = "INSERT INTO professor(nome, especialidade, id_curso,turno) values (?,?,?,?)";
        ResultSet rs;
        try {
            PreparedStatement p = con.prepareStatement(sql);
           
            p.setString(1, cl.getNome());
            p.setString(2, cl.getEspecialidade());
            p.setInt(3, cl.getidCurso());
            p.setString(4, cl.getTurno());
            
            p.execute();
            rs=buscarTodos();
            while(rs.next())
            {
            cl.setIdProf(rs.getInt("numero_fun"));
            }
            regi_tel(cl);
            
            System.out.println("CADASTRADO COM SUCESSO");
            
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
        
    }
    
    public void alterar(Professor cl){
    
        String sql = "UPDATE professor SET nome=?, especialidade=?,curso=?, turno=? WHERE numero_fun=?";
        
        try {
            PreparedStatement p = con.prepareStatement(sql);
            
            p.setString(1, cl.getNome());
            p.setString(2, cl.getTurno());
            p.setString(3, cl.getTurno());
            p.setInt(4, cl.getAno());
            p.setInt(5, cl.getIdProf());
            
           // p.setString(8, cl.getCodigo());
           
            
            p.execute();
            
            alteraTelEstudante(cl);
            System.out.println("ALTERADO COM SUCESSO");
            
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
        
    }
    
   
    
    public void excluir(Professor cl){
    
        String sql = "DELETE FROM professor WHERE numero_fun=?";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setInt(1, cl.getIdProf());
            
            p.execute();
            p.close();
            
           
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
        
    }
        public  void cadDisciplinaProf(Professor cl){
        int id=0;
        String sql = "insert into prof_disciplina values(?,?);";
        try {
            ResultSet rs;
            rs=maxid();
            while(rs.next())
            {
            id=rs.getInt("numero");
            }
            
            PreparedStatement p = con.prepareStatement(sql);
             p.setInt(1, cl.getIdDisc());
            p.setInt(2, id);
            p.execute();
            
              
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
    }    
      private void regi_tel(Professor cl){
    
        String sql = "insert into tel_prof values(?,?);";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setInt(1, cl.getIdProf());
             p.setString(2, cl.getTelefone());
            p.execute();
            p.close();
              
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
    }
    
   private ResultSet buscartelid(Professor cl){
        ResultSet rs=null;
        String sql = "select * from tel_prof where numero_fun=?;";
        try {
                    
            PreparedStatement p = con.prepareStatement(sql);
            p.setInt(1, cl.getIdProf());
            rs=p.executeQuery();
            
           
            p.close();
              
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
        return rs;
    }
   
      private void alteraTelEstudante(Professor cl){
        ResultSet rs=null;
        String sql = "update tel_prof set telefone=? where numero_fun=?;";
        try {
                    
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, cl.getTelefone());
            p.setInt(2, cl.getIdProf());
            rs=p.executeQuery();
            
           
            p.close();
              
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
      
    }
     
    public ResultSet buscarTodos(){
    
        String sql = "select p.numero_fun,p.nome,p.turno,curso.nome as curso,d.nome as Disciplina from professor as p \n" +
"join curso ,disciplina as d,prof_disciplina as pd where p.id_curso=curso.id_curso and\n" +
" d.id_disc=pd.id_disc and p.numero_fun=pd.numero_fun ;";
        
            ResultSet rs=null;
        try {
            
            PreparedStatement p = con.prepareStatement(sql);
            
            rs = p.executeQuery();
               
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
        
        return rs;
    }
    
    public Professor buscaporid(int idd){
        
     String sql = "select p.numero_fun,p.especialidade,p.nome,p.turno,curso.nome as cursos,d.nome as Disciplina from professor as p \n" +
"join curso ,disciplina as d,prof_disciplina as pd where p.id_curso=curso.id_curso and\n" +
" d.id_disc=pd.id_disc and p.numero_fun=pd.numero_fun and p.numero_fun=?";
     
     Professor cl = new Professor();;
     
     try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setInt(1, idd);
            
            ResultSet rs=null;
            ResultSet resultado = p.executeQuery();
            
            while (resultado.next()){
              
                cl.setNome(resultado.getString("nome"));
                cl.setCurso(resultado.getString("cursos"));
                cl.setDisciplina(resultado.getString("Disciplina"));   
                cl.setIdProf(Integer.parseInt(resultado.getString("numero_fun")));
                cl.setTurno(resultado.getString("turno"));
                cl.setEspecialidade(resultado.getString("especialidade"));
                
                
          // cl.setId_Funcionario(resultado.getInt("id_funcionario"));   
                
                
            }
            rs=buscartelid(cl);
            while(rs.next())
            {
                cl.setTelefone(resultado.getString("telefone"));
            }
            
        } catch (SQLException e) {
         System.out.println("erro no sql" + e.getMessage());  
        }
     
        return cl;
    }
    
}
