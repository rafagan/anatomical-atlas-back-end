package dao;

import models.Bone;
import models.BoneSet;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by rafaganabreu on 23/09/14.
 */
public class BoneSetDao extends AbstractDao {
    public List<BoneSet> queryBoneSets() {
        TypedQuery<BoneSet> query =
                dao.getEntityManager().createQuery(
                        "SELECT bs FROM BoneSet AS bs ", BoneSet.class);
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
                        "SELECT bs FROM BoneSet AS bs WHERE bs.idBoneSet = :id", BoneSet.class);
        query.setParameter("id",id);
        BoneSet boneSet = null;

        try {
            boneSet = query.getSingleResult();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return boneSet;
    }

    public List<Bone> queryBoneSetsBones(int id) {
        TypedQuery<Bone> query =
                dao.getEntityManager().createQuery(
                        "SELECT b FROM Bone AS b " +
                        "WHERE b.parentBoneSet.idBoneSet = :id", Bone.class);
        query.setParameter("id",id);
        List<Bone> sonBones = null;

        try {
            sonBones = query.getResultList();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return sonBones;
    }

    public BoneSet queryBoneSetParent(int id) {
        TypedQuery<BoneSet> query =
                dao.getEntityManager().createQuery(
                        "SELECT bs FROM BoneSet AS bs WHERE bs.parent.idBoneSet = :id", BoneSet.class);
        query.setParameter("id",id);
        BoneSet boneSet = null;

        try {
            boneSet = query.getSingleResult();
        } catch (NoResultException nre) {
            return null; //Expected result
        } catch(Exception e) {
            e.printStackTrace();
        }

        return boneSet;
    }
}
