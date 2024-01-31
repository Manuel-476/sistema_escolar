/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import daoCurso.CursoDAO;
import daoCurso.DisciplinaDAO;
import daoEstudante.EstudanteDAO;
import daoProfessor.ProfessorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelofuncionario.Disciplina;
import modelofuncionario.Estudante;

/**
 *
 * @author chags
 */
@WebServlet(name = "cad_disc", urlPatterns = {"/cad_disc"})
public class cad_disc extends HttpServlet {

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
        
           Disciplina fun=new Disciplina();
           DisciplinaDAO est;
        try {
            est = new DisciplinaDAO();
            ProfessorDAO este=new  ProfessorDAO();
                  int id=0;
           
            fun.setNome(request.getParameter("disc"));
            
            fun.setAno(Integer.parseInt(request.getParameter("ano")));
            fun.setidCurso(est.cursoidano(request.getParameter("curso"),fun));
              
            
         
        
            id=est.cadastrar(fun);
            fun.setIdDisc(id+1);
            est.cadastrarCurso(fun);
            
            response.sendRedirect("cad_disc.jsp");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(cad_disc.class.getName()).log(Level.SEVERE, null, ex);
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
