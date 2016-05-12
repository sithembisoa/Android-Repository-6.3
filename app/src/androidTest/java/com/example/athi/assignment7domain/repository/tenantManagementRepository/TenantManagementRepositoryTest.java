package com.example.athi.assignment7domain.repository.tenantManagementRepository;



import android.test.AndroidTestCase;

import com.example.athi.assignment7domain.domain.tenant.Tenant;
import com.example.athi.assignment7domain.domain.management.TenantManagement;
import com.example.athi.assignment7domain.factories.management.TenantManagementFactory;
import com.example.athi.assignment7domain.repository.Interfaces.Impl.management.TenantManagementRepositoryImpl;
import com.example.athi.assignment7domain.repository.Interfaces.management.TenantManagementTypeRepository;

import junit.framework.Assert;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by Administrator on 2016/04/21.
 */
public class TenantManagementRepositoryTest extends AndroidTestCase{

    private static final String TAG="TENANT MANAGEMENT TEST";
    private Long id;
    private ArrayList<Tenant> list = new ArrayList<>();

    public void testCreateReadUpdateDelete() throws Exception {
        TenantManagement tm = TenantManagementFactory.getTenantManagement(list);
        tm.AddTenant(new Tenant.Builder("945287541").fullName("Malusi Gigs").build());

        TenantManagementTypeRepository repo = new TenantManagementRepositoryImpl(this.getContext()) {
        };
        // CREATE
        TenantManagement createEntity = new TenantManagement.Builder()
                .list(tm.getTenantList())
                .build();
        TenantManagement insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<TenantManagement> tenantSet= repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",tenantSet.size()>0);

        //READ ENTITY
        TenantManagement entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);



        //UPDATE ENTITY
        createEntity.RemoveTenant("Malusi Gigs");

        TenantManagement updateEntity = new TenantManagement.Builder()
                .copy(entity)
                .list(createEntity.getTenantList())
                .build();
        repo.update(updateEntity);
        TenantManagement newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY",0,updateEntity.getSize());

        // DELETE ENTITY
        repo.delete(updateEntity);
        TenantManagement deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }
}
