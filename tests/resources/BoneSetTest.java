package resources;

import controllers.BoneSetController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * Created by rafaganabreu on 23/09/14.
 */
public class BoneSetTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldGetBoneSetParent() throws Exception {
        try {
            new BoneSetController().getBoneSetParent(1);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void shouldGetBoneSetBones() throws Exception {
        try {
            new BoneSetController().getBoneSetBones(1);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void shouldGetBoneSet() throws Exception {
        try {
            new BoneSetController().getBoneSet(1);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void shouldGetAllBoneSets() throws Exception {
        try {
            new BoneSetController().getAllBoneSets();
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void shouldGetQuestionsAboutBoneSet() throws Exception {
        try {
            new BoneSetController().getPublicQuestionsAboutBoneSet(1);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void shouldGetQuizTestsAboutBoneSet() throws Exception {
        try {
            new BoneSetController().getQuizTestsAboutBoneSet(1);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
