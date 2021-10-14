package javaTestCode;

public class MCharacter {
    private String name;
    private char occupation; // H C V
    int mutant;
    int powerlevel;
    
    //constructor
    public MCharacter(){
        occupation = 'C';
        mutant = 0;
        powerlevel = -1;
    }

    public MCharacter(String name, int mutant){
        this.name = name;
        this.mutant = mutant;
    }
    public MCharacter(String name){
        this.name = name;
        occupation = 'C';
        mutant = 0;
        powerlevel = -1;
    }

    public MCharacter(String name, char occupation, int mutant, int powerlevel){
        this.name = name;
        this.occupation = occupation;
        this.mutant = mutant;
        this.powerlevel = powerlevel;
        
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getMutant(){
        return this.mutant;
    }

    public void setMutant(int mutant){
        this.mutant = mutant;
    }

    public char getOccupation(){
        return this.occupation;
    }

    public void setOccupation(char occupation){
        this.occupation = occupation;
    }

    public int getPower(){
        return this.powerlevel;
    }

    public void setPower(int powerlevel){
        this.powerlevel = powerlevel;
    }



    public void display(){
        switch(this.getMutant()){
            case 1: 
                System.out.println("//////Mutant//////");
                break;
            case 0: 
                System.out.println("======Human======");
                break;
        }
        System.out.println("Person: " + this.getName());
        switch(this.getOccupation()){
            case 'C': 
                System.out.println("\tOccupation: Civilian");
                break;
        }
        switch(this.getPower()){
            case 0: 
                System.out.println("\tNo Risk");
                break;
            case 1: 
                System.out.println("\tLow Risk");
                break;
            case 2: 
                System.out.println("\tMinor Risk");
                break;
            case 3: 
                System.out.println("\tMedium Risk");
                break;
            case 4: 
                System.out.println("\tHigh Risk");
                break;
            case 5: 
                if(getMutant() == 1)
                    System.out.println("\tOMEGA LEVEL MUTANT ====== ELIMINATION REQUIRED");
                else
                    System.out.println("\tExtremely high Risk recommending elimination");
                break;
        }  
    }

    
    public void deconstruct(){
        System.out.println("Destruction method");
    }
}
