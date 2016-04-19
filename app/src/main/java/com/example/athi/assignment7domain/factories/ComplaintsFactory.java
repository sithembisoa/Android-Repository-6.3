package com.example.athi.assignment7domain.factories;

import com.example.athi.assignment7domain.domain.Complaints;

/**
 * Write a description of class ComplaintsFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComplaintsFactory
{
    public static Complaints getComplaints(String complain){
        
        Complaints com = new Complaints.Builder(complain)
                            .build();
        
        return com;
    }
}
