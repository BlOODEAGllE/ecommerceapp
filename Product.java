import java.util.HashMap;

public class Product {
    private String product_id;
    private String product_name;
    private int sellPrice;
    private int quantity;
    private int purchasePrice;
    private HashMap<Integer,Integer> purchaseHistory;
    private HashMap<Integer,Integer> orderHistory;

    private int soldN;
    public Product(String product_id, String product_name, int price){
        this.product_id = product_id;
        this.product_name = product_name;
        this.sellPrice = price;
        quantity = 0;
        purchasePrice = 0;
        soldN = 0;
        purchaseHistory = new HashMap<>();
        orderHistory = new HashMap<>();
    }
    // returns product id
    public String getId(){
        return product_id;
    }
    // returns product name
    public String getName(){
        return product_name;
    }
    // returns at what price it will be sold
    public int getSellPrice(){
        return sellPrice;
    }
    // returns product quantity
    public int getQuantity(){
        return quantity;
    }
    // returns at what price they bought it
    public int getPurchasePrice(){
        return purchasePrice;
    }
    // returns how many products were sold
    public int getSoldN(){
        return soldN;
    }
    // sets new sell price
    public void setPrice(int newPrice){
        sellPrice = newPrice;
    }
    // Changes quantity of product
    public void setQuantity(int newQuantity){
        quantity = newQuantity;
    }
    // Changes new purchase price
    public void setPurchasePrice(int newPurchasePrice){
        purchasePrice = newPurchasePrice;
    }
    // Changes the quantity of products sold
    public void setSoldN(int newSoldN){
        soldN = newSoldN;
    }

    // Updates purchase history after purchase
    public void updatePurchaseHistory(int quantity,int price){
        if(!purchaseHistory.containsKey(price)){
            purchaseHistory.put(price,quantity);
            return;
        }
        int tmp = purchaseHistory.get(price);
        purchaseHistory.put(price, tmp + quantity);
    }
    // Updates order history after order
    public void updateOrderHistory(int quantity){
        if(!orderHistory.containsKey(sellPrice)){
            orderHistory.put(sellPrice,quantity);
            return;
        }
        int tmp = orderHistory.get(sellPrice);
        orderHistory.put(sellPrice,quantity);
    }
    // Calculates the average purchase price for a given product history
    public int getAveragePurchasePrice(){
        int N = 0;
        int total = 0;
        for(int value : purchaseHistory.keySet()){
            total = total + value * purchaseHistory.get(value);
            N = N + purchaseHistory.get(value);
        }
        return total/N;
    }
    // Calculates the average order price for a given order history
    public int getAverageOrderPrice(){
        int N = 0;
        int total = 0;
        for(int value : orderHistory.keySet()){
            total = total + value * orderHistory.get(value);
            N = N + orderHistory.get(value);
        }
        return total/N;
    }
}
