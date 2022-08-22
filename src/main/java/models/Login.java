package models;
import Daos.UserDaos;

import java.util.Scanner;

public class Login {

    static int login1 = 1;
    static int login2 = 1;
    static int login3 = 1;
    static int login4 = 1;
    private final Userservice userService;
    String name;
    static String username;
    String password;
    String email;
    String id;
    private Users New;


    public void setUsername(String username){
        this.username=username;
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


    public void newmenu() {
        System.out.println("Hello to Bob's discount trees are you a returning user or would you like to make a new account? If new user press 1, if you would like to login press 2 if you would like to exit press 3");
        Scanner s = new Scanner(System.in);
        int menuResponse = Integer.parseInt(s.nextLine());
        switch (menuResponse) {
            case 1:
                while (login1 == 1) {
                    try {
                        Users user=new Users();
                        //Users user = signup();

                        System.out.println("Hello welcome to Bob's discount trees, we hope you leave with some more love in you heart than you came");
                        System.out.println("Why don't you tell us your name?");
                        name = s.nextLine();
                        System.out.println("It's great to meet you " + name + " lets set you up an account, Please enter the username you want");
                        username = s.nextLine().toLowerCase();

                        //if( username.contains())
                        System.out.println("Great job! Your username set to " + username + " Now enter a password, no spaces are allowed, you will have three attempts to set password.");
                        password = s.nextLine().toLowerCase();
                        while (password.contains(" ")) {
                            System.out.println("Please enter a password with no spaces");
                            password = s.nextLine();
                        }
                        while (login2 != 4) {
                            if (password.equals("password") || password.contains(" ")) {
                                login2++;
                                System.out.println("Invalid password, please try again, this is attempt number " + login2);
                                password = s.nextLine();
                            } else {
                                login2 = 4;
                            }
                        }
                        System.out.println("Please confirm password, you will have 3 attempts to do so");
                        String checkpassword = s.nextLine();
                        while (login3 != 4) {

                            if (checkpassword == null ? password != null : !checkpassword.equals(password)) {
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
                        System.out.println("Now please enter your email including your email domain: @gmail.com, @hotmail.com,@UCC.edu");
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
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw new RuntimeException();

                    }

                }
                break;
            case 2:
                returningUser();

                break;
            case 3:
                System.exit(0);
            default:
                throw new IllegalStateException("Unexpected value: " + menuResponse);
        }
        returningUser();
    }
    public void returningUser() {
        Scanner s = new Scanner(System.in);
        String username = "";
        String password = "";
        int userpasscheck = 0;
        while (userpasscheck == 0) {
            System.out.println("Please enter your username");
            username = s.nextLine().toLowerCase();
            System.out.println("Enter your password");
            password = s.nextLine().toLowerCase();
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
        System.out.println("We found you! Press 1 to make a purchase, 2 to review an order, 3 update your information");
        String menueSelectionForReturningUser=s.nextLine();
        System.out.println(username);
        //try {
            Purchase buyer = new Purchase();
            buyer.shop(username);
        //}catch (Exception e)
    }
    public void Userchange(){

    }






}
