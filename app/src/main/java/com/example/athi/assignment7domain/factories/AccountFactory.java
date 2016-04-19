package com.example.athi.assignment7domain.factories;

import com.example.athi.assignment7domain.domain.Account;
import com.example.athi.assignment7domain.domain.ElectricityBill;
import com.example.athi.assignment7domain.domain.ParkingBill;
import com.example.athi.assignment7domain.domain.WaterBill;

/**
 * Write a description of class AccountFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AccountFactory
{
    public static Account getAccount(String accNo, double balance, WaterBill waterBill, ElectricityBill electricityBill, ParkingBill park)
    {
        Account myAccount = new Account.Builder(accNo) 
                .balance(balance)
                .waterBill(waterBill)
                .electricityBill(electricityBill)
                .parking(park)
                .build();

        return myAccount;
    }
}
