package com.example.athi.assignment7domain.domain;

/**
 * Write a description of class WaterBill here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WaterBill implements Bills
{
   private double litres=150;
    private Long id;

   public double getLitres(){return litres;}
   
   public double calculateBill(){return litres*19.23;}
   
   private WaterBill (Builder builder){
       this.litres = builder.litres;
   }
    
   public static class Builder{
       
       private double litres;
       private Long id;

       public Builder (){}

       public Builder (double litres){
           this.litres = litres;
        }
       public Builder id(Long id){this.id=id;return this;}
       public Builder litres(double litres){this.litres=litres;return this;}

        public Builder copy(WaterBill water){
            this.litres = water.litres;
            this.id = water.id;
            return this;
        }
        
        public WaterBill build(){
            return new WaterBill(this);
        }
    
    
    
    }
}
