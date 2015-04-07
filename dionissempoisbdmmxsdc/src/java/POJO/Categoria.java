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
public class Categoria {
    int idCategoria;
    String nombreCategoria;
    boolean activoCategoria;

    public Categoria(int idCategoria, String nombreCategoria, boolean activoCategoria) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.activoCategoria = activoCategoria;
    }
     public Categoria( String nombreCategoria, boolean activoCategoria) {
        
        this.nombreCategoria = nombreCategoria;
        this.activoCategoria = activoCategoria;
    }
    

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public boolean isActivoCategoria() {
        return activoCategoria;
    }

    public void setActivoCategoria(boolean activoCategoria) {
        this.activoCategoria = activoCategoria;
    }
    
    
    
}
