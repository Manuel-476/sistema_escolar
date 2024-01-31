/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import daofuncionario.FuncionarioDAO;
import daofuncionario.cadFuncio;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelofuncionario.Funcionario;

/**
 *
 * @author chags
 */
public class excluir_fun extends HttpServlet {

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
            FuncionarioDAO fun=new FuncionarioDAO();
            Funcionario f=new Funcionario();
            f.setId_funcionario(Integer.parseInt(request.getParameter("id")));
            fun.excluir(f);
            request.getRequestDispatcher("cadastro.jsp").forward(request, response);
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
            Funcionario fun=new Funcionario();  
            FuncionarioDAO cf =new FuncionarioDAO();
            
            fun.setFuncao(request.getParameter("funcao"));
            fun.setId_funcionario(Integer.parseInt(request.getParameter("codigo")));
            fun.setNome(request.getParameter("nome"));
            fun.setArea(request.getParameter("area"));
            fun.setTelefone(request.getParameter("tel"));
            fun.setSalario(request.getParameter("salario"));  
           
            
            cf.alterar(fun);
            request.getRequestDispatcher("cadastro.jsp").forward(request, response);
            
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
