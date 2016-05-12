package com.example.athi.assignment7domain.repository.electricityRepository;

import android.test.AndroidTestCase;


import com.example.athi.assignment7domain.domain.bills.ElectricityBill;
import com.example.athi.assignment7domain.repository.Interfaces.bills.ElectricityTypeRepository;
import com.example.athi.assignment7domain.repository.Interfaces.Impl.bills.ElectricityRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Administrator on 2016/04/21.
 */
public class ElectricityRepositoryTest extends AndroidTestCase {

    private static final String TAG="ELECTRICITY BILL TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {

        ElectricityTypeRepository repo = new ElectricityRepositoryImpl(this.getContext());
        // CREATE
        ElectricityBill createEntity = new ElectricityBill.Builder()
                .wats(129.85)
                .build();
        ElectricityBill insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<ElectricityBill> bills = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",bills.size()>0);

        //READ ENTITY
        ElectricityBill entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);



        //UPDATE ENTITY
        ElectricityBill updateEntity = new ElectricityBill.Builder()
                .copy(entity)
                .wats(800.57)
                .build();
        repo.update(updateEntity);
        ElectricityBill newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY",800.57,newEntity.getWats());

        // DELETE ENTITY
        repo.delete(updateEntity);
        ElectricityBill deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }
}
