package resources;

import controllers.QuestionController;
import dtos.BoneStructureDescriptionDto;
import dtos.MultipleChoiceDto;
import dtos.TrueOrFalseDto;
import models.MultipleChoice;
import utils.WSResponseFactory;

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

    @POST
    @Path("true_or_false")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    @Consumes(CONTENT_TYPE_APPLICATION_JSON)
    public Response insertTrueOrFalsePublicQuestion(TrueOrFalseDto dto) {
        questionController.insertTrueOrFalsePublicQuestion(dto);
        return Response.ok(WSResponseFactory.normalSingleResponse(dto)).build();
    }

    @POST
    @Path("multiple_choice")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    @Consumes(CONTENT_TYPE_APPLICATION_JSON)
    public Response insertMultipleChoicePublicQuestion(MultipleChoiceDto dto) {
        questionController.insertMultipleChoicePublicQuestion(dto);
        return Response.ok(WSResponseFactory.normalSingleResponse(dto)).build();
    }
}
