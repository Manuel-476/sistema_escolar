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
public class Notas {
String nome;
String p_parcelar;
String p2;
String exame;
String recurso;
String extra;
int id;
int idaluno;
int ano;
int idnota;


  public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }    

    public String getPriparcelar() {
        return p_parcelar;
    }

    public void setPriparcelar(String p_parcelar) {
        this.p_parcelar = p_parcelar;
    }
     public String getSegparcelar() {
        return p2;
    }

    public void setSegparcelar(String s_parcelar) {
        this.p2= s_parcelar;
    }
     public String getExame() {
        return exame;
    }

    public void setExame(String exame) {
        this.exame = exame;
    }
     public String getRecurso() {
        return recurso;
    }

    public void setRecurso(String recurso) {
        this.recurso = recurso;
    }
    
    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public int getIddisc() {
        return id;
    }

    public void setIddisc(int id) {
        this.id = id;
    }
      public int getIdAluno() {
        return idaluno;
    }

    public void setIdAluno(int idaluno) {
        this.idaluno = idaluno;
    }
      public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    public int getIdnota() {
        return idnota;
    }

    public void setIdnota(int nota) {
        this.idnota = nota;
    }
}
