package javaTestCode;

public class Sock extends Clothing{
    private char length = 'U';
    public Sock(double price, char length){
        super(price);
        this.length = length;
    }
    @Override
    public void display(){
        System.out.print("Style 3: ");
        System.out.print("The sock is a " + length + ".");
        super.display();
    }
}
