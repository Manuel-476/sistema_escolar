<%-- 
    Document   : tLogin
    Created on : 28/mai/2022, 8:53:59
    Author     : chags
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href0="">
        <link href="css/logincss.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        
      
        
        
          <form class="form" action="login" method="post">
           <p><img src="imagens/Logo.Isppk.jpg" alt="" width="100px"/></p>
           <h1 class="title">ENTRAR</h1>
           <input type="email" placeholder="EMAIL" name="email"> <br/><br/>
           <input type="password" placeholder="SENHA" name="senha"><br/><br/>
           <button type="submit">ENTRAR</button> <br/><br/>
           <a href="cad_admin.jsp" class="n_registro">Novo Registro</a>
            </form>
        
    </body>
</html>
