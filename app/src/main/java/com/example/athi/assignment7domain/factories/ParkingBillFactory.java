package com.example.athi.assignment7domain.factories;

import com.example.athi.assignment7domain.domain.ParkingBill;

/**
 * Write a description of class ParkingBillFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ParkingBillFactory
{
   public static ParkingBill getParkingBill(int days)
    {
        ParkingBill parking = new ParkingBill.Builder(days)
                .build();

        return parking;

    }
}
