package dao;

import models.Bone;
import models.User;
import utils.EntityManagerUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;


public class BoneDao {
    private DaoManager dao = new DaoManager();

    public List<Bone> queryBones() {
        dao.startConnection(EntityManagerUtil.ATLAS_PU);
        TypedQuery<Bone> query = dao.getEntityManager().createQuery("SELECT b FROM Bone AS b", Bone.class);
        List<Bone> bones = null;

        try {
            bones = query.getResultList();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            dao.closeConnection();
        }

        return bones;
    }

    public Bone queryBone(int id) {
        dao.startConnection(EntityManagerUtil.ATLAS_PU);
        Bone bone = null;

        try {
            bone = (Bone) dao.findObject(Bone.class, id);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            dao.closeConnection();
        }

        return bone;
    }
}