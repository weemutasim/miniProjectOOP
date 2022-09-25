import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.Map;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

public class Product {
    JSONObject rd = new JSONObject();
    JSONParser parser = new JSONParser();

    public Product() {

    }
    
    public void listCoffee() {
        System.out.println(" -------------------------------------------------------");
        System.out.println(" |  Item No.  |   Item Name   |  Price  |   In Stock   |");
        System.out.println(" -------------------------------------------------------");

        try (Reader reader = new FileReader("./data_stock.json")) {

            JSONObject jsonObject = (JSONObject) parser.parse(reader);

            /*String name = (String) jsonObject.get("name");
            System.out.println("Name: " +name);

            String student_id = (String) jsonObject.get("student_id");
            System.out.println("Student id: " +student_id);

            long age = (Long) jsonObject.get("age");
            System.out.println("Age: " +age);*/

            // getting address
            Map address = ((Map)jsonObject.get("coffee"));

            // iterating address Map
            Iterator<Map.Entry> itr = address.entrySet().iterator();
            System.out.print("Address: ");
            while (itr.hasNext()) {
                Map.Entry pair = itr.next();
                System.out.print(pair.getKey() + " : " + pair.getValue()+ "\t");
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
