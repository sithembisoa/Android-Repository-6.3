package com.example.athi.assignment7domain.factories.account;

import com.example.athi.assignment7domain.domain.account.Account;
import com.example.athi.assignment7domain.domain.bills.ElectricityBill;
import com.example.athi.assignment7domain.domain.bills.ParkingBill;
import com.example.athi.assignment7domain.domain.bills.WaterBill;

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
