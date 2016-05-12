package com.example.athi.assignment7domain.domain.complaints;

import com.example.athi.assignment7domain.domain.maintenance.FlatMaintanance;

import java.io.Serializable;

/**
 * Write a description of class Complaints here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Complaints implements FlatMaintanance, Serializable
{
   private String complaint;
   private Long id;
    
    public Complaints(Builder builder){

        this.complaint = builder.complaint;
        this.id = builder.id;
    }
    public boolean maintananceChecks(){
        return false;
    }
    
    public String logComplaint(){
        return complaint;
    }
    public Long getId(){return id;}
    
    public static class Builder{
       
      private  String complaint;
        private Long id;

        public Builder(){}
        public Builder(String complaint){
           this.complaint = complaint;
        }
        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder complaint(String comp){this.complaint=comp;return this;}
        
        public Builder copy(Complaints  com){
            this.complaint =  com.complaint;
            this.id = com.id;
            return this;
        }
        
        public  Complaints build(){
            return new  Complaints(this);
        }
    }
}
