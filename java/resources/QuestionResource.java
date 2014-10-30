package resources;

import controllers.QuestionController;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("questions")
public class QuestionResource extends AbstractResource {
    QuestionController questionController = new QuestionController();

    @GET
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getAllPublicQuestions() {
        return questionController.getAllPublicQuestions();
    }

    @GET
    @Path("{id}")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getPublicQuestion(@PathParam("id") int questionId) {
        return questionController.getPublicQuestion(questionId);
    }

    @GET
    @Path("trueorfalse")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getTrueOrFalsePublicQuestions() {
        return questionController.getTrueOrFalsePublicQuestions();
    }

    @GET
    @Path("multiplechoice")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getMultipleChoicePublicQuestions() {
        return questionController.getMultipleChoicePublicQuestions();
    }
}
