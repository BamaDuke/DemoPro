package javaTestCode; // packages should be lowercase

import java.util.ArrayList; // for Arraylists
import java.util.Arrays; // arrays
import java.util.Scanner;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
//import javax.imageio.*; // need to add requires java.desktop to module-info
import java.awt.image.BufferedImage;




public class JavaCodeT {
	
	public static void main(String[] args) throws IOException{
		
		//test out statement
        /*System.out.println("Hello World!");
        System.out.println("\tHello world!");
        */

        //test if with two cases with two ints
        /*int x = 10, y = 9;
        int z = (y-x>0) ? 0 : 1;
        System.out.println("The result is " + z);
        */
        
        //test Object class 
        /*ObjectClass object = new ObjectClass();
        object.setFName("Gabriel");
        object.setLName("Summers");
        object.setAge(19);
        object.unleashTheEnergy();*/
        

        //args in the compile. Will need to use cmd and cd to desktop/java
        // compile with javac Javacode.java then java Javacode Gabriel 19
        /*String name;
        int age;
        if(args.length<2){
            System.out.println("Invalid arg list. You need two arguments (Name and age).");
        } else{
            name = args[0];
            age= Integer.parseInt(args[1]);
            System.out.println("Name: " + name + ". Age: " + age); 
        }
        */

        //while loop and for
        /*int floorNum = 0; 
        boolean floor = true; 
        while(floor){
            if(floorNum == 5){
                floor = false;
                System.out.println("Welcome to floor: " + floorNum);
                break;
            }
            else{
            System.out.println("Floor: " + floorNum);
            }
            floorNum++;
        }
        System.out.println("======For======");
        for(int idx = floorNum; idx>=0;idx--){
            if(idx == 0){
                floor = false;
                System.out.println("Welcome to floor: " + idx);
            }
            else{
            System.out.println("Floor: " + idx);
            }
        }*/
        
        //ArrayList
        /*ArrayList<String> names = new ArrayList();
        names.add("Vulcan");
        names.add("Cyclops");
        names.add("Tony");
        names.add("Natasha");
        for(int indx = 0; indx < names.size(); indx++){
            System.out.println(names.get(indx));
        }
        names.remove(1);
        names.remove("Vulcan");
        System.out.println("===========Loop 2==========");
        for(int indx = 0; indx < names.size(); indx++){
            System.out.println(names.get(indx));
        }
        names.add("Gabriel");
        names.add("Summers");
        System.out.println("===========Loop 3==========");
        for(int indx = 0; indx < names.size(); indx++){
            System.out.println(names.get(indx));
        }
        System.out.println(names);
        if(names.contains("Gabriel")){
            System.out.println("There is an omega level mutant among them.");
        }*/

        //Super class and subclass
        /*Clothing cloth = new Clothing();
        Shirt shirt1 = new Shirt(19.99, 'M');
        shirt1.setPrice(2.00);
        if(shirt1 instanceof Shirt) // makes sure that shirt1 is of type Shirt
        shirt1.display();
        Sock sock1 = new Sock(9.99, 'S');
       // if(cloth instanceof Shirt) // doesn't work due to cloth being not type Shirt
        //sock1.display();
        printClothing(sock1);
        printClothing(cloth);
       */

        // try and catch the functions are in Objectclass
        /*ObjectClass ob = new ObjectClass();
        ob.doThis();*/

        // Arrray to Arraylist
        /*String[] days = {"monday", "saturday", "tuesday", "sunday", "friday"};
        ArrayList<String> dayList = new ArrayList(Arrays.asList(days));
        for(String s: days){
            if(s.equals("sunday"))
                System.out.println("Sunday is here.");
        }
        System.out.println(dayList);
        */

        //Lambda Expression endswith contains greater or less or equal 10 people + using switch cases
        /*String[] strListName = {"Jean Grey", "Tony Stark", "Gabriel Summers", "Scott Summers", "Emma Frost",
         "Madelyne Prior", "Bruce Banner", "Peter Parker", "Nick Fury", "Jessica Drews", "Lorna Sally"};
        char[] charListOcc = {'H', 'H', 'V', 'H', 'V', 'V', 'H', 'C', 'C', 'H', 'V'};
        int[] powerLevelList = {5, 3, 5, 2, 3, 3, 5, 0, 1, 3, 3};
        int[] mutant = {1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1};
        ArrayList<MCharacter> charMarvel = new ArrayList();
        ArrayList<MCharacter> charMarvel2 = new ArrayList();
        //String searchStr = "an";
        System.out.println(strListName.length +" "+ charListOcc.length +" "+ powerLevelList.length+" "+ mutant.length);
        for(int i =0; i<strListName.length; i++){
            charMarvel.add(new MCharacter(strListName[i], charListOcc[i], mutant[i], powerLevelList[i]));     
            System.out.println(strListName[i]+ " " + charListOcc[i] + " " + mutant[i] + " " + powerLevelList[i]);
            if(charListOcc[i]== 'H'){
                charMarvel2.add(new Hero('A', 'V' ));
                charMarvel2.get(i).setName(strListName[i]);
                charMarvel2.get(i).setMutant(mutant[i]);
                charMarvel2.get(i).setOccupation(charListOcc[i]);
                charMarvel2.get(i).setPower(powerLevelList[i]);
            }
            else if(charListOcc[i]== 'V'){
                charMarvel2.add(new Villian('A', 'V' ));
                charMarvel2.get(i).setName(strListName[i]);
                charMarvel2.get(i).setMutant(mutant[i]);
                charMarvel2.get(i).setOccupation(charListOcc[i]);
                charMarvel2.get(i).setPower(powerLevelList[i]);
            }
            else{
                charMarvel2.add(new MCharacter(strListName[i], charListOcc[i], mutant[i], powerLevelList[i]));
            }
        }

        for(MCharacter p : charMarvel){
            p.display();
            System.out.println();
        }
        for(MCharacter p : charMarvel2){
            if(p instanceof Hero){ // need to cast to use Hero methods
                Hero hTest = new Hero();
                hTest = (Hero) p; 
                if(hTest.getName().equals("Tony Stark")){
                hTest.setStatus('D');
                hTest.setActive('A');
                }
                else if(hTest.getName().equals("Jean Grey")){
                    hTest.setStatus('D');
                    hTest.setActive('V');
                }else if(hTest.getName().equals("Bruce Banner")){
                    hTest.setStatus('A');
                    hTest.setActive('R');
                }
                p = hTest;
            }
            if(p instanceof Villian){ // need to cast to use Hero methods
                Villian hTest = new Villian();
                hTest = (Villian) p; 
                if(hTest.getName().equals("Gabriel Summers")){
                hTest.setStatus('A');
                hTest.setActive('M');
                }
                else if(hTest.getName().equals("Madelyne Prior")){
                    hTest.setStatus('D');
                    hTest.setActive('M');
                }else if(hTest.getName().equals("Lorna Sally")){
                    hTest.setStatus('A');
                    hTest.setActive('W');
                }
                p = hTest;
            }
            p.display();
            */
      
        //System.out.println(new File(".").getAbsolutePath()); // Visual and cmd print different things
        //readAndWrite1(); // working
        //System.out.println("TEST if exception ends the code");
        
        /*
        System.out.println("Searching for 'an'");
        System.out.println("====Contains===="); System.out.println();
         */
		
		//Read an Image
		int width = 963;
		int height = 640;
		BufferedImage image = null; 
		image = readFromFile(width, height, image);
		
		writeToFile(image);

	}
	
	 //public static void printClothing(Clothing ex) {
	 //       ex.display();
	 //   }

	    public static void readAndWrite1()  {
	        try {
	            File myObj = new File("MarvelChar.txt"); // r is removed or it
	            Scanner myReader = new Scanner(myObj);
	            while(myReader.hasNextLine()){
	                String data = myReader.nextLine();
	                System.out.println(data);
	            }
	            myReader.close();
	        }catch (FileNotFoundException e){
	            System.out.println("An error occured");
	            System.exit(0);

	        }
	    }
	    
	    private static BufferedImage readFromFile(int width, int height, BufferedImage image) {
	    	try {
	    		File sampleFile = new File("C:\\Users\\Wyatt\\eclipse-workspace\\JavaCode\\Images\\BlackIPhone12.jpg");
	    		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	    		image = ImageIO.read(sampleFile);
	    		System.out.println("Reading complete: " + image);
	    		
	    	}
	    	catch(IOException e){
	    		System.out.println("Error: "+ e);
	    	}
	    	return image;
	    }
	    //C:\Users\Wyatt\Desktop\ImageTest
	    private static void writeToFile(BufferedImage image) {
	    	try {
	    		File path = new File("C:\\Users\\Wyatt\\Desktop\\ImageTest\\Output.jpg");
	    		ImageIO.write(image, "jpg", path);
	    		System.out.println("Writing Complete");
	    	}
	    	catch(IOException e){
	    		System.out.println("Error: "+ e);
	    	}
	    }

}
