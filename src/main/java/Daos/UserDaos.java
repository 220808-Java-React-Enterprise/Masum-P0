package Daos;
import models.Users;
import java.util.List;
import database.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.Scanner;

public class UserDaos implements crudDaos<Users> {
    public void save(Users obj) {
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO users (id, name, username, password, email) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, obj.getId());
            ps.setString(2, obj.getName());
            ps.setString(3, obj.getUsername());
            ps.setString(4, obj.getPassword());
            ps.setString(5, obj.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    String id;

    @Override
    public void update(Users obj) {

    }

    @Override
    public void delete(Users obj) {

    }

    @Override
    public Users getById(String id) {
        return null;
    }


    @Override
    public List getAll() {
        return null;
    }

    public String getUsername(String username) {
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("Select (username) FROM users WHERE username=?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (rs.next()) return rs.getString("username");
            }
        } catch (SQLException e) {
            throw new RuntimeException("An error occured");
        }
        return null;
    }

    public Users getUserByUsernameAndPassword(String username, String password) {
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next())
                return new Users(rs.getString("id"), rs.getString("username"), rs.getString("password"));
        } catch (SQLException e) {
            throw new RuntimeException("An error occurred when tyring to save to the database.");
        }

        return null;
    }

    public Users getUserByid(String id) {
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE id = ?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next())
                return new Users(rs.getString("id"), rs.getString("username"), rs.getString("password"));
        } catch (SQLException e) {
            throw new RuntimeException("No idea exists, exiting program");
        }

        return null;
    }

    public void updateinfo(String newusername, String newpassword, String newemail, String newname)


            throws SQLException {
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("UPDATE users SET username  = ?, password = ?,email=? WHERE name=?");
            ps.setString(1, newusername);
            ps.setString(2, newpassword);
            ps.setString(3, newemail);
            ps.setString(4, newname);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Users getidbyusername(String username) {
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE username = ?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next())
                return new Users(rs.getString("id"), rs.getString("username"), rs.getString("password"));
        } catch (SQLException e) {
            throw new RuntimeException("No idea exists, exiting program");
        }

        return null;
    }

    public String getbyusername(String username) {
        String please="";
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT id FROM users WHERE username = ?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                please=rs.getString(1);

            }

            System.out.println(please);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return please;

    }

}






