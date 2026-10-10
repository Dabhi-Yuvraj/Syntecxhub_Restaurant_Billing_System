
import java.util.Scanner;

public class RestaurantBillingSystem {

    static Scanner sc = new Scanner(System.in);

    static String[] items = new String[100];
    static double[] prices = new double[100];
    static int count = 4;

    static {
        items[0] = "Pizza";
        items[1] = "Burger";
        items[2] = "Sandwich";
        items[3] = "Coffee";

        prices[0] = 150;
        prices[1] = 80;
        prices[2] = 60;
        prices[3] = 40;
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Restaurant Billing System ---");
            System.out.println("1. Display Menu");
            System.out.println("2. Generate Bill");
            System.out.println("3. Add Menu Item");
            System.out.println("4. Remove Menu Item");
            System.out.println("5. Exit");
            System.out.print("Enter Your choice: ");
            if (!sc.hasNextInt()) {
                System.out.println("Invalid choice! Please enter a number.");
                sc.next();
                continue;
            }

            choice = sc.nextInt();

            switch (choice) {
                case 1 ->
                    displayMenu();
                case 2 ->
                    generateBill();
                case 3 ->
                    addItem();
                case 4 ->
                    removeItem();
                case 5 ->
                    System.out.println("Thank You!");
                default ->
                    System.out.println("Invalid Choice!");
            }
        } while (choice != 5);
        sc.close();
    }

    static void displayMenu() {
        System.out.println("\n--- Menu ---");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + items[i] + " -Rs." + prices[i]);
        }
    }

    static void generateBill() {
        if (count == 0) {
            System.out.println("\n Menu is Empty");
            return;
        }
        int[] quantities = new int[count];
        double subtotal = 0;

        displayMenu();

        for (int i = 0; i < count; i++) {
            System.out.print("Enter quantity for " + items[i] + " (0 if not ordered) : ");
            if (!sc.hasNextInt()) {
                System.out.println("Invalid quantity! Please enter a number.");
                sc.next();
                i--;
                continue;
            }

            quantities[i] = sc.nextInt();

            if (quantities[i] < 0) {
                System.out.println("Invalid quantity!");
                i--;
                continue;
            }
            subtotal += quantities[i] * prices[i];
        }
        double gst = subtotal * 0.05; //5% GST
        double total = subtotal + gst;

        System.out.println("\n--- Bill Receipt ---");
        for (int i = 0; i < count; i++) {
            if (quantities[i] > 0) {
                System.out.println(items[i] + " x " + quantities[i] + " = Rs. " + (quantities[i] * prices[i]));
            }
        }
        System.out.println("Subtotal: Rs. " + subtotal);
        System.out.println("GST (5%): Rs. " + gst);
        System.out.println("Total Bill: Rs. " + total);
    }

    static void addItem() {
        if (count == items.length) {
            System.out.println("Menu is Full!");
            return;
        }
        sc.nextLine();
        System.out.print("Enter item name : ");
        String name = sc.nextLine();

        System.out.print("Enter item price: ");
        if (!sc.hasNextDouble()) {
            System.out.println("Invalid price! Please enter a number.");
            sc.next();
            return;
        }
        double price = sc.nextDouble();

        if (name.trim().isEmpty() || price <= 0) {
            System.out.println("Invalid item name or price!");
            return;
        }
        items[count] = name;
        prices[count] = price;
        count++;

        System.out.println("Item added succesfully!");
        displayMenu();
    }

    static void removeItem() {
        if (count == 0) {
            System.out.println("Menu is Empty!");
            return;
        }
        displayMenu();

        System.out.print("Enter item number to remove : ");
        int number = sc.nextInt();

        if (number < 1 || number > count) {
            System.out.println("Invalid item number!");
            return;
        }
        for (int i = number - 1; i < count - 1; i++) {
            items[i] = items[i + 1];
            prices[i] = prices[i + 1];
        }
        count--;

        displayMenu();
    }
}
