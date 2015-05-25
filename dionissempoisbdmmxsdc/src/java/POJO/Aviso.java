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
    String metodoPago;
    String descripcionAviso;
    String vigenciaAviso;
    String fechaAviso;
    String horaAviso;
    int idSubCategoriaAviso;
    int idProductoAviso;
    boolean activoAviso;
    String pathImagen;
    String nicknameUsuario;
    String nombreProducto;
    int contador;
  

    public Aviso(int idAviso, int cantidadAviso, float precioAviso, String metodoPago, String descripcionAviso, String vigenciaAviso, String fechaAviso, String horaAviso, int idSubCategoriaAviso, int idProductoAviso, boolean activoAviso) {
        this.idAviso = idAviso;
        this.cantidadAviso = cantidadAviso;
        this.precioAviso = precioAviso;
        this.metodoPago = metodoPago;
        this.descripcionAviso = descripcionAviso;
        this.vigenciaAviso = vigenciaAviso;
        this.fechaAviso = fechaAviso;
        this.horaAviso = horaAviso;
        this.idSubCategoriaAviso = idSubCategoriaAviso;
        this.idProductoAviso = idProductoAviso;
        this.activoAviso = activoAviso;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
     public Aviso(String nickNameUsuario, String nombreProducto,int idAviso, int cantidadAviso, float precioAviso, String metodoPago, String descripcionAviso, String vigenciaAviso, String fechaAviso, String horaAviso, int idProductoAviso, boolean activoAviso,int contador,String thumbnail) {
        
         this.nicknameUsuario = nickNameUsuario;
        this.nombreProducto = nombreProducto;
         this.idAviso = idAviso;
        this.cantidadAviso = cantidadAviso;
        this.precioAviso = precioAviso;
        this.metodoPago = metodoPago;
        this.descripcionAviso = descripcionAviso;
        this.vigenciaAviso = vigenciaAviso;
        this.fechaAviso = fechaAviso;
        this.horaAviso = horaAviso;
        this.contador = contador;
        this.idProductoAviso = idProductoAviso;
        this.activoAviso = activoAviso;
         this.pathImagen = thumbnail;
    }
    
       public Aviso(String pathImagen, String nickNameUsuario, String nombreProductom, int idAviso, int cantidadAviso, float precioAviso, String metodoPago, String descripcionAviso, String vigenciaAviso, String fechaAviso, String horaAviso, int idSubCategoriaAviso, int idProductoAviso, boolean activoAviso) {
        this.pathImagen = pathImagen;
        this.nicknameUsuario = nickNameUsuario;
        this.nombreProducto = nombreProductom;
        this.idAviso = idAviso;
        this.cantidadAviso = cantidadAviso;
        this.precioAviso = precioAviso;
        this.metodoPago = metodoPago;
        this.descripcionAviso = descripcionAviso;
        this.vigenciaAviso = vigenciaAviso;
        this.fechaAviso = fechaAviso;
        this.horaAviso = horaAviso;
        this.idSubCategoriaAviso = idSubCategoriaAviso;
        this.idProductoAviso = idProductoAviso;
        this.activoAviso = activoAviso;
    }
       public Aviso(int idAviso,int idProductoAviso){
           this.idAviso =  idAviso;
           this.idProductoAviso = idProductoAviso;
       }
       
        public Aviso(int idAviso){
           this.idAviso =  idAviso;
  
       }

    public String getPathImagen() {
        return pathImagen;
    }

    public void setPathImagen(String pathImagen) {
        this.pathImagen = pathImagen;
    }

    public String getNicknameUsuario() {
        return nicknameUsuario;
    }

    public void setNicknameUsuario(String nicknameUsuario) {
        this.nicknameUsuario = nicknameUsuario;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

 

    public Aviso(int cantidadAviso, float precioAviso, String metodoPago, String descripcionAviso, String vigenciaAviso, String fechaAviso, String horaAviso, int idSubCategoriaAviso, int idProductoAviso, boolean activoAviso) {

        this.cantidadAviso = cantidadAviso;
        this.precioAviso = precioAviso;
        this.metodoPago = metodoPago;
        this.descripcionAviso = descripcionAviso;
        this.vigenciaAviso = vigenciaAviso;
        this.fechaAviso = fechaAviso;
        this.horaAviso = horaAviso;
        this.idSubCategoriaAviso = idSubCategoriaAviso;
        this.idProductoAviso = idProductoAviso;
        this.activoAviso = activoAviso;
    }

    public int getIdSubCategoriaAviso() {
        return idSubCategoriaAviso;
    }

    public void setIdSubCategoriaAviso(int idSubCategoriaAviso) {
        this.idSubCategoriaAviso = idSubCategoriaAviso;
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

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
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
