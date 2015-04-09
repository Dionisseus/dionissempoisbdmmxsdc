/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Categoria;
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
public class CategoriaDAO {
     public static void insertar(Categoria cat) {
       ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
         try {
            cs = conn.prepareCall("{ call insertar_categoria(?,?) }");
            cs.setString(1, cat.getNombreCategoria());
            cs.setBoolean(2, cat.isActivoCategoria());
            
            cs.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
    }

    public static void borrar(Categoria cat) {
       ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
          try {
            cs = conn.prepareCall("{ call baja_categoria(?) }");
            cs.setInt(1, cat.getIdCategoria());
            cs.execute();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
    }

    public static Categoria buscar(String idCategoria, String nombreCategoria) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        ////////////////////////
        
              try {
            cs = conn.prepareCall("{ call buscar_producto(?) }");
            cs.setString(1, idCategoria);
            rs = cs.executeQuery();
            if (rs.next()) {
                Categoria cat = new Categoria(rs.getInt("idCategoria"), rs.getString("nombreCategoria"), rs.getBoolean("activoCategoria"));
                       
                
                return cat;
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

    public static void actualizar(Categoria cat) {
       ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
                try {
            cs = conn.prepareCall("{ call categoria_actualizar(?, ?, ?) }");
            cs.setInt(1, cat.getIdCategoria());
            cs.setString(2, cat.getNombreCategoria());
            cs.setBoolean(3,cat.isActivoCategoria());
            cs.execute();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }

    }

    public static boolean exists(String idCategoria, String nombreCategoria) {
        if (CategoriaDAO.buscar(idCategoria , nombreCategoria)!= null) {
         return true;   
        }
        else{
        return false;
        }
    }
    
     public static List<Categoria> lista() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            cs = conn.prepareCall("{ call todasCategorias() }");
            rs = cs.executeQuery();
            List<Categoria> categoriaLista = new ArrayList<Categoria>();
            while (rs.next()) {
                Categoria cat = new Categoria(
                        rs.getInt("idCategoria"), 
                        rs.getString("nombreCategoria"), 
                        rs.getBoolean("activoCategoria")
                );      
                categoriaLista.add(cat);
            }
            return categoriaLista;
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
