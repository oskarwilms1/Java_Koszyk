package Basket ;

import java.util.Arrays;

public class Basket {
    private Product[] listOfProducts = new Product[0];

    public void addProduct(Product prod) {
        this.listOfProducts = increaseBasketSize(prod);
        Arrays.sort(listOfProducts, new PriceAndNameComparator());
    }

    public Product[] increaseBasketSize(Product prod) {
        Product[] newBasket  = new Product[listOfProducts.length + 1];
        System.arraycopy(listOfProducts, 0, newBasket, 0, listOfProducts.length);
        newBasket[listOfProducts.length] = prod;
        return newBasket; 
    }

    public Product[] getBasket () {
        return listOfProducts;
    }

    public void executeCommand(Command command) {
        command.execute();
    }
}
