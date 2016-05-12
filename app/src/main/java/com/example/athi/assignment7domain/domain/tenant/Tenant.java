package com.example.athi.assignment7domain.domain.tenant;

import com.example.athi.assignment7domain.domain.account.Account;

import java.io.Serializable;

/**
 * Write a description of class Tenant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tenant implements Serializable {

    private String fullName;
    private String idNumber;
    private Account account;
    private Long id;


    public Tenant(Builder builder) {


        idNumber = builder.idNumber;
        fullName = builder.fullName;
        account = builder.account;
        id = builder.id;

    }



    public String getFullName() {return fullName;}

    public String getIdNumber() { return idNumber;}
    
    public Account getAccount(){return account;}

    public Long getId(){return id;}

    public static class Builder {

        private String fullName;
        private String idNumber;
        private Account account;
        private Long id;

        public Builder (String idNumber) {
            this.idNumber = idNumber;
        }

        public Builder(){}
        public Builder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }
        
        public Builder account(Account account) {
            this.account = account;
            return this;
        }
        public Builder idNumber(String idNumber){this.idNumber = idNumber;return this;}
        public Builder id(Long id){this.id = id; return this;}

        public Builder copy(Tenant tenant){

            this.idNumber = tenant.getIdNumber();
            this.fullName = tenant.getFullName();
            this.account = tenant.getAccount();
            this.id=tenant.id;
            return this;
        }


        public Tenant build() {
            return new Tenant(this);
        }
    }



}

