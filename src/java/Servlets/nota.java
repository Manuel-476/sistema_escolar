/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import daoCurso.DisciplinaDAO;
import daoEstudante.NotasDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelofuncionario.Notas;

/**
 *
 * @author chags
 */
public class nota extends HttpServlet {

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
        HttpSession s=request.getSession();
        s.setAttribute("idest", request.getParameter("id"));
        response.sendRedirect("Lancar_nota.jsp");
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
            NotasDAO n=new NotasDAO();
            Notas nota =new Notas();
             HttpSession s=request.getSession();
        
            
            nota.setPriparcelar(request.getParameter("p_parc"));
            nota.setSegparcelar(request.getParameter("ps"));
            nota.setExame(request.getParameter("exame"));
            nota.setRecurso(request.getParameter("rec"));
            nota.setExtra(request.getParameter("extra"));
            nota.setIdAluno(Integer.parseInt(s.getAttribute("idest").toString()));
            nota.setAno(DisciplinaDAO.ano);
            nota.setNome(request.getParameter("disc"));
            nota.setIdnota(Integer.parseInt(request.getParameter("id")));
            
           
            if(nota.getIdnota()!=0)
            {
                if(nota.getSegparcelar()!=" ")
                   n.cadastrarseg(nota);
                if(nota.getExame()!=" ")
                    n.cadastrarExame(nota);
               if(nota.getRecurso()!=" ")
                   n.cadastrarRec(nota);
               if(nota.getExtra()!=" ")
                  n.cadastrarExtra(nota);
            }
            else
                 if(Double.parseDouble(nota.getPriparcelar())>0.0)
             n.cadastrarpri(nota);
            response.sendRedirect("Lancar_nota.jsp");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(nota.class.getName()).log(Level.SEVERE, null, ex);
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
