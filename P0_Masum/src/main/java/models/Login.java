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
    String username;
    String password;
    String email;
    String id;
    private Users New;



    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
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
    public void returningcustomer() {
        System.out.println("Please enter your username");
        Scanner s = new Scanner(System.in);
        String attempt = s.nextLine();

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
                        password = s.nextLine();
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
                        System.out.println(newcustomer.getId() + " " + newcustomer.getName() + " " + newcustomer.getUsername() + " " + newcustomer.getPassword() + " " + newcustomer.getEmail());

                        login1 = 2;
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw new RuntimeException();

                    }

                }
            case 2:
                //System.out.println("Welcome back, enter username");
            case 3:
                System.exit(0);        }
    }
}
