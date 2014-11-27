package resources;

import controllers.BonePartController;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Created by rafaganabreu on 27/11/14.
 */
@Path("boneparts")
public class BonePartResource extends AbstractResource {
    BonePartController bpc;

    @GET
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getAllBones() { return bpc.getAllBoneParts(); }
}
