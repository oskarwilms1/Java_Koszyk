package Cart;

public class Product {
    private String code;
    private String name;
    private double price;
    private double discountPrice;

    public Product(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.discountPrice = price; 
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    public void resetDiscount(){
        this.discountPrice = this.price;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void applyDiscount(double discount) {
        this.discountPrice = this.price - (this.price * discount);
    }
}