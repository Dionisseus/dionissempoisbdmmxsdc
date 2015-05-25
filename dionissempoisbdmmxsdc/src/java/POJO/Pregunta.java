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
    String nickUsuarioPregunta;
    String nickUsuarioAviso;
    String respuesta;
    

    public Pregunta(int idPregunta, String descripcionPregunta, String fechaPregunta, String horaPregunta, int idUsuarioPregunta, int idAvisoPregunta) {
        this.idPregunta = idPregunta;
        this.descripcionPregunta = descripcionPregunta;
        this.fechaPregunta = fechaPregunta;
        this.horaPregunta = horaPregunta;
        this.idUsuarioPregunta = idUsuarioPregunta;
        this.idAvisoPregunta = idAvisoPregunta;
    }
    
    public Pregunta(int idPregunta, String descripcionPregunta, String horaPregunta, int idUsuarioPregunta, int idAvisoPregunta,String respuesta ,String nickUsuarioP, String nickUsuarioA) {
        this.idPregunta = idPregunta;
        this.descripcionPregunta = descripcionPregunta;
        this.horaPregunta = horaPregunta;
        this.idUsuarioPregunta = idUsuarioPregunta;
        this.idAvisoPregunta = idAvisoPregunta;
        this.respuesta = respuesta;
        this.nickUsuarioPregunta = nickUsuarioP;
        this.nickUsuarioAviso = nickUsuarioP;
    }
    
        public Pregunta(int idPregunta, String descripcionPregunta, String horaPregunta, int idUsuarioPregunta, int idAvisoPregunta, String nickUsuarioP, String nickUsuarioA) {
        this.idPregunta = idPregunta;
        this.descripcionPregunta = descripcionPregunta;
        this.horaPregunta = horaPregunta;
        this.idUsuarioPregunta = idUsuarioPregunta;
        this.idAvisoPregunta = idAvisoPregunta;
        this.nickUsuarioPregunta = nickUsuarioP;
        this.nickUsuarioAviso = nickUsuarioP;
    }
        
        public Pregunta(String descripcionPregunta, int idUsuarioPregunta, int idAvisoPregunta) {
        this.descripcionPregunta = descripcionPregunta;
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

    public String getNickUsuarioPregunta() {
        return nickUsuarioPregunta;
    }

    public String getNickUsuarioAviso() {
        return nickUsuarioAviso;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setNickUsuarioPregunta(String nickUsuarioPregunta) {
        this.nickUsuarioPregunta = nickUsuarioPregunta;
    }

    public void setNickUsuarioAviso(String nickUsuarioAviso) {
        this.nickUsuarioAviso = nickUsuarioAviso;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    
    
    
}
