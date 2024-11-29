package Cart;

public class DefaultComparator implements ProductComparator {
    @Override
    public int compare(Product p1, Product p2) {
        if (p2.getPrice()!=p1.getPrice()){
            return Double.compare(p2.getPrice(), p1.getPrice());
        } 
        else{
            return p1.getName().compareTo(p2.getName());
        }
    }
}
