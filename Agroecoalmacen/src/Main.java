package com.agroecoalmacen;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Probando conexión con la base de datos...\n");
        PlantaDAO dao = new PlantaDAO();

        // Definir plantas
        Planta[] plantas = {
            new Planta(0, "Echeveria Iris", "Echeveria sp.", "Suculenta", "2024-05-01", "Etapa 1", "planta"),
            new Planta(0, "Punto Rojo", "Acalypha sp.", "Ornamental", "2024-05-01", "Etapa 3", "planta"),
            new Planta(0, "Pitahaya", "Hylocereus sp.", "Frutal", "2024-05-01", "Etapa 1", "planta"),
            new Planta(0, "Pimentón Morrón", "Capsicum annuum", "Hortaliza", "2024-05-15", "Etapa 2", "planta"),
            new Planta(0, "Limonero", "Citrus limon", "Frutal", "2024-05-01", "Etapa 1", "planta")
        };

        // Insertar plantas evitando duplicados
        for (Planta p : plantas) {
            if (dao.existePlanta(p.getNombreComun())) {
                System.out.println("La planta '" + p.getNombreComun() + "' ya existe, no se agregará.");
            } else {
                if (dao.agregarPlanta(p)) {
                    System.out.println("Planta agregada correctamente. ID=" + p.getId());
                }
            }
        }

        // Listar todas las plantas
        System.out.println("\nListado de plantas:");
        List<Planta> lista = dao.listarPlantas();
        for (Planta p : lista) {
            System.out.println(p);
        }

        // Buscar la última planta agregada
        Planta ultima = lista.get(lista.size() - 1);
        Planta buscada = dao.buscarPorId(ultima.getId());
        System.out.println("\nBuscada por id: " + (buscada != null ? buscada : "No encontrada"));

        // Actualizar estado
        if (buscada != null) {
            buscada.setEstado("floracion");
            boolean ok = dao.actualizarPlanta(buscada);
            System.out.println("\nActualizar: " + (ok ? "OK" : "FALLÓ"));
        }
    }
}
