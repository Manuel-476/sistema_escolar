/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package daofuncionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelofuncionario.Funcionario;

/**
 *
 * @author Santos
 */
public class FuncionarioDAO {
    
   
 private Connection con;

	public FuncionarioDAO() throws ClassNotFoundException {
		con = Conexao.getConnection();
	}
        
    public void cadastrar(Funcionario cl){
    
        String sql = "INSERT INTO funcionario(nome, email, telefone, salario, area, funcao, id_funcionario, codigo)" + "values (?,?,?,?,?,?,?,?)";
    
        try {
            PreparedStatement p = con.prepareStatement(sql);
           
            p.setString(1, cl.getNome());
            p.setString(2, cl.getEmail());
            p.setString(3, cl.getTelefone());
            p.setString(4, cl.getSalario());
            p.setString(5, cl.getArea());
            p.setString(6, cl.getFuncao());
           // p.setInt(7, cl.getId_Funcionario());
            p.setString(8, cl.getCodigo());
            
            p.execute();
            
            
            regi_tel(cl);
            
            System.out.println("CADASTRADO COM SUCESSO");
            
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
        
    }
    
    public void alterar(Funcionario cl){
    
        String sql = "UPDATE funcionarios SET nome=?, email=?, salario=?, departamento=?, funcao=? WHERE numero_fun=?";
        
        try {
            PreparedStatement p = con.prepareStatement(sql);
            
            p.setString(1, cl.getNome());
            p.setString(2, cl.getEmail());
            
            p.setString(3, cl.getSalario());
            p.setString(4, cl.getArea());
            p.setString(5, cl.getFuncao());
            p.setInt(6, cl.getId_funcionario());
           // p.setString(8, cl.getCodigo());
           
            
            p.execute();
            p.close();
            alteraTelFuncio(cl);
            System.out.println("ALTERADO COM SUCESSO");
            
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
        
    }
    
   
    
    public void excluir(Funcionario cl){
    
        String sql = "DELETE FROM funcionarios WHERE numero_fun=?";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setInt(1, cl.getId_funcionario());
            
            p.execute();
            p.close();
            
            System.out.println("EXCLUIDO COM SUCESSO");
            
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
        
    }
    
      private void regi_tel(Funcionario cl){
    
        String sql = "insert into tel_funcio values(?,?);";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setInt(1, cl.getId_funcionario());
             p.setString(2, cl.getTelefone());
            p.execute();
            p.close();
              
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
    }
    
   private ResultSet buscartelid(Funcionario cl){
        ResultSet rs=null;
        String sql = "select * from tel_funcio where numero_fun=?;";
        try {
                    
            PreparedStatement p = con.prepareStatement(sql);
            p.setInt(1, cl.getId_funcionario());
            rs=p.executeQuery();
            
           
            p.close();
              
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
        return rs;
    }
   
      private void alteraTelFuncio(Funcionario cl){
        ResultSet rs=null;
        String sql = "update tel_funcio set teleone=? where numero_fun=?;";
        try {
                    
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, cl.getTelefone());
            p.setInt(2, cl.getId_funcionario());
            rs=p.executeQuery();
            
           
            p.close();
              
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
      
    }
     
    public List<Funcionario> buscarTodos(){
    
        String sql = "SELECT * FROM funcionarios";
        
            List<Funcionario> listas = new ArrayList<Funcionario>();
        try {
            PreparedStatement p = con.prepareStatement(sql);
            
            ResultSet resultado= p.executeQuery();
            
            while(resultado.next()){
                Funcionario cl = new Funcionario();
                
           cl.setNome(resultado.getString("nome"));     
           cl.setEmail(resultado.getString("email"));
           //cl.setTelefone(resultado.getString("telefone"));
           cl.setSalario(resultado.getString("salario"));
           cl.setArea(resultado.getString("departamento"));
           cl.setFuncao(resultado.getString("funcao"));
           cl.setId_funcionario(resultado.getInt("numero_fun"));
          // cl.setCodigo(resultado.getString("codigo"));
           
            listas.add(cl);
            }
            
            p.close();
            System.out.println("RESULTADO DA BUSCA");
            
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
        
        return listas;
    }
    
    public Funcionario buscaporid(int idd){
        
     String sql = "SELECT * FROM funcionarios WHERE numero_fun=?";
     
     Funcionario cl = null;
     
     try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setInt(1, idd);
            
            ResultSet rs=null;
            ResultSet resultado = p.executeQuery();
            
            while (resultado.next()){
                cl = new Funcionario();
                cl.setNome(resultado.getString("nome"));
                cl.setArea(resultado.getString("departamento"));    
                cl.setId_funcionario(Integer.parseInt(resultado.getString("numero_fun")));
                cl.setEmail(resultado.getString("email"));
                cl.setSalario(resultado.getString("salario"));
                cl.setFuncao(resultado.getString("funcao"));
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
    
    public List<Funcionario> buscapornome(String nome){
        
     String sql = "SELECT * FROM funcionario WHERE nomed like ?";
     
     List<Funcionario> lista = new ArrayList<Funcionario>();
     
     try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, "%" + nome + "%");
            
            ResultSet resultado = p.executeQuery();
            
            while (resultado.next()){
            Funcionario cl = new Funcionario();
            
                   cl.setNome(resultado.getString("nome"));     
           cl.setEmail(resultado.getString("email"));
           cl.setTelefone(resultado.getString("telefone"));
           cl.setSalario(resultado.getString("salario"));
           cl.setArea(resultado.getString("area"));
           cl.setFuncao(resultado.getString("funcao"));
          // cl.setId_Funcionario(resultado.getInt("id_funcionario"));
           cl.setCodigo(resultado.getString("codigo"));
            
            lista.add(cl);
            }
        } catch (SQLException e) {
         System.out.println("erro no sql" + e.getMessage());  
        }
     
        return lista;
    } 
        
}

    
