/*
 * To change this license header, choose License Headers in Project 
Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

/**
 *
 * @author Diosio
 */
public class Respuesta {
    int idRespuesta;
    String descripcionRespuesta;
    String fechaRespuesta;
    String horaRespuesta;
    int idPreguntaRespuesta;

    public Respuesta(int idRespuesta, String descripcionRespuesta, String fechaRespuesta, String horaRespuesta, int idPreguntaRespuesta) 
{
        this.idRespuesta = idRespuesta;
        this.descripcionRespuesta = descripcionRespuesta;
        this.fechaRespuesta = fechaRespuesta;
        this.horaRespuesta = horaRespuesta;
        this.idPreguntaRespuesta = idPreguntaRespuesta;
    }
    
    public Respuesta(String descripcionRespuesta,int idPreguntaRespuesta) {
        this.descripcionRespuesta = descripcionRespuesta;
        this.idPreguntaRespuesta = idPreguntaRespuesta;
    }

    public int getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(int idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public String getDescripcionRespuesta() {
        return descripcionRespuesta;
    }

    public void setDescripcionRespuesta(String descripcionRespuesta) {
        this.descripcionRespuesta = descripcionRespuesta;
    }

    public String getFechaRespuesta() {
        return fechaRespuesta;
    }

    public void setFechaRespuesta(String fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

    public String getHoraRespuesta() {
        return horaRespuesta;
    }

    public void setHoraRespuesta(String horaRespuesta) {
        this.horaRespuesta = horaRespuesta;
    }

    public int getIdPreguntaRespuesta() {
        return idPreguntaRespuesta;
    }

    public void setIdPreguntaRespuesta(int idPreguntaRespuesta) {
        this.idPreguntaRespuesta = idPreguntaRespuesta;
    }
    
    
    
}
