package Cart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

import org.junit.*;


public class SortingManagerTest {
    private Cart cart = new Cart();

    @Test
    public void testDefaultSort(){
        Product Bread = new Product("B001", "Bread", 1.00);
        Product Apple = new Product("A001", "Apple", 1.00);
        Product Chocolate = new Product("C001,","Chocolate",2.00);
        cart.addProduct(Bread);
        cart.addProduct(Apple);
        cart.addProduct(Chocolate);

        Product[] result = cart.getProducts();
        assertArrayEquals(new Product[] { Chocolate,Apple,Bread },result);
    }
    @Test
    public void testPriceSort(){
        Product Bread = new Product("B001", "Bread", 1.00);
        Product Mango = new Product("M001", "Mango", 1.50);
        Product Apple = new Product("A001", "Apple", 1.00);
        Product Chocolate = new Product("C001,","Chocolate",2.00);
        cart.setComparator(new PriceComparator());
        cart.addProduct(Bread);
        cart.addProduct(Mango);
        cart.addProduct(Apple);
        cart.addProduct(Chocolate);

        Product[] result = cart.getProducts();
        assertArrayEquals(new Product[] { Chocolate,Mango,Bread,Apple },result);
    }
    @Test
    public void testNameSort(){
        Product Bread = new Product("B001", "Bread", 1.00);
        Product Mango = new Product("M001", "Mango", 1.50);
        Product Apple = new Product("A001", "Apple", 1.00);
        Product Chocolate = new Product("C001,","Chocolate",2.00);
        cart.setComparator(new NameComparator());
        cart.addProduct(Bread);
        cart.addProduct(Mango);
        cart.addProduct(Apple);
        cart.addProduct(Chocolate);

        Product[] result = cart.getProducts();
        assertArrayEquals(new Product[] { Apple,Bread,Chocolate,Mango },result);
    }
    @Test
    public void testDefaultSortWithRemoving(){
        Product Bread = new Product("B001", "Bread", 1.00);
        Product Mango = new Product("M001", "Mango", 1.50);
        Product Apple = new Product("A001", "Apple", 1.00);
        Product Chocolate = new Product("C001,","Chocolate",2.00);

        cart.addProduct(Bread);
        cart.addProduct(Mango);
        cart.addProduct(Apple);
        cart.addProduct(Chocolate);
        cart.removeProduct(Mango);

        Product[] result = cart.getProducts();
        assertArrayEquals(new Product[] { Chocolate,Apple,Bread },result);
    }
    @Test
    public void testPriceSortWithRemoving(){
        Product Bread = new Product("B001", "Bread", 1.00);
        Product Mango = new Product("M001", "Mango", 1.50);
        Product Apple = new Product("A001", "Apple", 1.00);
        Product Chocolate = new Product("C001,","Chocolate",2.00);
        Product Cheese = new Product("CH01","Cheese",3.00);
        cart.setComparator(new PriceComparator());
        cart.addProduct(Bread);
        cart.addProduct(Mango);
        cart.addProduct(Apple);
        cart.addProduct(Chocolate);
        cart.removeProduct(Mango);
        cart.addProduct(Cheese);

        Product[] result = cart.getProducts();
        assertArrayEquals(new Product[] { Cheese,Chocolate,Bread,Apple},result);
    }
    @Test
    public void testNameSortWithRemoving(){
        Product Bread = new Product("B001", "Bread", 1.00);
        Product Mango = new Product("M001", "Mango", 1.50);
        Product Apple = new Product("A001", "Apple", 1.00);
        Product Chocolate = new Product("C001,","Chocolate",2.00);
        Product Cheese = new Product("CH01","Cheese",3.00);
        cart.setComparator(new NameComparator());
        cart.addProduct(Bread);
        cart.addProduct(Mango);
        cart.addProduct(Apple);
        cart.addProduct(Chocolate);
        cart.removeProduct(Mango);
        cart.addProduct(Cheese);

        Product[] result = cart.getProducts();
        assertArrayEquals(new Product[] { Apple,Bread,Cheese,Chocolate } ,result);
    }
}
