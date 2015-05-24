/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Usuario;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import xClasses.DBUtil;

/**
 *
 * @author Diosio
 */
public class UsuarioDAO {

    public static void insertar(Usuario user) {
       ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
         try {
            cs = conn.prepareCall("{ call usuario_insertar(?,?,?,?,?,?,?,?,?) }");
            cs.setString(1, user.getEmailUsuario());
            cs.setString(2, user.getPasswordUsuario());
            cs.setString(3, user.getNicknameUsuario());
            cs.setString(4, user.getNombreUsuario());
            cs.setString(5, user.getApellidoUsuario());
            cs.setInt(6, user.getTelefonoUsuario());
            cs.setBlob(7, user.getAvatarUsuario());
            cs.setBoolean(8, user.isConfirmadoUsuario());
            cs.setBoolean(9, user.isActivoUsuario());
            cs.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
    }

    public static void borrar(Usuario user) {
       ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
          try {
            cs = conn.prepareCall("{ call usuario_baja(?) }");
            cs.setString(1, user.getIdUsuario());
            cs.execute();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }

    }

    public static Usuario buscar(String emailUsuario, String passwordUsuario) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        ////////////////////////
        
              try {
            cs = conn.prepareCall("{ call usuario_buscar(?) }");
            cs.setString(1, emailUsuario);
            rs = cs.executeQuery();
            if (rs.next()) {
                Usuario emp = new Usuario(rs.getString("idUsuario"), rs.getString("emailUsuario"), rs.getString("passwordUsuario"),
                        rs.getString("nicknameUsuario"), rs.getString("nombreUsuario"), rs.getString("apellidoUsuario"),
                        rs.getInt("telefonoUsuario"), rs.getBinaryStream("avatarUsuario"), true, rs.getBoolean("activoUsuario"));
                       
                
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

    public static void actualizar(Usuario user) {
       ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
                try {
            cs = conn.prepareCall("{ call usuario_actualizar(?, ?, ?, ?, ?, ?,?,?) }");
            cs.setString(1, user.getIdUsuario());
            cs.setString(2, user.getEmailUsuario());
            cs.setString(3, user.getPasswordUsuario());
            cs.setString(4, user.getNicknameUsuario());
            cs.setString(5, user.getNombreUsuario());
            cs.setString(6, user.getApellidoUsuario());
            cs.setInt(7, user.getTelefonoUsuario());
            cs.setBlob(8, user.getAvatarUsuario());
            cs.execute();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }

    }

    public static boolean exists(String emailUsuario, String passwordUsuario) {
        if (UsuarioDAO.buscar(emailUsuario, passwordUsuario)!= null) {
         return true;   
        }
        else{
        return false;
        }
    }
    
     public static List<Usuario> lista() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            cs = conn.prepareCall("{ call buscar_empleados() }");
            rs = cs.executeQuery();
            List<Usuario> userLista = new ArrayList<Usuario>();
            while (rs.next()) {
                Usuario user = new Usuario(
                        rs.getString("idUsuario"), 
                        rs.getString("emailUsuario"), 
                        rs.getString("passwordUsuario"), 
                        rs.getString("nicknameUsuario"), 
                        rs.getString("nombreUsuario"),
                        rs.getString("apelidoUsuario"),
                        rs.getInt("telefonoUsuario"),
                        rs.getBinaryStream("avatarUsuario"),
                        rs.getBoolean("confirmadoUsuario"),
                        rs.getBoolean("activoUsuario")
                );
               
                userLista.add(user);
            }
            return userLista;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
    }
     
     public static InputStream imagenUsuario(int id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        try { 
            cs = connection.prepareCall("{ call imagenUsuario(?) }");
            cs.setInt(1, id);
            rs = cs.executeQuery();
            if (rs.next()) {
                return rs.getBinaryStream(1);
            }
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
            
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(cs);
            pool.freeConnection(connection);
        }
    }
}
