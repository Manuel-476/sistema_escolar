<%-- 
    Document   : cad_estudante
    Created on : 28/mai/2022, 13:35:54
    Author     : chags
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Servlets.cadastramento"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="daoEstudante.EstudanteDAO"%>
<%@page import="modelofuncionario.Estudante"%>
<%@page import="java.util.List"%>
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
        <h1>CADASTRAR ESTUDANTE</h1>
    
              <form  method="post" action="cad_estudante">
  
			
                       <input type="text" class="ipt" id="ipt1" placeholder="Nome Completo" name="nome">
			<input type="text" class="ipt" id="ipt3" placeholder="Telefone" name="tel">
                        <input type="number" placeholder="Ano"name="ano"></label>
			
			<select class="ipt" id="ipt6" name="turno">
				<option>Diurno</option>
				<option>Nocturno</option>
			</select>
                            <%
                        EstudanteDAO fd=new EstudanteDAO(); 
                        EstudanteDAO f=new EstudanteDAO(); 
          
           
                            
                             ResultSet rz = fd.selturma();
                   %>
			<select class="ipt" id="ipt7" name="turma">
                            <%while(rz.next()){%>
                            <option><%=rz.getString("n_turma") %></option>
                            <%}%>
                                
			</select>
			
			<button id="btn2">Cadastrar</button>
		</aside>
		<aside id="l2">
		</aside>
    </section>
</center>
        </form>
                         
        <h2>Listar</h2>
    
        <table>
         <thead>
        <th>ID</th>
        <th>NOME</th>
        <th>TURMA</th>
         <th>ANO</th>
         <th>CURSO</th>
        <th>DELETAR/EDITAR</th>
        </thead>
       
             <%
             ResultSet r=f.buscarTodos();
            while(r.next()) {
        %>
       
        <tr><td><%=r.getInt("numero_id")%></td><td><%=r.getString("nome")%></td><td><%=r.getString("turma")%>
               </td><td><%=r.getInt("ano")%></td>
               <td><%=r.getString("curso")%></td>
               <td>
                   <a href="excluir_estudan?id=<%=r.getInt("numero_id")%>">Deletar</a>
                    <a href="edit_est.jsp?id=<%=r.getInt("numero_id")%>">Editar</a>
                   </td>  
           </tr>  
         <%}
         %>
       </table>
      
       </form>
       <p class="volta"><a >Voltar Para Tela Principal</a></p>
    </body>
</html>
