package src.controllers;

import src.dao.QuizTestDao;
import src.models.Question;
import src.models.QuizTest;
import src.utils.EntityManagerUtil;
import src.utils.WSRN;

import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by rafaganabreu on 23/09/14.
 */
public class QuizTestController extends AbstractController {
    QuizTestDao qtDao;

    public QuizTestController() {
        dao = qtDao = new QuizTestDao();
    }

    public Response getAllPublicQuizTests() {
        WSRN.Response wResponse = new WSRN.Response();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<QuizTest> quizTests = qtDao.queryPublicQuizTests();

        for(QuizTest qt : quizTests) {
            qt.setResolutions(null);
            qt.setAuthor(null); //Se é pública, o autor será nulo de qualquer maneira

            for(Question q : qt.getQuestions()){
                q.setQuizTests(null);
                q.setCategories(null);
                q.setAuthors(null);
                q.setFigure(null);
            }
        }

        wResponse.setResult(quizTests);
        wResponse.setStatus("OK");
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getPublicQuizTest(int quizTestId) {
        WSRN.Response wResponse = new WSRN.Response();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        QuizTest quizTest = qtDao.queryPublicQuizTest(quizTestId);

        quizTest.setResolutions(null);
        quizTest.setAuthor(null); //Se é pública, o autor será nulo de qualquer maneira

        for(Question q : quizTest.getQuestions()){
            q.setQuizTests(null);
            q.setCategories(null);
            q.setAuthors(null);
            q.setFigure(null);
        }

        wResponse.setResult(quizTest);
        wResponse.setStatus("OK");
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }
}
