package com.example.athi.assignment7domain.factories;


import com.example.athi.assignment7domain.domain.ParkingBill;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by 212160923 on 4/17/2016.
 */
public class ParkingBillFactoryTest {

    @Test
    public void testCreate() throws Exception {
       ParkingBill bill = ParkingBillFactory.getParkingBill(35);
        Assert.assertEquals(bill.getDays(),35);
    }

    @Test
    public void testUpdate() throws Exception {
        ParkingBill bill = ParkingBillFactory.getParkingBill(35);
        ParkingBill bill2 = new ParkingBill.Builder()
                .copy(bill)
                .days(3)
                .build();
        Assert.assertTrue(bill2.calculateBill()<bill.calculateBill());

    }
}
