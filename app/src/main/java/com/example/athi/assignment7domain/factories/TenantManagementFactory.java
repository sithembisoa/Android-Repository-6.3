package com.example.athi.assignment7domain.factories;
/**
 * Write a description of class TenantManagementFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import com.example.athi.assignment7domain.domain.TenantManagement;

import java.util.ArrayList;

public class TenantManagementFactory
{
    public static TenantManagement getTenantManagement(ArrayList tenantList)
    {
        TenantManagement tenantManagement = new TenantManagement.Builder(tenantList)
                .build();

        return tenantManagement;

    }
}
