/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Aviso;
import POJO.Producto;
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
public class AvisoDAO {
    
    
        
     public static void insertar(Aviso user) {
       ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
         try {
            cs = conn.prepareCall("{ call aviso_insertar(?,?,?,?,?,?,?,?,?,?) }");
            cs.setInt(1, user.getCantidadAviso());
            cs.setFloat(2, user.getPrecioAviso());
            cs.setString(3, user.getMetodoPago());
            cs.setString(4, user.getDescripcionAviso());
            cs.setString(5, user.getFechaAviso());
            cs.setString(6, user.getVigenciaAviso());
            cs.setString(7, user.getHoraAviso());
            cs.setInt(8, user.getIdSubCategoriaAviso());
            cs.setInt(9, user.getIdProductoAviso());
            cs.setBoolean(10,true);
            cs.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
    }
     
      public static void borrar(int id) {
       ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
          try {
            cs = conn.prepareCall("{ call aviso_baja(?) }");
            cs.setInt(1,id);
            cs.execute();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
    }
      
       public static List<Aviso> busqueda(String texto, String nick,String fechaOrigen,String fechaFinal) {
       ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        
          try {
            cs = conn.prepareCall("{ call aviso_busqueda(?,?,?,?) }");
            cs.setString(1, texto);
            cs.setString(2, nick);
            cs.setString(3, fechaOrigen);
            cs.setString(4, fechaFinal);
            rs = cs.executeQuery();
            
              List <Aviso> Listaaviso = new ArrayList<Aviso>();
              while (rs.next()) {
                    Aviso aviso = new Aviso(rs.getString("pathImagen"), rs.getString("nicknameUsuario"), rs.getString("nombreProducto"), rs.getInt("idAviso"), rs.getInt("cantidadAviso"), rs.getInt("precioAviso"),
                          rs.getString("descripcionCortaAviso"), rs.getString("descripcionAviso"), rs.getString("vigenciaAviso"), rs.getString("fechaAviso"), rs.getString("horaAviso"),
                         rs.getInt("idSubCategoriaAviso"), rs.getInt("idProductoAviso"), rs.getBoolean("activoAviso"));
                  Listaaviso.add(aviso);
              }
              return Listaaviso;
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
       return null;
       }
       
           public static List<Aviso> recientesAvisos() {
       ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
               ResultSet rs = null;
          try {
            cs = conn.prepareCall("{ call recientesAvisos() }");
           
           rs = cs.executeQuery();
              List <Aviso> Listaaviso = new ArrayList<Aviso>();
              while (rs.next()) {
                  Aviso aviso = new Aviso(rs.getString("pathImagen"), rs.getString("nicknameUsuario"), rs.getString("nombreProducto"), rs.getInt("idAviso"), rs.getInt("cantidadAviso"), rs.getInt("precioAviso"),
                          rs.getString("descripcionCortaAviso"), rs.getString("descripcionAviso"), rs.getString("vigenciaAviso"), rs.getString("fechaAviso"), rs.getString("horaAviso"),
                         rs.getInt("idSubCategoriaAviso"), rs.getInt("idProductoAviso"), rs.getBoolean("activoAviso"));
                  Listaaviso.add(aviso);
              }
            return Listaaviso;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
          return null;
    }
           
           public static List<Aviso> preciosAvisos() {
       ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
               ResultSet rs = null;
          try {
            cs = conn.prepareCall("{ call preciosAvisos() }");
           
           rs = cs.executeQuery();
              List <Aviso> Listaaviso = new ArrayList<Aviso>();
              while (rs.next()) {
                  Aviso aviso = new Aviso(rs.getString("pathImagen"), rs.getString("nicknameUsuario"), rs.getString("nombreProducto"), rs.getInt("idAviso"), rs.getInt("cantidadAviso"), rs.getInt("precioAviso"),
                          rs.getString("descripcionCortaAviso"), rs.getString("descripcionAviso"), rs.getString("vigenciaAviso"), rs.getString("fechaAviso"), rs.getString("horaAviso"),
                         rs.getInt("idSubCategoriaAviso"), rs.getInt("idProductoAviso"), rs.getBoolean("activoAviso"));
                  Listaaviso.add(aviso);
              }
            return Listaaviso;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
          return null;
    }
           
        public static List<Aviso> misAvisos(int idUsuario) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            cs = conn.prepareCall("{ call misAvisos(?) }");
            cs.setInt(1, idUsuario);
            rs = cs.executeQuery();
            List<Aviso> prodLista = new ArrayList<Aviso>();
            while (rs.next()) {
                Aviso user = new Aviso(
                        rs.getString("pathImagen"),
                        rs.getString("nicknameUsuario"),
                        rs.getString("nombreProducto"),
                        rs.getInt("idAviso"),
                        rs.getInt("cantidadAviso"), 
                        rs.getInt("precioAviso"), 
                        rs.getString("descripcionCortaAviso"), 
                        rs.getString("descripcionAviso"),
                        rs.getString("vigenciaAviso"),
                        rs.getString("fechaAviso"),
                        rs.getString("horaAviso"),
                        rs.getInt("idSubcategoriaAviso"),
                        rs.getInt("idProductoAviso"),
                        rs.getBoolean("activoAviso")
                );      
                prodLista.add(user);
            }
            return prodLista;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
    }
     
         public static List<Aviso> avisosSubCategoria(int idSubcategoria) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            cs = conn.prepareCall("{ call avisosSubCategoria(?) }");
            cs.setInt(1, idSubcategoria);
            rs = cs.executeQuery();
            List<Aviso> prodLista = new ArrayList<Aviso>();
            while (rs.next()) {
                Aviso user = new Aviso(
                        rs.getString("pathImagen"),
                        rs.getString("nicknameUsuario"),
                        rs.getString("nombreProducto"),
                        rs.getInt("idAviso"),
                        rs.getInt("cantidadAviso"), 
                        rs.getInt("precioAviso"), 
                        rs.getString("descripcionCortaAviso"), 
                        rs.getString("descripcionAviso"),
                        rs.getString("vigenciaAviso"),
                        rs.getString("fechaAviso"),
                        rs.getString("horaAviso"),
                        rs.getInt("idSubcategoriaAviso"),
                        rs.getInt("idProductoAviso"),
                        rs.getBoolean("activoAviso")
                );      
                prodLista.add(user);
            }
            return prodLista;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
    }
        
        
        
       //  detalleaviso      subcategoriaavisos  todasimagenesaviso  todaspreguntasaviso
    
}