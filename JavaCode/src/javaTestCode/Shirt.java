package javaTestCode;

public class Shirt extends Clothing{
    private char fit;
    public Shirt(){
        super(0.0);
        fit = 'U';
    }
    public Shirt(double price, char fit){
        super(price);
        this.fit = fit;
    }
    public void display(){
        System.out.print("Style 1: ");
        System.out.println("The shirt is a " + fit + ". The price is " + super.getPrice() + ".");
        System.out.print("Style 2: ");
        System.out.print("The shirt is a " + fit + ".");
        super.display();
    }

}