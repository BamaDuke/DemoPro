package javaTestCode;

public class Clothing{
    private double price;
    
    //constructor
    public Clothing(){
        price = 0.0;
    }
    public Clothing(double price){
        this.price = price;
    }
    public double getPrice(){
        return this.price;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void display(){
        System.out.println(" The price is " + this.getPrice() + ". ");
    }

}