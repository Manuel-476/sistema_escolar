<%-- 
    Document   : edit_prof
    Created on : 29/mai/2022, 18:35:52
    Author     : chags
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="modelofuncionario.Professor"%>
<%@page import="daoProfessor.ProfessorDAO"%>
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
        <h1>EDITAR PROFESSOR</h1>
        <%
          ProfessorDAO fun =new ProfessorDAO();
          Professor f=new Professor();
        
        f=fun.buscaporid(Integer.parseInt(request.getParameter("id").toString()));
          f.setIdProf(Integer.parseInt(request.getParameter("id").toString()));
        %>
      <form  method="post" action="excluir_estudan">
        <header>
        	<p id="title1" class="txt">Cadastramento</p>
	</header>
<center>
    <section>
		<nav><p id="txt_leg1" class="txt"></p></nav>
		<aside id="l1">
			
                        <input type="text" class="ipt" id="ipt1" placeholder="Id" name="id" value="<%=f.getIdProf() %>">
			<input type="text" class="ipt" id="ipt1" placeholder="Nome Completo" name="nome" value="<%=f.getNome()%>">  
			<input type="text" class="ipt" id="ipt3" placeholder="Telefone" name="tel" value="<%=f.getTelefone()%>" >
			
			
			
                        <select class="ipt" id="ipt6" name="turno">
				<option>Diurno</option>
				<option>Nocturno</option>
			</select>
                        
                     <select class="ipt" id="ipt6"  name="curso">
                            <option selected><%=f.getCurso()%></option>
                         <%
                          
                             ResultSet rz = fun.selcurso();
                             ResultSet rs=fun.disciplina();
                            %>
				<%while(rz.next()){%>
                                <option><%=rz.getString("nome")%></option>
                                        <%}%>
			       </select>
                               <select class="ipt" id="ipt6"  name="disc">
                            <option selected><%=f.getDisciplina()%></option>
                               <%while(rs.next()){%>
                                <option><%=rs.getString("nome")%></option>
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
