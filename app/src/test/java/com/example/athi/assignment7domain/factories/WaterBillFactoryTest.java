package com.example.athi.assignment7domain.factories;

import com.example.athi.assignment7domain.domain.WaterBill;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by 212160923 on 4/17/2016.
 */
public class WaterBillFactoryTest {
    @Test
    public void testCreate() throws Exception {
        WaterBill bill = WaterBillFactory.getWaterBill(35.0);
        Assert.assertEquals(bill.getLitres(), 35.0);
    }

    @Test
    public void testUpdate() throws Exception {
        WaterBill bill = WaterBillFactory.getWaterBill(35.0);
        WaterBill bill2 = new WaterBill.Builder()
                .copy(bill)
                .litres(3.5)
                .build();
        Assert.assertTrue(bill2.calculateBill()<bill.calculateBill());

    }
}
