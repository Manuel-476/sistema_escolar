<%-- 
    Document   : principal
    Created on : 1/abr/2022, 13:17:47
    Author     : MUENDO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta name="viewport" content="width=divice-width, user-scalable=yes, initial-scale=1, maximun-scale=1, minimun-scale=1">
      	
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/telap.css" rel="stylesheet" type="text/css"/>
        <title>Tela Principal</title>
    </head>
    <body>
        <% if(session.getAttribute("email")==null)
             response.sendRedirect("tLogin.jsp");
        %>
        	
	

        <header>
	
            <div class="logo">
              <img src="imagens/transferir.jpeg" alt="" width="80"/>  
            </div>
            
            <nav>
		<div id="menu">
                    <ul>
			<li class="iten" id="l1" >
                            <img src="imagens/transferir.png" id="cad" onmousemove="verlista(1)" onmouseleave="verlista(2)" alt="Cadastrar" width="80"/>
                            <ul id="lista" onmousemove="verlista(1)" onmouseleave="verlista(2)">
                                <li > <a id="iten1" href="cadastro.jsp">Cadastrar Funcionario</a></li>
                                <li ><a id="iten1" href="cad_professor.jsp">Cadastrar Docente</a></li>
                                <li ><a id="iten1" href="cad_estudante.jsp">Cadastrar Estudante</a></li>
                                <li ><a id="iten1" href="cad_disc.jsp">Registro de Disciplina</a></li>
                                <li ><a id="iten1" href="cad_curso.jsp">Registro de CURSO</a></li>
                                <li ><a href="cursos.jsp">Lancar Notas</a></li>
                                <li><a href="login.jsp">Sair</a></li>
                            </ul>
                        </li>      
                     </li>	
                   </ul>
		</div>
	</nav>
     </header>
        
           
        <script>
            document.getElementById("lista").style="display:none";
            function verlista( num )
            {
              if(num==1){
                  document.getElementById("lista").style="transition:1s";
                 document.getElementById("lista").style="display:visible";
                 
             }
              else if(num==2)
                  document.getElementById("lista").style="display:none";
             
            }
        </script>

    </body>
</html>
