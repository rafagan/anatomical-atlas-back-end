package src.resources;

import src.controllers.BoneController;
import src.dtos.BoneStructureDescriptionDto;
import src.utils.WSOptionsResponse;
import src.utils.WSRN;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("v1/bones")
public class BoneResource extends AbstractResource {
    BoneController boneController = new BoneController();

    @GET
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getAllBones() {
        return boneController.getAllBones();
    }

    @OPTIONS
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getAllBonesOpt() {
        WSOptionsResponse r = new WSOptionsResponse();
        r.what = "Return all the bones of the human body";
        r.how = "GET api/bones";
        r.includes = "BoneParts, ParentBoneSet";

        WSRN.Response wResponse = new WSRN.Response();
        wResponse.setResult(r);
        return Response.ok(r).build();
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

        WSRN.Response wResponse = new WSRN.Response();
        wResponse.setResult(r);
        return Response.ok(r).build();
    }

    @PUT
    @Path("{id}/description")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    @Consumes(CONTENT_TYPE_APPLICATION_JSON)
    public Response updateBone(@PathParam("id") int boneId, BoneStructureDescriptionDto dto) {
        boneController.updateDescription(boneId,dto.description);
        return Response.ok(new WSRN.Response(dto)).build();
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

        return Response.ok(new WSRN.Response(r)).build();
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
