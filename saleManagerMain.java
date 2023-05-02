import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class saleManagerMain {
    public static void main(String[] args) {
        salesManeger process = new salesManeger();
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        String[] inputArray;
        while (true) {
            System.out.println("Desired action");
            String input = myObj.nextLine();  // Read user input
            inputArray = input.trim().split("\\s+");

            if(inputArray[0].equals("exit")){
                System.out.println("Exiting application...");
                process.exit();
            }else if(inputArray[0].equals("save_product")) {
                if (inputArray.length != 4) {
                    System.out.println("save_product needs 3 arguments");
                } else {
                    try {
                        int numPrice = Integer.parseInt(inputArray[3]);
                        process.save_product(inputArray[1], inputArray[2], numPrice);
                        System.out.println("The action was successfully performed");
                    } catch (NumberFormatException e) {
                        System.out.println("Price should be number");
                    }
                }
            } else if(inputArray[0].equals("purchase_product")) {
                if (inputArray.length != 4) {
                    System.out.println("purchase_product needs 3 arguments");
                } else {
                    try {
                        int numPrice = Integer.parseInt(inputArray[3]);
                        int numQuantity = Integer.parseInt(inputArray[2]);
                        process.purchase_product(inputArray[1], numQuantity, numPrice);
                        System.out.println("The action was successfully performed");
                    } catch (NumberFormatException e) {
                        System.out.println("Price and Quantity should be number");
                    }
                }
            }else if(inputArray[0].equals("order_product")) {
                if (inputArray.length != 3) {
                    System.out.println("purchase_product needs 2 arguments");
                } else {
                    try {
                        int numQuantity = Integer.parseInt(inputArray[2]);
                        process.order_product(inputArray[1], numQuantity);
                        System.out.println("The action was successfully performed");
                    } catch (NumberFormatException e) {
                        System.out.println("numQuantity should be number");
                    }
                }
            } else if(inputArray[0].equals("get_quantity_of_product")){
                if (inputArray.length != 2) {
                    System.out.println("get_quantity_of_product needs 1 argument");
                } else {
                    System.out.println(process.get_quantity_of_product(inputArray[1]));
                    System.out.println("The action was successfully performed");
                }
            }else  if(inputArray[0].equals("get_average_price")){
                if (inputArray.length != 2) {
                    System.out.println("get_average_price needs 1 argument");
                } else {
                    System.out.println(process.get_average_price(inputArray[1]));
                    System.out.println("The action was successfully performed");
                }
            }else if(inputArray[0].equals("get_product_profit")){
                if (inputArray.length != 2) {
                    System.out.println("get_product_profit needs 1 argument");
                } else {
                    System.out.println(process.get_product_profit(inputArray[1]));
                    System.out.println("The action was successfully performed");
                }
            }else if(inputArray[0].equals("get_fewest_product")){
                if (inputArray.length != 1) {
                    System.out.println("get_fewest_product doesn't need argument");
                } else {
                    System.out.println(process.get_fewest_product());
                    System.out.println("The action was successfully performed");
                }
            }else if(inputArray[0].equals("get_most_popular_product")){
                if (inputArray.length != 1) {
                    System.out.println("get_most_popular_product doesn't need argument");
                }
                System.out.println(process.get_most_popular_product());
                System.out.println("The action was successfully performed");
            }else{
                System.out.println("Can not perform this action");
            }
        }
    }
}