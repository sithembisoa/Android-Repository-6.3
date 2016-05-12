package com.example.athi.assignment7domain.factories.complaint;

import com.example.athi.assignment7domain.domain.complaints.Complaints;

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
