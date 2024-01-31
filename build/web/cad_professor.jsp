<%-- 
    Document   : cad_professor
    Created on : 28/mai/2022, 17:48:57
    Author     : chags
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="daoProfessor.ProfessorDAO"%>
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
        <h1>CADASTRAR PROFESSOR</h1>
        <form method="post" action="cad_professor">
                    
			<input type="text" class="ipt" id="ipt1" placeholder="Nome Completo" name="nome" >  
                        <input type="text" class="ipt" id="ipt1" placeholder="Telefone" name="tel" >  
			<select name="turno">
                            <option>Diurno</option>
                             <option>Nocturno</option>
                        </select>
                        
                         <%                
                          ProfessorDAO fd=new ProfessorDAO();                  
                          ResultSet rz = fd.selcurso(); 
                          ResultSet rs = fd.disciplina();
                          %>
			<select class="ipt" id="ipt7" name="curso">
                            <%while(rz.next()){%>
                            <option><%=rz.getString("nome") %></option>
                            <%}%>
                            </select>
                      
			<select class="ipt" id="ipt7" name="disc">
                            <%while(rs.next()){%>
                            <option><%=rs.getString("nome") %></option>
                            <%}%>
                            </select>
                        <select name="especialidade">
                            <option>Matematica</option>
                             <option>Portugues</option>
                        </select>
                            <button>Cadastrar</button>>
              
	</form>		
                            <p class="volta"><a >Voltar Para Tela Principal</a></p>
                     <h2>Listar</h2>
    
        <table>
         <thead>
        <th>ID</th>
        <th>NOME</th>
        <th>TURNO</th>
         <th>CURSO</th>
         <th>DISCIPLINA</th>
        <th>DELETAR/EDITAR</th>
        </thead>
       
             <%
             ResultSet r=fd.buscarTodos() ;
            while(r.next()) {
        %>
       
        <tr><td><%=r.getInt("numero_fun")%></td><td><%=r.getString("nome")%></td><td><%=r.getString("turno")%>
               </td><td><%=r.getString("curso")%></td>
               <td><%=r.getString("Disciplina")%></td>
               <td>
                   <a href="excluir_prof?id=<%=r.getInt("numero_fun")%>">Deletar</a>
                    <a href="edit_prof.jsp?id=<%=r.getInt("numero_fun")%>">Editar</a>
                   </td>  
           </tr>  
         <%}
         %>
       </table>
    </body>
</html>
