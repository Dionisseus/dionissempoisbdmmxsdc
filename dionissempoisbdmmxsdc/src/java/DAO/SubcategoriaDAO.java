/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Categoria;
import POJO.Subcategoria;
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
public class SubcategoriaDAO {
    
     public static void insertar(Subcategoria cat) {
       ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
         try {
            cs = conn.prepareCall("{ call insertar_subcategoria(?,?,?) }");
            cs.setString(1, cat.getNombreSubcategoria());
            cs.setBoolean(3, cat.isActivoSubcategoria());
            cs.setInt(2, cat.getIdCategoriaSubcategoria());
            
            cs.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
    }

    public static void borrar(Subcategoria cat) {
       ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
          try {
            cs = conn.prepareCall("{ call baja_subcategoria(?) }");
            cs.setInt(1, cat.getIdSubcategoria());
            cs.execute();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
    }

    public static Subcategoria buscar(String idCategoria, String nombreCategoria) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        ////////////////////////
        
              try {
            cs = conn.prepareCall("{ call buscar_subcategoria(?) }");
            cs.setString(1, idCategoria);
            rs = cs.executeQuery();
            if (rs.next()) {
                Subcategoria cat = new Subcategoria(rs.getInt("idSubcategoria"), rs.getString("nombreSubategoria"),rs.getInt("idCategoriaSubcategoria"), rs.getBoolean("activoCategoria"));      
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

    public static void actualizar(Subcategoria cat) {
       ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
                try {
            cs = conn.prepareCall("{ call subcategoria_actualizar(?, ?, ?, ?) }");
            cs.setInt(1, cat.getIdSubcategoria());
            cs.setString(2, cat.getNombreSubcategoria());
            cs.setInt(3,cat.getIdCategoriaSubcategoria());
            cs.setBoolean(4, cat.isActivoSubcategoria());
            cs.execute();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }

    }

    public static boolean exists(String idCategoria, String nombreCategoria) {
        if (SubcategoriaDAO.buscar(idCategoria , nombreCategoria)!= null) {
         return true;   
        }
        else{
        return false;
        }
    }
    
     public static List<Subcategoria> lista(int idCategoria) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            cs = conn.prepareCall("{ call todasSubcategorias(?) }");
            cs.setInt(1, idCategoria);
            rs = cs.executeQuery();
            List<Subcategoria> categoriaLista = new ArrayList<Subcategoria>();
            while (rs.next()) {
                if ( rs.getInt("idCategoriaSubcategoria")== idCategoria) {
                  Subcategoria cat = new Subcategoria(
                        rs.getInt("idSubcategoria"), 
                        rs.getString("nombreSubcategoria"), 
                        rs.getInt("idCategoriaSubcategoria"),
                        rs.getBoolean("activoSubcategoria")
                );      
                categoriaLista.add(cat);  
                }
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
