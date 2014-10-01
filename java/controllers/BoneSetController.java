package controllers;

import dao.BoneSetDao;
import models.Bone;
import models.BoneSet;
import utils.EntityManagerUtil;
import utils.WebserviceResponseFactory;

import javax.ws.rs.core.Response;
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
        WebserviceResponseFactory.WebserviceResponse wResponse;
        wResponse = WebserviceResponseFactory.normalListResponse();

        bsDao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<BoneSet> bonesSets = bsDao.queryBoneSets();

        wResponse.setResult(bonesSets);
        Response r = Response.ok(wResponse).build();
        bsDao.get().closeConnection();

        return r;
    }

    public Response getBoneSetBones(int boneSetId) {
        WebserviceResponseFactory.WebserviceResponse wResponse;
        wResponse = WebserviceResponseFactory.normalListResponse();

        bsDao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<Bone> bones = bsDao.queryBoneSetsBones(boneSetId);

        wResponse.setResult(bones);
        Response r = Response.ok(wResponse).build();
        bsDao.get().closeConnection();

        return r;
    }

    public Response getBoneSetParent(int boneSetId) {
        WebserviceResponseFactory.WebserviceResponse wResponse;
        wResponse = WebserviceResponseFactory.normalListResponse();

        bsDao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        BoneSet boneSet = bsDao.queryBoneSetParent(boneSetId);

        wResponse.setResult(boneSet);
        Response r = Response.ok(wResponse).build();
        bsDao.get().closeConnection();

        return r;
    }

    public Response getQuestionsAboutBoneSet(int boneId) {
        return Response.ok("").build();
    }

    public Response getQuizTestsAboutBoneSet(int boneId) {
        return Response.ok("").build();
    }


    public Response getBoneSet(int id) {
        WebserviceResponseFactory.WebserviceResponse wResponse;

        bsDao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        BoneSet boneSet = bsDao.queryBoneSet(id);

        wResponse = WebserviceResponseFactory.normalSingleResponse(boneSet);

        // TODO: Anular referência aos boneSets filhos do Parent

        Response r = Response.ok(wResponse).build();
        bsDao.get().closeConnection();

        return r;
    }
}
