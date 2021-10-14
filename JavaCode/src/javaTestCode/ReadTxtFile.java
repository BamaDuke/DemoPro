package javaTestCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ReadTxtFile {
   public static void main(String[] args){
        try {
            File myObj = new File("MarvelChar.txt");
            Scanner myReader = new Scanner(myObj);
            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        }catch (FileNotFoundException e){
            System.out.println("An error occured");
        }
   } 
}
