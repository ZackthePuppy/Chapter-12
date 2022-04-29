public class Inventory {
    private int stockNum, itemQty;
    private String itemName;

    public Inventory (int stockNum, int itemQty, String itemName) {
        this.stockNum = stockNum;
        this.itemQty = itemQty;
        this.itemName = itemName;
    }
    /**
     * @return String return the itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param itemName the itemName to set
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * @return String return the itemName
     */
    public int getstockNum() {
        return stockNum;
    }

    /**
     * @param itemName the itemName to set
     */
    public void setstockNum(int stock) {
        this.stockNum = stock;
    }

    /**
     * @return String return the itemName
     */
    public int getitemQty() {
        return itemQty;
    }

    /**
     * @param itemName the itemName to set
     */
    public void setitemQty(int qty) {
        this.itemQty = qty;
    }
}
