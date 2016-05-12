package com.example.athi.assignment7domain.repository.waterRepository;

import android.test.AndroidTestCase;


import com.example.athi.assignment7domain.domain.bills.WaterBill;
import com.example.athi.assignment7domain.repository.Interfaces.Impl.bills.WaterBillRepositoryImpl;
import com.example.athi.assignment7domain.repository.Interfaces.bills.WaterBillTypeRepository;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Administrator on 2016/04/21.
 */
public class WaterBillRepositoryTest extends AndroidTestCase {

    private static final String TAG="WATER BILL TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {

        WaterBillTypeRepository repo = new WaterBillRepositoryImpl(this.getContext());
        // CREATE
        WaterBill createEntity = new WaterBill.Builder()
                .litres(3815.6)
                .build();
        WaterBill insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<WaterBill> bills = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",bills.size()>0);

        //READ ENTITY
        WaterBill entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);



        //UPDATE ENTITY
        WaterBill updateEntity = new WaterBill.Builder()
                .copy(entity)
                .litres(300.78)
                .build();
        repo.update(updateEntity);
        WaterBill newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY",300.78,newEntity.getLitres());

        // DELETE ENTITY
        repo.delete(updateEntity);
        WaterBill deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }
}
