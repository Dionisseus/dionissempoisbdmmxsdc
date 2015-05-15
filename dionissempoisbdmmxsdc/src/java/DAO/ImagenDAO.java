/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Imagen;
import POJO.Usuario;
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
public class ImagenDAO {
      public static void insertar(Imagen user) {
       ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
         try {
            cs = conn.prepareCall("{ call imagen_insertar(?,?,?) }");
            cs.setString(1, user.getPathImagen());
            cs.setInt(2, user.getIdProductoImagen());
            cs.setBoolean(3, true);
        
            cs.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
    }
      
      
     public static List<Imagen> TodasImagenes(int idProductoImagen) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            cs = conn.prepareCall("{ call todasImagenesProdcuto(?) }");
            cs.setInt(1, idProductoImagen);
            rs = cs.executeQuery();
            List<Imagen> userLista = new ArrayList<Imagen>();
            while (rs.next()) {
                Imagen img = new Imagen(
                        rs.getInt("idImagen"), 
                        rs.getString("pathImagen"),
                        rs.getInt("idProductoImagen"),
                        rs.getBoolean("activoImagen")
                );
               
                userLista.add(img);
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
/*
    public static void borrar(Imagen user) {
       ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
          try {
            cs = conn.prepareCall("{ call usuario_baja(?) }");
         //   cs.setString(1, user.getIdUsuario());
            cs.execute();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }

    }
/*
    public static Imagen buscar( int idProductoImagen) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        ////////////////////////
        
              try {
            cs = conn.prepareCall("{ call _buscar(?) }");
            cs.setString(1, emailUsuario);
            rs = cs.executeQuery();
            if (rs.next()) {
                Usuario emp = new Usuario(rs.getString("idUsuario"), rs.getString("emailUsuario"), rs.getString("passwordUsuario"),
                        rs.getString("nicknameUsuario"), rs.getString("nombreUsuario"), rs.getString("apellidoUsuario"),
                        rs.getInt("telefonoUsuario"), rs.getBlob("avatarUsuario"), true, true);
                       
                
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
/*
    public static void actualizar(Imagen user) {
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

  /*  public static boolean exists(String emailUsuario, String passwordUsuario) {
        if (UsuarioDAO.buscar(emailUsuario, passwordUsuario)!= null) {
         return true;   
        }
        else{
        return false;
        }
    }*/
    
    
}
