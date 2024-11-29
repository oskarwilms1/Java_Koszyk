package Cart;

public class ProductFinder {

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
    public Product FindProductFromCode(Cart cart,String code){
        Product[] products = cart.getProducts();
        for (int i=0;i < cart.getProductCount(); i+=1){
            if (products[i].getCode() == code){
                return products[i];
            }
        }
        return null;
    }
    public boolean IsIn(Cart cart,String code){
        Product[] products = cart.getProducts();
        for(int i=0;i < cart.getProductCount(); i+=1){
            if (products[i].getCode()==code){
                return true;
            }
        }
        return false;
    }
}
    
