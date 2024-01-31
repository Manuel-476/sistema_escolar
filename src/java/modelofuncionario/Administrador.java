/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelofuncionario;

/**
 *
 * @author chags
 */
public class Administrador {
    private int id;
    private String nome;
    private String email;
    private String senha;
    
     public String getEmail() {
        return email;
    }
     public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
        
     public String getSenha() {
        return senha;
    }
         
     public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    
}
