package koszyk;

public class Koszyk {

    private Product[] List_Of_Products = new Product[0];

    public void AddProduct( Product prod ){
        IncreaseKoszykSize(prod);

    }

    public void IncreaseKoszykSize( Product prod ){
        int new_length = this.List_Of_Products.length + 1;
        Product[] temp_Array = new Product[new_length];
        System.arraycopy(this.List_Of_Products, 0 , temp_Array, 0 , new_length - 1);
        this.List_Of_Products = temp_Array;
        this.List_Of_Products[new_length-1] = prod;

    }

    public Product getKoszyk(){
        Product result = this.List_Of_Products[0];
        return result;
    }



}
