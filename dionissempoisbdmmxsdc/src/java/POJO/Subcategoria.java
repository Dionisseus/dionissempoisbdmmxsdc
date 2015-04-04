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
public class Subcategoria {
    int idSubcategoria;
    String nombreSubcategoria;
    int idCategoriaSubcategoria;
    boolean activoSubcategoria;

    public Subcategoria(int idSubcategoria, String nombreSubcategoria, int idCategoriaSubcategoria, boolean activoSubcategoria) {
        this.idSubcategoria = idSubcategoria;
        this.nombreSubcategoria = nombreSubcategoria;
        this.idCategoriaSubcategoria = idCategoriaSubcategoria;
        this.activoSubcategoria = activoSubcategoria;
    }

    public int getIdSubcategoria() {
        return idSubcategoria;
    }

    public void setIdSubcategoria(int idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
    }

    public String getNombreSubcategoria() {
        return nombreSubcategoria;
    }

    public void setNombreSubcategoria(String nombreSubcategoria) {
        this.nombreSubcategoria = nombreSubcategoria;
    }

    public int getIdCategoriaSubcategoria() {
        return idCategoriaSubcategoria;
    }

    public void setIdCategoriaSubcategoria(int idCategoriaSubcategoria) {
        this.idCategoriaSubcategoria = idCategoriaSubcategoria;
    }

    public boolean isActivoSubcategoria() {
        return activoSubcategoria;
    }

    public void setActivoSubcategoria(boolean activoSubcategoria) {
        this.activoSubcategoria = activoSubcategoria;
    }
    
    
    
}
