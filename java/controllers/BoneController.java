package controllers;

import dao.BoneDao;
import models.Bone;
import models.BonePart;
import org.hibernate.Hibernate;
import utils.EntityManagerUtil;
import utils.WebserviceResponseFactory;

import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by rafaganabreu on 22/09/14.
 */
public class BoneController {
    private BoneDao dao = new BoneDao();

    public Response getAllBones() {
        WebserviceResponseFactory.WebserviceResponse wResponse;
        wResponse = WebserviceResponseFactory.normalListResponse();

        dao.getDao().startConnection(EntityManagerUtil.ATLAS_PU);
        List<Bone> bones = dao.queryBones();

        for (Bone bone : bones) {
            bone.setNeighbors(null);
            Hibernate.initialize(bone.getBoneParts());
        }

        wResponse.setResult(bones);
        Response r = Response.ok(wResponse).build();
        dao.getDao().closeConnection();

        return r;
    }

    public Response getBone(int id) {
        WebserviceResponseFactory.WebserviceResponse wResponse;

        dao.getDao().startConnection(EntityManagerUtil.ATLAS_PU);
        Bone bone = dao.queryBone(id);

        wResponse = WebserviceResponseFactory.normalSingleResponse(bone);

        Hibernate.initialize(bone.getBoneParts());
        Hibernate.initialize(bone.getNeighbors());

        for (Bone neighbors : bone.getNeighbors()) {
            neighbors.setNeighbors(null);
            neighbors.setBoneParts(null);
        }

        Response r = Response.ok(wResponse).build();
        dao.getDao().closeConnection();

        return r;
    }

    public Response getBoneNeighbors(int boneId) {
        WebserviceResponseFactory.WebserviceResponse wResponse;
        wResponse = WebserviceResponseFactory.normalListResponse();

        dao.getDao().startConnection(EntityManagerUtil.ATLAS_PU);
        List<Bone> neighbors = dao.queryBoneNeighbors(boneId);
        wResponse.setResult(neighbors);

        for (Bone bone : neighbors) {
            bone.setBoneParts(null);
            bone.setNeighbors(null);
        }

        Response r = Response.ok(wResponse).build();
        dao.getDao().closeConnection();

        return r;
    }
}
