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
public class MetodoPago {
    int idMetodoPago;
    String nombreMetodoPago;
    boolean activoMetodoPago;

    public MetodoPago(int idMetodoPago, String nombreMetodoPago, boolean activoMetodoPago) {
        this.idMetodoPago = idMetodoPago;
        this.nombreMetodoPago = nombreMetodoPago;
        this.activoMetodoPago = activoMetodoPago;
    }

    public int getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(int idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    public String getNombreMetodoPago() {
        return nombreMetodoPago;
    }

    public void setNombreMetodoPago(String nombreMetodoPago) {
        this.nombreMetodoPago = nombreMetodoPago;
    }

    public boolean isActivoMetodoPago() {
        return activoMetodoPago;
    }

    public void setActivoMetodoPago(boolean activoMetodoPago) {
        this.activoMetodoPago = activoMetodoPago;
    }
    
    
}
