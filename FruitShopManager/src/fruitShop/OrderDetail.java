package fruitShop;

public class OrderDetail {
    private String product;
    private int quantity;
    private double price;
    private double amount;

    public OrderDetail() {
    }

    public OrderDetail(String product, int quantity, double price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.amount = quantity * price;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAmount() {
        return amount;
    }
}
