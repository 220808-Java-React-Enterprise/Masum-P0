import Daos.UserDaos;
import database.ConnectionFactory;
import models.Login;
import models.Userservice;

import java.io.IOException;
import java.sql.SQLException;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;
public class Main {

    public static void main(String[] args) throws SQLException, URISyntaxException, IOException {

        UserDaos user= new UserDaos();


        new Login(new Userservice(new UserDaos())).newmenu();

        System.exit(0);
        /*try {
            System.out.println(ConnectionFactory.getInstance().getConnection());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/

    }
}
