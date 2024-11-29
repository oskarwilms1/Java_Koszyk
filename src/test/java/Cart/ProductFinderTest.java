package Cart;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ProductFinderTest {
    @Test
    public void testFindCheapest(){
        Cart cart = new Cart();
        Product Apple = new Product("A001", "Apple", 1.50);
        Product Bread = new Product("B001", "Bread", 1.00);
        Product Chocolate = new Product("C001,","Chocolate",2.00);
        
        cart.addProduct(Apple);
        cart.addProduct(Bread);
        cart.addProduct(Chocolate);

        Product result = cart.getCheapest();
        assertEquals(Bread,result);
    }
    @Test
    public void testFindMostExpensive(){
        Cart cart = new Cart();
        Product Bread = new Product("B001", "Bread", 1.00);
        Product Apple = new Product("A001", "Apple", 2.00);
        Product Chocolate = new Product("C001,","Chocolate",3.00);
        Product Mango = new Product("M001", "Mango", 4);
        cart.addProduct(Bread);
        cart.addProduct(Apple);
        cart.addProduct(Chocolate);
        cart.addProduct(Mango);

        Product result = cart.getMostExpensive();
        assertEquals(Mango,result);
    }
    @Test
    public void testFindNCheapest(){
        Cart cart = new Cart();
        Product Bread = new Product("B001", "Bread", 1.00);
        Product Apple = new Product("A001", "Apple", 1.50);
        Product Chocolate = new Product("C001,","Chocolate",2.00);
        Product Mango = new Product("M001", "Mango", 1.50);
        Product Cheese = new Product("CH01","Cheese",3.00);
        Product Cupcake = new Product ("CP01","Cupcake",0.50);
        cart.addProduct(Bread);
        cart.addProduct(Apple);
        cart.addProduct(Chocolate);
        cart.addProduct(Mango);
        cart.addProduct(Cheese);
        cart.addProduct(Cupcake);

        Product[] result = cart.getNCheapest(3);
        assertArrayEquals(new Product[] { Mango,Bread,Cupcake } , result);
    }
    @Test
    public void testFindNMostExpensive(){
        Cart cart = new Cart();
        Product Bread = new Product("B001", "Bread", 1.00);
        Product Apple = new Product("A001", "Apple", 1.50);
        Product Chocolate = new Product("C001,","Chocolate",2.00);
        Product Mango = new Product("M001", "Mango", 1.50);
        Product Cheese = new Product("CH01","Cheese",3.00);
        Product Cupcake = new Product ("CP01","Cupcake",0.50);
        cart.addProduct(Bread);
        cart.addProduct(Apple);
        cart.addProduct(Chocolate);
        cart.addProduct(Mango);
        cart.addProduct(Cheese);
        cart.addProduct(Cupcake);

        Product[] result = cart.getNMostExpensive(2);
        assertArrayEquals(new Product[] { Cheese,Chocolate} , result);
    }
    
}
