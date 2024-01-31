<%-- 
    Document   : cad_disc
    Created on : 29/mai/2022, 21:50:42
    Author     : chags
--%>

<%@page import="daoCurso.DisciplinaDAO"%>
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
        <h1>CADASTRAR DISCIPLINA</h1>
        <form method="post" action="cad_disc">
            
        <input type="text" class="ipt" id="ipt1" placeholder="Nome Do Disciplina" name="disc" >  <br/><br/>
        <input type="number" class="ipt" id="ipt1" placeholder="Ano" name="ano" ><br/><br/>
                       <%
                        CursoDAO fd=new CursoDAO();      
                             ResultSet rz = fd.buscarTodos();
                   %>
			<select class="ipt" id="ipt7" name="curso">
                            <%while(rz.next()){%>
                            <option><%=rz.getString("nome") %></option>
                            <%}%>
                                
			</select><br/><br/>
        <button>CADASTRAR</button>
        </form><br/><br/>
        <span><a href="telaprincipal.jsp">Voltar</a></span><br/><br/>
     <table>
         <p class="volta"><a >Voltar Para Tela Principal</a></p>
         <thead>
        <th>ID_DISCIPLINA</th>
        <th>DISCIPLINA</th>
        <th>CURSO</th>
        <th>ANO</th>
        <th>DELETAR/EDITAR</th>
        </thead>
             <%
                 DisciplinaDAO f=new DisciplinaDAO(); 
                       
             ResultSet r=f.buscarTodos();
            while(r.next()) {
        %>
       
        <tr><td><%=r.getInt("id_disc")%></td><td><%=r.getString("nome")%></td><td><%=r.getString("curso")%></td><td><%=r.getInt("ano")%></td>
               <td>
                   <a href="excluir_disc?id=<%=r.getInt("id_disc")%>">Deletar</a>
                    <a href="edit_disc.jsp?id=<%=r.getInt("id_disc")%>">Editar</a>
                   </td>  
           </tr>  
         <%}
         %>
       </table>
    </body>
</html>
