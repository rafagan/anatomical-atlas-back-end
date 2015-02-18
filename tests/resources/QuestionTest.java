package resources;

import src.controllers.QuestionController;
import src.dao.QuestionDao;
import src.models.MultipleChoice;
import src.models.Question;
import src.models.TrueOrFalse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import src.utils.EntityManagerUtil;

import java.util.List;

import static org.junit.Assert.*;

public class QuestionTest {
    QuestionDao qDao;
    QuestionController qc;

    @Before
    public void setUp() throws Exception {
        qDao = new QuestionDao();
        qc = new QuestionController();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetAllPublicQuestions() throws Exception {
        try {
            qc.getAllPublicQuestions();
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        qDao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<Question> questions = qDao.queryPublicQuestions();

        //Testando Lazy Binding
        for (Question question : questions) {
            question.getPublicDomain();
        }

        qDao.get().closeConnection();
    }

    @Test
    public void testGetPublicQuestion() throws Exception {
        try {
            qc.getPublicQuestion(1014);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        try {
            qDao.get().startConnection(EntityManagerUtil.ATLAS_PU);
            Question q = qDao.queryPublicQuestion(1013);
            q.getPublicDomain();
            qDao.get().closeConnection();
        } catch(Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testGetTrueOrFalseQuestions() throws Exception {
        try {
            qc.getAllPublicQuestions();
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        qDao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<TrueOrFalse> questions = qDao.queryTFPublicQuestions();

        //Testando Lazy Binding
        for (TrueOrFalse question : questions) {
            question.getPublicDomain();
        }

        qDao.get().closeConnection();
    }

    @Test
    public void testGetMultipleChoiceQuestions() throws Exception {
        try {
            qc.getAllPublicQuestions();
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        qDao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<MultipleChoice> questions = qDao.queryMCPublicQuestions();

        //Testando Lazy Binding
        for (MultipleChoice question : questions) {
            question.getPublicDomain();
        }

        qDao.get().closeConnection();
    }
}