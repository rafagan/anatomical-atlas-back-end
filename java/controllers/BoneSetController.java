package controllers;

import controllers.dto.QuestionDto;
import dao.BoneSetDao;
import models.*;
import utils.EntityManagerUtil;
import utils.WSResponseFactory;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafaganabreu on 23/09/14.
 */
public class BoneSetController extends AbstractController {
    private BoneSetDao bsDao;

    public BoneSetController() {
        dao = bsDao = new BoneSetDao();
    }

    public Response getAllBoneSets() {
        WSResponseFactory.WSResponse wResponse;
        wResponse = WSResponseFactory.normalListResponse();

        bsDao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<BoneSet> bonesSets = bsDao.queryBoneSets();

        for (BoneSet set : bonesSets) {
            set.setRelatedQuestions(null);
            set.setParent(null);
            set.setBoneChildren(null);
            set.setBoneSetChildren(null);
        }

        wResponse.setResult(bonesSets);
        Response r = Response.ok(wResponse).build();
        bsDao.get().closeConnection();

        return r;
    }

    public Response getBoneSet(int id) {
        WSResponseFactory.WSResponse wResponse;

        bsDao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        BoneSet set = bsDao.queryBoneSet(id);

        set.setRelatedQuestions(null);
        set.setParent(null);
        set.setBoneChildren(null);
        set.setBoneSetChildren(null);

        wResponse = WSResponseFactory.normalSingleResponse(set);
        Response r = Response.ok(wResponse).build();
        bsDao.get().closeConnection();

        return r;
    }

    public Response getBoneSetBones(int boneSetId) {
        WSResponseFactory.WSResponse wResponse;
        wResponse = WSResponseFactory.normalListResponse();

        bsDao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<Bone> bones = bsDao.queryBoneSetsBones(boneSetId);

        for (Bone bone : bones) {
            bone.setNeighbors(null);
            bone.setParentBoneSet(null);

            if (bone.getBoneParts().size() == 0)
                bone.setBoneParts(null);
        }

        wResponse.setResult(bones);
        Response r = Response.ok(wResponse).build();
        bsDao.get().closeConnection();

        return r;
    }

    public Response getBoneSetParent(int boneSetId) {
        WSResponseFactory.WSResponse wResponse;
        wResponse = WSResponseFactory.normalListResponse();

        bsDao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        BoneSet set = bsDao.queryBoneSetParent(boneSetId);

        if(set != null) {
            set.setRelatedQuestions(null);
            set.setParent(null);
            set.setBoneChildren(null);
            set.setBoneSetChildren(null);
        }

        wResponse.setResult(set);
        Response r = Response.ok(wResponse).build();
        bsDao.get().closeConnection();

        return r;
    }

    public Response getPublicQuestionsAboutBoneSet(int id) {
        WSResponseFactory.WSResponse wResponse;
        wResponse = WSResponseFactory.normalListResponse();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<Question> questions = bsDao.queryPublicQuestionsAbout(id);
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

    public Response getQuizTestsAboutBoneSet(int id) {
        WSResponseFactory.WSResponse wResponse;
        wResponse = WSResponseFactory.normalListResponse();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<QuizTest> quizTests = bsDao.queryQuizTestsAbout(id);

        wResponse.setResult(quizTests);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }
}
