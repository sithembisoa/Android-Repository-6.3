package com.example.athi.assignment7domain.factories;

/**
 * Created by 212160923 on 4/17/2016.
 */
import com.example.athi.assignment7domain.domain.ElectricityBill;
import com.example.athi.assignment7domain.domain.ParkingBill;
import com.example.athi.assignment7domain.domain.WaterBill;
import com.example.athi.assignment7domain.domain.Account;

import junit.framework.Assert;
import org.junit.Test;

public class AccountFactoryTest {

    private WaterBill water = new WaterBill.Builder().litres(25.3).build();
    private ElectricityBill elec = new ElectricityBill.Builder().wats(300).build();
    private ParkingBill park = new ParkingBill.Builder().days(35).build();

    @Test
    public void testTenant() throws Exception {
        Account acc = AccountFactory.getAccount("24567", 3568.5, water, elec, park);

        Assert.assertEquals(acc.getAccNo(),"24567");
        Assert.assertFalse(3568.5 > acc.getBalance());
        Assert.assertTrue((3568.5+water.calculateBill()+park.calculateBill()+elec.calculateBill())==acc.getBalance());
    }

   @Test
   public void testUpdate() throws Exception {
       Account acc = AccountFactory.getAccount("24567", 3568.5, water, elec, park);
       Account acc2 = new Account.Builder()
                                 .copy(acc)
                                 .balance(0)
                                 .accNo("12345")
                                 .build();
       Assert.assertEquals(acc2.getAccNo(),"12345");
       Assert.assertFalse(3568.5 > acc2.getBalance());
       Assert.assertTrue((water.calculateBill()+park.calculateBill()+elec.calculateBill())==acc2.getBalance());
    }
}


