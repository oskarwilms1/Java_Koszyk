package Cart;

public class PriceComparator implements ProductComparator {
    @Override
    public int compare(Product p1, Product p2) {
        return Double.compare(p2.getPrice(), p1.getPrice()); 
    }
}
