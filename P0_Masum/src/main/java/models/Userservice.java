package models;
import models.Users;
import Daos.UserDaos;

public class Userservice {
    private final UserDaos userDAO;


    public Userservice(UserDaos userDAO) {
        this.userDAO = userDAO;
    }

    public void register(Users user) {
        userDAO.save(user);
    }
    public Users getUserById(String id) {
        return userDAO.getById(id);
    }

}


