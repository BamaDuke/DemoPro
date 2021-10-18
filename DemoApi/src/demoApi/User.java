package demoApi;

import java.util.Objects;

public class User {
	private String username;
	private String password;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getUsername(){
        return this.username;
    }

    public void setUsername(String username){
        this.username = username;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public int verifyAccount(String username, String password) {
    	if(Objects.equals(this.password, password) && Objects.equals(this.username, username))
    		return 1;//true
    	return 0; //False
    }
    
    public void display() {
    	System.out.println("Username: " + username +" Password: " + password);
    }
}
