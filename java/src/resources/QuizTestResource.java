package src.resources;

import src.controllers.QuizTestController;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("v1/quiztests")
public class QuizTestResource extends AbstractResource {
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
