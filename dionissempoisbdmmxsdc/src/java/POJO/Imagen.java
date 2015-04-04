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
public class Imagen {
    int idImagen;
    String pathImagen;
    int idProductoImagen;
    boolean activoImagen;

    public Imagen(int idImagen, String pathImagen, int idProductoImagen, boolean activoImagen) {
        this.idImagen = idImagen;
        this.pathImagen = pathImagen;
        this.idProductoImagen = idProductoImagen;
        this.activoImagen = activoImagen;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public String getPathImagen() {
        return pathImagen;
    }

    public void setPathImagen(String pathImagen) {
        this.pathImagen = pathImagen;
    }

    public int getIdProductoImagen() {
        return idProductoImagen;
    }

    public void setIdProductoImagen(int idProductoImagen) {
        this.idProductoImagen = idProductoImagen;
    }

    public boolean isActivoImagen() {
        return activoImagen;
    }

    public void setActivoImagen(boolean activoImagen) {
        this.activoImagen = activoImagen;
    }
    
    
}
