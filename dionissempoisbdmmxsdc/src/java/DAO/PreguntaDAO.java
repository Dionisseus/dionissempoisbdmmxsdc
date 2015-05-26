/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Pregunta;
import POJO.Usuario;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.rowset.serial.SerialBlob;
import xClasses.DBUtil;

/**
 *
 * @author Asus
 */
public class PreguntaDAO {
    public static void agregarPregunta(Pregunta pregunta) {
       ConnectionPool pool = ConnectionPool.getInstance();
       Connection conn = pool.getConnection();
       CallableStatement cs = null;
         try {
            cs = conn.prepareCall("{ call altaPregunta(?,?,?) }");
            cs.setString(1,pregunta.getDescripcionPregunta());
            cs.setInt(2,pregunta.getIdUsuarioPregunta());
            cs.setInt(3,pregunta.getIdAvisoPregunta());
            cs.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
    }
    
    public static List<Pregunta> preguntasAviso(int idAviso) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;        
            try {
            cs = conn.prepareCall("{ call todasPreguntasAviso(?) }");
            cs.setInt(1, idAviso);
            rs = cs.executeQuery();
            List<Pregunta> listaPreg = new ArrayList<Pregunta>();
            while (rs.next()) {
                Pregunta pre = new Pregunta(rs.getInt("idPregunta"), rs.getString("descripcionPregunta"), 
                rs.getString("fechaPregunta"),rs.getString("horaPregunta"), rs.getInt("idUsuarioPregunta"), 
                rs.getInt("idAvisoPregunta"), rs.getString("descripcionRespuesta"));  
                listaPreg.add(pre);
            }
            return listaPreg;
        }catch (Exception ex) {
            ex.printStackTrace();
            return null;
            
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
    }
}
