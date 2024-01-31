package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import Servlets.cadastramento;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.ResultSet;
import daoEstudante.EstudanteDAO;
import modelofuncionario.Estudante;
import java.util.List;

public final class cad_005festudante_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("         <style>\n");
      out.write("            table{border:1px solid black;border-spacing: 0px;text-align: center;}\n");
      out.write("            table tr td{border:1px solid black;border-spacing: 0px;text-align: center;}\n");
      out.write("            table thead th{border:1px solid black;border-spacing: 0px;text-align: center;background-color:blue;color:#fff; }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>CADASTRAR ESTUDANTE</h1>\n");
      out.write("    \n");
      out.write("              <form  method=\"post\" action=\"cad_estudante\">\n");
      out.write("        <header>\n");
      out.write("        \t<p id=\"title1\" class=\"txt\">Cadastramento</p>\n");
      out.write("\t</header>\n");
      out.write("<center>\n");
      out.write("    <section>\n");
      out.write("\t\t<nav><p id=\"txt_leg1\" class=\"txt\"></p></nav>\n");
      out.write("\t\t<aside id=\"l1\">\n");
      out.write("\t\t\t<div id=\"cad_aln\">\n");
      out.write("\t\t\t\t<button id=\"btn1\">Sair</button>\n");
      out.write("\t\t\t</div>\n");
      out.write("                       <input type=\"text\" class=\"ipt\" id=\"ipt1\" placeholder=\"Nome Completo\" name=\"nome\">\n");
      out.write("\t\t\t<input type=\"text\" class=\"ipt\" id=\"ipt3\" placeholder=\"Telefone\" name=\"tel\">\n");
      out.write("                        <label>Ano:<input type=\"number\" name=\"ano\"></label>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t<select class=\"ipt\" id=\"ipt6\" name=\"turno\">\n");
      out.write("\t\t\t\t<option>Diurno</option>\n");
      out.write("\t\t\t\t<option>Nocturno</option>\n");
      out.write("\t\t\t</select>\n");
      out.write("                            ");

                        EstudanteDAO fd=new EstudanteDAO(); 
                        EstudanteDAO f=new EstudanteDAO(); 
          
           
                            
                             ResultSet rz = fd.selturma();
                   
      out.write("\n");
      out.write("\t\t\t<select class=\"ipt\" id=\"ipt7\" name=\"turma\">\n");
      out.write("                            ");
while(rz.next()){
      out.write("\n");
      out.write("                            <option>");
      out.print(rz.getString("n_turma") );
      out.write("</option>\n");
      out.write("                            ");
}
      out.write("\n");
      out.write("                                \n");
      out.write("\t\t\t</select>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t<button id=\"btn2\">Cadastrar</button>\n");
      out.write("\t\t</aside>\n");
      out.write("\t\t<aside id=\"l2\">\n");
      out.write("\t\t</aside>\n");
      out.write("    </section>\n");
      out.write("</center>\n");
      out.write("        </form>\n");
      out.write("                         \n");
      out.write("        <h2>Listar</h2>\n");
      out.write("    \n");
      out.write("        <table>\n");
      out.write("         <thead>\n");
      out.write("        <th>ID</th>\n");
      out.write("        <th>NOME</th>\n");
      out.write("        <th>TURMA</th>\n");
      out.write("         <th>ANO</th>\n");
      out.write("         <th>CURSO</th>\n");
      out.write("        <th>DELETAR/EDITAR</th>\n");
      out.write("        </thead>\n");
      out.write("       \n");
      out.write("             ");

             ResultSet r=f.buscarTodos();
            while(r.next()) {
        
      out.write("\n");
      out.write("       \n");
      out.write("        <tr><td>");
      out.print(r.getInt("numero_id"));
      out.write("</td><td>");
      out.print(r.getString("nome"));
      out.write("</td><td>");
      out.print(r.getString("turma"));
      out.write("\n");
      out.write("               </td><td>");
      out.print(r.getInt("ano"));
      out.write("</td>\n");
      out.write("               <td>");
      out.print(r.getString("curso"));
      out.write("</td>\n");
      out.write("               <td>\n");
      out.write("                   <a href=\"excluir_estudan?id=");
      out.print(r.getInt("numero_id"));
      out.write("\">Deletar</a>\n");
      out.write("                    <a href=\"edit_est.jsp?id=");
      out.print(r.getInt("numero_id"));
      out.write("\">Editar</a>\n");
      out.write("                   </td>  \n");
      out.write("           </tr>  \n");
      out.write("         ");
}
         
      out.write("\n");
      out.write("       </table>\n");
      out.write("      \n");
      out.write("       </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
