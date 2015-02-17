package dao;

import models.MultipleChoice;
import models.Question;
import models.TrueOrFalse;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by rafaganabreu on 23/10/14.
 */
public class QuestionDao extends AbstractDao {
    public List<Question> queryPublicQuestions() {
        return dao.findEntities(getEM().createQuery("SELECT q FROM Question AS q " +
                "WHERE q.publicDomain = 1", Question.class));
    }

    public List<TrueOrFalse> queryTFPublicQuestions() {
        return dao.findEntities(getEM().createQuery("SELECT q FROM TrueOrFalse AS q " +
                "WHERE q.publicDomain = 1", TrueOrFalse.class));
    }

    public List<MultipleChoice> queryMCPublicQuestions() {
        return dao.findEntities(getEM().createQuery("SELECT q FROM MultipleChoice AS q " +
                "WHERE q.publicDomain = 1", MultipleChoice.class));
    }

    public Question queryPublicQuestion(int id) {
        TypedQuery<Question> query =
                dao.getEntityManager().createQuery(
                        "SELECT q FROM Question AS q " +
                                "WHERE q.idQuestion = :id AND q.publicDomain = 1", Question.class);
        query.setParameter("id",id);

        return dao.findEntity(query);
    }
}
