package src.resources;

import src.controllers.QuizTestController;

import javax.ws.rs.*;
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
    public Response getPublicQuizTest(@PathParam("id") int quizTestId, @QueryParam("full") boolean full) {
        return quizTestController.getPublicQuizTest(quizTestId,full);
    }
}
