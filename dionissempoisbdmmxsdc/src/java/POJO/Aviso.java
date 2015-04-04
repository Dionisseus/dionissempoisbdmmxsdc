/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

/**
 *
 * @author Diosio
 */
public class Aviso {
    int idAviso;
    int cantidadAviso;
    float precioAviso;
    String descripcionCortaAviso;
    String descripcionAviso;
    String vigenciaAviso;
    String fechaAviso;
    String horaAviso;
    int idProductoAviso;
    boolean activoAviso;

    public Aviso(int idAviso, int cantidadAviso, float precioAviso, String descripcionCortaAviso, String descripcionAviso, String vigenciaAviso, String fechaAviso, String horaAviso, int idProductoAviso, boolean activoAviso) {
        this.idAviso = idAviso;
        this.cantidadAviso = cantidadAviso;
        this.precioAviso = precioAviso;
        this.descripcionCortaAviso = descripcionCortaAviso;
        this.descripcionAviso = descripcionAviso;
        this.vigenciaAviso = vigenciaAviso;
        this.fechaAviso = fechaAviso;
        this.horaAviso = horaAviso;
        this.idProductoAviso = idProductoAviso;
        this.activoAviso = activoAviso;
    }

    public int getIdAviso() {
        return idAviso;
    }

    public void setIdAviso(int idAviso) {
        this.idAviso = idAviso;
    }

    public int getCantidadAviso() {
        return cantidadAviso;
    }

    public void setCantidadAviso(int cantidadAviso) {
        this.cantidadAviso = cantidadAviso;
    }

    public float getPrecioAviso() {
        return precioAviso;
    }

    public void setPrecioAviso(float precioAviso) {
        this.precioAviso = precioAviso;
    }

    public String getDescripcionCortaAviso() {
        return descripcionCortaAviso;
    }

    public void setDescripcionCortaAviso(String descripcionCortaAviso) {
        this.descripcionCortaAviso = descripcionCortaAviso;
    }

    public String getDescripcionAviso() {
        return descripcionAviso;
    }

    public void setDescripcionAviso(String descripcionAviso) {
        this.descripcionAviso = descripcionAviso;
    }

    public String getVigenciaAviso() {
        return vigenciaAviso;
    }

    public void setVigenciaAviso(String vigenciaAviso) {
        this.vigenciaAviso = vigenciaAviso;
    }

    public String getFechaAviso() {
        return fechaAviso;
    }

    public void setFechaAviso(String fechaAviso) {
        this.fechaAviso = fechaAviso;
    }

    public String getHoraAviso() {
        return horaAviso;
    }

    public void setHoraAviso(String horaAviso) {
        this.horaAviso = horaAviso;
    }

    public int getIdProductoAviso() {
        return idProductoAviso;
    }

    public void setIdProductoAviso(int idProductoAviso) {
        this.idProductoAviso = idProductoAviso;
    }

    public boolean isActivoAviso() {
        return activoAviso;
    }

    public void setActivoAviso(boolean activoAviso) {
        this.activoAviso = activoAviso;
    }
    
    
    
}
