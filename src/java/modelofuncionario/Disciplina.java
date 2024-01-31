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
public class Disciplina {
      String faculdade;
     String nome;
    String curso;
    String disc;
    int id_curso;
    int ano;
    int iddisc;
 
    public int getIdDisc() {
        return iddisc;
    }

    public void setIdDisc(int iddisc) {
        this.iddisc = iddisc;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getidCurso() {
        return id_curso;
    }

    public void setidCurso(int id_curso) {
        this.id_curso = id_curso;
    }
    
        public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
