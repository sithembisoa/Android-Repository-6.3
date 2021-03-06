package com.example.athi.assignment7domain.factories.bills;

import com.example.athi.assignment7domain.domain.bills.WaterBill;

/**
 * Write a description of class WaterBillFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WaterBillFactory
{
    public static WaterBill getWaterBill(double litres)
    {
       WaterBill waterBill = new WaterBill.Builder(litres)
                .build();

        return waterBill;

    }
}
