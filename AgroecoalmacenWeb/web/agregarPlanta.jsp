<%-- 
    Document   : agregarPlanta
    Created on : 14/11/2025, 6:17:10 p. m.
    Author     : Caos
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8" />
    <title>Agregar Planta</title>
</head>
<body>
    <h1>Agregar Nueva Planta</h1>

    <form action="PlantaServlet" method="post">
        <label for="nombre">Nombre común:</label><br>
        <input type="text" id="nombre" name="nombre" required /><br><br>

        <label for="nombreCientifico">Nombre científico:</label><br>
        <input type="text" id="nombreCientifico" name="nombreCientifico" /><br><br>

        <label for="tipo">Tipo:</label><br>
        <input type="text" id="tipo" name="tipo" /><br><br>

        <label for="fecha">Fecha (YYYY-MM-DD):</label><br>
        <input type="date" id="fecha" name="fecha" /><br><br>

        <label for="etapa">Etapa / Ubicación:</label><br>
        <input type="text" id="etapa" name="etapa" /><br><br>

        <label for="estado">Estado:</label><br>
        <select id="estado" name="estado">
            <option value="germinacion">germinacion</option>
            <option value="plantula">plantula</option>
            <option value="planta" selected>planta</option>
            <option value="floracion">floracion</option>
            <option value="muerto">muerto</option>
        </select><br><br>

        <button type="submit">Agregar Planta</button>
    </form>

    <p><a href="PlantaServlet">Ver listado de plantas</a></p>
</body>
</html>
