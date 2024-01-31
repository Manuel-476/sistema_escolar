/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import daoCurso.CursoDAO;
import daoEstudante.EstudanteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelofuncionario.Curso;
import modelofuncionario.Estudante;

/**
 *
 * @author chags
 */
public class excluir_curso extends HttpServlet {

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
            CursoDAO fun=new CursoDAO();
            Curso f=new Curso();
            f.setidCurso(Integer.parseInt(request.getParameter("id")));
            fun.excluir(f);
            request.getRequestDispatcher("cad_curso.jsp").forward(request, response);
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
            Curso fun=new Curso();  
            CursoDAO cf =new CursoDAO();
            
            
            fun.setFaculdade(request.getParameter("faculdade"));
            fun.setCurso(request.getParameter("curso"));
            fun.setTurno(request.getParameter("turno"));
          
           
            fun.setidCurso(Integer.parseInt(request.getParameter("id")));
             
           
            
            cf.alterar(fun);
            request.getRequestDispatcher("cad_curso.jsp").forward(request, response);
            
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
