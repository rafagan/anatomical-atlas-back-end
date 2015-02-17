package dao;


import models.QuizTest;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by rafaganabreu on 23/10/14.
 */
public class QuizTestDao extends AbstractDao {
    public List<QuizTest> queryPublicQuizTests() {
        return dao.findEntities(getEM().createQuery("SELECT qt FROM QuizTest AS qt " +
                "WHERE qt.author = NULL", QuizTest.class));
    }

    public QuizTest queryPublicQuizTest(int id) {
        TypedQuery<QuizTest> query =
                dao.getEntityManager().createQuery(
                        "SELECT qt FROM QuizTest AS qt " +
                                "WHERE qt.idQuizTest = :id AND qt.author = NULL", QuizTest.class);
        query.setParameter("id",id);

        return dao.findEntity(query);
    }
}
