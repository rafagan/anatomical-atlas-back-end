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
    @Path("true_or_false")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getTrueOrFalsePublicQuestions() {
        return questionController.getTrueOrFalsePublicQuestions();
    }

    @GET
    @Path("multiple_choice")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getMultipleChoicePublicQuestions() {
        return questionController.getMultipleChoicePublicQuestions();
    }
}
