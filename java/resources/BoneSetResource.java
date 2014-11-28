package resources;

import controllers.BoneSetController;
import dtos.BoneStructureDescriptionDto;
import utils.WSResponseFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("bonesets")
public class BoneSetResource extends AbstractResource {
    BoneSetController boneSetController = new BoneSetController();

    @GET
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getAllBoneSets() {
        return boneSetController.getAllBoneSets();
    }

    @GET
    @Path("{id}")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getBoneSet(@PathParam("id") int boneSetId) {
        return boneSetController.getBoneSet(boneSetId);
    }

    @GET
    @Path("{id}/bones")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getBoneSetBones(@PathParam("id") int boneSetId) {
        return boneSetController.getBoneSetBones(boneSetId);
    }

    @GET
    @Path("{id}/parent")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getBoneSetParent(@PathParam("id") int boneSetId) {
        return boneSetController.getBoneSetParent(boneSetId);
    }

    @GET
    @Path("{id}/questions")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getPublicQuestionsAboutBoneSet(@PathParam("id") int boneSetId) {
        return boneSetController.getPublicQuestionsAboutBoneSet(boneSetId);
    }

    @GET
    @Path("{id}/quiztests")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getQuizTestsAboutBoneSet(@PathParam("id") int boneSetId) {
        return boneSetController.getQuizTestsAboutBoneSet(boneSetId);
    }

    @PUT
    @Path("{id}/description")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    @Consumes(CONTENT_TYPE_APPLICATION_JSON)
    public Response updateBone(@PathParam("id") int boneSetId, BoneStructureDescriptionDto dto) {
        boneSetController.updateDescription(boneSetId,dto.description);
        return Response.ok(WSResponseFactory.normalSingleResponse(dto)).build();
    }
}
