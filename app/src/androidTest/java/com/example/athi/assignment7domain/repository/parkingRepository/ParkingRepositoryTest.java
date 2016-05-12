package com.example.athi.assignment7domain.repository.parkingRepository;

import android.test.AndroidTestCase;


import com.example.athi.assignment7domain.domain.bills.ParkingBill;
import com.example.athi.assignment7domain.repository.Interfaces.Impl.bills.ParkingBillRepositoryImpl;
import com.example.athi.assignment7domain.repository.Interfaces.bills.ParkingBillTypeRepository;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Administrator on 2016/04/21.
 */
public class ParkingRepositoryTest extends AndroidTestCase {

    private static final String TAG="PARKING BILL TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {

        ParkingBillTypeRepository repo = new ParkingBillRepositoryImpl(this.getContext());
        // CREATE
        ParkingBill createEntity = new ParkingBill.Builder()
                .days(38)
                .build();
        ParkingBill insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<ParkingBill> bills = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",bills.size()>0);

        //READ ENTITY
        ParkingBill entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);



        //UPDATE ENTITY
        ParkingBill updateEntity = new ParkingBill.Builder()
                .copy(entity)
                .days(300)
                .build();
        repo.update(updateEntity);
        ParkingBill newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY",300,newEntity.getDays());

        // DELETE ENTITY
        repo.delete(updateEntity);
        ParkingBill deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }
}
