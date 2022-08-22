package models;
import Daos.UserDaos;

import java.util.List;

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


    public boolean isDuplicateUsername(String username) {
        if (userDAO.getUsername(username) != null)
            return false;


        return false;
    }

    public Users Loging(String username, String password) {
        Users user = userDAO.getUserByUsernameAndPassword(username, password);

        if (user == null) throw new RuntimeException("\nIncorrect username or password");
        return user;

    }
}






