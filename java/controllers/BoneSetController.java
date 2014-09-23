package controllers;

import dao.BoneSetDao;
import models.BoneSet;
import utils.EntityManagerUtil;
import utils.WebserviceResponseFactory;

import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by rafaganabreu on 23/09/14.
 */
public class BoneSetController {
    BoneSetDao dao = new BoneSetDao();

    public Response getAllBoneSets() {
        WebserviceResponseFactory.WebserviceResponse wResponse;
        wResponse = WebserviceResponseFactory.normalListResponse();

        dao.getDao().startConnection(EntityManagerUtil.ATLAS_PU);
        List<BoneSet> bonesSets = dao.queryBoneSets();

        wResponse.setResult(bonesSets);
        Response r = Response.ok(wResponse).build();
        dao.getDao().closeConnection();

        return r;
    }

    public Response getBoneSetBones(int boneSetId) {
        return Response.ok("").build();
    }

    public Response getBoneSetParent(int questionId) {
        return Response.ok("").build();
    }

    public Response getQuestionsAboutBoneSet(int boneId) {
        return Response.ok("").build();
    }

    public Response getQuizTestsAboutBoneSet(int boneId) {
        return Response.ok("").build();
    }


    public Response getBoneSet(int id) {
        WebserviceResponseFactory.WebserviceResponse wResponse;

        dao.getDao().startConnection(EntityManagerUtil.ATLAS_PU);
        BoneSet boneSet = dao.queryBoneSet(id);

        wResponse = WebserviceResponseFactory.normalSingleResponse(boneSet);

        // TODO: Anular referência aos boneSets filhos do Parent

        Response r = Response.ok(wResponse).build();
        dao.getDao().closeConnection();

        return r;
    }
}
