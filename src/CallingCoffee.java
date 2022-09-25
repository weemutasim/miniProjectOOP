import java.util.Scanner;

public class CallingCoffee {
    public static void main(String[] args) {
        Scanner rk = new Scanner(System.in);
        Admin am = new Admin(rk);
        Product pd = new Product();
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
                    break;
                case 2:
                    am.loginMain();
                    if (am.getPass().equals(password)) {
                        System.out.println("Access Granted! Welcome!");
                        do {
                            am.printMenu();
                            switch (am.getSlmenu()) {
                                case 1:
                                    
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
