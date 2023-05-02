import java.util.HashMap;
import java.util.SplittableRandom;

public class salesManeger {
    HashMap<String,Product> register;
    public salesManeger(){
        register  = new HashMap<>();
    }
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
    public void order_product(String product_id, int quantity){
        if (register.get(product_id) == null) {
            System.out.println("There is no product saved with this id");
            return;
        }
        if(register.get(product_id).getQuantity() < quantity){
            System.out.println("Do not have enough products with the corresponding ID");
            return;
        }
        Product tmp = register.get(product_id);
        tmp.setQuantity(tmp.getQuantity() - quantity);
        tmp.setSoldN(tmp.getSoldN() + quantity);
        tmp.updateOrderHistory(quantity);
        register.put(product_id,tmp);

    }
    public int get_quantity_of_product(String product_id){
        return register.get(product_id).getQuantity();
    }
    public int get_average_price(String product_id){
        Product tmp = register.get(product_id);
        return tmp.getAveragePurchasePrice();
    }
    public int get_product_profit(String product_id){
        Product prd = register.get(product_id);
        int prchPrice = prd.getAveragePurchasePrice();
        int ordrPrice = prd.getAverageOrderPrice();
        int totalSales = prd.getSoldN();
        return (ordrPrice - prchPrice) * totalSales;
    }
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
    public void exit(){
        System.exit(0);
    }
}
