/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import POJO.Venta;
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
    public static List<Venta> misVentas(int idUsuario) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;        
            try {
            cs = conn.prepareCall("{ call misVentas(?) }");
            cs.setInt(1, idUsuario);
            rs = cs.executeQuery();
            List<Venta> listaVentas = new ArrayList<Venta>();
            while (rs.next()) {
                Venta vent = new Venta(rs.getInt("idVenta"), 
                rs.getBoolean("confirmadaVenta"),
                rs.getInt("cantidadCompradaVenta"),
                rs.getInt("idAvisoVenta"),
                rs.getInt("idUsuarioVenta"), 
                rs.getInt("idMetodoPagoElegidoVenta"), 
                rs.getString("nombreProducto"),
                rs.getString("Comprador"),
                rs.getString("nombreMetodoPago"),
                rs.getString("descripcionAviso"),
                rs.getString("Vendedor"),
                rs.getString("fechaVenta"),
                rs.getInt("precioProducto"),
                rs.getString("pathImagen"));  
                listaVentas.add(vent);
            }
            return listaVentas;
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