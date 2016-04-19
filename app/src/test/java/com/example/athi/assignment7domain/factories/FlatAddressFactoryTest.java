package com.example.athi.assignment7domain.factories;

import com.example.athi.assignment7domain.domain.Block;
import com.example.athi.assignment7domain.domain.BlockA;
import com.example.athi.assignment7domain.domain.BlockB;
import com.example.athi.assignment7domain.domain.FlatAddress;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by 212160923 on 4/17/2016.
 */
public class FlatAddressFactoryTest {
    private Block blockA = new BlockA();
    @Test
    public void testCreate() throws Exception {
        FlatAddress addr = FlatAddressFactory.getFlatAddress(7784,blockA,"27");
        Assert.assertTrue(addr.getFlatNo()=="27");

    }

    @Test
    public void testUpdate() throws Exception {
        FlatAddress addr = FlatAddressFactory.getFlatAddress(7784,blockA,"27");
        FlatAddress newAddr = new FlatAddress.Builder()
                                    .copy(addr)
                                    .flatNo("30")
                                    .block(new BlockB())
                                    .build();
        Assert.assertTrue(addr.getFlatNo()!= newAddr.getFlatNo());
    }
}

