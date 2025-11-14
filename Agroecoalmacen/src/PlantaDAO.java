package com.agroecoalmacen;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlantaDAO {

    private Connection conn;

    public PlantaDAO() {
        conn = ConexionBD.getConnection();
    }

    // Verificar si existe planta
    public boolean existePlanta(String nombreComun) {
        String sql = "SELECT COUNT(*) FROM organismos WHERE nombre_comun = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nombreComun);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.out.println("Error al verificar planta existente: " + e.getMessage());
        }
        return false;
    }

    // Agregar planta
    public boolean agregarPlanta(Planta p) {
        String sql = "INSERT INTO organismos(nombre_comun, nombre_cientifico, tipo, fecha_ingreso, ubicacion, estado) VALUES (?,?,?,?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, p.getNombreComun());
            ps.setString(2, p.getNombreCientifico());
            ps.setString(3, p.getTipo());
            ps.setString(4, p.getFechaIngreso());
            ps.setString(5, p.getUbicacion());
            ps.setString(6, p.getEstado());
            int rows = ps.executeUpdate();
            if (rows > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) p.setId(rs.getInt(1));
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error al agregar planta: " + e.getMessage());
        }
        return false;
    }

    // Listar plantas
    public List<Planta> listarPlantas() {
        List<Planta> lista = new ArrayList<>();
        String sql = "SELECT * FROM organismos";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Planta p = new Planta(
                    rs.getInt("id"),
                    rs.getString("nombre_comun"),
                    rs.getString("nombre_cientifico"),
                    rs.getString("tipo"),
                    rs.getString("fecha_ingreso"),
                    rs.getString("ubicacion"),
                    rs.getString("estado")
                );
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar plantas: " + e.getMessage());
        }
        return lista;
    }

    // Buscar por ID
    public Planta buscarPorId(int id) {
        String sql = "SELECT * FROM organismos WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Planta(
                    rs.getInt("id"),
                    rs.getString("nombre_comun"),
                    rs.getString("nombre_cientifico"),
                    rs.getString("tipo"),
                    rs.getString("fecha_ingreso"),
                    rs.getString("ubicacion"),
                    rs.getString("estado")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar planta: " + e.getMessage());
        }
        return null;
    }

    // Actualizar planta
    public boolean actualizarPlanta(Planta p) {
        String sql = "UPDATE organismos SET estado = ? WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getEstado());
            ps.setInt(2, p.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar planta: " + e.getMessage());
        }
        return false;
    }
}
