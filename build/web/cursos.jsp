<%-- 
    Document   : cursos
    Created on : 30/mai/2022, 0:22:12
    Author     : chags
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="daoCurso.CursoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/generico.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <% if(session.getAttribute("email")==null)
             response.sendRedirect("tLogin.jsp");
        %>
        <h1>CURSOS</h1>
        <table>
         <thead>
        <th>CURSO</th>
        <th>ENTRAR</th>
        
        </thead>
             <%
            CursoDAO f=new CursoDAO(); 
                       
            ResultSet r=f.buscarTodos();
            while(r.next()) {
        %>
       
        <tr><td><%=r.getString("nome")%></td><td><a href="ano.jsp?nome=<%=r.getString("nome")%>">ENTRAR</a></td>  
           </tr>  
         <%}
         %>
       </table>
       <p class="volta"><a href="telaprincipal.jsp">Voltar Para Tela Principal</a></p>
    </body>
</html>
