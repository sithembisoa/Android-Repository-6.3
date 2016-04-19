package com.example.athi.assignment7domain.factories;

import com.example.athi.assignment7domain.domain.Account;
import com.example.athi.assignment7domain.domain.ElectricityBill;
import com.example.athi.assignment7domain.domain.ParkingBill;
import com.example.athi.assignment7domain.domain.Tenant;
import com.example.athi.assignment7domain.domain.WaterBill;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by 212160923 on 4/17/2016.
 */
public class TenantFactoryTest {
    private WaterBill water;
    private ElectricityBill elec;
    private ParkingBill park;
    private Account acc = AccountFactory.getAccount("24567",3568.5,water,elec,park);;

    @Test
    public void testCreate() throws Exception {
        Tenant tenant = TenantFactory.getTenant("940325478","Malusi Gigaba",acc);
        Assert.assertTrue(tenant.getFullName()=="Malusi Gigaba");
        Assert.assertTrue(tenant.getAccount().getAccNo()=="24567");
    }

    @Test
    public void testUpdate() throws Exception {
        Tenant tenant = TenantFactory.getTenant("940325478", "Malusi Gigaba", acc);

        Tenant tenantUpdate = new Tenant.Builder()// uses accNo as primary key
                .copy(tenant)
                .idNumber("90035412587")
                .fullName("Athi Sithembiso")
                .build();

        Assert.assertNotNull(tenantUpdate);
        Assert.assertEquals(tenantUpdate.getIdNumber(),"90035412587");

        Assert.assertEquals(tenantUpdate.getFullName(),"Athi Sithembiso");
        Assert.assertEquals(tenantUpdate.getAccount().getAccNo(),acc.getAccNo());

    }
}
