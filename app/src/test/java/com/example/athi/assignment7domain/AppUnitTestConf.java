package com.example.athi.assignment7domain;

/**
 * Created by 212160923 on 4/17/2016.
 */

import com.example.athi.assignment7domain.factories.AccountFactoryTest;
import com.example.athi.assignment7domain.factories.BlockFactoryTest;
import com.example.athi.assignment7domain.factories.ComplaintsFactoryTest;
import com.example.athi.assignment7domain.factories.ElectricityBillFactoryTest;
import com.example.athi.assignment7domain.factories.FlatAddressFactoryTest;
import com.example.athi.assignment7domain.factories.MaintananceFactoryTest;
import com.example.athi.assignment7domain.factories.ParkingBillFactoryTest;
import com.example.athi.assignment7domain.factories.TenantFactoryTest;
import com.example.athi.assignment7domain.factories.TenantManagementFactoryTest;
import com.example.athi.assignment7domain.factories.WaterBillFactoryTest;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;



@RunWith(Suite.class)
@Suite.SuiteClasses({
        AccountFactoryTest.class,
        BlockFactoryTest.class,
        ComplaintsFactoryTest.class,
        FlatAddressFactoryTest.class,
        MaintananceFactoryTest.class,
        ParkingBillFactoryTest.class,
        TenantManagementFactoryTest.class,
        TenantFactoryTest.class,
        WaterBillFactoryTest.class,
        ElectricityBillFactoryTest.class})

public class AppUnitTestConf {}
