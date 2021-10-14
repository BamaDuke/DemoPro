package javaTestCode;



public class ObjectClass {
    String firstName;
    String lastName;
    int age;
    //sets and gets for each
    public String getFName(){
        return firstName;
    }
    public void setFName(String firstName){
        this.firstName = firstName;
    }
    
    public String getLName(){
        return lastName;
    }
    public void setLName(String lastName){
        this.lastName = lastName;
    }
  
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }

    //Fun Print
    public void unleashTheEnergy(){
        System.out.println("I am " + this.firstName + " " + this.lastName + ". Born " + age +" years ago. Fear my power!"); 
    }

    public void doThis(){
        try{
            doThat();
        }
        catch (Exception e){
            String errMsg = e.getMessage();
            System.out.println("Dothis: -" + errMsg);
        }
    }

    public void doThat() throws Exception{
        System.out.println("doThat: Throwing exception");
        throw new Exception ("Ouch!");
    }

}
