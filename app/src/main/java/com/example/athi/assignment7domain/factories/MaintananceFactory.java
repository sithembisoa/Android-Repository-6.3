package com.example.athi.assignment7domain.factories;

import com.example.athi.assignment7domain.domain.Maintanance;

/**
 * Write a description of class MaintananceFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MaintananceFactory
{
    public static Maintanance getMaintanance(boolean check){
    
        Maintanance main = new Maintanance.Builder(check)
                           .build();
        
       return main;
    }
}
