<%-- 
    Document   : editar_funcio
    Created on : 28/mai/2022, 10:54:16
    Author     : chags
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelofuncionario.Funcionario"%>
<%@page import="daofuncionario.FuncionarioDAO"%>
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
        <h1>EDITAR FUNCIONARIO</h1>
        <%FuncionarioDAO fun =new FuncionarioDAO();
        Funcionario f=new Funcionario();
        
        f=fun.buscaporid(Integer.parseInt(request.getParameter("id").toString()));
        %>
               <form  method="post" action="excluir_fun">
        <header>
        	<p id="title1" class="txt">Cadastramento</p>
	</header>
<center>
    <section>
		<nav><p id="txt_leg1" class="txt"></p></nav>
		<aside id="l1">
		
			<input type="text" class="ipt" id="ipt1" placeholder="Nome Completo" name="nome" value="<%=f.getNome() %>">
			<input type="text" class="ipt" id="ipt2" placeholder="Email" name="email" value="<%=f.getEmail() %>" >
			<input type="text" class="ipt" id="ipt3" placeholder="Telefone" name="tel" value="<%=f.getTelefone() %>" >
			<input type="text" class="ipt" id="ipt4" placeholder="Codigo" name="codigo" value="<%=f.getId_funcionario() %>">
			<input type="text" class="ipt" id="ipt5" placeholder="Salário" name="salario" value="<%=f.getSalario() %>">
			<select class="ipt" id="ipt6"  >
				<option>Gestor/a</option>
				<option>Professor/a</option>
			</select>
                        <select class="ipt" id="ipt7"  name="funcao">
                            <option selected><%=f.getFuncao() %></option>
				<option>Função</option>
                                <option>Dar Aula</option>
                                <option>Administrar</option>
                                <option>Gerir</option>
                                <option></option>
			</select>
			<select class="ipt" id="ipt8"  name="area">
                                <option selected><%=f.getArea() %></option>
				<option>Area</option>
                                <option>Administrativa</option>
                                <option>Academica</option>
			</select>
			<button id="btn2">Cadastrar</button>
		</aside>
		<aside id="l2">
		</aside>
    </section>
</center>
        </form>
                                <p class="volta"><a >Voltar Para Tela Principal</a></p>
    </body>
</html>
