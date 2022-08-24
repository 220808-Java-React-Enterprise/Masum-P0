package models;
import Daos.AdminDaos;
import Daos.ReviewDaos;
import Daos.UserDaos;
import Daos.ordersDaos;
import java.io.File;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.Scanner;


public class Login {

    static int login1 = 1;
    static int login2 = 1;
    static int login3 = 1;
    static int login4 = 1;
    static int both=0;
    private final Userservice userService;
    String name;
    static String username;
    String password;
    String email;
    String id;
    private Users New;


    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }


    public Login(Userservice userService) {
        this.userService = userService;
    }


    public void newmenu() throws SQLException {
        System.out.println("Hello to Bob's discount trees are you a returning user or would you like to make a new account? \n---If new user press [1]-----------------\n---If you would like to login press [2]--\n---If you would like to exit press [3]---");
        Scanner s = new Scanner(System.in);
       String menuResponse = s.nextLine();
        while (!menuResponse.equals("done")) {
            switch (menuResponse) {
                case "1":
                    while (login1 == 1) {
                        try {
                            Users user = new Users();
                            //Users user = signup();

                            System.out.println("Hello welcome to Bob's discount trees, we hope you leave with some more love in you heart than you came");
                            System.out.println("Why don't you tell us your name?");
                            name = s.nextLine();
                            System.out.println("It's great to meet you " + name + " lets set you up an account, Please enter the username you want");

                            username = s.nextLine();

                            System.out.println("Great job! Your username set to " + username + " Now enter a password, no spaces are allowed, you will have three attempts to set password.");
                            password = s.nextLine();








                            System.out.println("Please confirm password, you will have 3 attempts to do so");
                            String checkpassword = s.nextLine();
                            while (login3 != 4) {
                                if (!(checkpassword !=password)) {
                                    int passwordAttempt = 4 - login3;
                                    System.out.println("Sorry that is incorrect, try again you have " + passwordAttempt + " attempts remaining");
                                    checkpassword = s.nextLine();
                                    login3++;

                                }
                                if (login3 == 4) {
                                    System.out.println("I'm sorry you have used all your attempts restarting....");
                                    System.exit(0);
                                } else {
                                    login3 = 4;
                                }
                            }
                            System.out.println("Now please enter your email including your email domain etc: @gmail.com, @hotmail.com,@UCC.edu");
                            email = s.nextLine();
                            while (login4 != 4) {
                                if (!email.contains("@") && (!email.contains(".com"))) {
                                    System.out.println("That is an invalid email try again");
                                    email = s.nextLine();
                                    login4++;
                                } else {
                                    login4 = 4;
                                }
                            }
                            Users newcustomer = new Users();
                            newcustomer.userSet(String.valueOf(Math.floor(Math.random() * 10000000)), name, username, password, email);
                            userService.register(newcustomer);
                            System.out.println("Your account details are:");
                            System.out.println(newcustomer.getId() + " " + newcustomer.getName() + " " + newcustomer.getUsername() + " " + newcustomer.getPassword() + " " + newcustomer.getEmail());
                            login1 = 2;
                            System.out.println("---Taking you to main menue---");
                            returningUser();
                        } catch (Exception e) {
                            e.printStackTrace();
                            throw new RuntimeException();

                        }

                    }
                    break;
                case "2":
                    try {
                        returningUser();
                    } catch (URISyntaxException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "3":
                    menuResponse="done";
                    System.exit(0);
                default:
                    System.out.println("Not an allowed chioce try again");
                    menuResponse=s.nextLine();
                    break;
            }

        }
    }
    public void returningUser() throws SQLException, URISyntaxException, IOException {
        Scanner s = new Scanner(System.in);
        String username = "";
        String password = "";
        int userpasscheck = 0;
        while (userpasscheck == 0) {
            System.out.println("Please enter your username");
            username = s.nextLine();
            System.out.println("Enter your password");
            password = s.nextLine();
            if (username.equals("bob")){
                AdminDaos Bob=new AdminDaos();
                AdminService Bobby=new AdminService(Bob);
                Bobby.AdminMenu();
                System.exit(0);
            }
            try {
                Users user = userService.Loging(username, password);
                userpasscheck = 1;

            } catch (Exception e) {
                //e.printStackTrace();
                // throw new RuntimeException();
                System.out.println("Sorry that username and password do not match");
                userpasscheck = 0;
            }
        }

        //System.out.println("would you like to buy or ");
        //String userchoosestobuyorupdate= s.nextLine();
        int x=0;
        while(x==0) {
            System.out.println("Welcome to Main Menu,Press \n[1]To make a purchase,\n[2]To review your orders\n[3]Update your information,\n[4]To enter a rating for your order\n[5]Learn more about our trees.\n[6] to exit application");
            String menueSelectionForReturningUser = s.nextLine();
            switch (menueSelectionForReturningUser) {
                case "1":
                    Purchase buyer = new Purchase();
                    buyer.shop(username);
                    break;
                case "2":
                    //System.out.println("Enter your username to confirm looking at order");
                    //username = s.nextLine();
                    ordersDaos recall = new ordersDaos();
                    recall.returnorder(username);
                    break;
                case "3":
                    UserDaos someguy = new UserDaos();

                    System.out.println("To update your info you must enter your name");
                    String newname = s.nextLine().toString();
                    System.out.println("Please enter your new username");
                    String newusername = s.nextLine().toString();
                    System.out.println("Enter new username");
                    String newpassword = s.nextLine().toString();
                    System.out.println("Enter new email");
                    String newemail = s.nextLine().toString();

                    someguy.updateinfo(newusername, newpassword, newemail, newname);
                    System.out.println("You have changed your account details, goodbye.");
                    break;
                case "4":
                    System.out.println("We're so happy you're leaving a review, for security please your Order number");
                    String orderNumberForReview = s.nextLine();
                    ReviewDaos newordercheck = new ReviewDaos();

                    if (newordercheck.CheckOrder(orderNumberForReview) == false) {
                        System.out.println("I'm sorry that order doesn't exist, try again or enter  exit program");
                        orderNumberForReview = s.nextLine();
                        if (orderNumberForReview.equals("exit")) {
                            System.exit(0);
                        }
                    }
                    System.out.println("We found your order\nPlease enter your comments");
                    String comment = s.nextLine();
                    System.out.println("Please enter your rating from 1 to 10");
                    int rating = Integer.valueOf(s.nextLine());
                    if (!(rating <= 10 && rating >= 0)) {
                        System.out.println("A number from 1 to 10 please");
                        rating = Integer.valueOf(s.nextLine());
                    }
                    orders blalal=new orders();
                    ordersDaos orderReview=new ordersDaos();
                    ReviewDaos rev= new ReviewDaos();
                    //System.out.println(orderReview.forReview(orderNumberForReview).getStorename());
                   //System.out.println(orderReview.forReview(orderNumberForReview).getuser_id());
                    String ReviewID=String.valueOf(Math.floor(Math.random()*100000));
                    System.out.println("Great we've logged your review\nReturning to main menue\n----------------------------------------");
                    int ratings=rating;
                    rev.registerReview(ReviewID,orderReview.forReview(orderNumberForReview).getuser_id(),orderReview.forReview(orderNumberForReview).getStorename(),orderNumberForReview,comment, ratings);
                case "5":
                    System.out.println("We would like to ask permission to open a webpage\nIf that is acceptable enter YES if not enter NO");
                    String webz=s.nextLine().toLowerCase();
                    if(webz.equals("yes")){
                        String URL="src/main/java/models/POhtml/projectP0.html";
                        File file=new File(URL);
                        Desktop.getDesktop().browse(file.toURI());

                    }
                        break;
                case "6":
                    System.exit(0);
            }



            }
        }


    }

