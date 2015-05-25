/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Categoria;
import POJO.MetodoPago;
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
public class MetodoPagoDAO {
    public static List<MetodoPago> lista(){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            cs = conn.prepareCall("{ call todosMetodoPago() }");
            rs = cs.executeQuery();
            List<MetodoPago> metodoLista = new ArrayList<MetodoPago>();
            while (rs.next()) {
                MetodoPago met = new MetodoPago(
                        rs.getInt("idMetodoPago"), 
                        rs.getString("nombreMetodoPago"), 
                        rs.getBoolean("activoMetodoPago")
                );      
                metodoLista.add(met);
            }
            return metodoLista;
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
