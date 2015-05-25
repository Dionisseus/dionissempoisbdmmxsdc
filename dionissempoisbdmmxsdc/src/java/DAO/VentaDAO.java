/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Venta;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import xClasses.DBUtil;

/**
 *
 * @author Asus
 */
public class VentaDAO {
    public static void altaVenta(Venta ven){
    ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
         try {
            cs = conn.prepareCall("{ call altaVenta(?,?,?,?,?) }");
            cs.setBoolean(1, ven.isConfirmadaVenta());
            cs.setInt(2, ven.getCantidadCompradaVenta());
            cs.setInt(3, ven.getIdAvisoVenta());
            cs.setInt(4, ven.getIdUsuarioVenta());
            cs.setInt(5, ven.getIdMetodoPagoElegidoVenta());
            cs.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
}
}