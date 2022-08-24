package Daos;
import models.Users;
import models.orders;

import java.util.ArrayList;
import java.util.List;
import database.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
public class ordersDaos implements crudDaos<orders> {
    @Override
    public void save(orders obj) {
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {

            PreparedStatement ps = con.prepareStatement("INSERT INTO orders (id, username,user_id, total, tree1, tree2, tree3,store_name) VALUES (?, ?, ?, ?, ?, ?,?,?)");
            ps.setString(1, obj.getId());
            ps.setString(2, obj.getUsername());
            ps.setString(3, obj.getUser_id());
            ps.setInt(4, obj.getTotal());
            ps.setInt(5, obj.getTree1());
            ps.setInt(6, obj.getTree2());
            ps.setInt(7, obj.getTree3());
            ps.setString(8,obj.getthisstore());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public String[] returnorder(String username) {
        String[] orderdetails=new String[6];
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("Select * FROM orders WHERE username=?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = rs.getString(i);
                    System.out.print(rsmd.getColumnName(i)+": "+columnValue + " "  );
                }
                System.out.println("");
            }
            /*while (rs.next()) {
                System.out.println("Order Id: "+rs.getString(1));
                System.out.println("Order Username "+rs.getString(2));
                System.out.println("Order total"+rs.getString(3));
                System.out.println("Store Name:"+rs.getString(8));
            }*/
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return orderdetails;
    }
    public orders forReview(String order_id) {
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("Select * FROM orders WHERE id=?");
            ps.setString(1, order_id);
            ResultSet rs = ps.executeQuery();
            if((rs.next())) {
                return new orders(rs.getString(3), rs.getString(8));
            }else {
                return new orders(rs.getString(3), rs.getString(8));
            }
            } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

        @Override
    public void update(orders obj) {

    }

    @Override
    public void delete(orders obj) {

    }

    @Override
    public orders getById(String id) {
        return null;
    }

    @Override
    public List<orders> getAll() {
        return null;
    }
}
