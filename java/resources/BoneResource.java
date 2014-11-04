package resources;

import controllers.BoneController;
import utils.WSOptionsResponse;
import utils.WSResponseFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("bones")
public class BoneResource extends AbstractResource {
    BoneController boneController = new BoneController();

    @GET
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getAllBones() { return boneController.getAllBones(); }

    @OPTIONS
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getAllBonesOpt() {
        WSOptionsResponse r = new WSOptionsResponse();
        r.what = "Return all the bones of the human body";
        r.how = "GET api/bones";
        r.includes = "BoneParts, ParentBoneSet";

        WSResponseFactory.WSResponse wr = WSResponseFactory.normalSingleResponse(r);
        return Response.ok(wr).build();
    }

    @GET
    @Path("{id}")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getBone(@PathParam("id") int boneId) {
        return boneController.getBone(boneId);
    }

    @OPTIONS
    @Path("{id}")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getBoneOpt(@PathParam("id") int boneId) {
        WSOptionsResponse r = new WSOptionsResponse();
        r.what = "Return the bone " + boneId + " of the human body";
        r.how = "GET api/bones/" + boneId;
        r.includes = "BoneParts, ParentBoneSet, BoneNeighbors";

        WSResponseFactory.WSResponse wr = WSResponseFactory.normalSingleResponse(r);
        return Response.ok(wr).build();
    }

    @GET
    @Path("{id}/neighbors")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getBoneNeighbors(@PathParam("id") int boneId) {
        return boneController.getBoneNeighbors(boneId);
    }

    @OPTIONS
    @Path("{id}/neighbors")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getBoneNeighborsOpt(@PathParam("id") int boneId) {
        WSOptionsResponse r = new WSOptionsResponse();
        r.what = "Return the bone neighbors of bone " + boneId;
        r.how = "GET api/bones/" + boneId + "/neighbors";
        r.includes = "the neighbors of bone " + boneId;

        WSResponseFactory.WSResponse wr = WSResponseFactory.normalSingleResponse(r);
        return Response.ok(wr).build();
    }

    @GET
    @Path("{id}/questions")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getQuestionAboutBone(@PathParam("id") int questionId) {
        return Response.ok("Ainda não suportado").build();
    }

    @GET
    @Path("{id}/quiztests")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getQuizTestsAboutBone(@PathParam("id") int boneId) {
        return Response.ok("Ainda não suportado").build();
    }
}
