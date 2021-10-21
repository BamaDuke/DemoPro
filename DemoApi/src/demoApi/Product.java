package demoApi;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Product {
	private int id;
	private String modelName;
	private String modelNumber;
	private String color;
	private double price;
	private BufferedImage image;
	private String features;
	
	public Product(int id, String modelName, String modelNumber, String color, double price, String features, BufferedImage image) {
		this.id = id;
		this.modelName = modelName;
		this.modelNumber = modelNumber;
		this.color = color;
		this.price = price;
		this.image = image;
		this.features = features; 
	}
	
	public int getID(){
        return this.id;
    }

    public void setID(int id){
        this.id = id;
    }
	
	public String getModelName(){
        return this.modelName;
    }

    public void setName(String modelName){
        this.modelName = modelName;
    }
    
    public String getModelNumber(){
        return this.modelNumber;
    }

    public void setNumber(String modelNumber){
        this.modelNumber = modelNumber;
    }
    
    public String getColor(){
        return this.color;
    }

    public void setColor(String color){
        this.color = color;
    }
    
    public double getPrice(){
        return this.price;
    }

    public void setColor(double price){
        this.price = price;
    }
    
    public BufferedImage getImage(){
    	return this.image;
    }
    
    public void setImage(BufferedImage image) {
    	this.image = image;
    }
    //Test Function for local prints
    private static void writeToFile(BufferedImage image, int id) {
    	try {
    		File path = new File("C:\\Users\\Wyatt\\Desktop\\ImageTest\\" + id + ".jpg");
    		ImageIO.write(image, "jpg", path);
    		System.out.println("Writing Complete");
    	}
    	catch(IOException e){
    		System.out.println("Error: "+ e);
    	}
    }
    
    public void display() {
    	
    	System.out.println("\tID: " + this.id);
    	System.out.print("ModelName: " + this.modelName);
    	System.out.println(" ModelNumber: " + this.modelNumber);
    	System.out.print("Color: " + this.color);
    	System.out.println(" Price: " +this.price);
    	System.out.println("Features include: " + this.features);
    	System.out.println("Image: " +this.image);
    	writeToFile(this.image, this.id);
    }
    
    
    
}
