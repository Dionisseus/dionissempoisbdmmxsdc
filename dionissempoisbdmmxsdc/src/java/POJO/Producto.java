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
public class Producto {
    int idProducto;
    String nombreProducto;
    String descripcionProducto;
    float precioProducto;
    int existenciaProducto;
    String vigenciaProducto;
    String caracteristicaProducto;
    String fechaProducto;
    String horaProducto;
    int idUsuarioProducto;
    boolean activoProducto;

    public Producto(int idProducto, String nombreProducto, String descripcionProducto, float precioProducto, int existenciaProducto, String vigenciaProducto, String caracteristicaProducto, String fechaProducto, String horaProducto, int idUsuarioProducto, boolean activoProducto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.precioProducto = precioProducto;
        this.existenciaProducto = existenciaProducto;
        this.vigenciaProducto = vigenciaProducto;
        this.caracteristicaProducto = caracteristicaProducto;
        this.fechaProducto = fechaProducto;
        this.horaProducto = horaProducto;
        this.idUsuarioProducto = idUsuarioProducto;
        this.activoProducto = activoProducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public float getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(float precioProducto) {
        this.precioProducto = precioProducto;
    }

    public int getExistenciaProducto() {
        return existenciaProducto;
    }

    public void setExistenciaProducto(int existenciaProducto) {
        this.existenciaProducto = existenciaProducto;
    }

    public String getVigenciaProducto() {
        return vigenciaProducto;
    }

    public void setVigenciaProducto(String vigenciaProducto) {
        this.vigenciaProducto = vigenciaProducto;
    }

    public String getCaracteristicaProducto() {
        return caracteristicaProducto;
    }

    public void setCaracteristicaProducto(String caracteristicaProducto) {
        this.caracteristicaProducto = caracteristicaProducto;
    }

    public String getFechaProducto() {
        return fechaProducto;
    }

    public void setFechaProducto(String fechaProducto) {
        this.fechaProducto = fechaProducto;
    }

    public String getHoraProducto() {
        return horaProducto;
    }

    public void setHoraProducto(String horaProducto) {
        this.horaProducto = horaProducto;
    }

    public int getIdUsuarioProducto() {
        return idUsuarioProducto;
    }

    public void setIdUsuarioProducto(int idUsuarioProducto) {
        this.idUsuarioProducto = idUsuarioProducto;
    }

    public boolean isActivoProducto() {
        return activoProducto;
    }

    public void setActivoProducto(boolean activoProducto) {
        this.activoProducto = activoProducto;
    }
    
    
}
