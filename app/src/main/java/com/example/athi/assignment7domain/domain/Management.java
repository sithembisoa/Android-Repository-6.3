package com.example.athi.assignment7domain.domain;
/**
 * Abstract class Management - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */

import java.util.List;

public abstract class Management
{
    // instance variables - replace the example below with your own
    public abstract void AddTenant(Tenant tenant);
    public abstract void RemoveTenant (String tenantName);
    public abstract String DisplayTenants();
}
