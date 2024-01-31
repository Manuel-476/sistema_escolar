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
public class Professor {
    String nome;
    String telefone;
    String turno;
    String turma;
    String curso;
    String disc;
    String especialidade;
    int id_prof;
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

    public String getTelefone() {
        return telefone;
    }
     public String getCurso() {
        return curso;
    }

    public void setCurso(String turma) {
        this.curso = curso;
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


    
     public int getIdProf() {
        return id_prof;
    }

    public void setIdProf(int id_prof) {
        this.id_prof = id_prof;
    }
    
  

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
     public String getEspecialidade() {
        return especialidade;
    }
      
     public String getDisciplina() {
        return disc;
    }

    public void setDisciplina(String disc) {
        this.disc = disc;
    }
    
}
