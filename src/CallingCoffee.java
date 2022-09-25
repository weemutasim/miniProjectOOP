import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;

import java.util.Map;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.NumberFormat.Style;
import java.util.Iterator;
import java.util.Scanner;

public class CallingCoffee {
    public static void main(String[] args) {
        Scanner rk = new Scanner(System.in);
        Admin am = new Admin(rk);
        Product pd = new Product();
        int x=0;
        Integer.valueOf(x).longValue();
        

        String password;

        password = "123456";

        while (true) {
            if (am.getSelect() == 3) {
                break;
            }
            am.printWelcome();
            switch (am.getSelect()) {
                case 1:
                    pd.listCoffee();
                    try (Reader reader = new FileReader("./data_stock.json")) {
                        JSONParser parser = new JSONParser();
                        JSONObject jsonObject = (JSONObject) parser.parse(reader);

                        // loop array
                        //JSONArray cf = (JSONArray) jsonObject.get("coffee");
                        //System.out.println(cf);

                        /*for (int i = 0; i < 4; i++) {
                            JSONObject coffee = (JSONObject) cf.get(i);
                            int item_no = coffee.get("items_n0").hashCode();
                            String item_name = coffee.get("items_name").toString();

                            System.out.println("Test Coffee" +item_no+ "Test" +item_name);
                        }*/
                        //JSONObject JScoffee = (JSONObject) jsonObject.get("coffee");
                        //int item_no = (Integer) JScoffee.get("item_no");
                        //int intValue = Integer.parseInt(item_no);
                        //String item_name = (String) JScoffee.get("item_name");
                        //int price = (int) JScoffee.get("price");
                        //Double stock = (Double) JScoffee.get("stock");
                        //System.out.println(item_no +"\t"+ item_name +"\t"+ price +"\t"+ stock);
                        //System.out.println("Test int : " +item_no);
                        //System.out.println("Test int : " +intValue+ "\t" +item_no);

                        // getting coffee
                        Map coffee = ((Map)jsonObject.get("coffee"));

                        // iterating address Map
                        Iterator<Map.Entry> itr = coffee.entrySet().iterator();
                        while (itr.hasNext()) {
                            Map.Entry pair = itr.next();
                            System.out.print("\t" +pair.getValue()+ "\t");
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    am.loginMain();
                    if (am.getPass().equals(password)) {
                        System.out.println("Access Granted! Welcome!");
                        do {
                            am.printMenu();
                            switch (am.getSlmenu()) {
                                case 1:
                                    // pd.listCoffee();

                                    break;
                                case 2:
                                    am.dataWrite();
                                    break;
                                case 3:

                                    break;
                                case 4:

                                    break;
                                case 5:
                                    break;
                                case 6:
                                    break;
                                case 0:
                                    break;
                                default:
                                    System.out.println("Invalid!");
                                    break;
                            }
                        } while (am.getSlmenu() != 0);
                    }
                    break;
                case 3:
                    System.out.println("THANKS");
                    break;
                default:
                    System.out.println("Invalid!");
                    break;
            }
        }
    }
}
