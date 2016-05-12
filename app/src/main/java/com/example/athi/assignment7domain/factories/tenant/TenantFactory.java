package com.example.athi.assignment7domain.factories.tenant;

import com.example.athi.assignment7domain.domain.tenant.Tenant;
import com.example.athi.assignment7domain.domain.account.Account;

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
