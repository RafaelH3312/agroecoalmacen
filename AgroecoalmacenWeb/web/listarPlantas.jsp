<%@ page import="java.util.List" %>
<%@ page import="com.agroecoalmacen.Planta" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Listado de Plantas</title>
</head>
<body>

    <h1>Listado de Plantas</h1>

    <%
        List<Planta> plantas = (List<Planta>) request.getAttribute("plantas");
    %>

    <%
        if (plantas == null || plantas.isEmpty()) {
    %>
        <p>No hay plantas registradas.</p>
    <%
        } else {
    %>

    <table border="1" cellpadding="6" cellspacing="0">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombre común</th>
                <th>Nombre científico</th>
                <th>Tipo</th>
                <th>Fecha ingreso</th>
                <th>Etapa</th>
                <th>Estado</th>
            </tr>
        </thead>

        <tbody>
        <%
            for (Planta p : plantas) {
        %>
            <tr>
                <td><%= p.getId() %></td>
                <td><%= p.getNombre() %></td>
                <td><%= p.getNombreCientifico() %></td>
                <td><%= p.getTipo() %></td>
                <td><%= p.getFecha() %></td>
                <td><%= p.getEtapa() %></td>
                <td><%= p.getEstado() %></td>
            </tr>
        <%
            }
        %>
        </tbody>
    </table>

    <%
        }
    %>

    <p><a href="agregarPlanta.jsp">Agregar otra planta</a></p>

</body>
</html>
