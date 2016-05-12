package com.example.athi.assignment7domain.repository.maintenanceRepository;

import android.test.AndroidTestCase;


import com.example.athi.assignment7domain.domain.maintenance.Maintanance;
import com.example.athi.assignment7domain.repository.Interfaces.Impl.maintenance.MaintananceRepositoryImpl;
import com.example.athi.assignment7domain.repository.Interfaces.maintenance.MaintananceTypeRepository;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Administrator on 2016/04/21.
 */
public class MaintenanceRepositoryTest extends AndroidTestCase {

    private static final String TAG="MAINTENANCE TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        MaintananceTypeRepository repo = new MaintananceRepositoryImpl(this.getContext());
        // CREATE
        Maintanance createEntity = new  Maintanance.Builder()
                .check(false)
                .build();
        Maintanance insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set< Maintanance> complaints = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",complaints.size()>0);

        //READ ENTITY
        Maintanance entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);



        //UPDATE ENTITY
        Maintanance updateEntity = new  Maintanance.Builder()
                .copy(entity)
                .check(true)
                .build();
        repo.update(updateEntity);
        Maintanance newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY",true,newEntity.maintananceChecks());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Maintanance deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }
}
