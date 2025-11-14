package com.agroecoalmacen;

public class Planta {
    private int id;
    private String nombreComun;
    private String nombreCientifico;
    private String tipo;
    private String fechaIngreso;
    private String ubicacion;
    private String estado;

    //  Constructor vacío
    public Planta() {}

    //  Constructor completo
    public Planta(int id, String nombreComun, String nombreCientifico, String tipo,
                  String fechaIngreso, String ubicacion, String estado) {
        this.id = id;
        this.nombreComun = nombreComun;
        this.nombreCientifico = nombreCientifico;
        this.tipo = tipo;
        this.fechaIngreso = fechaIngreso;
        this.ubicacion = ubicacion;
        this.estado = estado;
    }

    //  Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombreComun() { return nombreComun; }
    public void setNombreComun(String nombreComun) { this.nombreComun = nombreComun; }

    public String getNombreCientifico() { return nombreCientifico; }
    public void setNombreCientifico(String nombreCientifico) { this.nombreCientifico = nombreCientifico; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getFechaIngreso() { return fechaIngreso; }
    public void setFechaIngreso(String fechaIngreso) { this.fechaIngreso = fechaIngreso; }

    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return id + " - " + nombreComun + " (" + estado + ")";
    }
}