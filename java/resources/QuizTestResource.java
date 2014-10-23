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
public class QuizTestResource extends AbstractResource {
    private static final String CONTENT_TYPE_APPLICATION_JSON = MediaType.APPLICATION_JSON + ";charset=utf-8";
    QuizTestController quizTestController = new QuizTestController();

    @GET
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getAllPublicQuizTests() {
        return quizTestController.getAllPublicQuizTests();
    }

    @GET
    @Path("{id}")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getPublicQuizTest(@PathParam("id") int quizTestId) {
        return quizTestController.getPublicQuizTest(quizTestId);
    }
}
