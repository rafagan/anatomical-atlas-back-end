package dao;

import models.Bone;

import javax.persistence.TypedQuery;
import java.util.List;


public class BoneDao extends AbstractDao {
    public List<Bone> queryBones() {
        TypedQuery<Bone> query =
                dao.getEntityManager().createQuery(
                        "SELECT b FROM Bone AS b", Bone.class);
        List<Bone> bones = null;

        try {
            bones = query.getResultList();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return bones;
    }

    public Bone queryBone(int id) {
        TypedQuery<Bone> query =
                dao.getEntityManager().createQuery(
                        "SELECT b FROM Bone AS b WHERE b.idBone = :id", Bone.class);
        query.setParameter("id",id);
        Bone bone = null;

        try {
            bone = query.getSingleResult();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return bone;
    }

    public List<Bone> queryBoneNeighbors(int boneId) {
        TypedQuery<Bone> query =
                dao.getEntityManager().createQuery(
                "SELECT n FROM Bone AS b " +
                "JOIN b.neighbors AS n " +
                "WHERE b.idBone = :id", Bone.class);
        query.setParameter("id",boneId);
        List<Bone> neighbours = null;

        try {
            neighbours = query.getResultList();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return neighbours;
    }
}