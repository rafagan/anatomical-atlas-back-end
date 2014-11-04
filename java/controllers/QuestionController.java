package controllers;

import dao.QuestionDao;
import models.MultipleChoice;
import models.Question;
import models.TrueOrFalse;
import utils.EntityManagerUtil;
import utils.WSResponseFactory;

import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by rafaganabreu on 23/10/14.
 */
public class QuestionController extends AbstractController {
    QuestionDao qDao;

    public QuestionController() {
        dao = qDao = new QuestionDao();
    }

    public Response getAllPublicQuestions() {
        WSResponseFactory.WSResponse wResponse;
        wResponse = WSResponseFactory.normalListResponse();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<Question> questions = qDao.queryPublicQuestions();

        wResponse.setResult(questions);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getPublicQuestion(int id) {
        WSResponseFactory.WSResponse wResponse;

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        Question question = qDao.queryPublicQuestion(id);

        wResponse = WSResponseFactory.normalSingleResponse(question);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getTrueOrFalsePublicQuestions() {
        WSResponseFactory.WSResponse wResponse;
        wResponse = WSResponseFactory.normalListResponse();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<TrueOrFalse> questions = qDao.queryTFPublicQuestions();

        wResponse.setResult(questions);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getMultipleChoicePublicQuestions() {
        WSResponseFactory.WSResponse wResponse;
        wResponse = WSResponseFactory.normalListResponse();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<MultipleChoice> questions = qDao.queryMCPublicQuestions();

        wResponse.setResult(questions);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }
}
