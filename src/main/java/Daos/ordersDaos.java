package Daos;
import models.orders;
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
            PreparedStatement ps = con.prepareStatement("INSERT INTO orders (id, username, total, tree1, tree2, tree3) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, obj.getId());
            ps.setString(2, obj.getUsername());
            ps.setInt(3, obj.getTotal());
            ps.setInt(4, obj.getTree1());
            ps.setInt(5, obj.getTree2());
            ps.setInt(6, obj.getTree3());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
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
