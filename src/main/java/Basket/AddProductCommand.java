package Basket;

public class AddProductCommand implements Command {
    private Basket basket;
    private Product product;

    public AddProductCommand(Basket basket, Product product) {
        this.basket = basket;
        this.product = product;
    }

    @Override
    public void execute() {
        basket.addProduct(product);
    }
}