package src.dao;

import src.models.Bone;
import src.models.BoneSet;
import src.models.Question;
import src.models.QuizTest;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by rafaganabreu on 23/09/14.
 */
public class BoneSetDao extends AbstractDao {
    public List<BoneSet> queryBoneSets() {
        return dao.findEntities(getEM().createQuery("SELECT bs FROM BoneSet AS bs", BoneSet.class));
    }

    public BoneSet queryBoneSet(int id) {
        TypedQuery<BoneSet> query =
                dao.getEntityManager().createQuery(
                        "SELECT bs FROM BoneSet AS bs WHERE bs.idBoneSet = :id", BoneSet.class);
        query.setParameter("id",id);

        return dao.findEntity(query);
    }

    public List<Bone> queryBoneSetsBones(int id) {
        TypedQuery<Bone> query =
                dao.getEntityManager().createQuery(
                        "SELECT b FROM Bone AS b " +
                        "WHERE b.parentBoneSet.idBoneSet = :id", Bone.class);
        query.setParameter("id",id);

        return dao.findEntities(query);
    }

    public BoneSet queryBoneSetParent(int id) {
        TypedQuery<BoneSet> query =
                dao.getEntityManager().createQuery(
                        "SELECT bs.parent FROM BoneSet AS bs WHERE bs.idBoneSet = :id", BoneSet.class);
        query.setParameter("id",id);

        return dao.findEntity(query);
    }


    public List<Question> queryPublicQuestionsAbout(int id) {
        TypedQuery<Question> query =
                dao.getEntityManager().createQuery(
                        "SELECT q FROM Question AS q " +
                                "JOIN q.categories AS bs ON bs.idBoneSet = :id " +
                                "WHERE q.publicDomain = 1", Question.class);
        query.setParameter("id",id);

        return dao.findEntities(query);
    }

    public List<QuizTest> queryQuizTestsAbout(int id) {
        return null;
    }
}
