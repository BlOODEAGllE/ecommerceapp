import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.SplittableRandom;

public class salesManeger {
    HashMap<String,Product> register;
    ArrayList<myReport> reportList = new ArrayList<>();
    public salesManeger(){
        register  = new HashMap<>();
    }
    // add product to catalog
    public void save_product(String product_id, String product_name, int price){
        if(register.containsKey(product_id)){
            Product tmp = register.get(product_id);
            tmp.setPrice(price);
            register.put(product_id,tmp);
            return;
        }
        Product tmp = new Product(product_id,product_name,price);
        register.put(product_id,tmp);
    }
    // buy product, update its quantity and purchase history
    public void purchase_product(String product_id, int quantity, int price) {
        if (register.get(product_id) == null) {
            System.out.println("There is no product saved with this id");
            return;
        }
        Product tmp = register.get(product_id);
        tmp.setPurchasePrice(price);
        tmp.setQuantity(tmp.getQuantity() + quantity);
        tmp.updatePurchaseHistory(quantity,price);
        register.put(product_id, tmp);
    }
    // orders product, updates order history and saves specific information
    // for late to print whole order history report
    public void order_product(String product_id, int quantity){
        if (register.get(product_id) == null) {
            System.out.println("There is no product saved with this id");
            return;
        }
        if(register.get(product_id).getQuantity() < quantity){
            System.out.println("Do not have enough products with the corresponding ID");
            return;
        }
        String name = register.get(product_id).getName();
        int sellingPrice = register.get(product_id).getSellPrice();
        int COGS = get_average_price(product_id);
        myReport rpt = new myReport(product_id,name,quantity,COGS,sellingPrice);
        reportList.add(rpt);

        Product tmp = register.get(product_id);
        tmp.setQuantity(tmp.getQuantity() - quantity);
        tmp.setSoldN(tmp.getSoldN() + quantity);
        tmp.updateOrderHistory(quantity);
        register.put(product_id,tmp);
    }
    // returns current quantity for specific id product
    public int get_quantity_of_product(String product_id){
        if (register.get(product_id) == null) {
            return -1;
        }
        return register.get(product_id).getQuantity();
    }
    // calculates average price with purchase history for specific id product
    public int get_average_price(String product_id){
        if (register.get(product_id) == null) {
            return -1;
        }
        Product tmp = register.get(product_id);
        return tmp.getAveragePurchasePrice();
    }
    //  Calculates the product's profit by approximating average purchases and orders
    public int get_product_profit(String product_id){
        if (register.get(product_id) == null) {
            return -1;
        }
        Product prd = register.get(product_id);
        int prchPrice = prd.getAveragePurchasePrice();
        int ordrPrice = prd.getAverageOrderPrice();
        int totalSales = prd.getSoldN();
        return (ordrPrice - prchPrice) * totalSales;
    }
    // returns current fewest products in catalog
    public String  get_fewest_product(){
        int tmp = Integer.MAX_VALUE;
        String result = "";
        for(String product_id : register.keySet()){
            if(register.get(product_id).getQuantity() < tmp){
                tmp = register.get(product_id).getQuantity();
                result = register.get(product_id).getName();
            }
        }
        return result;
    }
    // returns the product that has been sold the most times
    public String get_most_popular_product(){
        int tmp = -1;
        String result = "";
        for(String product_id : register.keySet()){
            if(register.get(product_id).getSoldN() > tmp){
                tmp = register.get(product_id).getSoldN();
                result = register.get(product_id).getName();
            }
        }
        return result;
    }
    // print all ordered reports in order
    public void get_orders_report(){
        if(reportList.size() == 0){
            System.out.println("There has not been an order yet");
            return;
        }
        for(int i = 0; i < reportList.size(); i++){
            myReport tmp = reportList.get(i);
            System.out.println("#" + (i+1) + " ID - " + tmp.getID() + "        Product Name - " + tmp.getProductName() + "        Quantity - " + tmp.getQuantity() + "        COGS - " + tmp.getCOGS() + "        Selling Price - " + tmp.getSellingPrice());
        }
    }
    // write to the file with filePath as destination and FileWritter
    public void export_orders_report(String filePath) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        // Write the CSV header
        writer.append("ID,Product Name,Quantity,COGS,Selling Price\n");

        // Write each myReport object as a new line in the CSV file
        for (myReport report : reportList) {
            writer.append(report.getID() + ",");
            writer.append(report.getProductName() + ",");
            writer.append(report.getQuantity() + ",");
            writer.append(report.getCOGS() + ",");
            writer.append(report.getSellingPrice() + "\n");
        }
        writer.close();
        System.out.println("CSV file successfully exported to " + filePath);
    }
    public void exit(){
        System.exit(0);
    }

}
