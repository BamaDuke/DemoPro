package demoApi;


import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import javax.imageio.ImageIO;


public class Main {
	ArrayList<Integer> cartIds = new ArrayList<Integer>();
	public static void main (String[] args) throws IOException{
		String username, password, name, phone, email;
		String modelName, modelNumber, color, features;
		double price;
		int id;
		BufferedImage image;
		checkFiles();
		
		 
		ArrayList<Integer> idsForFind = new ArrayList<Integer>();
		ArrayList<Integer> idsForFind1 = new ArrayList<Integer>();
		idsForFind.add(0);
		idsForFind1.add(0);
		idsForFind = findForUser("Features", "5g speed", idsForFind);
		System.out.println(idsForFind);
		idsForFind = findForUserPrice(80, idsForFind);
		System.out.println(idsForFind);
		idsForFind = findForUser("Features", "battery life", idsForFind);
		System.out.println(idsForFind);
		//Customer initializer
		/*username = "AdamT";
		password = "HaloWars";
		String fName = "Adam";
		String mName = "Danny";
		String lName = "Thomas";
		name = fName + " " + mName+ " " + lName;
		phone = "615-309-8765";
		email = "adam.thomas@gmail.com";*/
		
		
		int width = 963;
		int height = 640;
		
		//Product initializer 
		/*modelName = "IPhone12";
		modelNumber = "XT34-XL5555";
		color = "blue";
		price = 88.99;
		image = null; 
		id = 100002;
		image = readImageFromFile(width, height, image, id);
		features = "Camera, touch screen, great battery life, 5g speed";*/
		
		
			   
		
		
	    //test Object class 
	    //Customer object = new Customer( username, password, name, phone, email);
	    //object.display();
	    //System.out.println("Test for Same: " + object.verifyAccount(username, password));//pass 1
	    //System.out.println("Test for not equal: " + object.verifyAccount("Adam", password));//pass 0 
	    //System.out.println("Test for not equal: " + object.verifyAccount(username, "pass"));//pass 0
	    
	   // Product iphone = new Product(id,modelName, modelNumber, color, price, features,image);
	   // iphone.display();
	    
		String check = "JohnW.txt";
		//createNewUser("JohnW", "PassTest", "Johnny", "William", "Wong", "314-499-3312", "john.wong@gmail.com" );
	    int i = checkFileExists(check); // 1 exists | 0 Doesn't
	    System.out.println("Result is " + i);
	    if(i == 1) {
	    	//userLogin();
	    	System.out.println("Run interface"); 
	    }
	    
	}
	
	
	private static BufferedImage readImageFromFile(int width, int height, BufferedImage image, int id) {
    	try {
    		File fs = new File(".");
    		String path = fs.getCanonicalPath() + "\\Images\\";
    		File f = new File(path+ id+".jpg");
    		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    		image = ImageIO.read(f);
    		
    	}
    	catch(IOException e){
    		System.out.println("Error: "+ e);
    	}
    	return image;
    }
	
	private static int checkFileExists(String check) throws IOException {
		File fs = new File(".");
		String path = fs.getCanonicalPath() + "\\Users\\";
		File f = new File(path + check);
		if (f.exists())
			return 1;
		return 0;
	}
	
	
	
	private static ArrayList<Integer> findForUser(String category, String strCompare, ArrayList<Integer> ids) throws IOException {
		File fs = new File(".");
		String path = fs.getCanonicalPath() + "\\Products\\";
		ArrayList<Integer> returnList = new ArrayList<Integer>();
		if(ids.get(0) == 0) {
			File f = new File(path);
			for(File file: f.listFiles()) {
					FileReader fr = new FileReader(file);
					BufferedReader br = new BufferedReader(fr); 
					String line;
					int index = 0; 
					//String modelName, modelNumber, color;
					while((line = br.readLine()) != null) {
						line = line.toUpperCase();
						strCompare = strCompare.toUpperCase();
						if(Objects.equals(category, "Color") && index == 2 && Objects.equals(strCompare, line)) {
							int id = Integer.parseInt(file.getName().substring(0, file.getName().length() - 4));
							returnList.add(id);
						}
						else if(Objects.equals(category, "Model Name") && index == 0 && Objects.equals(strCompare, line)) {
							int id = Integer.parseInt(file.getName().substring(0, file.getName().length() - 4));
							returnList.add(id);
						}
						else if(Objects.equals(category, "Model Number") && index == 1 && Objects.equals(strCompare, line)) {
							int id = Integer.parseInt(file.getName().substring(0, file.getName().length() - 4));
							returnList.add(id);
						}
						else if(Objects.equals(category, "Features") && index == 4 && line.contains(strCompare)) {
							int id = Integer.parseInt(file.getName().substring(0, file.getName().length() - 4));
							returnList.add(id);
						}
						index++;
					}
					br.close();
					fr.close();
				
			}
		}
		else { // array already filled
			for(int i = 0; i<ids.size(); i++){
				File f = new File(path + ids.get(i)+ ".txt");
				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr); 
				String line;
				int index = 0; 
				//String modelName, modelNumber, color;
				while((line = br.readLine()) != null) {
					line = line.toUpperCase();
					strCompare = strCompare.toUpperCase();
					if(Objects.equals(category, "Color") && index == 2 && Objects.equals(strCompare, line)) {
						returnList.add(ids.get(i));
					}
					else if(Objects.equals(category, "Model Name") && index == 0 && Objects.equals(strCompare, line)) {
						returnList.add(ids.get(i));
					}
					else if(Objects.equals(category, "Model Number") && index == 1 && Objects.equals(strCompare, line)) {
						returnList.add(ids.get(i));
					}
					else if(Objects.equals(category, "Features") && index == 4 && line.contains(strCompare)) {
						returnList.add(ids.get(i));
					}
					index++;
				}
				br.close();
				fr.close();
			}
			if(returnList.size()== 0) {
				returnList.add(0);
				return returnList;
			}
		}
		//System.out.println("Count of files: " + count);
		if(returnList.size() > 0)
			return returnList;
		return ids; 
	}
	
	private static ArrayList<Integer> findForUserPrice(double price, ArrayList<Integer> ids) throws IOException {
		//File f = new File("C:\\Users\\Wyatt\\eclipse-workspace\\DemoApi\\Products\\");
		File fs = new File(".");
		String path = fs.getCanonicalPath() + "\\Products\\";
		//System.out.println(path);
		ArrayList<Integer> returnList = new ArrayList<Integer>();
		if(ids.get(0) == 0) {
			File f = new File(path);
			for(File file: f.listFiles()) {
					FileReader fr = new FileReader(file);
					BufferedReader br = new BufferedReader(fr); 
					String line;
					int index = 0; 
					//String modelName, modelNumber, color;
					while((line = br.readLine()) != null) {
						if(index == 3) {
							double num = Double.parseDouble(line);
							if (num <= price) {
								int id = Integer.parseInt(file.getName().substring(0, file.getName().length() - 4));
								returnList.add(id);
							}
						}
						index++;
					}
					br.close();
					fr.close();
				
			}
		}
		else { //array already filled
			for(int i = 0; i<ids.size(); i++){
				File f = new File(path + ids.get(i)+".txt");
				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr); 
				String line;
				int index = 0; 
				//String modelName, modelNumber, color;
				while((line = br.readLine()) != null) {
					if(index == 3) {
						double num = Double.parseDouble(line);
						if (num <= price) {
							returnList.add(ids.get(i));
						}
					}
					index++;
				}
				br.close();
				fr.close();
			}
			if(returnList.size()== 0) {
				returnList.add(0);
				return returnList;
			}
		}
			if(returnList.size() > 0)
				return returnList;
			return ids; 
	}
	
	//Check to make sure File counts are the same.
	private static int countTxtFilesInDirectory() throws IOException{
		File fs = new File(".");
		String path = fs.getCanonicalPath() + "\\Products\\";
		File f = new File(path);
		int count = 0;
		for(File file: f.listFiles()) {
			if (file.isFile() && (file.getName().endsWith(".txt")))
				count++;
		}
		return count;
	}
	
	private static int countJpgFilesInDirectory() throws IOException {
		File fs = new File(".");
		String path = fs.getCanonicalPath() + "\\Images\\";
		File f = new File(path);
		int count = 0;
		for(File file: f.listFiles()) {
			if (file.isFile() && (file.getName().endsWith(".jpg")))
				count++;
		}
		return count;
	}
	
	
	private static void checkFiles() throws IOException{
		int countOfPI = 0;
		int countOfPT = 0;
		try {
	    	countOfPI = countJpgFilesInDirectory();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   try {
	    	countOfPT = countTxtFilesInDirectory();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	 if(countOfPT != countOfPI || countOfPI == 0 || countOfPT == 0 ) {
		 System.out.println("Products text files do not equal the amount of files of images in Images.");
		 System.exit(0);
	 }
	}
	//returns 0 if it does work
	private static int createNewUser(String username, String password, String firstName, String middleName, String lastName, String phone, String email) throws IOException {
		File fs = new File(".");
		String path = fs.getCanonicalPath() + "\\Users\\"+ username + ".txt" ;
		File f = new File(path);
		f.createNewFile();
		try {
		      FileWriter myWriter = new FileWriter(path);
		      myWriter.write(password + "\n" + firstName + "\n" + middleName + "\n" + lastName + "\n" + phone + "\n" + email);
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		      return 1;
		    }
		
		return 0;
	}
}
