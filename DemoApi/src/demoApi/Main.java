package demoApi;


import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.FileSystem;
import java.util.*;
import javax.imageio.ImageIO;

public class Main {
	public static void main (String[] args) throws IOException{
		String username, password, name, phone, email;
		String modelName, modelNumber, color;
		double price;
		int id, countOfPI, countOfPT; // ID starts at 100000 Counts is for the amount of products and ids
		BufferedImage image;
		countOfPI = 0;
		countOfPT = 0;
		
		   try {
		    	countOfPI = countJpgFilesInDirectory();
				//System.out.println("The count of jpg files in the Image folder is "+ countOfPI);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   try {
		    	countOfPT = countTxtFilesInDirectory();
				//System.out.println("The count of txt files in the products folder is "+ countOfPT);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		 if(countOfPT != countOfPI || countOfPI == 0 || countOfPT == 0 ) {
			 System.out.println("Products text files do not equal the amount of files of images in Images.");
			 System.exit(0);
		 }
		 
		ArrayList<Integer> idsForFind = new ArrayList<Integer>();
		ArrayList<Integer> idsForFind1 = new ArrayList<Integer>();
		idsForFind.add(0);
		idsForFind1.add(0);
		idsForFind = findForUser("Model Number", "XT34-XL5555", idsForFind, countOfPT);
		System.out.println(idsForFind);
		idsForFind = findForUserPrice(80, idsForFind, countOfPT);
		System.out.println(idsForFind);
		idsForFind = findForUser("Color", "White", idsForFind, countOfPT);
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
		image = readFromFile(width, height, image, id);*/
		
		
			   
		
		
	    //test Object class 
	    //Customer object = new Customer( username, password, name, phone, email);
	    //object.display();
	    //System.out.println("Test for Same: " + object.verifyAccount(username, password));//pass 1
	    //System.out.println("Test for not equal: " + object.verifyAccount("Adam", password));//pass 0 
	    //System.out.println("Test for not equal: " + object.verifyAccount(username, "pass"));//pass 0
	    
	    //Product iphone = new Product(id,modelName, modelNumber, color, price, image);
	    //iphone.display();
	    
	 
	    
	    
	}
	
	
	private static BufferedImage readFromFile(int width, int height, BufferedImage image, int id) {
    	try {
    		File fs = new File(".");
    		String path = fs.getCanonicalPath() + "\\Images\\";
    		File f = new File(path+ id+".jpg");
    		//File sampleFile = new File("C:\\Users\\Wyatt\\eclipse-workspace\\DemoApi\\Images\\100000.jpg");
    		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    		image = ImageIO.read(f);
    		//System.out.println("Reading complete: " + image);
    		
    	}
    	catch(IOException e){
    		System.out.println("Error: "+ e);
    	}
    	return image;
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
		//System.out.println("Count of files: " + count);
		return count;
	}
	
	private static ArrayList<Integer> findForUser(String category, String strCompare, ArrayList<Integer> ids, int countOfPts) throws IOException {
		//File f = new File("C:\\Users\\Wyatt\\eclipse-workspace\\DemoApi\\Products\\");
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
						index++;
					}
					br.close();
					fr.close();
				
			}
		}
		else { // array already filled
			for(int i = 0; i<ids.size(); i++){
				File f = new File(path + ids.get(i)+".txt");
				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr); 
				String line;
				int index = 0; 
				//String modelName, modelNumber, color;
				while((line = br.readLine()) != null) {
					if(Objects.equals(category, "Color") && index == 2 && Objects.equals(strCompare, line)) {
						returnList.add(ids.get(i));
					}
					else if(Objects.equals(category, "Model Name") && index == 0 && Objects.equals(strCompare, line)) {
						returnList.add(ids.get(i));
					}
					else if(Objects.equals(category, "Model Number") && index == 1 && Objects.equals(strCompare, line)) {
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
	
	private static ArrayList<Integer> findForUserPrice(double price, ArrayList<Integer> ids, int countOfPts) throws IOException {
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
							System.out.println(num + "<=" + price);
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
			//System.out.println("Count of files: " + count);
			if(returnList.size() > 0)
				return returnList;
			return ids; 
	}
	private static int countTxtFilesInDirectory() throws IOException{
		File fs = new File(".");
		String path = fs.getCanonicalPath() + "\\Products\\";
		File f = new File(path);
		int count = 0;
		for(File file: f.listFiles()) {
			if (file.isFile() && (file.getName().endsWith(".txt")))
				count++;
		}
		//System.out.println("Count of files: " + count);
		return count;
	}
}
