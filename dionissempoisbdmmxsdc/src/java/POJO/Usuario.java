/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.io.InputStream;
import java.sql.Blob;

/**
 *
 * @author Diosio
 */
public class Usuario {
    
    String idUsuario;
    String emailUsuario;
    String passwordUsuario;
    String nicknameUsuario;
    String nombreUsuario;
    String apellidoUsuario;
    int telefonoUsuario;
    InputStream avatarUsuario;
    boolean confirmadoUsuario;
    boolean activoUsuario;

    public Usuario( String emailUsuario, String passwordUsuario, String nicknameUsuario,
            String nombreUsuario, String apellidoUsuario, int telefonoUsuario, InputStream avatarUsuario, boolean confirmadoUsuario, boolean activoUsuario) {
      //  this.idUsuario = idUsuario;
        this.emailUsuario = emailUsuario;
        this.passwordUsuario = passwordUsuario;
        this.nicknameUsuario = nicknameUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.telefonoUsuario = telefonoUsuario;
        this.avatarUsuario = avatarUsuario;
        this.confirmadoUsuario = confirmadoUsuario;
        this.activoUsuario = activoUsuario;
    }
    public Usuario(String idUsuario, String emailUsuario, String passwordUsuario, String nicknameUsuario,
            String nombreUsuario, String apellidoUsuario, int telefonoUsuario, InputStream avatarUsuario, boolean confirmadoUsuario, boolean activoUsuario) {
        this.idUsuario = idUsuario;
        this.emailUsuario = emailUsuario;
        this.passwordUsuario = passwordUsuario;
        this.nicknameUsuario = nicknameUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.telefonoUsuario = telefonoUsuario;
        this.avatarUsuario = avatarUsuario;
        this.confirmadoUsuario = confirmadoUsuario;
        this.activoUsuario = activoUsuario;
    }



    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

    public String getNicknameUsuario() {
        return nicknameUsuario;
    }

    public void setNicknameUsuario(String nicknameUsuario) {
        this.nicknameUsuario = nicknameUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public int getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(int telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public InputStream getAvatarUsuario() {
        return avatarUsuario;
    }

    public void setAvatarUsuario(InputStream avatarUsuario) {
        this.avatarUsuario = avatarUsuario;
    }

    public boolean isConfirmadoUsuario() {
        return confirmadoUsuario;
    }

    public void setConfirmadoUsuario(boolean confirmadoUsuario) {
        this.confirmadoUsuario = confirmadoUsuario;
    }

    public boolean isActivoUsuario() {
        return activoUsuario;
    }

    public void setActivoUsuario(boolean activoUsuario) {
        this.activoUsuario = activoUsuario;
    }
    
    
}
