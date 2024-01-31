<%-- 
    Document   : edit_disc
    Created on : 29/mai/2022, 23:51:47
    Author     : chags
--%>

<%@page import="daoCurso.CursoDAO"%>
<%@page import="daoCurso.DisciplinaDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="daoCurso.DisciplinaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/generico.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <% if(session.getAttribute("email")==null)
             response.sendRedirect("tLogin.jsp");
        %>
        <%
           DisciplinaDAO fun =new DisciplinaDAO();
           ResultSet f=fun.buscaporid(Integer.parseInt(request.getParameter("id").toString()));
        
        %>
      <form  method="post" action="excluir_disc">
        <header>
        	<p id="title1" class="txt">Cadastramento</p>
	</header>

		<nav><p id="txt_leg1" class="txt"></p></nav>
		
			</div>
                    <%while(f.next()){%>
                    <input type="text" class="ipt" id="ipt1" placeholder="Id" name="id" value="<%=f.getInt("id_disc") %>">
                    <input type="text" class="ipt" id="ipt1" placeholder="Curso" name="disc" value="<%=f.getString("nome") %>">  
                    <input type="text" class="ipt" id="ipt1" placeholder="Curso" name="ano" value="<%=f.getString("ano") %>"> 
			<%}%>
			      <%
                        CursoDAO fd=new CursoDAO();      
                             ResultSet rz = fd.buscarTodos();
                   %>
			<select class="ipt" id="ipt7" name="curso">
                            <%while(rz.next()){%>
                            <option><%=rz.getString("nome") %></option>
                            <%}%>
			
			<input type="submit" value="EDITAR">
		
        </form>
                            <p class="volta"><a href="telaprincipal.jsp">Voltar Para Tela Principal</a></p>
    </body>
</html>
