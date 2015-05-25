/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Producto;
import POJO.Usuario;
import POJO.Pregunta;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import xClasses.DBUtil;

/**
 *
 * @author Asus
 */
public class PreguntasDAO {
    
    public static void agregarPregunta(Pregunta pregunta) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        try{
            cs = conn.prepareCall("{ call altaPregunta(?,?,?) }");
            cs.setString(1, pregunta.getDescripcionPregunta());
            cs.setInt(2, pregunta.getIdUsuarioPregunta());
            cs.setInt(3, pregunta.getIdAvisoPregunta());
            cs.execute();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
    }
    
        public static List<Pregunta> preguntasAviso(int idAviso){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        try{
            cs = conn.prepareCall("{call todasPreguntasAviso((?))}");
            cs.setInt(1, idAviso);
            rs = cs.executeQuery();
            List<Pregunta> preguntaLista = new ArrayList<Pregunta>();
            while (rs.next()) {
                    Pregunta pu = new Pregunta(rs.getInt("idPregunta"),
                        rs.getString("descripcionPregunta"),
                        rs.getString("fechaPregunta"),
                        rs.getString("horaPregunta"),
                        rs.getInt("idUsuarioPregunta"), 
                        rs.getInt("idAvisoPregunta"),
                        rs.getString("descripcionRespuesta"));
                        preguntaLista.add(pu); 
                
            }     
            return preguntaLista;
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
        return null;
    }
    
    public static List<Pregunta> misPreguntas_1(int idUsuario){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        try{
            cs = conn.prepareCall("{call misPreguntas_1((?))}");
            cs.setInt(1, idUsuario);
            rs = cs.executeQuery();
            List<Pregunta> preguntaLista = new ArrayList<Pregunta>();
            while (rs.next()) {
               if (rs.getInt("idUsuarioPregunta") == idUsuario) {
                    Pregunta pu = new Pregunta(rs.getInt("idPregunta"),
                        rs.getString("descripcionPregunta"),
                        rs.getString("horaPregunta"),
                        rs.getInt("idUsuarioPregunta"), 
                        rs.getInt("idAvisoPregunta"),
                        rs.getString("Usuario pregunta"),
                        rs.getString("Usuario aviso"));
                         preguntaLista.add(pu);
                }  
                return preguntaLista;
            }            
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
        return null;
    }
    
        public static List<Pregunta> misPreguntas_2(int idUsuario, int idAviso){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        try{
            cs = conn.prepareCall("{call misPreguntas_2((?,?))}");
            cs.setInt(1, idUsuario);
            cs.setInt(2, idAviso);
            rs = cs.executeQuery();
            List<Pregunta> preguntaLista = new ArrayList<Pregunta>();
            while (rs.next()) {
               if (rs.getInt("idUsuarioPregunta") == idUsuario && rs.getInt("idAvisoPregunta") == idAviso) {
                    Pregunta pu = new Pregunta(rs.getInt("idPregunta"),
                        rs.getString("descripcionPregunta"),
                        rs.getString("horaPregunta"),
                        rs.getInt("idUsuarioPregunta"), 
                        rs.getInt("idAvisoPregunta"),
                        rs.getString("Usuario pregunta"),
                        rs.getString("Usuario aviso"));
                         preguntaLista.add(pu);
                }  
                return  preguntaLista;
            }            
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
        return null;
    }
        
    /*public static List<Pregunta> misPreguntas_3(int idUsuario){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        try{
            cs = conn.prepareCall("{call misPreguntas_2((?))}");
            cs.setInt(1, idUsuario);
            rs = cs.executeQuery();
            List<Pregunta> preguntaLista = new ArrayList<Pregunta>();
            while (rs.next()) {
               if (rs.getInt("idUsuarioPregunta") == idUsuario) {
                    Pregunta pu = new Pregunta(rs.getInt("idPregunta"),
                        rs.getString("descripcionPregunta"),
                        rs.getString("horaPregunta"),
                        rs.getInt("idUsuarioPregunta"), 
                        rs.getInt("idAvisoPregunta"),
                        rs.getString("descripcionRespuesta"),
                        rs.getString("PREGUNTA"),
                        rs.getString("AVISO"));
                        preguntaLista.add(pu);
                }  
                return preguntaLista;
            }            
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
        return null;
    }*/
    
    
}