/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import xClasses.DBUtil;

/**
 *
 * @author Diosio
 */
public class UsuarioDao {

    public static void insertar() {
       ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
    }

    public static void borrar() {
       ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;

    }

    public static Usuario buscar(String emailUsuario, String passwordUsuario) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        ////////////////////////
        
              try {
            cs = conn.prepareCall("{ call buscar_usuario(?) }");
            cs.setString(1, emailUsuario);
            rs = cs.executeQuery();
            if (rs.next()) {
                Usuario emp = new Usuario(rs.getString("idUsuario"), rs.getString("emailUsuario"), rs.getString("passwordUsuario"),
                        rs.getString("emailUsuario"), rs.getString("emailUsuario"), rs.getString("emailUsuario"),
                        rs.getInt("telefonoUsuario"), null, true, true);
                       
                
                return emp;
            }
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
            
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
        
     

    }

    public static void actualizar() {
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
