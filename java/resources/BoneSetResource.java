package resources;


import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("bonesets")
public class BoneSetResource {
    private static final String CONTENT_TYPE_APPLICATION_JSON = MediaType.APPLICATION_JSON + ";charset=utf-8";
    @Context
    HttpServletRequest request;

    @GET
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getAllBoneSets() {

        return Response.ok("bonesets").build();
    }

    @GET
    @Path("{id}")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getBoneSetBones(@PathParam("id") long boneSetId) {


        return Response.ok("").build();
    }

    @GET
    @Path("{id}/parent")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getBoneSetParent(@PathParam("id") long questionId) {


        return Response.ok("").build();
    }

    @GET
    @Path("{id}/questions")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getQuestionsAboutBoneSet(@PathParam("id") long boneId) {


        return Response.ok("").build();
    }

    @GET
    @Path("{id}/quiztests")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getQuizTestsAboutBoneSet(@PathParam("id") long boneId) {


        return Response.ok("").build();
    }
}
