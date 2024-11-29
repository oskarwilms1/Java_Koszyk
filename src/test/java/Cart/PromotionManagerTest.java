package Cart;

import static org.junit.Assert.assertEquals;

import org.junit.*;

public class PromotionManagerTest {
    private Cart cart = new Cart();

    @Test
    public void testVolumeDiscount() {
        cart.addProduct(new Product("P001", "Product 1", 150));
        cart.addProduct(new Product("P002", "Product 2", 200));
        


        assertEquals(332.5, cart.calculateTotal(), 0.01); 
    }

    @Test
    public void testFreeProductOnThreeItems() {
        cart.addProduct(new Product("P001", "Product 1", 50));
        cart.addProduct(new Product("P002", "Product 2", 100));
        cart.addProduct(new Product("P003", "Product 3", 30)); // 3 produkty - najtańszy w gratisie

        
        assertEquals(150.0, cart.calculateTotal(), 0.01); // Produkt 3 jest usuwany
    }

    @Test
    public void testFreeCupPromotion() {
        cart.addProduct(new Product("P001", "Product 1", 210));
        cart.addProduct(new Product("P002", "Product 2", 50));

        assertEquals(3, cart.getProductCount()); // Sprawdza, czy kubek został dodany
    }

    @Test
    public void testOneTimeDiscountCoupon() {
        Product Product1 = new Product("P001", "Product 1", 100);
        Product Product2 = new Product("P002", "Product 2", 30);
        Product Product4 = new Product("P004", "Product 4", 10);
        cart.addProduct(Product4);
        cart.addProduct(Product1);
        cart.addProduct(Product2);
        cart.applyOneTimePromotion(Product1);
        double total = cart.calculateTotal();

        assertEquals(100.0, total, 0.01);
    }

    
}
