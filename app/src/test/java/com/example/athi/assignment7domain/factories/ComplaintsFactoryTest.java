package com.example.athi.assignment7domain.factories;

/**
 * Created by 212160923 on 4/17/2016.
 */
import com.example.athi.assignment7domain.domain.Complaints;
import junit.framework.Assert;
import org.junit.Test;

public class ComplaintsFactoryTest {

    @Test
    public void testComplaintsCreate() throws Exception {
        Complaints comp = ComplaintsFactory.getComplaints("Pipe Leak");
        Assert.assertEquals(comp.logComplaint(),"Pipe Leak");
    }

    @Test
    public void testComplaintsUpdate() throws Exception {
        Complaints comp = ComplaintsFactory.getComplaints("Pipe Leak");
        Complaints comp2 = new Complaints.Builder("")
                .copy(comp)
                .complaint("electrical fault")
                .build();
        Assert.assertEquals(comp2.logComplaint(),"electrical fault");

    }
}
