package javaTestCode;

public class Villian extends MCharacter {
    private char status; //Dead or Alive
    private char active; //In active duty or vigilanti or retired or wanted and retired or missing
    
    public Villian(){
        super();
        status = 'U'; //unknown
        active = 'U'; 
    }
    public Villian(char status, char active){
        super();
        this.status = status; //unknown
        this.active = active; 
    }
    public Villian(String name, char occupation, int mutant, int powerlevel){
        super(name, occupation, mutant, powerlevel);
        //System.out.print("name: " + name +" Occ:" + occupation + " Mutant: " + mutant + " Powerlevel: " +powerlevel);
        this.status = 'U'; //unknown
        this.active = 'U';
    }
    public void setStatus(char status){
        this.status = status;
    }
    public void setActive(char active){
        this.active = active;
    }
    @Override
    public void display(){
        super.display();
        System.out.println("\tOccupation: Villian");
        System.out.println("\tStatus: " + status + " Active: " + active);
        
    }
    @Override
    public void deconstruct(){
        super.deconstruct();
    }


}
