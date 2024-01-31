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
public class Curso {
    String faculdade;
     String nome;
    String telefone;
    String turno;
    String turma;
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

    public String getFaculdade() {
        return faculdade;
    }
    public void setFaculdade(String faculdade) {
        this.faculdade = faculdade;
    }
    
     public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
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
}
