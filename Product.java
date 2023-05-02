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
    public String getId(){
        return product_id;
    }
    public String getName(){
        return product_name;
    }
    public int getSellPrice(){
        return sellPrice;
    }
    public int getQuantity(){
        return quantity;
    }
    public int getPurchasePrice(){
        return purchasePrice;
    }
    public int getSoldN(){
        return soldN;
    }
    public void setPrice(int newPrice){
        sellPrice = newPrice;
    }
    public void setQuantity(int newQuantity){
        quantity = newQuantity;
    }
    public void setPurchasePrice(int newPurchasePrice){
        purchasePrice = newPurchasePrice;
    }

    public void setSoldN(int newSoldN){
        soldN = newSoldN;
    }

    public void updatePurchaseHistory(int quantity,int price){
        if(!purchaseHistory.containsKey(price)){
            purchaseHistory.put(price,quantity);
            return;
        }
        int tmp = purchaseHistory.get(price);
        purchaseHistory.put(price, tmp + quantity);
    }
    public void updateOrderHistory(int quantity){
        if(!orderHistory.containsKey(sellPrice)){
            orderHistory.put(sellPrice,quantity);
            return;
        }
        int tmp = orderHistory.get(sellPrice);
        orderHistory.put(sellPrice,quantity);
    }

    public int getAveragePurchasePrice(){
        int N = 0;
        int total = 0;
        for(int value : purchaseHistory.keySet()){
            total = total + value * purchaseHistory.get(value);
            N = N + purchaseHistory.get(value);
        }
        return total/N;
    }
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
