package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class erro_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/estilos.css\" class=\"css\">\n");
      out.write("        <title>Tela Login</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form class=\"form\" action=\"Alternativo\" method=\"post\">\n");
      out.write("\t\t<div class=\"card\">\n");
      out.write("            <div class=\"card-top\">\n");
      out.write("            \n");
      out.write("                <h2 class=\"title\">ISPPKILAMBA</h2>\n");
      out.write("                <p></p>\n");
      out.write("            </div>\n");
      out.write("              <h2  style=\" color: red;\"> O seu Email ou Senha esta Errado/a!</h2>       \n");
      out.write("        <div class=\"card-group\">\n");
      out.write("            <label>Email</label>\n");
      out.write("            <input type=\"email\" name=\"email\">\n");
      out.write("        </div>\n");
      out.write("        <div class=\"card-group\">\n");
      out.write("            <label>Senha</label>\n");
      out.write("            <input type=\"password\" name=\"senha\">\n");
      out.write("        </div>\n");
      out.write("        <div class=\"card-group\">\n");
      out.write("            <label><input type=\"checkbox\">Lembre-me</label>   \n");
      out.write("        </div>\n");
      out.write("        <div class=\"card-group btn\">\n");
      out.write("            <button type=\"submit\">ACESSAR</button> <br>\n");
      out.write("            <button type=\"reset\">LIMPAR</button> <br>\n");
      out.write("        </form>\n");
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
