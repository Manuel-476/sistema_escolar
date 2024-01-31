/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import daoEstudante.EstudanteDAO;
import daoProfessor.ProfessorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelofuncionario.Estudante;
import modelofuncionario.Professor;

/**
 *
 * @author chags
 */
public class excluir_prof extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
         try {
            ProfessorDAO fun=new ProfessorDAO();
            Professor f=new Professor();
            f.setIdProf(Integer.parseInt(request.getParameter("id")));
            fun.excluir(f);
            request.getRequestDispatcher("cad_professor.jsp").forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(excluir_fun.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
               try {  
            Professor fun=new Professor();  
            ProfessorDAO cf =new ProfessorDAO();
            
           
            fun.setDisciplina(request.getParameter("Disciplina"));
            fun.setNome(request.getParameter("nome"));
            fun.setTurno(request.getParameter("turno"));
            fun.setTelefone(request.getParameter("tel"));
            fun.setidCurso(cf.cursoid(request.getParameter("curso")));
            fun.setIdProf(Integer.parseInt(request.getParameter("id")));
             
           
            
            cf.alterar(fun);
            request.getRequestDispatcher("cad_estudante.jsp").forward(request, response);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(cadastramento.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
