package com.example.athi.assignment7domain.repository.tenantRepository;

import android.test.AndroidTestCase;


import com.example.athi.assignment7domain.domain.account.Account;
import com.example.athi.assignment7domain.domain.bills.ElectricityBill;
import com.example.athi.assignment7domain.domain.bills.ParkingBill;
import com.example.athi.assignment7domain.domain.tenant.Tenant;
import com.example.athi.assignment7domain.domain.bills.WaterBill;
import com.example.athi.assignment7domain.factories.account.AccountFactory;
import com.example.athi.assignment7domain.repository.Interfaces.Impl.tenant.TenantRepositoryImpl;
import com.example.athi.assignment7domain.repository.Interfaces.tenant.TenantTypeRepository;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Administrator on 2016/04/21.
 */
public class TenantRepositoryTest extends AndroidTestCase {

    private static final String TAG="TENANT TEST";
    private Long id;
    private WaterBill water;
    private ElectricityBill elec;
    private ParkingBill park;
    private Account acc = AccountFactory.getAccount("24567",3568.5,water,elec,park);

    public void testCreateReadUpdateDelete() throws Exception {

        TenantTypeRepository repo = new TenantRepositoryImpl(this.getContext()) {
        };
        // CREATE
        Tenant createEntity = new Tenant.Builder()
                .idNumber("940458125")
                .account(acc)
                .fullName("Monwabisi Sifo")
                .build();
        Tenant insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<Tenant> tenantSet= repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",tenantSet.size()>0);

        //READ ENTITY
        Tenant entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);



        //UPDATE ENTITY
        Tenant updateEntity = new Tenant.Builder()
                .copy(entity)
                .fullName("Boniface")
                .build();
        repo.update(updateEntity);
        Tenant newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","Boniface",newEntity.getFullName());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Tenant deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }
}
