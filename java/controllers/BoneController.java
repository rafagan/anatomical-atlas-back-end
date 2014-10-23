package controllers;

import dao.BoneDao;
import models.Bone;
import org.hibernate.Hibernate;
import utils.EntityManagerUtil;
import utils.WebserviceResponseFactory;

import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by rafaganabreu on 22/09/14.
 */
public class BoneController extends AbstractController {
    private BoneDao bDao;

    public BoneController() {
        dao = bDao = new BoneDao();
    }

    public Response getAllBones() {
        WebserviceResponseFactory.WebserviceResponse wResponse;
        wResponse = WebserviceResponseFactory.normalListResponse();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<Bone> bones = bDao.queryBones();

        for (Bone bone : bones) {
            bone.setNeighbors(null);
            Hibernate.initialize(bone.getBoneParts());
        }

        wResponse.setResult(bones);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getBone(int id) {
        WebserviceResponseFactory.WebserviceResponse wResponse;

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        Bone bone = bDao.queryBone(id);

        wResponse = WebserviceResponseFactory.normalSingleResponse(bone);

        Hibernate.initialize(bone.getBoneParts());
        Hibernate.initialize(bone.getNeighbors());

        for (Bone neighbors : bone.getNeighbors()) {
            neighbors.setNeighbors(null);
            neighbors.setBoneParts(null);
        }

        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getBoneNeighbors(int boneId) {
        WebserviceResponseFactory.WebserviceResponse wResponse;
        wResponse = WebserviceResponseFactory.normalListResponse();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<Bone> neighbors = bDao.queryBoneNeighbors(boneId);
        wResponse.setResult(neighbors);

        for (Bone bone : neighbors) {
            bone.setBoneParts(null);
            bone.setNeighbors(null);
        }

        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getQuestionAboutBone(int questionId) {
        return Response.ok("").build();
    }

    public Response getQuizTestsAboutBone(int boneId) {
        return Response.ok("").build();
    }
}
