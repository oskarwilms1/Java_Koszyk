package Basket ;

import java.util.Comparator;

public class PriceAndNameComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        int priceComparison = Double.compare(p1.getPrice(), p2.getPrice());

        if (priceComparison != 0) {
            return priceComparison;
        } else {
            return p1.getName().compareTo(p2.getName());
        }
    }
}