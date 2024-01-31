<%-- 
    Document   : cad_admin
    Created on : 28/mai/2022, 9:57:47
    Author     : chags
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/logincss.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
     
          <form class="form" action="cadast_admin" method="post">
              <p><img src="imagens/Logo.Isppk.jpg" alt="" width="100px"/></p>
              <h1>CADASTRAR</h1>
            <input type="text" placeholder="Nome Completo" name="nome"><br/><br/>
            <input type="email" placeholder="Email" name="email"> <br/><br/>
            <input type="password" placeholder="Senha" name="senha"><br/><br/>
            <button type="submit">CASDASTRAR</button> <br/>
            <a href="tLogin.jsp">Fazer Login</a>
            </form>
        
    </body>
</html>
