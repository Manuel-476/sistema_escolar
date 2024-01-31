/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoEstudante;

import daofuncionario.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelofuncionario.Estudante;
import modelofuncionario.Funcionario;

/**
 *
 * @author chags
 */
public class EstudanteDAO {
    private Connection con;

	public EstudanteDAO() throws ClassNotFoundException {
		con = Conexao.getConnection();
	}
        
       public int turmaid(String cl){
        ResultSet rs=null;
        int id=0;
        String sql = "select * from turma where n_turma=?;";
    
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, cl);
            
            rs=p.executeQuery();
          while(rs.next())
          {
              id=rs.getInt("id_turma");
          }
             
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
        return id;
    }
      public ResultSet selturma(){
        
        String sql = "select * from turma";
         ResultSet rs=null;
        try {
            PreparedStatement p = con.prepareStatement(sql);  
            rs=p.executeQuery();
            
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
        return rs;
    } 
       
    public void cadastrar(Estudante cl){
    
        String sql = "INSERT INTO estudante(nome, id_turma, turno, ano) values (?,?,?,?)";
        ResultSet rs;
        try {
            PreparedStatement p = con.prepareStatement(sql);
           
            p.setString(1, cl.getNome());
            p.setInt(2, cl.getIdturma());
            p.setString(3, cl.getTurno());
            p.setInt(4, cl.getAno());
          
            
            p.execute();
            rs=buscarTodos();
            while(rs.next())
            {
            cl.setIdAluno(rs.getInt("numero_id"));
            }
            regi_tel(cl);
            
            System.out.println("CADASTRADO COM SUCESSO");
            
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
        
    }
    
    public void alterar(Estudante cl){
    
        String sql = "UPDATE estudante SET nome=?, id_turma=?, turno=?, ano=? WHERE numero_id=?";
        
        try {
            PreparedStatement p = con.prepareStatement(sql);
            
            p.setString(1, cl.getNome());
            p.setInt(2, cl.getIdturma());
            p.setString(3, cl.getTurno());
            p.setInt(4, cl.getAno());
            p.setInt(5, cl.getIdAluno());
            
           // p.setString(8, cl.getCodigo());
           
            
            p.execute();
            
            alteraTelEstudante(cl);
            System.out.println("ALTERADO COM SUCESSO");
            
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
        
    }
    
   
    
    public void excluir(Estudante cl){
    
        String sql = "DELETE FROM estudante WHERE numero_id=?";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setInt(1, cl.getIdAluno());
            
            p.execute();
            p.close();
            
           
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
        
    }
    
      private void regi_tel(Estudante cl){
    
        String sql = "insert into tel_estudante values(?,?);";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setInt(1, cl.getIdAluno());
             p.setString(2, cl.getTelefone());
            p.execute();
            p.close();
              
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
    }
    
   private ResultSet buscartelid(Estudante cl){
        ResultSet rs=null;
        String sql = "select * from tel_estudante where id_aluno=?;";
        try {
                    
            PreparedStatement p = con.prepareStatement(sql);
            p.setInt(1, cl.getIdAluno());
            rs=p.executeQuery();
            
           
            p.close();
              
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
        return rs;
    }
   
      private void alteraTelEstudante(Estudante cl){
        ResultSet rs=null;
        String sql = "update tel_estudante set telefone=? where id_aluno=?;";
        try {
                    
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, cl.getTelefone());
            p.setInt(2, cl.getIdAluno());
            rs=p.executeQuery();
            
           
            p.close();
              
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
      
    }
     
    public ResultSet buscarTodos(){
    
        String sql = "select e.numero_id,e.nome,turma.n_turma as turma,e.turno,e.ano,curso.nome as curso from estudante as e join curso,turma" +
                      " where turma.id_turma=e.id_turma and turma.id_curso=curso.id_curso;";
        
            ResultSet rs=null;
        try {
            
            PreparedStatement p = con.prepareStatement(sql);
            
            rs = p.executeQuery();
               
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
        
        return rs;
    }
    
        public ResultSet buscarTodosCursoAno(int i){
    
        String sql = "select e.numero_id,e.nome from estudante as e join turma,curso\n" +
                     "where e.id_turma=turma.id_turma and curso.id_curso=turma.id_curso and e.ano=curso.ano "
                   + "and e.ano=?;";
        
            ResultSet rs=null;
        try {
            
            PreparedStatement p = con.prepareStatement(sql);
            p.setInt(1, i);
            
            rs = p.executeQuery();
               
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
        
        return rs;
    }
    public Estudante buscaporid(int idd){
        
     String sql = "select e.nome,turma.n_turma as turma,e.turno,e.ano as ano_actual,curso.nome as cursos from estudante as e join curso,turma " +
                  "where turma.id_turma=e.id_turma and turma.id_curso=curso.id_curso and numero_id=?";
     
     Estudante cl = new Estudante();;
     
     try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setInt(1, idd);
            
            ResultSet rs=null;
            ResultSet resultado = p.executeQuery();
            
            while (resultado.next()){
              
                cl.setNome(resultado.getString("nome"));
                cl.setCurso(resultado.getString("cursos"));
                cl.setTurma(resultado.getString("turma"));    
                cl.setIdAluno(Integer.parseInt(resultado.getString("numero_id")));
                cl.setTurno(resultado.getString("turno"));
                cl.setCurso(resultado.getString("curso"));
                cl.setAno(resultado.getInt("ano"));
                
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
