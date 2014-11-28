package resources;

import controllers.BonePartController;
import dtos.BoneStructureDescriptionDto;
import utils.WSResponseFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by rafaganabreu on 27/11/14.
 */
@Path("boneparts")
public class BonePartResource extends AbstractResource {
    BonePartController bpc = new BonePartController();

    @GET
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getAllBones() { return bpc.getAllBoneParts(); }

    @PUT
    @Path("{id}/description")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    @Consumes(CONTENT_TYPE_APPLICATION_JSON)
    public Response updateBone(@PathParam("id") int bonePartId, BoneStructureDescriptionDto dto) {
        bpc.updateDescription(bonePartId,dto.description);
        return Response.ok(WSResponseFactory.normalSingleResponse(dto)).build();
    }
}
