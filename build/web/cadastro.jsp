<%-- 
    Document   : cadastro
    Created on : 11/abr/2022, 19:05:01
    Author     : MUENDO
--%>

<%@page import="java.util.List"%>
<%@page import="daofuncionario.FuncionarioDAO"%>
<%@page import="modelofuncionario.Funcionario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <!-- <link rel="stylesheet" href="css/tprincipal.css">-->
        <title>Cadastrar Funcionario</title>
        <link href="css/generico.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <% if(session.getAttribute("email")==null)
             response.sendRedirect("tLogin.jsp");
        %>
        <header>
        	<h1>CADASTRAR FUNCIONARIO</h1>
	</header>
        <form  method="post" action="cadastramento">
        

		<nav><p id="txt_leg1" class="txt"></p></nav>
		<aside id="l1">
			
			<input type="text" class="ipt" id="ipt1" placeholder="Nome Completo" name="nome">
			<input type="text" class="ipt" id="ipt2" placeholder="Email" name="email">
			<input type="text" class="ipt" id="ipt3" placeholder="Telefone" name="tel">
			<input type="text" class="ipt" id="ipt4" placeholder="Codigo" name="codigo">
			<input type="text" class="ipt" id="ipt5" placeholder="Salário" name="salario">
			<select class="ipt" id="ipt6" name="area">
				<option>Gestor/a</option>
				<option>Professor/a</option>
			</select>
			<select class="ipt" id="ipt7">
				<option>Função</option>
                                <option>Dar Aula</option>
                                <option>Administrar</option>
                                <option>Gerir</option>
                                <option></option>
			</select>
			<select class="ipt" id="ipt8">
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
        <h2>Listar</h2>
    
        <table >
         <thead>
        <th>ID</th>
        <th>NOME</th>
        <th>DEPARTAMENTO</th>
        <th>DELETAR/EDITAR</th>
        </thead>
        <%List <Funcionario> lista;
        FuncionarioDAO fd=new FuncionarioDAO();
        lista=fd.buscarTodos();
        for(Funcionario f : lista) {
        %>
       
           <tr><td><%=f.getId_funcionario() %></td><td><%=f.getNome()%></td><td><%=f.getArea()%>
               </td><td>
                   <a href="excluir_fun?id=<%=f.getId_funcionario()%>">Deletar</a>
                    <a href="editar_funcio.jsp?id=<%=f.getId_funcionario()%>">Editar</a>
                   </td>
           </tr>  
         <%}%>
       </table>
      
       </form>
       <p class="volta"><a >Voltar Para Tela Principal</a></p>
	<footer>
    </footer>
    </div>
    </body>
</html>
