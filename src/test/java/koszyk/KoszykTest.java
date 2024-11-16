package koszyk;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class KoszykTest {
    @Test
    public void checkKoszyk(){
        Koszyk sut = new Koszyk();
        Product Bread = new Product("0001","Bread",1.00);
        sut.AddProduct(Bread);
        Product result = sut.getKoszyk();
        assertEquals(result,Bread);
    }
    


}
