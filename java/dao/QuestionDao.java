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
        TypedQuery<Question> query =
                dao.getEntityManager().createQuery(
                        "SELECT q FROM Question AS q " +
                                "WHERE q.publicDomain = 1", Question.class);
        List<Question> questions = null;

        try {
            questions = query.getResultList();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return questions;
    }

    public List<TrueOrFalse> queryTFPublicQuestions() {
        TypedQuery<TrueOrFalse> query =
                dao.getEntityManager().createQuery(
                        "SELECT q FROM TrueOrFalse AS q " +
                                "WHERE q.publicDomain = 1", TrueOrFalse.class);
        List<TrueOrFalse> questions = null;

        try {
            questions = query.getResultList();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return questions;
    }

    public List<MultipleChoice> queryMCPublicQuestions() {
        TypedQuery<MultipleChoice> query =
                dao.getEntityManager().createQuery(
                        "SELECT q FROM MultipleChoice AS q " +
                                "WHERE q.publicDomain = 1", MultipleChoice.class);
        List<MultipleChoice> questions = null;

        try {
            questions = query.getResultList();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return questions;
    }

    public Question queryPublicQuestion(int id) {
        TypedQuery<Question> query =
                dao.getEntityManager().createQuery(
                        "SELECT q FROM Question AS q " +
                                "WHERE q.idQuestion = :id AND q.publicDomain = 1", Question.class);
        query.setParameter("id",id);
        Question question = null;

        try {
            question = query.getSingleResult();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return question;
    }
}
