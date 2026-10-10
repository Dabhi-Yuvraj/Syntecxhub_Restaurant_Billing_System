import java.util.Scanner;

public class Cookie{


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the cost of the meal : ");
        double mealPrice = scan.nextDouble();
        double tax = 0.07 * mealPrice;
        double tip = (mealPrice + tax) * 0.15;
        double totalBill = mealPrice + tax + tip;

        System.out.printf("Cost of meal : %f \n", mealPrice);
        System.out.printf("Tax : %f \n", tax);
        System.out.printf("Tip : %f \n", tip);
        System.out.printf("Total bill : %f \n", totalBill);
    }
}