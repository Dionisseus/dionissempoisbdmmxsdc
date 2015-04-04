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
public class Pregunta {
    int idPregunta;
    String descripcionPregunta;
    String fechaPregunta;
    String horaPregunta;
    int idUsuarioPregunta;
    int idAvisoPregunta;

    public Pregunta(int idPregunta, String descripcionPregunta, String fechaPregunta, String horaPregunta, int idUsuarioPregunta, int idAvisoPregunta) {
        this.idPregunta = idPregunta;
        this.descripcionPregunta = descripcionPregunta;
        this.fechaPregunta = fechaPregunta;
        this.horaPregunta = horaPregunta;
        this.idUsuarioPregunta = idUsuarioPregunta;
        this.idAvisoPregunta = idAvisoPregunta;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getDescripcionPregunta() {
        return descripcionPregunta;
    }

    public void setDescripcionPregunta(String descripcionPregunta) {
        this.descripcionPregunta = descripcionPregunta;
    }

    public String getFechaPregunta() {
        return fechaPregunta;
    }

    public void setFechaPregunta(String fechaPregunta) {
        this.fechaPregunta = fechaPregunta;
    }

    public String getHoraPregunta() {
        return horaPregunta;
    }

    public void setHoraPregunta(String horaPregunta) {
        this.horaPregunta = horaPregunta;
    }

    public int getIdUsuarioPregunta() {
        return idUsuarioPregunta;
    }

    public void setIdUsuarioPregunta(int idUsuarioPregunta) {
        this.idUsuarioPregunta = idUsuarioPregunta;
    }

    public int getIdAvisoPregunta() {
        return idAvisoPregunta;
    }

    public void setIdAvisoPregunta(int idAvisoPregunta) {
        this.idAvisoPregunta = idAvisoPregunta;
    }
    
    
    
}
