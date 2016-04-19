package com.example.athi.assignment7domain.factories;

import com.example.athi.assignment7domain.domain.Account;
import com.example.athi.assignment7domain.domain.Tenant;

/**
 * Write a description of class TenantFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TenantFactory
{
    public static Tenant getTenant(String idNumber, String fullName, Account acc)
    {
        Tenant tenant = new Tenant.Builder(idNumber)
                .fullName(fullName)
                .account(acc)
                .build();

        return tenant;

    }
}
