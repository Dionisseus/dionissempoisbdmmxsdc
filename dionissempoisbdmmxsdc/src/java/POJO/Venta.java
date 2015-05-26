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
    String nombreProducto;
    String nickNameUsuario;
    String metodoPago;
    String descripcionAviso;
    String nickVendedor;
    String fechaVenta;
    int precioProducto;
    String pathImagen;
    
    public Venta(boolean confirmadaVenta, int cantidadCompradaVenta, int idAvisoVenta, int idUsuarioVenta, int idMetodoPagoElegidoVenta) {
        this.confirmadaVenta = confirmadaVenta;
        this.cantidadCompradaVenta = cantidadCompradaVenta;
        this.idAvisoVenta = idAvisoVenta;
        this.idUsuarioVenta = idUsuarioVenta;
        this.idMetodoPagoElegidoVenta = idMetodoPagoElegidoVenta;
    }

    public Venta(int idVenta, boolean confirmadaVenta, int cantidadCompradaVenta, int idAvisoVenta, int idUsuarioVenta, int idMetodoPagoElegidoVenta, String nombreProducto, String nickNameUsuario, String metodoPago, String descripcionAviso, String nickVendedor, String fechaVenta, int precioProducto, String pathImagen) {
        this.idVenta = idVenta;
        this.confirmadaVenta = confirmadaVenta;
        this.cantidadCompradaVenta = cantidadCompradaVenta;
        this.idAvisoVenta = idAvisoVenta;
        this.idUsuarioVenta = idUsuarioVenta;
        this.idMetodoPagoElegidoVenta = idMetodoPagoElegidoVenta;
        this.nombreProducto = nombreProducto;
        this.nickNameUsuario = nickNameUsuario;
        this.metodoPago = metodoPago;
        this.descripcionAviso = descripcionAviso;
        this.nickVendedor = nickVendedor;
        this.fechaVenta = fechaVenta;
        this.precioProducto = precioProducto;
        this.pathImagen = pathImagen;
    }

    public int getPrecioProducto() {
        return precioProducto;
    }

    public String getPathImagen() {
        return pathImagen;
    }

    public void setPrecioProducto(int precioProducto) {
        this.precioProducto = precioProducto;
    }

    public void setPathImagen(String pathImagen) {
        this.pathImagen = pathImagen;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
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

    public String getNombreProducto() {
        return nombreProducto;
    }

    public String getNickNameUsuario() {
        return nickNameUsuario;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public String getDescripcionAviso() {
        return descripcionAviso;
    }

    public String getNickVendedor() {
        return nickVendedor;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setNickNameUsuario(String nickNameUsuario) {
        this.nickNameUsuario = nickNameUsuario;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void setDescripcionAviso(String descripcionAviso) {
        this.descripcionAviso = descripcionAviso;
    }

    public void setNickVendedor(String nickVendedor) {
        this.nickVendedor = nickVendedor;
    }
    
    
    
}
