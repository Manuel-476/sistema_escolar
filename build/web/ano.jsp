<%-- 
    Document   : ano
    Created on : 30/mai/2022, 0:35:16
    Author     : chags
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="daoCurso.CursoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/generico.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <H1>ANOS DO CURSO</h1>
       <table>
         <thead>
         <th>ID</th>
        <th>CURSO</th>
        <th>ANO</th>
        <th>ENTRAR</th>
        
        </thead>
             <%
            CursoDAO f=new CursoDAO(); 
                       
            ResultSet r=f.buscarTodosNome(request.getParameter("nome"));
            while(r.next()) {
        %>
       
        <tr><td><%=r.getInt("id_curso")%></td><td><%=r.getString("nome")%></td><td><%=r.getInt("ano")%></td>
          <td><a href="alunos.jsp?ano=<%=r.getInt("ano")%>&&id=<%=r.getInt("id_curso")%>">ENTRAR</a></td>  
           </tr>  
         <%}
         %>
       </table>
    </body>
</html>
