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
            cs = conn.prepareCall("{ call pregunta_insertar(?,?,?,?,?) }");
            cs.setString(1, pregunta.getDescripcionPregunta());
            cs.setString(2, pregunta.getFechaPregunta());
            cs.setString(3, pregunta.getHoraPregunta());
            cs.setInt(4, pregunta.getIdUsuarioPregunta());
            cs.setInt(5, pregunta.getIdAvisoPregunta());
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
    }
    
    public static void misPreguntas_1(int idUsuario){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        try{
            cs = conn.prepareCall("{call misPreguntas_1((?))}");
            cs.setInt(1, idUsuario);
            rs = cs.executeQuery();
            while (rs.next()) {
               if (rs.getInt("idUsuarioPregunta") == idUsuario) {
                        rs.getInt("idPregunta");
                        rs.getString("descripcionPregunta");
                        rs.getString("horaPregunta");
                        rs.getString("idUsuarioPregunta"); 
                        rs.getInt("idAvisoPregunta"); 
                        rs.getInt("Usuario pregunta"); 
                        rs.getString("Usuario aviso");
                }  
               
            }            
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
    }
    
}