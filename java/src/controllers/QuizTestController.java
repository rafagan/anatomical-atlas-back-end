package src.controllers;

import src.dao.QuizTestDao;
import src.models.BoneSet;
import src.models.Question;
import src.models.QuizTest;
import src.models.Teacher;
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
        WSRN.ResponseQuizTest wResponse = new WSRN.ResponseQuizTest();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<QuizTest> quizTests = qtDao.queryPublicQuizTests();

        for(QuizTest qt : quizTests) {
            qt.setResolutions(null);
            qt.setAuthor(null); //Se é pública, o autor será nulo de qualquer maneira
            qt.setQuestions(null);
        }

        wResponse.setQuizTests(quizTests);
        wResponse.setStatus("OK");
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getPublicQuizTest(int quizTestId, boolean full) {
        WSRN.ResponseQuizTest wResponse = new WSRN.ResponseQuizTest();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        QuizTest quizTest = qtDao.queryPublicQuizTest(quizTestId);

        quizTest.setResolutions(null);
        quizTest.setAuthor(null); //Se é pública, o autor será nulo de qualquer maneira

        if(!full)
            quizTest.setQuestions(null);
        else
            for(Question q : quizTest.getQuestions()){
                q.setQuizTests(null);

                for(BoneSet cat : q.getCategories()) {
                    cat.setBoneChildren(null);
                    cat.setParent(null);
                    cat.setRelatedQuestions(null);
                    cat.setBoneSetChildren(null);
                }

                for(Teacher author : q.getAuthors()) {
                    author.setWorkingOrganizations(null);
                    author.setOwnerOfOrganizations(null);
                    author.setOwnerOfClasses(null);
                    author.setMonitoratedClasses(null);
                    author.setMyQuizTests(null);
                    author.setMyQuestions(null);
                    author.setLogin(null);
                }
            }

        wResponse.setQuizTests(quizTest);
        wResponse.setStatus("OK");
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }
}
