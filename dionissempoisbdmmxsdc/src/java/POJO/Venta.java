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
public class Venta {
    int idVenta;
    boolean confirmadaVenta;
    int cantidadCompradaVenta;
    int idAvisoVenta;
    int idUsuarioVenta;
    int idMetodoPagoElegidoVenta;

    public Venta(int idVenta, boolean confirmadaVenta, int cantidadCompradaVenta, int idAvisoVenta, int idUsuarioVenta, int idMetodoPagoElegidoVenta) {
        this.idVenta = idVenta;
        this.confirmadaVenta = confirmadaVenta;
        this.cantidadCompradaVenta = cantidadCompradaVenta;
        this.idAvisoVenta = idAvisoVenta;
        this.idUsuarioVenta = idUsuarioVenta;
        this.idMetodoPagoElegidoVenta = idMetodoPagoElegidoVenta;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public boolean isConfirmadaVenta() {
        return confirmadaVenta;
    }

    public void setConfirmadaVenta(boolean confirmadaVenta) {
        this.confirmadaVenta = confirmadaVenta;
    }

    public int getCantidadCompradaVenta() {
        return cantidadCompradaVenta;
    }

    public void setCantidadCompradaVenta(int cantidadCompradaVenta) {
        this.cantidadCompradaVenta = cantidadCompradaVenta;
    }

    public int getIdAvisoVenta() {
        return idAvisoVenta;
    }

    public void setIdAvisoVenta(int idAvisoVenta) {
        this.idAvisoVenta = idAvisoVenta;
    }

    public int getIdUsuarioVenta() {
        return idUsuarioVenta;
    }

    public void setIdUsuarioVenta(int idUsuarioVenta) {
        this.idUsuarioVenta = idUsuarioVenta;
    }

    public int getIdMetodoPagoElegidoVenta() {
        return idMetodoPagoElegidoVenta;
    }

    public void setIdMetodoPagoElegidoVenta(int idMetodoPagoElegidoVenta) {
        this.idMetodoPagoElegidoVenta = idMetodoPagoElegidoVenta;
    }
    
    
    
}
