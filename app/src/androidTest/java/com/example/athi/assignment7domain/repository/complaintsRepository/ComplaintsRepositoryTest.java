package com.example.athi.assignment7domain.repository.complaintsRepository;

import android.test.AndroidTestCase;

import com.example.athi.assignment7domain.domain.complaints.Complaints;
import com.example.athi.assignment7domain.repository.Interfaces.complaint.ComplaintsTypeRepository;
import com.example.athi.assignment7domain.repository.Interfaces.Impl.complaint.ComplaintsRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;
/**
 * Created by Administrator on 2016/04/21.
 */
public class ComplaintsRepositoryTest extends AndroidTestCase {

    private static final String TAG="COMPLAINTS TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        ComplaintsTypeRepository repo = new ComplaintsRepositoryImpl(this.getContext());
        // CREATE
        Complaints createEntity = new Complaints.Builder()
                .complaint("water flood")
                .build();
        Complaints insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<Complaints> complaints = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",complaints.size()>0);

        //READ ENTITY
        Complaints entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);



        //UPDATE ENTITY
        Complaints updateEntity = new Complaints.Builder()
                .copy(entity)
                .complaint("electrical fault")
                .build();
        repo.update(updateEntity);
        Complaints newEntity = repo.findById(id);
        Assert.assertEquals(TAG+ " UPDATE ENTITY","electrical fault",newEntity.logComplaint());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Complaints deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }


}
