package Cart;

import java.util.Arrays;
import java.util.Comparator;

public class SortManager {

    public Product[] sort(Cart cart){
        Comparator<Product> comparator = cart.getComparator();
        Product[] products = cart.getProducts();
        int length = cart.getProductCount();

        
        Arrays.sort(products, 0, length, comparator);


        return products;
    }
}
