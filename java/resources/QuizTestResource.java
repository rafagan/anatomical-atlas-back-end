package resources;

import controllers.QuizTestController;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("quiztests")
public class QuizTestResource {
    private static final String CONTENT_TYPE_APPLICATION_JSON = MediaType.APPLICATION_JSON + ";charset=utf-8";
    QuizTestController boneSetController = new QuizTestController();

    @Context
    HttpServletRequest request;

    @GET
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getAllPublicQuizTests() {
        return Response.ok("").build();
    }

    @GET
    @Path("{id}")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getPublicQuizTest(@PathParam("id") long quizTestId) {
        return Response.ok("").build();
    }
}
