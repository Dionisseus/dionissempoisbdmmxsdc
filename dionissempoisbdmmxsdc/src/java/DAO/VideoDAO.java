/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Video;
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
public class VideoDAO {
    
    
          public static void insertar(Video user) {
       ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
         try {
            cs = conn.prepareCall("{ call video_insertar(?,?,?) }");
            cs.setString(1, user.getPathVideo());
            cs.setInt(2, user.getIdProductoVideo());
            cs.setBoolean(3, true);
        
            cs.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
    }
          
           public static List<Video> TodosVideos(int idProductoVideo) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            cs = conn.prepareCall("{ call todosVideosProducto(?) }");
            cs.setInt(1, idProductoVideo);
            rs = cs.executeQuery();
            List<Video> userLista = new ArrayList<Video>();
            while (rs.next()) {
                Video img = new Video(
                        rs.getInt("idVideo"), 
                        rs.getString("pathVideo"),
                        rs.getInt("idProductoVideo"),
                        rs.getBoolean("activoVideo")
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
    
    
}
