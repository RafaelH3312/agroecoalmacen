package com.agroecoalmacen.web;

import com.agroecoalmacen.Planta;
import com.agroecoalmacen.PlantaDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/PlantaServlet")
public class PlantaServlet extends HttpServlet {

    private PlantaDAO dao;

    @Override
    public void init() throws ServletException {
        dao = new PlantaDAO(); // Inicializa el DAO al iniciar el servlet
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Listado de Plantas</title></head><body>");
        out.println("<h1>Listado de Plantas</h1>");

        List<Planta> lista = dao.listarPlantas();
        out.println("<ul>");
        for (Planta p : lista) {
            out.println("<li>" + p + "</li>");
        }
        out.println("</ul>");

        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        // Obtener parámetros del formulario
        String nombre = request.getParameter("nombre");
        String nombreCientifico = request.getParameter("nombreCientifico");
        String tipo = request.getParameter("tipo");
        String fecha = request.getParameter("fecha");
        String etapa = request.getParameter("etapa");
        String estado = request.getParameter("estado");

        Planta nueva = new Planta(0, nombre, nombreCientifico, tipo, fecha, etapa, estado);

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Agregar Planta</title></head><body>");

        if (dao.existePlanta(nombre)) {
            out.println("<p>La planta '" + nombre + "' ya existe, no se agregará.</p>");
        } else if (dao.agregarPlanta(nueva)) {
            out.println("<p>Planta agregada correctamente. ID=" + nueva.getId() + "</p>");
        } else {
            out.println("<p>Error al agregar la planta.</p>");
        }

        out.println("<p><a href=\"PlantaServlet\">Volver al listado</a></p>");
        out.println("</body></html>");
    }
}
