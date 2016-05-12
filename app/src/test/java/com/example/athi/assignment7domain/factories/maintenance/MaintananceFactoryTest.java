package com.example.athi.assignment7domain.factories.maintenance;

import com.example.athi.assignment7domain.domain.maintenance.Maintanance;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by 212160923 on 4/17/2016.
 */
public class MaintananceFactoryTest {

    @Test
    public void testCreate() throws Exception {
        Maintanance main = MaintananceFactory.getMaintanance(false);
        Assert.assertTrue(main.maintananceChecks()==true);
    }

    @Test
    public void testUpdate() throws Exception {
        Maintanance main = MaintananceFactory.getMaintanance(false);
        Maintanance main2 = new Maintanance.Builder().copy(main).check(true).build();

        Assert.assertTrue(main2.maintananceChecks()==true);

    }
}
