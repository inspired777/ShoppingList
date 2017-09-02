package sample;

public class Item {
    private int id;
    private String purchName;
    private int price;

    public Item(int purchId, String purchaseName, int purchasePrice) {
        id = purchId;
        purchName = purchaseName;
        price = purchasePrice;
    }

    public String getPurchName(){
        return purchName;
    }
    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }
}
