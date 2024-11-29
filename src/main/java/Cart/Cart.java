package Cart;

import java.util.Comparator;

public class Cart {
    private Product[] products;
    private int productCount;
    private Comparator CartComparator = new DefaultComparator();
    private PromotionManager promotionManager = new PromotionManager();
    private SortManager SortManager = new SortManager();

    public Cart() {
        this.products = new Product[0];
        this.productCount = 0;
    }
    public void add(Product product){
        products[productCount] = product;
        productCount++;
    }

    public void addProduct(Product product) {
        resizeArray();
        add(product);
        applyPromotions();
        sort();
    }

    private void resizeArray() {
        int newSize = products.length + 1;
        Product[] newArray = new Product[newSize];
        System.arraycopy(products, 0, newArray, 0, products.length);
        products = newArray;
    }

    public double calculateTotal() {
        double total = 0;
        for (int i = 0; i < productCount; i++) {
            total += products[i].getDiscountPrice();
        }
        return total;
    }
    public void applyPromotions() {
        promotionManager.applyPromotions(this);
    }
    public Comparator getComparator(){
        return this.CartComparator;
    }
    public Product[] getProducts() {
        Product[] activeProducts = new Product[productCount];
        System.arraycopy(products, 0, activeProducts, 0, productCount);
        return activeProducts;
    }

    public void sort(){
        SortManager.sort(this);
    }
    public int getProductCount() {
        return productCount;
    }

    public void removeProduct(Product product) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].equals(product)) {
                System.arraycopy(products, i + 1, products, i, productCount - i - 1);
                products[--productCount] = null;
                break;
            }
        }
    }
}