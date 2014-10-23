package controllers;

import javax.ws.rs.core.Response;

/**
 * Created by rafaganabreu on 23/09/14.
 */
public class QuizTestController extends AbstractController {

    public Response getAllPublicQuizTests() {
        return Response.ok("").build();
    }

    public Response getPublicQuizTest(int quizTestId) {
        return Response.ok("").build();
    }
}
