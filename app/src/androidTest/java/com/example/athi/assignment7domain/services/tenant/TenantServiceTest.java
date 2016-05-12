package com.example.athi.assignment7domain.services.tenant;

import android.content.Intent;
import android.test.AndroidTestCase;

import com.example.athi.assignment7domain.conf.util.App;
import com.example.athi.assignment7domain.domain.account.Account;
import com.example.athi.assignment7domain.domain.bills.ElectricityBill;
import com.example.athi.assignment7domain.domain.bills.ParkingBill;
import com.example.athi.assignment7domain.domain.bills.WaterBill;
import com.example.athi.assignment7domain.domain.tenant.Tenant;
import com.example.athi.assignment7domain.factories.account.AccountFactory;
import com.example.athi.assignment7domain.repository.Interfaces.Impl.tenant.TenantRepositoryImpl;
import com.example.athi.assignment7domain.repository.Interfaces.tenant.TenantTypeRepository;
import com.example.athi.assignment7domain.services.tenant.Impl.TenantServiceImpl;

import junit.framework.Assert;

/**
 * Created by 212160923 on 5/10/2016.
 */
public class TenantServiceTest extends AndroidTestCase {

    private WaterBill water;
    private ElectricityBill elec;
    private ParkingBill park;
    private Account acc = AccountFactory.getAccount("24567",3568.5,water,elec,park);

    @Override
    public void setUp() throws Exception {
        super.setUp();
    }

    public void testAddTenantService() throws Exception {

        TenantTypeRepository repo = new TenantRepositoryImpl(this.getContext());
        Long id;
        Intent intent = new Intent(App.getAppContext(),TenantServiceImpl.class);

        TenantService tenantService = new TenantServiceImpl();


        Tenant tenant = new Tenant.Builder()
                        .idNumber("94032654")
                        .fullName("Athi Sithembiso")
                        .account(acc)
                        .build();

        tenantService.addTenant(App.getAppContext(),tenant);
        App.getAppContext().startService(intent);
        id = tenant.getId();

        Assert.assertNotNull("CREATE",tenant);
        Assert.assertEquals(tenant.getIdNumber(),"94032654");
    }
}

