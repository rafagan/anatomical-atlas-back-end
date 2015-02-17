package resources;

import controllers.BoneController;
import dao.BoneDao;
import models.Bone;
import models.BonePart;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import src.utils.EntityManagerUtil;
import java.util.List;

import static org.junit.Assert.*;

public class BoneTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldGetAllBones() throws Exception {
        try {
            new BoneController().getAllBones();
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        BoneDao dao = new BoneDao();
        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<Bone> bones = dao.queryBones();

        if(bones.size() == 0)
            fail("Não encontrou nenhum Bone no banco");
        if(bones.size() != 238)
            fail("A base não possui todos os 206 ossos + 32 dentes do corpo humano");

        //Testando Lazy Binding
        for (Bone bone : bones) {
            for (BonePart part : bone.getBoneParts())
                System.out.println(part.getName());
            for (Bone neighbor : bone.getNeighbors())
                System.out.println(neighbor.getName());
        }

        dao.get().closeConnection();
    }

    @Test
    public void shouldGetBone() throws Exception {
        try {
            new BoneController().getBone(1);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        BoneDao dao = new BoneDao();
        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        Bone bone = dao.queryBone(1);

        for (BonePart part : bone.getBoneParts())
            System.out.println(part.getName());
        for (Bone neighbor : bone.getNeighbors())
            System.out.println(neighbor.getName());

        dao.get().closeConnection();
    }

    @Test
    public void shouldGetBoneNeighbors() throws Exception {
        try {
            new BoneController().getBoneNeighbors(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}