package controllers;

import controllers.dto.QuestionDto;
import dao.QuestionDao;
import models.MultipleChoice;
import models.Question;
import models.Teacher;
import models.TrueOrFalse;
import utils.EntityManagerUtil;
import utils.WSResponseFactory;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
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
        List<QuestionDto> dtos = new ArrayList<>();

        for(Question q : questions) {
            QuestionDto dto = new QuestionDto();

            dto.setId(q.getIdQuestion());
            dto.setFigure(q.getFigure());

            for(Teacher t : q.getAuthors()) {
                dto.getAuthorsId().add(t.getIdTeacher());
                dto.getAuthorsName().add(t.getName());
            }

            if(q instanceof TrueOrFalse) {
                TrueOrFalse tf = (TrueOrFalse) q;

                dto.setStatement(tf.getStatement());
                dto.setCorrectAnswerB(tf.getCorrectAnswer());
            } else if(q instanceof MultipleChoice) {
                MultipleChoice mc = (MultipleChoice) q;

                dto.setStatement(mc.getStatement());
                dto.setCorrectAnswer(mc.getCorrectAnswer());
                dto.setAnswerA(mc.getAnswerA());
                dto.setAnswerB(mc.getAnswerB());
                dto.setAnswerC(mc.getAnswerC());
                dto.setAnswerD(mc.getAnswerD());
                dto.setAnswerE(mc.getAnswerE());
            }

            dtos.add(dto);
        }

        wResponse.setResult(dtos);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getPublicQuestion(int id) {
        WSResponseFactory.WSResponse wResponse;

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        Question q = qDao.queryPublicQuestion(id);

        if(q == null) {
            wResponse = WSResponseFactory.normalSingleResponse(null);
            Response r = Response.ok(wResponse).build();
            dao.get().closeConnection();

            return r;
        }

        QuestionDto dto = new QuestionDto();

        dto.setId(q.getIdQuestion());
        dto.setFigure(q.getFigure());

        for(Teacher t : q.getAuthors()) {
            dto.getAuthorsId().add(t.getIdTeacher());
            dto.getAuthorsName().add(t.getName());
        }

        if(q instanceof TrueOrFalse) {
            TrueOrFalse tf = (TrueOrFalse) q;

            dto.setStatement(tf.getStatement());
            dto.setCorrectAnswerB(tf.getCorrectAnswer());
        } else if(q instanceof MultipleChoice) {
            MultipleChoice mc = (MultipleChoice) q;

            dto.setStatement(mc.getStatement());
            dto.setCorrectAnswer(mc.getCorrectAnswer());
            dto.setAnswerA(mc.getAnswerA());
            dto.setAnswerB(mc.getAnswerB());
            dto.setAnswerC(mc.getAnswerC());
            dto.setAnswerD(mc.getAnswerD());
            dto.setAnswerE(mc.getAnswerE());
        }

        wResponse = WSResponseFactory.normalSingleResponse(dto);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getTrueOrFalsePublicQuestions() {
        WSResponseFactory.WSResponse wResponse;
        wResponse = WSResponseFactory.normalListResponse();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<TrueOrFalse> questions = qDao.queryTFPublicQuestions();
        List<QuestionDto> dtos = new ArrayList<>();

        for(TrueOrFalse q : questions) {
            QuestionDto dto = new QuestionDto();

            dto.setId(q.getIdQuestion());
            dto.setFigure(q.getFigure());

            for(Teacher t : q.getAuthors()) {
                dto.getAuthorsId().add(t.getIdTeacher());
                dto.getAuthorsName().add(t.getName());
            }

            dto.setStatement(q.getStatement());
            dto.setCorrectAnswerB(q.getCorrectAnswer());
            dtos.add(dto);
        }

        wResponse.setResult(dtos);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getMultipleChoicePublicQuestions() {
        WSResponseFactory.WSResponse wResponse;
        wResponse = WSResponseFactory.normalListResponse();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<MultipleChoice> questions = qDao.queryMCPublicQuestions();
        List<QuestionDto> dtos = new ArrayList<>();

        for(MultipleChoice q : questions) {
            QuestionDto dto = new QuestionDto();

            dto.setId(q.getIdQuestion());
            dto.setFigure(q.getFigure());

            for(Teacher t : q.getAuthors()) {
                dto.getAuthorsId().add(t.getIdTeacher());
                dto.getAuthorsName().add(t.getName());
            }

            dto.setStatement(q.getStatement());
            dto.setCorrectAnswer(q.getCorrectAnswer());
            dto.setAnswerA(q.getAnswerA());
            dto.setAnswerB(q.getAnswerB());
            dto.setAnswerC(q.getAnswerC());
            dto.setAnswerD(q.getAnswerD());
            dto.setAnswerE(q.getAnswerE());

            dtos.add(dto);
        }

        wResponse.setResult(dtos);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }
}
