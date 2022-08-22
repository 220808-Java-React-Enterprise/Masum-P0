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
