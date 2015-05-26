/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Respuesta;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import xClasses.DBUtil;

/**
 *
 * @author Asus
 */
public class RespuestaDAO {
    public static void insertar(Respuesta res) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
         try {
           cs = conn.prepareCall("{ call altaRespuesta(?,?) }");
           cs.setString(1, res.getDescripcionRespuesta()); 
           cs.setInt(2, res.getIdPreguntaRespuesta());
           cs.execute();
         }catch (SQLException ex) {
            ex.printStackTrace();
            
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
    }
}
