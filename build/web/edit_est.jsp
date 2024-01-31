<%-- 
    Document   : edit_est
    Created on : 28/mai/2022, 16:42:53
    Author     : chags
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="modelofuncionario.Estudante"%>
<%@page import="daoEstudante.EstudanteDAO"%>
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
           <h1>EDITAR ESTUDANTE</h1>
        <%
          EstudanteDAO fun =new EstudanteDAO();
          Estudante f=new Estudante();
        
        f=fun.buscaporid(Integer.parseInt(request.getParameter("id").toString()));
          f.setIdAluno(Integer.parseInt(request.getParameter("id").toString()));
        %>
      <form  method="post" action="excluir_estudan">
        <header>
        	<p id="title1" class="txt">Cadastramento</p>
	</header>
<center>
    <section>
		<nav><p id="txt_leg1" class="txt"></p></nav>
		<aside id="l1">
			<div id="cad_aln">
				
			</div>
                        <input type="text" class="ipt" id="ipt1" placeholder="Id" name="id" value="<%=f.getIdAluno()%>">
			<input type="text" class="ipt" id="ipt1" placeholder="Nome Completo" name="nome" value="<%=f.getNome()%>">  
			<input type="text" class="ipt" id="ipt3" placeholder="Telefone" name="tel" value="<%=f.getTelefone()%>" >
			<input type="text" class="ipt" id="ipt4"                  name="curso" value="<%=f.getCurso()%>">
			<input type="number"  name="ano" value="<%=f.getAno()%>">
			
                        <select class="ipt" id="ipt6" name="turno">
				<option>Diurno</option>
				<option>Nocturno</option>
			</select>
                        
                     <select class="ipt" id="ipt6"  name="turma">
                            <option selected><%=f.getTurma()%></option>
                         <%
                        EstudanteDAO fd=new EstudanteDAO();  
                             ResultSet rz = fd.selturma();
                            %>
				<%while(rz.next()){%>
                                <option><%=rz.getString("n_turma")%></option>
                                        <%}%>
			       </select>
			
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
