import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// This class is responsible for communicating with the user

public class saleManagerMain {
    private static salesManeger process;
    private static String[] inputArray;
    public static void main(String[] args) throws IOException {
        process = new salesManeger();
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        printFunctions();
        while (true) {
            System.out.println("Desired action: ");
            String input = myObj.nextLine();  // Read user input
            inputArray = input.trim().split("\\s+");

            switch (inputArray[0]) {
                case "exit" -> {
                    System.out.println("Exiting application...");
                    process.exit();
                }
                case "help" -> printFunctions();
                case "save_product" -> saveProduct();
                case "purchase_product" -> purchaseProduct();
                case "order_product" -> orderProduct();
                case "get_quantity_of_product" -> getQuantityOfProduct();
                case "get_average_price" -> getAveragePrice();
                case "get_product_profit" -> getProductProfit();
                case "get_fewest_product" -> getFewestProduct();
                case "get_most_popular_product" -> getMostPopularProduct();
                case "get_orders_report" -> getOrdersReport();
                case "export_orders_report" -> exportOrdersReport();
                default -> {
                    System.out.println("Can not perform this action");
                    printFunctions();
                }
            }
        }
    }
    // print all supported functions
    private static void printFunctions(){
        System.out.println("Here is a list of actions this program provides: ");
        System.out.println("save_product {product_id} {product_name} {price}");
        System.out.println("purchase_product {product_id} {quantity} {price}");
        System.out.println("order_product {product_id} {quantity}");
        System.out.println("get_quantity_of_product {product_id}");
        System.out.println("get_average_price {product_id}");
        System.out.println("get_product_profit {product_id}");
        System.out.println("get_fewest_product");
        System.out.println("get_most_popular_product");
        System.out.println("get_orders_report");
        System.out.println("export_orders_report {path}");
        System.out.println("exit");
    }
    // Saves the product information given by the user
    private static void saveProduct(){
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
    }
    // Purchases products entered by the user
    private static void purchaseProduct(){
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
    }
    // Orders products entered by the user
    private static void orderProduct(){
        if (inputArray.length != 3) {
            System.out.println("order_product needs 2 arguments");
        } else {
            try {
                int numQuantity = Integer.parseInt(inputArray[2]);
                process.order_product(inputArray[1], numQuantity);
                System.out.println("The action was successfully performed");
            } catch (NumberFormatException e) {
                System.out.println("numQuantity should be number");
            }
        }
    }
    // Print the number of products for that ID entered by user
    private static void getQuantityOfProduct(){
        if (inputArray.length != 2) {
            System.out.println("get_quantity_of_product needs 1 argument");
        } else if(process.get_quantity_of_product(inputArray[1]) == -1) {
            System.out.println("There is no product saved with this id");
        } else {
            System.out.println(process.get_quantity_of_product(inputArray[1]));
            System.out.println("The action was successfully performed");
        }
    }
    // Print average price of a specific ID product, entered by user
    private static void getAveragePrice(){
        if (inputArray.length != 2) {
            System.out.println("get_average_price needs 1 argument");
        }else if(process.get_average_price(inputArray[1]) == -1) {
            System.out.println("There is no product saved with this id");
        } else {
            System.out.println(process.get_average_price(inputArray[1]));
            System.out.println("The action was successfully performed");
        }
    }
    // Print product profit of a specific ID product, entered by user
    private static void getProductProfit(){
        if (inputArray.length != 2) {
            System.out.println("get_product_profit needs 1 argument");
        }else if((process.get_product_profit(inputArray[1]) == -1)) {
            System.out.println("There is no product saved with this id");
        } else {
            System.out.println(process.get_product_profit(inputArray[1]));
            System.out.println("The action was successfully performed");
        }
    }
    //  Print fewest remained products
    private static void getFewestProduct(){
        if (inputArray.length != 1) {
            System.out.println("get_fewest_product doesn't need argument");
        } else {
            System.out.println(process.get_fewest_product());
            System.out.println("The action was successfully performed");
        }
    }
    // Print most popular product
    private static void getMostPopularProduct() {
        if (inputArray.length != 1) {
            System.out.println("get_most_popular_product doesn't need argument");
        } else {
            System.out.println(process.get_most_popular_product());
            System.out.println("The action was successfully performed");
        }
    }
    // write order reports
    private static void getOrdersReport() {
        if (inputArray.length != 1) {
            System.out.println("get_orders_report doesn't need argument");
        } else {
            process.get_orders_report();
            System.out.println("The action was successfully performed");
        }
    }
    // write reports in the fail
    private static void exportOrdersReport() throws IOException {
        if (inputArray.length != 2) {
            System.out.println("export_orders_report needs 1 argument");
        } else {
            process.export_orders_report(inputArray[1]);
            System.out.println("The action was successfully performed");
        }
    }
}