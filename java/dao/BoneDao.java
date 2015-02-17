package dao;

import models.Bone;

import javax.persistence.TypedQuery;
import java.util.List;


public class BoneDao extends AbstractDao {
    public List<Bone> queryBones() {
        return dao.findEntities(getEM().createQuery("SELECT b FROM Bone AS b", Bone.class));
    }

    public Bone queryBone(int id) {
        TypedQuery<Bone> query =
                dao.getEntityManager().createQuery(
                        "SELECT b FROM Bone AS b WHERE b.idBone = :id", Bone.class);
        query.setParameter("id",id);

        return dao.findEntity(query);
    }

    public List<Bone> queryBoneNeighbors(int boneId) {
        TypedQuery<Bone> query =
                dao.getEntityManager().createQuery(
                "SELECT n FROM Bone AS b " +
                "JOIN b.neighbors AS n " +
                "WHERE b.idBone = :id", Bone.class);
        query.setParameter("id",boneId);

        return dao.findEntities(query);
    }
}