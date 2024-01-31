package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class telaprincipal_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<meta name=\"viewport\" content=\"width=divice-width, user-scalable=yes, initial-scale=1, maximun-scale=1, minimun-scale=1\">\n");
      out.write("      \t\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"css/telap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <title>Tela Principal</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
 if(session.getAttribute("email")==null)
             response.sendRedirect("tLogin.jsp");
        
      out.write("\n");
      out.write("        \t\n");
      out.write("\t\n");
      out.write("\n");
      out.write("        <header>\n");
      out.write("\t\n");
      out.write("            <div class=\"logo\">\n");
      out.write("              <img src=\"imagens/transferir.jpeg\" alt=\"\" width=\"80\"/>  \n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <nav>\n");
      out.write("\t\t<div id=\"menu\">\n");
      out.write("                    <ul>\n");
      out.write("\t\t\t<li class=\"iten\" id=\"l1\" >\n");
      out.write("                            <img src=\"imagens/transferir.png\" id=\"cad\" onmousemove=\"verlista(1)\" onmouseleave=\"verlista(2)\" alt=\"Cadastrar\" width=\"80\"/>\n");
      out.write("                            <ul id=\"lista\" onmousemove=\"verlista(1)\" onmouseleave=\"verlista(2)\">\n");
      out.write("                                <li > <a id=\"iten1\" href=\"cadastro.jsp\">Cadastrar Funcionario</a></li>\n");
      out.write("                                <li ><a id=\"iten1\" href=\"cad_professor.jsp\">Cadastrar Docente</a></li>\n");
      out.write("                                <li ><a id=\"iten1\" href=\"cad_estudante.jsp\">Cadastrar Estudante</a></li>\n");
      out.write("                                <li ><a id=\"iten1\" href=\"cad_disc.jsp\">Registro de Disciplina</a></li>\n");
      out.write("                                <li ><a id=\"iten1\" href=\"cad_curso.jsp\">Registro de CURSO</a></li>\n");
      out.write("                                <li ><a href=\"cursos.jsp\">Lancar Notas</a></li>\n");
      out.write("                                <li><a href=\"login.jsp\">Sair</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>      \n");
      out.write("                     </li>\t\n");
      out.write("                   </ul>\n");
      out.write("\t\t</div>\n");
      out.write("\t</nav>\n");
      out.write("     </header>\n");
      out.write("        \n");
      out.write("           \n");
      out.write("        <script>\n");
      out.write("            document.getElementById(\"lista\").style=\"display:none\";\n");
      out.write("            function verlista( num )\n");
      out.write("            {\n");
      out.write("              if(num==1){\n");
      out.write("                  document.getElementById(\"lista\").style=\"transition:1s\";\n");
      out.write("                 document.getElementById(\"lista\").style=\"display:visible\";\n");
      out.write("                 \n");
      out.write("             }\n");
      out.write("              else if(num==2)\n");
      out.write("                  document.getElementById(\"lista\").style=\"display:none\";\n");
      out.write("             \n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("\n");
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
