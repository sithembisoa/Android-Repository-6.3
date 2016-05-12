package com.example.athi.assignment7domain.factories.tenantManagement;

import com.example.athi.assignment7domain.domain.tenant.Tenant;
import com.example.athi.assignment7domain.domain.management.TenantManagement;
import com.example.athi.assignment7domain.factories.management.TenantManagementFactory;

import junit.framework.Assert;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by 212160923 on 4/17/2016.
 */
public class TenantManagementFactoryTest {
    private ArrayList<Tenant> list = new ArrayList<>();
    @Test
    public void testCreate() throws Exception {
        TenantManagement tm = TenantManagementFactory.getTenantManagement(list);
        tm.AddTenant(new Tenant.Builder("945287541").fullName("Malusi Gigs").build());

        Assert.assertTrue(list.isEmpty() == false);
        Assert.assertEquals(tm.searchByName("Malusi Gigs"),true);
    }

    @Test
    public void testUpdate() throws Exception {
        ArrayList<Tenant> list2 = new ArrayList<>();

        TenantManagement tm = TenantManagementFactory.getTenantManagement(list);
        tm.AddTenant(new Tenant.Builder("945287541").fullName("Malusi Gigs").build());

        TenantManagement newTm = new TenantManagement.Builder().copy(tm).list(list2).build();


        Assert.assertEquals(newTm.getSize(),0);
    }
}
