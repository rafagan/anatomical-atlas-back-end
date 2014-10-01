package resources;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("questions")
public class QuestionResource extends AbstractResource {
    @GET
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getAllPublicQuestions() {
        return Response.ok("").build();
    }

    @GET
    @Path("{id}")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getPublicQuestion(@PathParam("id") long questionId) {
        return Response.ok("").build();
    }

    @GET
    @Path("trueorfalse")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getTrueOrFalseQuestions() {
        return Response.ok("").build();
    }

    @GET
    @Path("multiplechoice")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getMultipleChoiceQuestions() {
        return Response.ok("").build();
    }
}
