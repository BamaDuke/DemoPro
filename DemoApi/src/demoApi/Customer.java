package demoApi;

public class Customer extends User {
	//Customer information
	private String name;
	private String phone;
	private String email;

	//Constructor
	public Customer(String username, String password, String name, String phone, String email){
		super(username, password);
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
	
	public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }
    
    public String getPhone(){
        return this.phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }
    
    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }
    
    public void display() {
    	super.display();
    	System.out.println("\tName: " + this.name);
    	System.out.println("\tEmail: " + this.email + "\n\tPhone: " + this.phone);
    }
    
    
}
