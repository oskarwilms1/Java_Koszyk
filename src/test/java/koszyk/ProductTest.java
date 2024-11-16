package koszyk;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ProductTest{
    @Test
    public void CheckCode(){
        Product sut = new Product("0001","Bread",1.00);
        String result = sut.Getcode();
        assertEquals("0001",result);
    }


}