package koszyk;

public class Product{

    private String code;
    private String name;
    private double price;
    private double discountPrice;

    public Product(String code, String name, double price){
        this.code = code;
        this.name = name;
        this.price = price;
    }
    
    public String Getcode(){
        return this.code;
    }
    public String Getname(){
        return this.name;
    }
    public double Getprice(){
        return this.price;
    }
    









}