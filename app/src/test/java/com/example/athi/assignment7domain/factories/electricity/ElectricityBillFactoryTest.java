package com.example.athi.assignment7domain.factories.electricity;


import com.example.athi.assignment7domain.domain.bills.ElectricityBill;
import com.example.athi.assignment7domain.factories.bills.ElectricityBillFactory;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by 212160923 on 4/17/2016.
 */
public class ElectricityBillFactoryTest {

    @Test
    public void testCreate() throws Exception {
        ElectricityBill bill = ElectricityBillFactory.getElectricityBill(27.8);
        Assert.assertEquals(bill.getWats(),27.8,2);
    }

    @Test
    public void testUpdate() throws Exception {
        ElectricityBill bill = ElectricityBillFactory.getElectricityBill(27.8);
        ElectricityBill bill2 = new ElectricityBill.Builder()
                .copy(bill)
                .wats(300.5)
                .build();
        Assert.assertTrue(bill2.calculateBill()>bill.calculateBill());

    }
}
