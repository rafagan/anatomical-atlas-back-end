package dao;

import models.BoneSet;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by rafaganabreu on 23/09/14.
 */
public class BoneSetDao extends AbstractDao {
    public List<BoneSet> queryBoneSets() {
        TypedQuery<BoneSet> query =
                dao.getEntityManager().createQuery(
                        "SELECT b FROM BoneSet AS b ", BoneSet.class);
        List<BoneSet> boneSets = null;

        try {
            boneSets = query.getResultList();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return boneSets;
    }

    public BoneSet queryBoneSet(int id) {
        TypedQuery<BoneSet> query =
                dao.getEntityManager().createQuery(
                        "SELECT b FROM BoneSet AS b WHERE b.idBoneSet = :id", BoneSet.class);
        query.setParameter("id",id);
        BoneSet boneSet = null;

        try {
            boneSet = query.getSingleResult();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return boneSet;
    }
}
