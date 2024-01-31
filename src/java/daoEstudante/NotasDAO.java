/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoEstudante;

import daoCurso.DisciplinaDAO;
import daofuncionario.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelofuncionario.Disciplina;
import modelofuncionario.Notas;

/**
 *
 * @author chags
 */
public class NotasDAO  {
    private Connection con;
    
    public  NotasDAO() throws ClassNotFoundException {
		con = Conexao.getConnection();
	}
    public int cadastrarpri( Notas cl) throws ClassNotFoundException{
    
        String sql = "insert into notas(pri_parcelar,ano,id_disc) values (?,?,?)";
         int id=0,ano=0;
         
        try {
            DisciplinaDAO d=new  DisciplinaDAO();
            ResultSet rs=d.buscarpornome(cl.getNome());
             while(rs.next())
             {
                 id=rs.getInt("id_disc");
                 ano=rs.getInt("ano");
             }
             cl.setIddisc(id);
            PreparedStatement p = con.prepareStatement(sql);
           
            p.setString(1, cl.getPriparcelar());
            p.setInt(2, ano);
            p.setInt(3, id);
            
            p.executeUpdate();
            
            cadastrarDiscEstudante(cl);
                    
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
        return id;
    }
    
        public int cadastrarseg( Notas cl) throws ClassNotFoundException{
    
        String sql = "update  notas set seg_parcelar=?,estado=? where id_nota=?";
      
         int id=0,ano=0;
         Double v;
         PreparedStatement st=null;
        try {
            DisciplinaDAO d=new  DisciplinaDAO();
            
         
            PreparedStatement p = con.prepareStatement(sql);
           
            p.setString(1, cl.getSegparcelar());
            p.setString(2, "dispensa");
            p.setInt(3, cl.getIdnota());
            
            p.executeUpdate();
            
            
            
        
            
                    
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
        return id;
    }
      
     public int cadastrarRec( Notas cl) throws ClassNotFoundException{
    
        String sql = "update  notas set recurso=?,estado=? where id_nota=?";
         int id=0,ano=0;
         Double v;
         PreparedStatement st=null;
        try {
            DisciplinaDAO d=new  DisciplinaDAO();
            
       
            PreparedStatement p = con.prepareStatement(sql);
           
            p.setString(1, cl.getRecurso());
            p.setString(2,"dispensa");
            p.setInt(3, cl.getIdnota());
            
            p.executeUpdate();
            
            
                      
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
        return id;
    }
     public int cadastrarExame( Notas cl) throws ClassNotFoundException{
    
        String sql = "update  notas set exame=?,estado=? where id_nota=?";
         int id=0,ano=0;
         Double v;
         PreparedStatement st=null;
        try {
            DisciplinaDAO d=new  DisciplinaDAO();
            
        
            PreparedStatement p = con.prepareStatement(sql);
           
            p.setString(1,cl.getExame());
            p.setString(2,"dispensa");
            p.setInt(3, cl.getIdnota());
            p.execute();
                        
        }catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
        return id;
    }
      public int cadastrarExtra( Notas cl) throws ClassNotFoundException{
    
        String sql = "update  notas set extraordinario=?,estado=? where id_nota=?";
         int id=0,ano=0;
         Double v;
         PreparedStatement st=null;
        try {
            DisciplinaDAO d=new  DisciplinaDAO();
            
           
            PreparedStatement p = con.prepareStatement(sql);
           
            p.setString(1, cl.getExtra());
            p.setString(2,"dispensa");
            p.setInt(3, cl.getIdnota());
            
            p.executeUpdate();
            
           
                      
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
        return id;
    }
        
   public String VerDispensa(int i, Notas cl) throws ClassNotFoundException, SQLException{
      ResultSet rs=buscarTodos(cl.getIdAluno());
      Double result;
      String estado="activo";
      String p1=null,p2=null,exa=null,recu=null,extr=null;
      
     while( rs.next())
     {
         p1=rs.getString("pri_parcelar");
         p2=rs.getString("seg_parcelar");
         exa=rs.getString("exame");
         recu=rs.getString("recurso");
         extr=rs.getString("extraordinario");
     }
        
     result=(Double.parseDouble(p1)+Double.parseDouble(p2))/2;
     if(result>=14 && i==1)
         estado="Dispensou";
     else if(i==2)
     {
       if((result+Double.parseDouble(exa))>=14)
          estado="Dispensou";
     }
     else if(i==3)
         if((Double.parseDouble(recu))>=10)
          estado="Dispensou";
    else if(i==4)
          if((Double.parseDouble(extr))>=10)
            estado="Dispensou";
     else
              estado="Cadeira";
       
        return estado;
    }
        
   public ResultSet buscarTodos(int i){
    
        String sql = "select n.id_nota,n.pri_parcelar,n.seg_parcelar,n.exame,n.recurso,n.extraordinario,n.ano  from notas as n join estudante as e,estu_disc as ed\n" +
       "where n.id_disc=ed.id_disc and e.numero_id=ed.numero_id and ed.id_nota=n.id_nota and e.numero_id=?;";
        
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
     public ResultSet buscaridnotas(Notas cl){
    
        String sql = "select n.id_nota as id from estu_disc where numero_id=? and id_disc=?;";
        
            ResultSet rs=null;
        try {
            
            PreparedStatement p = con.prepareStatement(sql);
            p.setInt(1, cl.getIdAluno());
            p.setInt(2, cl.getIddisc());
            rs = p.executeQuery();
               
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
        
        return rs;
     }
       public ResultSet maxidnota( ){
    
        String sql = "select max(id_nota) as id from notas;";
        ResultSet rs=null;
        try {
            PreparedStatement p = con.prepareStatement(sql);
           rs=p.executeQuery();
                    
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
        return rs;
    }
     
         public void cadastrarDiscEstudante( Notas cl){
    
        String sql = "INSERT INTO estu_disc (numero_id, id_disc,id_nota) values (?,?,?)";
        int id=0;
        try {
            ResultSet rs=maxidnota();
            while(rs.next())
            {
               id=rs.getInt("id");
            }
            PreparedStatement p = con.prepareStatement(sql);
           
            p.setInt(1, cl.getIdAluno());
            p.setInt(2, cl.getIddisc());
            p.setInt(3, id);
            
            p.executeUpdate();
                 
        } catch (SQLException e) {
             System.out.println("erro no sql" + e.getMessage());
        }
    }
}
