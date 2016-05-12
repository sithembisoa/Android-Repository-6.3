package com.example.athi.assignment7domain.services.management;

import android.content.Intent;
import android.test.AndroidTestCase;

import com.example.athi.assignment7domain.conf.util.App;
import com.example.athi.assignment7domain.domain.management.TenantManagement;
import com.example.athi.assignment7domain.domain.tenant.Tenant;
import com.example.athi.assignment7domain.repository.Interfaces.Impl.management.TenantManagementRepositoryImpl;
import com.example.athi.assignment7domain.repository.Interfaces.management.TenantManagementTypeRepository;
import com.example.athi.assignment7domain.services.management.Impl.TenantManagementServiceImpl;

import junit.framework.Assert;

import java.util.ArrayList;

/**
 * Created by 212160923 on 5/10/2016.
 */
public class TenantManagementServiceTest extends AndroidTestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void testAddTenantManagementService() throws Exception {

        TenantManagementTypeRepository repo = new TenantManagementRepositoryImpl(this.getContext());
        Long id;
        Intent intent = new Intent(App.getAppContext(),TenantManagementServiceImpl.class);

        TenantManagementService tenantService = new TenantManagementServiceImpl();

        ArrayList<Tenant> list = new ArrayList<>();

        TenantManagement management = new TenantManagement.Builder()
                .list(list)
                .build();

        tenantService.addManagement(App.getAppContext(),management);
        App.getAppContext().startService(intent);
        id = management.getId();

        Assert.assertNotNull("CREATE",management);

    }
}
