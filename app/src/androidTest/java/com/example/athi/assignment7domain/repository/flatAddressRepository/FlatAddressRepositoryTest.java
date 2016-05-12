package com.example.athi.assignment7domain.repository.flatAddressRepository;

import android.test.AndroidTestCase;


import com.example.athi.assignment7domain.domain.address.FlatAddress;
import com.example.athi.assignment7domain.repository.Interfaces.address.FlatAddressTypeRepository;
import com.example.athi.assignment7domain.repository.Interfaces.Impl.address.FlatAddressRepositoryImpl;


import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Administrator on 2016/04/21.
 */
public class FlatAddressRepositoryTest extends AndroidTestCase {

    private static final String TAG="FLAT ADDRESS TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {

        FlatAddressTypeRepository repo = new FlatAddressRepositoryImpl(this.getContext());
        // CREATE
        FlatAddress createEntity = new FlatAddress.Builder()
                .flatNo("20")
                .zip(7784)
                .build();
        FlatAddress insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<FlatAddress> addressTypes = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",addressTypes.size()>0);

        //READ ENTITY
        FlatAddress entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);



        //UPDATE ENTITY
        FlatAddress updateEntity = new FlatAddress.Builder()
                .copy(entity)
                .flatNo("25")
                .build();
        repo.update(updateEntity);
        FlatAddress newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","25",newEntity.getFlatNo());

        // DELETE ENTITY
        repo.delete(updateEntity);
        FlatAddress deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }
}
