package dao;


import models.QuizTest;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by rafaganabreu on 23/10/14.
 */
public class QuizTestDao extends AbstractDao {
    public List<QuizTest> queryPublicQuizTests() {
        TypedQuery<QuizTest> query =
                dao.getEntityManager().createQuery(
                        "SELECT qt FROM QuizTest AS qt " +
                                "WHERE qt.author = NULL", QuizTest.class);
        List<QuizTest> questions = null;

        try {
            questions = query.getResultList();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return questions;
    }

    public QuizTest queryPublicQuizTest(int id) {
        TypedQuery<QuizTest> query =
                dao.getEntityManager().createQuery(
                        "SELECT qt FROM QuizTest AS qt " +
                                "WHERE qt.idQuizTest = :id AND qt.author = NULL", QuizTest.class);
        query.setParameter("id",id);
        QuizTest question = null;

        try {
            question = query.getSingleResult();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return question;
    }
}
