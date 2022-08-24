package Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import database.ConnectionFactory;
import models.Stores;
import models.Users;
import database.ConnectionFactory;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.List;
import models.Review;
import models.orders;

public class ReviewDaos implements crudDaos<Review> {
    public boolean CheckOrder(String ordernumberforreview){
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("Select (username) FROM orders WHERE id=?");
            ps.setString(1, ordernumberforreview);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException("An error occured");
        }
    }
    public void registerReview(String reviewID,String user_id,String store_name ,String order_number,String comment,int rating) {
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("insert into  reviews(id,user_id,comments,rating,storename) values(?,?,?,?,?)");
            ps.setString(1,reviewID);
            ps.setString(2, user_id);
            ps.setString(3, comment);
            ps.setInt(4, rating);
            ps.setString(5, store_name);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
        @Override
    public void save(Review obj) {

    }

    @Override
    public void update(Review obj) {

    }

    @Override
    public void delete(Review obj) {

    }

    @Override
    public Review getById(String id) {
        return null;
    }

    @Override
    public List<Review> getAll() {
        return null;
    }
}
