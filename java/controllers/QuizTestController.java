package controllers;

import dao.QuizTestDao;
import models.QuizTest;
import utils.EntityManagerUtil;
import utils.WSResponseFactory;

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
        WSResponseFactory.WSResponse wResponse;
        wResponse = WSResponseFactory.normalListResponse();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<QuizTest> quizTests = qtDao.queryPublicQuizTests();

        wResponse.setResult(quizTests);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getPublicQuizTest(int quizTestId) {
        WSResponseFactory.WSResponse wResponse;

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        QuizTest quizTest = qtDao.queryPublicQuizTest(quizTestId);

        wResponse = WSResponseFactory.normalSingleResponse(quizTest);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }
}
