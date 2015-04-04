/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;

/**
 *
 * @author Diosio
 */
public class UsuarioDao {

    public static void insertar() {
        establecerConnectionPool();
    }

    public static void borrar() {
        establecerConnectionPool();

    }

    public static Usuario buscar(String emailUsuario, String passwordUsuario) {
        establecerConnectionPool();
        
        
        return null;

    }

    public static void actualizar() {
        establecerConnectionPool();

    }

    public static void establecerConnectionPool() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
    }

    public static boolean exists(String emailUsuario, String passwordUsuario) {
        if (UsuarioDao.buscar(emailUsuario, passwordUsuario)!= null) {
         return true;   
        }
        else{
        return false;
        }
        
    }

   
}
