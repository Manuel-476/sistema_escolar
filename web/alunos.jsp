<%-- 
    Document   : alunos
    Created on : 30/mai/2022, 0:45:28
    Author     : chags
--%>

<%@page import="daoCurso.DisciplinaDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="daoEstudante.EstudanteDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <h1>ESTUDANTES DO CURSO</h1>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/generico.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <% DisciplinaDAO.ano=Integer.parseInt(request.getParameter("ano"));
           DisciplinaDAO.id=Integer.parseInt(request.getParameter("id")); 
        %>
        <table>
     
         <thead>
        <th>CURSO</th>
        <th>NOME</th>
        <th>ENTRAR</th>
        
        </thead>
             <%
            EstudanteDAO f=new EstudanteDAO(); 
                       
            ResultSet r=f.buscarTodosCursoAno(Integer.parseInt(request.getParameter("ano")));
            while(r.next()) {
        %>
       
        <tr><td><%=r.getInt("numero_id")%></td><td><%=r.getString("nome")%></td>
          <td><a href="nota?id=<%=r.getInt("numero_id")%>">ENTRAR</a></td>  
           </tr>  
         <%}
         %>
       </table>
    </body>
</html>
