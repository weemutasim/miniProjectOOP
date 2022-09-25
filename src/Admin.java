import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;
public class Admin {
    String password;
    int select, slmenu;
    Scanner sc;
    JSONObject obj = new JSONObject();

    public Admin(Scanner rk) {
        sc=rk;
    }

    public void loginMain() {
        while (true) {
            System.out.print("Please Enter Password or ( 1 to Back in Main Menu ) : ");
            password = sc.next();
            int pass = Integer.parseInt(password);
            if (pass == 123456) {
                break;
            }else if (pass == 1) {
                break;
            } else {
                System.out.println("Invalid Password!");
            }
        }
    }
    /*public void setUser(String username) {
        this.username = username;
    }
    public void setPass(String password) {
        this.password = password;
    }*/
    public String getPass() {
        return password;
    }
    public void printWelcome() {
        //System.out.print("\033[H\033[2J");
        System.out.println("\nWELCOME TO COFFEE SHOP SYSTEM\n");
        System.out.println(">> 1. Costumer");
        System.out.println(">> 2. Admin Panel");
        System.out.println(">> 3. Exit");
        System.out.print("\nplease select >> ");
        select = sc.nextInt();
    }
    public int getSelect() {
        return select;
    }
    public void printMenu() {
        //System.out.print("\033[H\033[2J");
        System.out.println("\n>>>> Admin Panel <<<<");
        System.out.println("1. Total Cash Today");
        System.out.println("2. Add Coffee Item");
        System.out.println("3. Delete Item");
        System.out.println("4. Item List");
        System.out.println("5. Instant Order Preview");
        System.out.println("0. Main Menu");
        System.out.print("Enter Your From 1-0 >> ");
        slmenu = sc.nextInt();
    }
    public int getSlmenu() {
        return slmenu;
    }
    public void dataWrite() {

        //JSONArray coffee = new JSONArray();
        /*System.out.print("Enter add Item No. >> ");
        coffee.add(sc.nextInt());
        System.out.print("Enter add Item Name >> ");
        coffee.add(sc.next());
        System.out.print("Enter add Price >> ");
        coffee.add(sc.nextDouble());
        System.out.print("Enter add Stock >> ");
        coffee.add(sc.nextInt());*/

        JSONObject objcf = new JSONObject();
        System.out.print("Enter add Item No. >> ");
        objcf.put("itemId", sc.nextInt());
        System.out.print("Enter add Item Name >> ");
        objcf.put("itemName", sc.next());
        System.out.print("Enter add Price >> ");
        objcf.put("price", sc.nextDouble());
        System.out.print("Enter add Stock >> ");
        objcf.put("stock", sc.nextInt());

        obj.put("coffee", objcf);
        //obj.put("coffee", coffee);

        try(FileWriter file = new FileWriter("./data_stock.json")) {
            file.write(obj.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(obj);
    }

}
