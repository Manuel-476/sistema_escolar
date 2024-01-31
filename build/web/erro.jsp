<%-- 
    Document   : erro
    Created on : 28/mar/2022, 22:26:08
    Author     : MUENDO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/estilos.css" class="css">
        <title>Tela Login</title>
    </head>
    <body>
        <form class="form" action="Alternativo" method="post">
		<div class="card">
            <div class="card-top">
              <h2 class="title">ISPPKILAMBA</h2>
                <p></p>
            </div>
              <h2  style=" color: red;"> O seu Email ou Senha esta Errado/a!</h2>       
        <div class="card-group">
            <label>Email</label>
            <input type="email" name="email">
        </div>
        <div class="card-group">
            <label>Senha</label>
            <input type="password" name="senha">
        </div>
        <div class="card-group">
            <label><input type="checkbox">Lembre-me</label>   
        </div>
        <div class="card-group btn">
            <button type="submit">ACESSAR</button> <br>
            <button type="reset">LIMPAR</button> <br>
        </form>
    </body>
</html>
