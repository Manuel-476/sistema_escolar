package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import daoCurso.CursoDAO;
import java.sql.ResultSet;

public final class cad_005fcurso_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"css/generico.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>CADASTRAR CURSO</h1>\n");
      out.write("        <form method=\"post\" action=\"cad_curso\">\n");
      out.write("            \n");
      out.write("        <input type=\"text\" class=\"ipt\" id=\"ipt1\" placeholder=\"Nome Do curso\" name=\"curso\" >  \n");
      out.write("        <input type=\"number\" class=\"ipt\" id=\"ipt1\" placeholder=\"Anos\" name=\"anos\" >\n");
      out.write("        <select name=\"faculdade\">\n");
      out.write("            <option>Tecnologica</option>\n");
      out.write("            <option>Saude</option>\n");
      out.write("            <option>Ciencias Socias</option>\n");
      out.write("        </select>\n");
      out.write("        <button>CADASTRAR</button>\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("         \n");
      out.write("     \n");
      out.write("        <table>\n");
      out.write("     \n");
      out.write("         <thead>\n");
      out.write("        <th>ID_CURSO</th>\n");
      out.write("        <th>CURSO</th>\n");
      out.write("        <th>ANO</th>\n");
      out.write("        <th>FACULDADE</th>\n");
      out.write("        <th>DELETAR/EDITAR</th>\n");
      out.write("        </thead>\n");
      out.write("             ");

                 CursoDAO f=new CursoDAO(); 
                       
             ResultSet r=f.buscarTodosano();
            while(r.next()) {
        
      out.write("\n");
      out.write("       \n");
      out.write("        <tr><td>");
      out.print(r.getInt("id_curso"));
      out.write("</td><td>");
      out.print(r.getString("nome"));
      out.write("</td><td>");
      out.print(r.getInt("ano"));
      out.write("</td><td>");
      out.print(r.getString("faculdade"));
      out.write("</td>\n");
      out.write("               <td>\n");
      out.write("                   <a href=\"excluir_curso?id=");
      out.print(r.getInt("id_curso"));
      out.write("\">Deletar</a>\n");
      out.write("                    <a href=\"edit_curso.jsp?id=");
      out.print(r.getInt("id_curso"));
      out.write("\">Editar</a>\n");
      out.write("                   </td>  \n");
      out.write("           </tr>  \n");
      out.write("         ");
}
         
      out.write("\n");
      out.write("       </table>\n");
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