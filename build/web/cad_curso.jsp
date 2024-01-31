<%-- 
    Document   : cad_curso
    Created on : 29/mai/2022, 18:48:05
    Author     : chags
--%>

<%@page import="daoCurso.CursoDAO"%>
<%@page import="java.sql.ResultSet"%>
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
        <h1>CADASTRAR CURSO</h1>
        
        <form method="post" action="cad_curso">
            
        <input type="text" class="ipt" id="ipt1" placeholder="Nome Do curso" name="curso" >  <br/><br/>
        <input type="number" class="ipt" id="ipt1" placeholder="Anos" name="anos" ><br/><br/>
        <select name="faculdade">
            <option>Tecnologica</option>
            <option>Saude</option>
            <option>Ciencias Socias</option>
        </select><br/><br/>
        <button>CADASTRAR</button>
        </form><br/><br/>
        <span><a href="telaprincipal.jsp">Voltar</a></span>
        <br/><br/>
         
     
        <table>
         <thead>
        <th>ID_CURSO</th>
        <th>CURSO</th>
        <th>ANO</th>
        <th>FACULDADE</th>
        <th>DELETAR/EDITAR</th>
        </thead>
             <%
                 CursoDAO f=new CursoDAO(); 
                       
             ResultSet r=f.buscarTodosano();
            while(r.next()) {
        %>
       
        <tr><td><%=r.getInt("id_curso")%></td><td><%=r.getString("nome")%></td><td><%=r.getInt("ano")%></td><td><%=r.getString("faculdade")%></td>
               <td>
                   <a href="excluir_curso?id=<%=r.getInt("id_curso")%>">Deletar</a>
                    <a href="edit_curso.jsp?id=<%=r.getInt("id_curso")%>">Editar</a>
                   </td>  
           </tr>  
         <%}
         %>
       </table>
       
    </body>
</html>
