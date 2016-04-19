package com.example.athi.assignment7domain.factories;

import com.example.athi.assignment7domain.domain.ElectricityBill;

/**
 * Write a description of class ElectricityBillFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ElectricityBillFactory
{
    public static ElectricityBill getElectricityBill(double wats)
    {
        ElectricityBill electricityBill = new ElectricityBill.Builder(wats)
                .build();

        return electricityBill;

    }
}
