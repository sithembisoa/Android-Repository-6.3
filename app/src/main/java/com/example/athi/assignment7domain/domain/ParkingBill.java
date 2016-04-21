package com.example.athi.assignment7domain.domain;

/**
 * Write a description of class ParkingBill here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ParkingBill implements Bills
{
   private int days=30;
   private Long id;
    
   
   public int getDays(){return days;}
   public Long getId(){return id;}
   public void setDays(int days){this.days=days;}
   
   public double calculateBill(){return days*20.00;}
   
   private ParkingBill (Builder builder){
       this.days = builder.days;
       this.id = builder.id;
   }
    
   public static class Builder{
       
       private int days;
       private Long id;
       public Builder (){

       }
       public Builder (int days){
           this.days = days;
        }
       public Builder days(int days){
           this.days = days;
           return this;
       }
       public Builder id(Long id){this.id = id;return this;}
        
        public Builder copy(ParkingBill parking){
            this.days = parking.days;
            this.id = parking.id;
            return this;
        }
        
        public ParkingBill build(){
            return new ParkingBill(this);
        }
    }
}
