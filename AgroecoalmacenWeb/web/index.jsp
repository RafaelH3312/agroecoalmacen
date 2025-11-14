<%-- 
    Document   : index
    Created on : 14/11/2025, 1:06:35 p. m.
    Author     : Caos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
<html>
<head><title>Agroecoalmacen</title></head>
<body>
<h2>Bienvenido al módulo web de Plantas</h2>
<form action="PlantaServlet" method="post">
    Nombre de la planta: <input type="text" name="nombre"><br>
    Tipo: <input type="text" name="tipo"><br>
    <input type="submit" value="Agregar Planta">
</form>
</body>
</html>
