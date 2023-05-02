public class myReport {
    private final String ID;
    private final String productName;
    private final int quantity;
    private final int COGS;
    private final int sellingPrice;
    public myReport(String ID, String productName, int quantity, int COGS, int sellingPrice){
        this.ID = ID;
        this.productName = productName;
        this.quantity = quantity;
        this.COGS = COGS;
        this.sellingPrice = sellingPrice;
    }
    public int getQuantity(){
        return quantity;
    }
    public int getSellingPrice(){
        return sellingPrice;
    }
    public int getCOGS(){
        return COGS;
    }
    public String getID(){
        return ID;
    }
    public String getProductName(){
        return productName;
    }
}
