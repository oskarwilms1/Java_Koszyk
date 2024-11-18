package Basket;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Basket.Product;

public class ProductTest{
    @Test
    public void CheckCode(){
        Product sut = new Product("0001","Bread",1.00);
        String result = sut.getCode();
        assertEquals("0001",result);
    }


}