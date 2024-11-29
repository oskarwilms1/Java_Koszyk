package Cart;

import java.util.Comparator;

public class Cart {
    private Product[] products;
    private int productCount;
    private Comparator CartComparator = new DefaultComparator();
    private PromotionManager promotionManager = new PromotionManager();
    private SortManager SortManager = new SortManager();
    private ProductFinder Finder = new ProductFinder();

    public Cart() {
        this.products = new Product[0];
        this.productCount = 0;
    }
    private void add(Product product){
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
    public Product getCheapest(){
        return Finder.FindCheapest(this);
    }
    public Product getMostExpensive(){
        return Finder.FindMostExpensive(this);
    }
    public Product[] getNCheapest(int n){
        return Finder.FindNCheapest(this,n);
    }
    public Product[] getNMostExpensive(int n){
        return Finder.FindNMostExpensive(this, n);
    }
    private void applyPromotions() {
        promotionManager.applyPromotions(this);
    }
    public void applyOneTimePromotion(Product product){
        promotionManager.applyOneTimePromotion(this, product);
    }
    public void setComparator(Comparator<Product> comparator){
        this.CartComparator = comparator;
    }
    public Comparator<Product> getComparator(){
        return this.CartComparator;
    }
    public Product[] getProducts() {
        Product[] activeProducts = new Product[productCount];
        System.arraycopy(products, 0, activeProducts, 0, productCount);
        return activeProducts;
    }

    public void sort(){
        this.products=SortManager.sort(this);
    }
    public int getProductCount() {
        return productCount;
    }
    private void remove(Product product){
        for (int i = 0; i < productCount; i++) {
            if (products[i].equals(product)) {
                System.arraycopy(products, i + 1, products, i, productCount - i - 1);
                products[productCount-1] = null;
                break;
                }
        }
    }

    public void removeProduct(Product product) {
        remove(product);
        productCount--;
        applyPromotions();
        sort();
    }
}