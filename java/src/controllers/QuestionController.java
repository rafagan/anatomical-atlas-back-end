package src.controllers;

import src.dtos.MultipleChoiceDto;
import src.dtos.QuestionDto;
import src.dao.QuestionDao;
import src.dtos.TrueOrFalseDto;
import src.models.*;
import src.utils.EntityManagerUtil;
import src.utils.WSRN;

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
        WSRN.ResponseQuestion wResponse = new WSRN.ResponseQuestion();

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

        wResponse.setQuestions(dtos);
        wResponse.setStatus("OK");
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getPublicQuestion(int id) {
        WSRN.ResponseQuestion wResponse = new WSRN.ResponseQuestion();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        Question q = qDao.queryPublicQuestion(id);

        if(q == null) {
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

        wResponse.setQuestions(q);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getTrueOrFalsePublicQuestions() {
        WSRN.Response wResponse = new WSRN.Response();

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
        WSRN.Response wResponse = new WSRN.Response();

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

    public void insertTrueOrFalsePublicQuestion(TrueOrFalseDto dto) {
        qDao.get().startConnection(EntityManagerUtil.ATLAS_PU);

        TrueOrFalse tf = new TrueOrFalse();
        tf.setCorrectAnswer(dto.correctAnswer);
        tf.setStatement(dto.statement);
        if(tf.getFigure() != null) tf.setFigure(dto.figure.getBytes());
        tf.setPublicDomain((byte) 1);

        for(Integer id : dto.categories) {
            BoneSet bs = (BoneSet) qDao.get().findObject(BoneSet.class,id);
            tf.addCategory(bs);
        }

        Teacher t = (Teacher) qDao.get().findObject(Teacher.class,6);
        t.addQuestion(tf);

        qDao.get().insertObject(tf);
        qDao.get().closeConnection();
    }

    public void insertMultipleChoicePublicQuestion(MultipleChoiceDto dto) {
        qDao.get().startConnection(EntityManagerUtil.ATLAS_PU);

        MultipleChoice mc = new MultipleChoice();
        mc.setStatement(dto.statement);

        if(mc.getFigure() != null) mc.setFigure(dto.figure.getBytes());
        mc.setAnswerA(dto.answerA);
        mc.setAnswerB(dto.answerB);
        mc.setAnswerC(dto.answerC);
        mc.setAnswerD(dto.answerD);
        mc.setAnswerE(dto.answerE);
        mc.setCorrectAnswer(dto.correctAnswer);
        mc.setPublicDomain((byte) 1);

        for(Integer id : dto.categories) {
            BoneSet bs = (BoneSet) qDao.get().findObject(BoneSet.class,id);
            mc.addCategory(bs);
        }

        Teacher t = (Teacher) qDao.get().findObject(Teacher.class,6);
        t.addQuestion(mc);

        qDao.get().insertObject(mc);
        qDao.get().closeConnection();
    }
}
