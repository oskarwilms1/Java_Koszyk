package Cart;

import java.util.Arrays;

public class PromotionManager {
    ProductFinder Finder = new ProductFinder();
    public void applyPromotions(Cart cart) {
        ResetDiscounts(cart);
        applyVolumeDiscount(cart);
        applyFreeProduct(cart);
        applyCupPromotion(cart);
    }
    public void ResetDiscounts(Cart cart){
        Product[] products = cart.getProducts();
        for(int i = 0; i<cart.getProductCount();i+=1){
            products[i].resetDiscount();
        }
    }
    public void applyOneTimePromotion(Cart cart,String code){

        Product product = Finder.FindProductFromCode(cart,code);
        if (product != null){
            product.applyDiscount(0.3);
        }
    }

    private void applyVolumeDiscount(Cart cart) {
        if (cart.calculateTotal() > 300) {
            for (int i = 0; i < cart.getProductCount(); i++) {
                cart.getProducts()[i].applyDiscount(0.05); 
            }
        }
        else{

        }
    }

    private void applyFreeProduct(Cart cart) {
        
        if (cart.getProductCount() >= 3) {
            Finder.FindCheapest(cart).applyDiscount(1);

        }
    }

    private void applyCupPromotion(Cart cart) {
        if (cart.calculateTotal() > 200 && Finder.IsIn(cart, "CUP001") == false){
            Product cup = new Product("CUP001", "Firmowy Kubek", 0);
            cart.addProduct(cup); 
        }
    }
}
