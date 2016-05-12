package com.example.athi.assignment7domain.services.address;

import android.content.Intent;
import android.test.AndroidTestCase;

import com.example.athi.assignment7domain.conf.util.App;
import com.example.athi.assignment7domain.domain.address.FlatAddress;
import com.example.athi.assignment7domain.domain.block.Block;
import com.example.athi.assignment7domain.domain.block.BlockA;
import com.example.athi.assignment7domain.factories.block.BlockFactory;
import com.example.athi.assignment7domain.repository.Interfaces.Impl.address.FlatAddressRepositoryImpl;
import com.example.athi.assignment7domain.repository.Interfaces.address.FlatAddressTypeRepository;
import com.example.athi.assignment7domain.services.address.Impl.AddressAddServiceImpl;

import junit.framework.Assert;

/**
 * Created by 212160923 on 5/11/2016.
 */
public class AddressAddServiceTest extends AndroidTestCase {

    @Override
    public void setUp() throws Exception {
        super.setUp();
    }

    public void testAddTenantService() throws Exception {


        Long id;
        Intent intent = new Intent(App.getAppContext(),AddressAddServiceImpl.class);

        AddressAddService addressService = new AddressAddServiceImpl();

        Block block = new BlockA();

        FlatAddress address = new FlatAddress.Builder()
                .zip(7784)
                .flatNo("25")
                .block(block)
                .build();

        addressService.addAddress(App.getAppContext(),address);
        App.getAppContext().startService(intent);
        id = address.getId();

        Assert.assertNotNull("CREATE",address);
    }
}
