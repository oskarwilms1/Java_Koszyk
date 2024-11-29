package Cart;

import java.util.Comparator;
import java.util.Arrays;

public class ProductFinder {
    private SortManager SortManager = new SortManager();
    public Product FindCheapest(Cart cart){
        Product[] products = cart.getProducts();
        Product result = products[0];
        for(int i = 0;i < cart.getProductCount()-1;i++){
            if (products[i].getPrice() >= products[i+1].getPrice()){
                result = products[i+1];
            }
            else{
                result = products[i];
            
                }
            }
        return result; 
    }
    public Product[] FindNCheapest(Cart cart,int n){
        Comparator<Product> SavedComparator = cart.getComparator();
        cart.setComparator(new PriceComparator());
        Product[] products = SortManager.sort(cart);
        Product[] result = new Product[n];
        System.arraycopy(products, n ,result, 0, n);
        cart.setComparator(SavedComparator);

        return result;
    }

    public Product FindMostExpensive(Cart cart){
        Product[] products = cart.getProducts();
        Product result = products[0];
        double maxPrice = products[0].getPrice();
    
        for(int i = 1;i < cart.getProductCount();i++){
            if (products[i].getPrice() > maxPrice){
                maxPrice = products[i].getPrice();
                result = products[i];
            }
        }
        return result;
    }
    public Product[] FindNMostExpensive(Cart cart,int n){
        
        Comparator<Product> SavedComparator = cart.getComparator();
        cart.setComparator(new PriceComparator());
        Product[] products = SortManager.sort(cart);
        Product[] result = new Product[n];
        System.arraycopy(products, 0 ,result, 0, n);
        cart.setComparator(SavedComparator);
        
        return result;
    }
    public Product FindProductFromCode(Cart cart,Product product){
        String code = product.getCode();
        Product[] products = cart.getProducts();
        for (int i=0;i < cart.getProductCount(); i+=1){
            if (products[i].getCode() == code){
                return products[i];
            }
        }
        return null;
    }
    public boolean IsIn(Cart cart,Product product){
        String code = product.getCode();
        Product[] products = cart.getProducts();
        for(int i=0;i < cart.getProductCount(); i+=1){
            if (products[i].getCode()==code){
                return true;
            }
        }
        return false;
    }
}
    
