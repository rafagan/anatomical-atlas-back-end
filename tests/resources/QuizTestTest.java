package resources;

import controllers.QuizTestController;
import dao.QuizTestDao;
import models.QuizTest;
import models.Teacher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.EntityManagerUtil;

import java.util.List;

import static org.junit.Assert.*;

public class QuizTestTest {
    QuizTestController qtc;
    QuizTestDao qtd;

    @Before
    public void setUp() throws Exception {
        qtc = new QuizTestController();
        qtd = new QuizTestDao();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetAllPublicQuizTests() throws Exception {
        try {
            qtc.getAllPublicQuizTests();
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        qtd.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<QuizTest> quizTests = qtd.queryPublicQuizTests();

        //Testando Lazy Binding
        for (QuizTest quizTest : quizTests) {
            quizTest.getDifficultLevel();
        }

        qtd.get().closeConnection();
    }

    @Test
    public void testGetPublicQuizTest() throws Exception {
        try {
            qtc.getPublicQuizTest(4);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        try {
            qtd.get().startConnection(EntityManagerUtil.ATLAS_PU);
            QuizTest qt = qtd.queryPublicQuizTest(1);
            qt.getDifficultLevel();
            qtd.get().closeConnection();
        } catch(Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}