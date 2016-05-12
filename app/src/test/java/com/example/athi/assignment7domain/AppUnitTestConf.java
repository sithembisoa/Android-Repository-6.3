package com.example.athi.assignment7domain;

/**
 * Created by 212160923 on 4/17/2016.
 */

import com.example.athi.assignment7domain.factories.account.AccountFactoryTest;
import com.example.athi.assignment7domain.factories.block.BlockFactoryTest;
import com.example.athi.assignment7domain.factories.complaints.ComplaintsFactoryTest;
import com.example.athi.assignment7domain.factories.electricity.ElectricityBillFactoryTest;
import com.example.athi.assignment7domain.factories.flatAddress.FlatAddressFactoryTest;
import com.example.athi.assignment7domain.factories.maintenance.MaintananceFactoryTest;
import com.example.athi.assignment7domain.factories.parking.ParkingBillFactoryTest;
import com.example.athi.assignment7domain.factories.tenant.TenantFactoryTest;
import com.example.athi.assignment7domain.factories.tenantManagement.TenantManagementFactoryTest;
import com.example.athi.assignment7domain.factories.water.WaterBillFactoryTest;


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
