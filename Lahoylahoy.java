
package lahoylahoy;
import java.util.Scanner;

public class Lahoylahoy {
    static String[][] accounts = new String[3][2]; // [contains the username and password]
    static int userCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        // User will choose a number among the available options
        do {
            System.out.println("\n--- Choose an Option: ---");
            System.out.println("   (1) Login ");
            System.out.println("   (2) Register ");
            System.out.println("   (0) Exit ");
            System.out.print("Enter Number: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            //choosing their option
            switch (choice) {
                case 1:
                    login(scanner);
                    break;
                case 2:
                    register(scanner);
                    break;
                case 0:
                    System.out.println("GOODBYE:(");
                    break;
                default:
                    System.out.println("INVALID!! please try again");
            }
        } while (choice != 0);

        scanner.close();
    }

    //register system
    static void register(Scanner scanner) {
        if (userCount >= accounts.length) {
            System.out.println("User limit reached.");
            return;
        }

        System.out.print("Enter your Username: ");
        String user = scanner.nextLine();

        System.out.print("Enter Password: ");
        String pass = scanner.nextLine();

        System.out.print("Confirm Password: ");
        String confirm = scanner.nextLine();

        if (!pass.equals(confirm)) {
            System.out.println("Passwords does not match:(");
            return;
        }

        accounts[userCount][0] = user;
        accounts[userCount][1] = pass;
        userCount++;

        System.out.println("Registered successfully! WOW Congrats!");
    }

    //login system
    static void login(Scanner scanner) {
        System.out.print("Enter username: ");
        String user = scanner.nextLine();

        System.out.print("Enter password: ");
        String pass = scanner.nextLine();

        for (int i = 0; i < userCount; i++) {
            if (accounts[i][0].equals(user) && accounts[i][1].equals(pass)) {
                System.out.println("Hello " + user + "!");
                System.out.println("Have a wonderful day!^^");
                return;
            }
        }

        //if login does not match the user and pass
        System.out.println("Login failed. Wrong username or password.");
    }
}


