package dao;

import models.BonePart;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by rafaganabreu on 27/11/14.
 */
public class BonePartDao extends AbstractDao {

    public List<BonePart> queryBoneParts() {
        TypedQuery<BonePart> query =
                dao.getEntityManager().createQuery("SELECT bp FROM BonePart AS bp", BonePart.class);
        List<BonePart> boneParts = null;

        try {
            boneParts = query.getResultList();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return boneParts;
    }
}
