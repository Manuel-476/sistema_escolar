/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import daoEstudante.NotasDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Position;
import javax.swing.text.Segment;

/**
 *
 * @author chags
 */
@WebServlet(name = "imprensao", urlPatterns = {"/imprensao"})
public class imprensao extends HttpServlet {

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
    }
    @SuppressWarnings("empty-statement")
 protected void Imprimir(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        Document folha=new Document();
        try {
            
            response.setContentType("apllication/pdf");
            response.addHeader("content-Disposition", "inline; filename="+"Nota.pdf");
            PdfWriter.getInstance( folha, response.getOutputStream());
            HttpSession s=request.getSession();
            folha.open();
            folha.add(new Paragraph("Nota:"));
            folha.add(new Paragraph(" "));
            //criar uma tabela
            PdfPTable tabela=new PdfPTable(7);
            //cabeçalho
            
            PdfPCell col1=new PdfPCell(new Paragraph("ID"));
            PdfPCell col2=new PdfPCell(new Paragraph("1 Parcelar"));
            PdfPCell col3=new PdfPCell(new Paragraph("2 Parcelar"));
            PdfPCell col4=new PdfPCell(new Paragraph("Exame"));
            PdfPCell col5=new PdfPCell(new Paragraph("Recurso"));
            PdfPCell col6=new PdfPCell(new Paragraph("Extraordinario"));
            PdfPCell col7=new PdfPCell(new Paragraph("ANO"));
            
            tabela.addCell(col1);
            tabela.addCell(col2);
            tabela.addCell(col3);
            tabela.addCell(col4);
            tabela.addCell(col5);
            tabela.addCell(col6);
            tabela.addCell(col7);
       
            //popular as tabelas com a classificacao;
            NotasDAO c=new NotasDAO();
           ResultSet lista= c.buscarTodos(Integer.parseInt(s.getAttribute("idest").toString()));;
            while(lista.next()){
                
                
                tabela.addCell(String.valueOf(lista.getInt("id_nota")));
               tabela.addCell(lista.getString("pri_parcelar"));
               tabela.addCell(lista.getString("seg_parcelar"));
               tabela.addCell(lista.getString("exame"));
               tabela.addCell(lista.getString("recurso"));
               tabela.addCell(lista.getString("extraordinario"));
              tabela.addCell(String.valueOf(lista.getInt("ano")));
               
               
               
              
               
                       
            }
            
           /* Paragraph paragrafoData=new Paragraph();
               paragrafoData.setAlignment(Element.ALIGN_CENTER);*/
            folha.add(tabela);
            folha.close();
            
        } catch (Exception e) {
           System.out.println(e);
           folha.close();
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
