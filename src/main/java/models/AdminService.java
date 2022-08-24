package models;
import Daos.AdminDaos;
import Daos.UserDaos;
import sun.reflect.generics.tree.Tree;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.*;
public class AdminService {
    private final AdminDaos adminDaos;

    public AdminService(AdminDaos adminDaos) {
        this.adminDaos = adminDaos;
    }

    public void AdminMenu() {
        int nameChange = 0;
        String banUser = "0";
        int restockStore = 0;
        int restockTree1 = 0;
        int restockTree2 = 0;
        int restockTree3 = 0;
        int AdminChioces = 0;
        String newstoreid="0";
        String newstorename="0";
        String userid="0";
        AdminDaos newadmin=new AdminDaos();
        String userchnaged = "";
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome Bob and/ or Bob's discount tree's manager , enter your Name");
        String adminName = s.nextLine().toLowerCase();
        while (AdminChioces == 0) {
            System.out.println("Press \n[1] Open new store \n[2] Restock \n[3] Ban a user \n[4] Exit Application");
            String AdminActivity = s.nextLine();
            System.out.println("--------------------");

            switch(AdminActivity){
                case "1":
                    System.out.println("What is the name of the new store?");
                    newstorename=s.nextLine();
                    System.out.println("What is the id of the new store?");
                    newstoreid=s.nextLine();
                    System.out.println(" Enter the name of the first tree ie:?");
                    String newtree11=s.nextLine();
                    System.out.println(" Enter how many of the first tree ?");
                    restockTree1=Integer.parseInt(s.nextLine());
                    System.out.println(" Enter the name of the second tree ?");
                    String newtree12=s.nextLine();
                    System.out.println(" Enter how many of the second tree?");
                    restockTree2=Integer.parseInt(s.nextLine());
                    System.out.println(" Enter the name of the third tree ?");
                    String newtree13=s.nextLine();
                    System.out.println(" Enter how many of the third tree?");
                    restockTree3= Integer.parseInt(s.nextLine());
                    System.out.println(" New Store created, awaiting approval.");
                    newadmin.newstore(newstorename,newstoreid,restockTree1,restockTree2,restockTree3);
                    break;

                   // Admin
                    case "2":
                    System.out.println("What is the name of the store?");
                    newstorename=s.nextLine();
                    newstorename= newstorename.replaceAll("\\s", "");
                    System.out.println(" How many of the first tree ie:?");
                    restockTree1=Integer.parseInt(s.nextLine());
                    System.out.println(" How many of the second tree ie:?");
                    restockTree2=Integer.parseInt(s.nextLine());
                    System.out.println(" How many of the third tree ie:?");
                    restockTree3=Integer.parseInt(s.nextLine());
                    newadmin.restock(restockTree1,restockTree2, restockTree3,newstorename);
                    System.out.println(" Restock complete");
                    break;
                    case "3":
                         System.out.println("what is the name of the user?");
                         banUser=s.nextLine();
                         UserDaos check= new UserDaos();
                         check.getUsername(banUser);
                         newadmin.banuser(banUser);
                         System.out.println("They will never harm our trees again");
                case "4":
                    AdminChioces=2;





            }
            newadmin.adminlog(adminName,newstorename,newstoreid,banUser,userid,restockTree1,restockTree2,restockTree3);















        }


    }
}