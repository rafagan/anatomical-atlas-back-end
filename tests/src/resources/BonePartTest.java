package src.resources;

import src.controllers.BonePartController;
import src.dao.BonePartDao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BonePartTest {
    BonePartController bpc;
    BonePartDao bpd;

    @Before
    public void setUp() throws Exception {
        bpc = new BonePartController();
        bpd = new BonePartDao();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetAllBoneParts() throws Exception {
        try {
            bpc.getAllBoneParts();
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}