package com.agroecoalmacen.web;

import com.agroecoalmacen.Planta;
import com.agroecoalmacen.PlantaDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/PlantaServlet")
public class PlantaServlet extends HttpServlet {

    private PlantaDAO dao;

    @Override
    public void init() throws ServletException {
        dao = new PlantaDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Planta> lista = dao.listarPlantas();

        request.setAttribute("plantas", lista);
        request.getRequestDispatcher("listarPlantas.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String nombre = request.getParameter("nombre");
        String nombreCientifico = request.getParameter("nombreCientifico");
        String tipo = request.getParameter("tipo");
        String fecha = request.getParameter("fecha");
        String etapa = request.getParameter("etapa");
        String estado = request.getParameter("estado");

        Planta nueva = new Planta(0, nombre, nombreCientifico, tipo, fecha, etapa, estado);

        dao.agregarPlanta(nueva);

        response.sendRedirect("PlantaServlet");
    }
}
