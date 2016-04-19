package com.example.athi.assignment7domain.domain;

import android.os.Build;

/**
 * Write a description of class Account here.
 * 
 * @author Athi sithembiso 
 * @version (a version number or a date)
 */
public class Account {

    private String accNo, id;
    private double balance=0;
    private WaterBill waterBill;
    private ElectricityBill electricityBill;
    private ParkingBill parking;
    

    public Account(Builder builder) {

        accNo = builder.accNo;
        balance = builder.balance;
        waterBill = builder.waterBill;
        electricityBill = builder.electricityBill;
        parking = builder.parking;
        id = builder.id;
    }

    public String getAccNo() {
        return accNo;
    }


    public double getBalance() {
        return balance+waterBill.calculateBill()+electricityBill.calculateBill()+parking.calculateBill();
    }


    public static class Builder {

        private String accNo,id;
        private double balance;
        private WaterBill waterBill;
        private ElectricityBill electricityBill;
        private ParkingBill parking;

        public Builder(){}
        public Builder accNo(String no){this.accNo=no;return this;}
        public Builder(String accNo) {
            this.accNo = accNo;
        }

        public Builder balance(double balance) {
            this.balance = balance;
            return this;
        }

        public Builder waterBill(WaterBill waterBill) {
            this.waterBill = waterBill;
            return this;
        }
        
         public Builder electricityBill(ElectricityBill electricityBill) {
            this.electricityBill = electricityBill;
            return this;
        }
        
         public Builder parking(ParkingBill parking) {
            this.parking = parking;
            return this;
        }

        public Builder id(String id){
            this.id=id;
            return this;
        }



        public Builder copy(Account account){
            this.accNo = account.getAccNo();
            this.balance = account.getBalance();
            this.waterBill = account.waterBill;
            this.electricityBill = account.electricityBill;
            this.parking = account.parking;
            this.id=account.id;
            return this;
        }


        public Account build() {
            return new Account(this);
        }
    }


}
