/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daofuncionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelofuncionario.Funcionario;

/**
 *
 * @author chags
 */
public class cadFuncio extends Conexao
{
    public void cadastrarFuncionario(Funcionario fun) throws ClassNotFoundException, SQLException
    {
        Connection con=getConnection();
        PreparedStatement stmt=con.prepareStatement("insert into funcionarios (nome,numero_fun,departamento,funcao,salario,email) values (?,?,?,?,?,?)");
        stmt.setString(1, fun.getNome());
        stmt.setString(2, String.valueOf(fun.getId_funcionario()));
        stmt.setString(3, fun.getArea());
        stmt.setString(4, fun.getFuncao() );
        stmt.setString(5, fun.getSalario() );
        stmt.setString(6, fun.getEmail());
        stmt.executeUpdate();
    }
    
}
