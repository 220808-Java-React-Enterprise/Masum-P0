import Daos.UserDaos;
import database.ConnectionFactory;
import models.Login;
import models.Userservice;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        new Login(new Userservice(new UserDaos())).newmenu();


        try {
            System.out.println(ConnectionFactory.getInstance().getConnection());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
