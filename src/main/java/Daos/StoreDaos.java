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

public class StoreDaos implements crudDaos<Stores> {
    //String path="src"



    @Override
    public void save(Stores obj) {

    }

    @Override
    public void update(Stores obj) {

    }

    @Override
    public void delete(Stores obj) {

    }

    @Override
    public Stores getById(String id) {
        return null;
    }

    @Override


    public List<Stores> getAll() {
        List<Stores> stores = new ArrayList<>();

        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM stores");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Stores newstore = new Stores(rs.getString("id"), rs.getString("name"), rs.getInt("tree1"), rs.getInt("tree2"), rs.getInt("tree3"));
                stores.add(newstore);
            }
        } catch (SQLException e) {
            throw new RuntimeException("An error occurred when tyring to save to the database.");
        }

        return stores;
    }
}

