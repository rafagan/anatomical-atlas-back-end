package controllers;

import dao.BoneDao;
import models.Bone;
import models.BoneSet;
import src.utils.EntityManagerUtil;
import src.utils.WSRN;

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
        WSRN.ResponseBone wResponse = new WSRN.ResponseBone();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<Bone> bones = bDao.queryBones();

        for (Bone bone : bones) {
            bone.setNeighbors(null);

            if(bone.getBoneParts().size() == 0)
                bone.setBoneParts(null);

            BoneSet parentBoneSet = bone.getParentBoneSet();
            parentBoneSet.setBoneChildren(null);
            parentBoneSet.setBoneSetChildren(null);
            parentBoneSet.setParent(null);
            parentBoneSet.setRelatedQuestions(null);
        }

        wResponse.setBones(bones);
        wResponse.setStatus("OK");
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    //Hibernate.initialize(bone.getBoneParts());

    public Response getBone(int id) {
        WSRN.Response wResponse = new WSRN.Response();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        Bone bone = bDao.queryBone(id);

        if(bone.getBoneParts().size() == 0)
            bone.setBoneParts(null);

        BoneSet parentBoneSet = bone.getParentBoneSet();
        parentBoneSet.setBoneChildren(null);
        parentBoneSet.setBoneSetChildren(null);
        parentBoneSet.setParent(null);
        parentBoneSet.setRelatedQuestions(null);

        if(bone.getNeighbors().size() == 0)
            bone.setNeighbors(null);
        else {
            for (Bone neighbors : bone.getNeighbors()) {
                neighbors.setNeighbors(null);
                neighbors.setBoneParts(null);
                neighbors.setParentBoneSet(null);
            }
        }

        wResponse.setResult(bone);
        wResponse.setStatus("OK");
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getBoneNeighbors(int boneId) {
        WSRN.Response wResponse = new WSRN.Response();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<Bone> neighbors = bDao.queryBoneNeighbors(boneId);
        wResponse.setResult(neighbors);

        for (Bone bone : neighbors) {
            bone.setBoneParts(null);
            bone.setNeighbors(null);
            bone.setParentBoneSet(null);
        }

        wResponse.setResult(neighbors);
        wResponse.setStatus("OK");
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public void updateDescription(int boneId, String description) {
        bDao.get().startConnection(EntityManagerUtil.ATLAS_PU);

        Bone b = (Bone) bDao.get().findObject(Bone.class,boneId);
        b.setDescription(description);
        bDao.get().changeOrInsertObject(b);

        bDao.get().closeConnection();
    }
}
