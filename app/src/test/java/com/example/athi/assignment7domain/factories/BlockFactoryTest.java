package com.example.athi.assignment7domain.factories;

/**
 * Created by 212160923 on 4/17/2016.
 */


import junit.framework.Assert;
import org.junit.Test;

public class BlockFactoryTest {

    @Test
    public void testCreate() throws Exception {

        String block = BlockFactory.getBlock(25);
        String block2 = BlockFactory.getBlock(10);
        String block3 = BlockFactory.getBlock(19);

        Assert.assertTrue(block=="BlockC");
        Assert.assertTrue(block2=="BlockA");
        Assert.assertTrue(block3=="BlockB");
    }

}
