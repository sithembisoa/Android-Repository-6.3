package com.example.athi.assignment7domain.factories.address;

import com.example.athi.assignment7domain.domain.block.Block;
import com.example.athi.assignment7domain.domain.address.FlatAddress;

/**
 * Created by student on 2016/04/07.
 */
public class FlatAddressFactory {

    public static FlatAddress getFlatAddress(int zipcode, Block block, String flatNo)
    {
        FlatAddress address = new FlatAddress.Builder(zipcode)
                .block(block)
                .flatNo(flatNo)
                .build();

        return address;
    }
}
