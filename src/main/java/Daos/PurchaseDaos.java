package Daos;
import models.Stores;
import models.Users;
import java.util.List;
import database.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.Purchase;
import models.PurchaseService;
public class PurchaseDaos {

    public void save(Stores obj) {

    }

    public void update(Stores obj) {
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("UPDATE stores set (tree1=tree1-?) where id=? )");
            ps.setInt(1, obj.getTree1());
            ps.setString(2, obj.getID());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());

        }
    }
}






