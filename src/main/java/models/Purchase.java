package models;
import Daos.ordersDaos;
import models.Login;
import Daos.PurchaseDaos;

import java.util.List;
import java.util.Scanner;

public class Purchase {
    public void shop(String username) {
        String ordernumber = String.valueOf(Math.floor(Math.random() * 1000000));
        int storepref = 0;
        int saptree1 = 0;
        int saptree2 = 0;
        int saptree3 = 0;
        int westtree1 = 0;
        int westtree2 = 0;
        int westtree3 = 0;
        int xx = 0;
        Scanner s = new Scanner(System.in);
        System.out.print("We currently have two stores in operation right now, Westcoast Firs and Sappy Logs \n Press 1 for WestCoast firs \n Press 2 for Sappy logs \n Press 3 to exit \n");
        String storechoice = s.nextLine();
        while (storepref == 0) {
            switch (storechoice) {
                case "1":
                    System.out.println("Great chioce, personally I like Westcoast Firs more");
                    storepref = 1;
                    break;
                case "2":
                    System.out.println("Great chioce personally, I like Sappy logs more");
                    storepref = 2;
                    break;
                case "3":
                    System.exit(0);
                default:
                    System.out.println("invalid response, Try again\n Press 1 for WestCoast firs \n Press 2 for Sappy logs \n Press 3 to exit");
                    storechoice = s.nextLine();
            }


            if (storepref == 1) {
                System.out.println("West coast elms has 3 diffrent types of trees\n Forest elms \n Palm trees \n Birch trees\n Press 1 to buy a Forest elm, 2 to buy a Palm tree, 3 to buy a Birchtree, press 4 to exit");
                Stores westCoast = new Stores();


                String treeresponse = s.nextLine();

                while (xx == 0) {
                    switch (treeresponse) {
                        case "1":
                            westtree1 = westtree1 + 1;
                            System.out.println("You have selected a Forest elm,that will be $8891 and has been added to your cart, " +
                                    "will there be anything else?\n  Press 1 to buy a Forest elm,\n  2 to buy a Palm tree,\n  3 to buy a Birchtree,\n  press 4 to see your cart");
                            treeresponse = s.nextLine();
                            break;

                        case "2":
                            westtree2 = westtree2 + 1;
                            System.out.println("You have selected a Palm tree,that will be $4211 and has been added to your cart, " +
                                    "will there be anything else?\n  Press 1 to buy a Forest elm,\n  2 to buy a Palm tree,\n  3 to buy a Birchtree,\n  press 4 to see your cart");
                            treeresponse = s.nextLine();
                            break;
                        case "3":
                            westtree3 = westtree3 + 1;
                            System.out.println("You have selected a Birch,that will be $4242 and has been added to your cart, " +
                                    "will there be anything else?\n  Press 1 to buy a Forest elm,\n  2 to buy a Palm tree,\n  3 to buy a Birchtree,\n  press 4 to see your cart");
                            treeresponse = s.nextLine();
                            break;
                        case "4":
                            xx = 2;
                            break;
                    }

                }
            }
            if (storepref == 1) {
                Stores WestCoastfir = new Stores();
                WestCoastfir.setStore("555", westtree1, westtree2, westtree3);

                //newpurchase.update(WestCoastfir);
                int total = westtree1 * 8891 + westtree2 * 4211 + westtree3 * 4242;
                System.out.println("Your cart includes " + westtree1 + "Forest Elm, " + westtree2 + " Palm tree, " +
                        "" + westtree3 + " Birch," + "that will be a total of $" + total);
                Stores SapLog = new Stores();
                SapLog.setStore("894", westtree1, westtree2, westtree3);
                PurchaseDaos newpurchase = new PurchaseDaos();
                //newpurchase.update(saplog);

                orders neworder = new orders();

                neworder.setOrder(ordernumber, username, total, westtree1, westtree2, westtree3);

                ordersDaos neworderDaos = new ordersDaos();
                neworderDaos.save(neworder);


                System.out.print("Would you like to purchase? enter 1 for yes or 2 for no");
                int orderinquiry = Integer.parseInt(s.nextLine());


                if (orderinquiry == 1) {
                    System.out.println("Your username : "+username+"\nour order number: " + ordernumber + "\nYour order total is : $" + total + " \n your items are " + westtree1 + "Forest Elm, " + westtree2 + " Palm tree, " + "" + westtree3 + " Birch");

                } else if (orderinquiry == 2) {
                    System.out.print("Okay understood, May the forest be with you ");
                }
                System.out.println("Goodbye");

            }



            if (storepref == 2) {
                System.out.println("West coast elms has 3 diffrent types of trees\n Red oak \n Yew \n Rubber\n Press 1 to buy a Red oak, 2 to buy a Yew tree, 3 to buy a Rubber tree, press 4 to exit");
                Stores saplog = new Stores();


                String treeresponse = s.nextLine();
                xx = 0;
                while (xx == 0) {
                    switch (treeresponse) {
                        case "1":
                            saptree1 = saptree1 + 1;
                            System.out.println("You have selected a Red oak elm,that will be $8891 and has been added to your cart, " +
                                    "will there be anything else?\n  Press 1 to buy a Red oak,\n  2 to buy a Yew,\n  3 to buy a Rubber tree,\n  press 4 to see your cart");
                            treeresponse = s.nextLine();
                            break;

                        case "2":
                            saptree2 = saptree2 + 1;
                            System.out.println("You have selected a Yew,that will be $4211 and has been added to your cart, " +
                                    "will there be anything else?\n  Press 1 to buy a Red oak,\n  2 to buy a Yew,\n  3 to buy a Rubber tree,\n  press 4 to see your cart");
                            treeresponse = s.nextLine();
                            break;
                        case "3":
                            saptree3 = saptree3 + 1;
                            System.out.println("You have selected a Rubber tree,that will be $4242 and has been added to your cart, " +
                                    "will there be anything else?\n  Press 1 to buy a Red oak,\n  2 to buy a Yew,\n  3 to buy a Rubber tree,\n press 4 to see your cart");
                            treeresponse = s.nextLine();
                            break;
                        case "4":
                            xx = 2;
                            break;
                    }

                }
            }

            if (storepref == 2) {
                int total = saptree1 * 8891 + saptree2 * 4211 + saptree3 * 4242;
                System.out.println("Your cart includes " + saptree1 + "Red oak, " + saptree2 + " Yew, " +
                        "" + saptree3 + " Rubber tree," + "that will be a total of $" + total);
                Stores SapLog = new Stores();
                SapLog.setStore("894", saptree1, saptree2, saptree3);
                // PurchaseDaos newpurchase = new PurchaseDaos();
                //newpurchase.update(saplog);

                orders neworder = new orders();

                neworder.setOrder(ordernumber, username, total, saptree1, saptree2, saptree3);

                ordersDaos neworderDaos = new ordersDaos();
                neworderDaos.save(neworder);

                System.out.println("Would you like to purchase? enter 1 for yes or 2 for no");
                int orderinquiry = Integer.parseInt(s.nextLine());


                if (orderinquiry == 1) {
                    System.out.println("Your username : "+username+"\nYour order number: " + ordernumber + "\nYour order total is : $" + total + " \n Your items are : " + saptree1 + " Red oak, " + saptree2 + " Yew tree, " + "" + saptree3 + " Rubber Tree");

                } else if (orderinquiry == 2) {
                    System.out.print("Okay understood, May the forest be with you ");
                }
                System.out.println("Goodbye");

            }
        }

        //public void purchase (List < Stores > Warehouse) {

    }
}



