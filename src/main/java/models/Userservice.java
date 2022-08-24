package models;
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

    public void updateinfo(String is) {

    }


    public boolean isValidEmail(String email) {
        if (email.contains("@") && (email.contains(".com"))) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isValidUsername(String username) {
        if (username.matches("^(?=[a-zA-Z0-9._]{8,20}$)(?!.*[_.]{2})[^_.].*[^_.]$")) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isValidPassword(String password) {
        if (password.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")) {
            return false;
        } else {

            return true;
        }

    }
}








