package Daos;
import  models.Admin;
import models.Users;
import java.util.List;
import database.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
public class AdminDaos implements crudDaos<Admin> {
    public void restock(int tree1,int tree2,int tree3,String name) {

        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("UPDATE stores SET tree1  = tree1+?, tree2 =tree2+ ?,tree3=tree3+? WHERE name=?");
            ps.setInt(1, tree1);
            ps.setInt(2, tree2);
            ps.setInt(3, tree3);
            ps.setString(4, name);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void newstore(String newstorename,String newstoreid,int restockTree1,int restockTree2,int restockTree3){
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO stores (id,name,ratings,tree1,tree2,tree3) VALUES(?,?,?,?,?,?)");
            String non="none";
            ps.setString(1,newstoreid);
            ps.setString(2,newstorename);
            ps.setString(3,non);
            ps.setInt(4, restockTree1);
            ps.setInt(5, restockTree3);
            ps.setInt(6, restockTree3);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void banuser(String banuser){
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM users WHERE name=?");
            ps.setString(1,banuser);


            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void adminlog(String name,String storename,String storeid,String username,String userid,int tree1,int tree2,int tree3) {
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("insert into adminactvities(name,store_name,store_id,username,user_id,tree1,tree2,tree3) values(?,?,?,?,?,?,?,?)");
            ps.setString(1,name);
            ps.setString(2,storename);
            ps.setString(3,storeid);
            ps.setString(4,username);
            ps.setString(5,userid);
            ps.setInt (6,tree1);
            ps.setInt (7,tree2);
            ps.setInt (8,tree3);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void save(Admin obj) {

    }

    @Override
    public void update(Admin obj) {

    }

    @Override
    public void delete(Admin obj) {

    }

    @Override
    public Admin getById(String id) {
        return null;
    }

    @Override
    public List<Admin> getAll() {
        return null;
    }

}
