package Cart;

import java.util.Arrays;

public class SortManager{
    
    public void sort(Cart cart) {
        Arrays.sort(cart.getProducts(),0,cart.getProductCount(),cart.getComparator());
    }
}
