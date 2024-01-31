<%-- 
    Document   : edit_curso
    Created on : 29/mai/2022, 20:53:27
    Author     : chags
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="modelofuncionario.Curso"%>
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
        <% if(session.getAttribute("email")==null)
             response.sendRedirect("tLogin.jsp");
        %>
         <%
          CursoDAO fun =new CursoDAO();
           ResultSet f=fun.buscaporid(Integer.parseInt(request.getParameter("id").toString()));
        
        %>
      <form  method="post" action="excluir_curso">
        <header>
        	<p id="title1" class="txt">Cadastramento</p>
	</header>
<center>
    <section>
		<nav><p id="txt_leg1" class="txt"></p></nav>
		<aside id="l1">
			<div id="cad_aln">
			
			</div>
                    <%while(f.next()){%>
                    <input type="text" class="ipt" id="ipt1" placeholder="Id" name="id" value="<%=f.getInt("id_curso") %>">
                    <input type="text" class="ipt" id="ipt1" placeholder="Curso" name="curso" value="<%=f.getString("nome") %>">  
                    <select name="faculdade"> 
                        <option selected><%=f.getString("faculdade") %>" </option>
                        <option>Saude</option>
                         <option>Ciencias Socias</option>
                    </select>
			<%}%>
			
			

			
			<button id="btn2">EDITAR</button>
		</aside>
		<aside id="l2">
		</aside>
              </section>
           </center>
        </form>
                        <p class="volta"><a >Voltar Para Tela Principal</a></p>
    </body>
</html>
