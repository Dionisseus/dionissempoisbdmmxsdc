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
public class AvisoMetodoPago {
    int idAviso;
    int idMetodoPago;

    public AvisoMetodoPago(int idAviso, int idMetodoPago) {
        this.idAviso = idAviso;
        this.idMetodoPago = idMetodoPago;
    }

    public int getIdAviso() {
        return idAviso;
    }

    public void setIdAviso(int idAviso) {
        this.idAviso = idAviso;
    }

    public int getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(int idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }
    
    
}
