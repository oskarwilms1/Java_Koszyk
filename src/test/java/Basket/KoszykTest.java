package Basket;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import Basket.Basket;
import Basket.Product;

public class KoszykTest {
    @Test
    public void checkKoszyk(){
        Basket sut = new Basket();
        Product Bread = new Product("0001","Bread",10.00);
        Product Butter = new Product("0002","Butter",4.00);
        sut.addProduct(Bread);
        sut.addProduct(Butter);
        Product[] result = sut.getBasket();
        assertTrue(Arrays.equals(new Product[] { Butter,Bread }, result));

        }
    @Test
    public void checkSortingDefault(){
        Basket sut = new Basket();
        Product Apple = new Product("0010", "Apple", 1.00);

        Product Bread = new Product("0001", "Bread", 1.00);
        Product Beer = new Product("0010", "Beer", 1.50);
        Product Cinnamon = new Product("0202", "Cinnamon", 1.00);

        sut.addProduct(Apple);
        sut.addProduct(Bread);
        sut.addProduct(Beer);
        sut.addProduct(Cinnamon);
        Product[] result = sut.getBasket();
        assertTrue(Arrays.equals(new Product[] { Apple,Bread,Cinnamon,Beer}, result));
    }
    @Test
    public void checkSortingByName(){
        Basket sut = new Basket();
        Product Apple = new Product("0010", "Apple", 1.00);
        Product Apricot = new Product("0011", "Apricot", 1.00);
        Product Bread = new Product("0001", "Bread", 1.00);
        Product Beer = new Product("0010", "Beer", 1.50);
        Product Cinnamon = new Product("0202", "Cinnamon", 1.00);
        sut.ChangeSortSettings("getName");
        sut.addProduct(Apple);
        sut.addProduct(Apricot);
        sut.addProduct(Bread);
        sut.addProduct(Beer);
        sut.addProduct(Cinnamon);
        Product[] result = sut.getBasket();
        assertTrue(Arrays.equals(new Product[] { Apple,Apricot,Beer,Bread,Cinnamon}, result));
    }
}   
    



