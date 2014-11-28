package controllers;

import dao.BonePartDao;
import models.Bone;
import models.BonePart;
import models.BoneSet;
import utils.EntityManagerUtil;
import utils.WSResponseFactory;

import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by rafaganabreu on 27/11/14.
 */
public class BonePartController extends AbstractController {
    private BonePartDao bpd;

    public BonePartController() {dao = bpd = new BonePartDao();}

    public Response getAllBoneParts() {
        WSResponseFactory.WSResponse wResponse;
        wResponse = WSResponseFactory.normalListResponse();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<BonePart> boneParts = bpd.queryBoneParts();

        for (BonePart bonePart : boneParts) {
            Bone p = bonePart.getParentBone();

            p.setNeighbors(null);
            p.setParentBoneSet(null);
            p.setBoneParts(null);
        }

        wResponse.setResult(boneParts);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public void updateDescription(int bonePartId, String description) {
        bpd.get().startConnection(EntityManagerUtil.ATLAS_PU);

        BonePart b = (BonePart) bpd.get().findObject(BonePart.class,bonePartId);
        b.setDescription(description);
        bpd.get().changeOrInsertObject(b);

        bpd.get().closeConnection();
    }
}
