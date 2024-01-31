<%-- 
    Document   : Lancar_nota
    Created on : 30/mai/2022, 0:16:28
    Author     : chags
--%>

<%@page import="daoEstudante.NotasDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="modelofuncionario.Disciplina"%>
<%@page import="daoCurso.DisciplinaDAO"%>
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
        <header>
        	<p id="title1" class="txt">LANÇAMENTO DE NOTAS</p>
	</header>
        <form  method="post" action="nota">
        

		<nav><p id="txt_leg1" class="txt"></p></nav>
		
			</div>
                          <%
                        DisciplinaDAO fd=new DisciplinaDAO();   
                        Disciplina f=new Disciplina();
                        f.setAno(DisciplinaDAO.ano);
                        f.setidCurso(DisciplinaDAO.id);
                       //DisciplinaDAO.idaluno=Integer.parseInt(request.getParameter("id"));
                        ResultSet rz = fd.DisciplinaAnoCurso(f);
                   %>
			<select class="ipt" id="ipt7" name="disc">
                            <%while(rz.next()){%>
                            <option><%=rz.getString("nome") %></option>
                            <%}%>
			
                    <input type="text" class="ipt" id="ipt1" placeholder="1 parcelar" name="p_parc" /> 
                    <input type="text" class="ipt" id="ipt1" placeholder="2 Parcelar" name="ps"/>  
                    <input type="text" class="ipt" id="ipt1" placeholder="Exame" name="exame" /> 
                    <input type="text" class="ipt" id="ipt1" placeholder="Recurso" name="rec" />
	            <input type="text" class="ipt" id="ipt1" placeholder="eExtraordinario" name="extra" />
                    <input type="number" Placeholder="ID" name="id">
			
			<button> REGITRAR</button>
        </form><br/><br/>
                            
         <table>
     
         <thead>
        <th>ID</th>
        <th>1 PARCELAR</th>
        <th>2 PARCELAR</th>
        <th>EXAME</th>
        <th>RECURSO</th>
        <th>EXTRAORDINARIO</th>
        <th>ANO</th>
        </thead>
             <%
                 NotasDAO fZ=new NotasDAO(); 
                       
             ResultSet r=fZ.buscarTodos(Integer.parseInt(session.getAttribute("idest").toString()));
            while(r.next()) {
        %>
       
        <tr><td><%=r.getInt("id_nota")%></td><td><%=r.getString("pri_parcelar")%></td><td><%=r.getString("seg_parcelar")%></td>
           <td><%=r.getString("exame")%></td><td><%=r.getString("recurso")%></td><td><%=r.getString("extraordinario")%></td><td><%=r.getInt("ano")%></td>
               <td>
                   
                   </td>  
           </tr>  
         <%}
         %>
       </table>
       <a href="imprensao" class="botao2">Imprimir</a>
    </body>
</html>
