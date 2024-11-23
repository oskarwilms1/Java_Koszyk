package Basket ;

import java.lang.reflect.Method;
import java.util.Comparator;

public class PriceAndNameComparator implements Comparator<Product> {
    Method StoredMethod;
    PriceAndNameComparator(){
        this.StoredMethod = Product.getMethod("getPrice");
    }
    PriceAndNameComparator(String method){
        this.StoredMethod = method;
    }
    @Override
    public int compare(Product p1, Product p2) {

        int Comparison = p1.class.getMethod(StoredMethod);
        
        return Comparison;
    }

}