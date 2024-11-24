package Basket;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Basket {
    private Product[] listOfProducts = new Product[0];
    private String HowtoSort = "getPrice";
    public void addProduct(Product prod) {
        if (prod == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        this.listOfProducts = increaseBasketSize(prod);
        Arrays.sort(listOfProducts, new PriceAndNameComparator(HowtoSort)); // Default sorting by price
    }

    public Product[] increaseBasketSize(Product prod) {
        Product[] newBasket = new Product[listOfProducts.length + 1];
        System.arraycopy(listOfProducts, 0, newBasket, 0, listOfProducts.length);
        newBasket[listOfProducts.length] = prod;
        return newBasket; 
    }
    public void ChangeSortSettings(String methodName){
        this.HowtoSort = methodName;
    }

    public Product[] getBasket() {
        return listOfProducts;
    }

    public void executeCommand(Command command) {
        command.execute();
    }
}