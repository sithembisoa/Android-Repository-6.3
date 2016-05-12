package com.example.athi.assignment7domain.domain.maintenance;

/**
 * Write a description of class Maintanance here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Maintanance implements FlatMaintanance
{
    private boolean check;
    private Long id;
    
    public Maintanance(Builder builder){
        this.check = builder.check;
        this.id = builder.id;
    }
    public Long getId(){return id;}
    public boolean maintananceChecks()
    {
        System.out.println("Did the maintanance team clear this apartment of the following?\n");
        System.out.println("Electricity wires");
        System.out.println("Doors and Windows");
        System.out.println("Leaks\n\n");
        
        System.out.println("Check Y/N");
        char c = 'Y';
        
        if(c == 'Y')
            return check=true;
        return check=false; 
    }
    
    public String logComplaint(){
        return "";
    }
    
    public static class Builder{
       
      private  boolean check;
        private Long id;

       public Builder(){}
       public Builder(boolean check){
           this.check = check;
        }
       public Builder id(Long id){this.id=id;return this;}
       public Builder check(boolean c){this.check=c;return this;}
        
        public Builder copy( Maintanance  maintanance){
            this.check =  maintanance.check;
            this.id = maintanance.id;
            return this;
        }
        
        public  Maintanance build(){
            return new  Maintanance(this);
        }
    }
}
