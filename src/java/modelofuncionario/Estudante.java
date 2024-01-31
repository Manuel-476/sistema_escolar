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
public class Estudante {
    String nome;
    String telefone;
    String turno;
    String turma;
    String curso;
    int id_aluno;
    int id_turma;
    int ano;
 

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdturma() {
        return id_turma;
    }

    public void setIdturma(int id_turma) {
        this.id_turma = id_turma;
    }

    public String getTelefone() {
        return telefone;
    }
     public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
     public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getTurno() {
        return turno;
    }
    

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano= ano;
    }


    
     public int getIdAluno() {
        return id_aluno;
    }

    public void setIdAluno(int id_aluno) {
        this.id_aluno = id_aluno;
    }
    
  

    public void setCurso(String curso) {
        this.curso = curso;
    }
     public String getCurso() {
        return curso;
    }
}
