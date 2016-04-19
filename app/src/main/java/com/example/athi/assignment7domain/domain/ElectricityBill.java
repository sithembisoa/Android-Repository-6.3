package com.example.athi.assignment7domain.domain;

/**
 * Write a description of class ElectricityBill here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ElectricityBill implements Bills
{
   private double wats=2500;
    private Long id;
   
   public double getWats(){return wats;}
   
   public double calculateBill(){return wats*9.23;}
   
   private ElectricityBill (Builder builder){
       this.wats = builder.wats;
   }
    
   public static class Builder{
       
       private double wats;
       private Long id;
       public Builder (){

       }
       public Builder (double wats){
           this.wats = wats;
        }
       public Builder wats(double wats){this.wats=wats;return this;}

       public Builder id(Long id){
           this.id=id;
           return this;
       }
        public Builder copy(ElectricityBill electricity){
            this.wats = electricity.wats;
            this.id = electricity.id;
            return this;
        }
        
        public ElectricityBill build(){
            return new ElectricityBill(this);
        }
    
    }
}
