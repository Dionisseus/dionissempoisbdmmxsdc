/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Producto;
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
public class ProductoDao {
    
     public static void insertar(Producto user) {
       ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
         try {
            cs = conn.prepareCall("{ call producto_insertar(?,?,?,?,?,?,?,?,?,?) }");
            cs.setString(1, user.getNombreProducto());
            cs.setString(2, user.getDescripcionProducto());
            cs.setFloat(3, user.getPrecioProducto());
            cs.setInt(4, user.getExistenciaProducto());
            cs.setString(5, user.getVigenciaProducto());
            cs.setString(6, user.getCaracteristicaProducto());
            cs.setString(7, user.getFechaProducto());
            cs.setString(8, user.getHoraProducto());
            cs.setInt(9, user.getIdUsuarioProducto());
            cs.setBoolean(10, user.isActivoProducto());
            cs.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
    }

    public static void borrar(Producto user) {
       ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
          try {
            cs = conn.prepareCall("{ call producto_baja(?) }");
            cs.setInt(1, user.getIdProducto());
            cs.execute();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
    }

    public static Producto buscar(String idProducto, String nombreProducto) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        ////////////////////////
        
              try {
            cs = conn.prepareCall("{ call buscar_producto(?) }");
            cs.setString(1, idProducto);
            rs = cs.executeQuery();
            if (rs.next()) {
                Producto pro = new Producto(rs.getInt("idProducto"), rs.getString("nombreProducto"), rs.getString("descripcionProducto"),
                        rs.getFloat("precioProducto"), rs.getInt("existenciaProducto"), rs.getString("vigenciaProducto"),
                        rs.getString("caracteristicaProducto"), rs.getString("fechaProducto"), rs.getString("horaProducto"),rs.getInt("idUsuarioProducto"), true);
                       
                
                return pro;
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

    public static void actualizar(Producto pro) {
       ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
                try {
            cs = conn.prepareCall("{ call producto_actualizar(?, ?, ?, ?, ?, ?,?,?,?,?,?) }");
            cs.setInt(1, pro.getIdProducto());
            cs.setString(2, pro.getNombreProducto());
            cs.setString(3, pro.getDescripcionProducto());
            cs.setFloat(4, pro.getPrecioProducto());
            cs.setInt(5, pro.getExistenciaProducto());
            cs.setString(6, pro.getVigenciaProducto());
            cs.setString(7, pro.getCaracteristicaProducto());
            cs.setString(8, pro.getFechaProducto());
            cs.setString(9, pro.getHoraProducto());
            cs.setInt(10, pro.getIdUsuarioProducto());
            cs.setBoolean(11, pro.isActivoProducto());
            cs.execute();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }

    }

    public static boolean exists(String idProducto, String nombreProducto) {
        if (ProductoDao.buscar(idProducto, nombreProducto)!= null) {
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
                        rs.getBlob("avatarUsuario"),
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
    
}
