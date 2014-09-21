package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("bones")
public class BoneResource {
    private static final String CONTENT_TYPE_APPLICATION_JSON = MediaType.APPLICATION_JSON + ";charset=utf-8";

    @Context
    HttpServletRequest request;

    @GET
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getAllBones() {


        return Response.ok("").build();
    }

    @GET
    @Path("{id}")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getBone(@PathParam("id") long boneId) {


        return Response.ok("").build();
    }

    @GET
    @Path("{id}/questions")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getQuestionAboutBone(@PathParam("id") long questionId) {


        return Response.ok("").build();
    }

    @GET
    @Path("{id}/neighbours")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getBoneNeighbours(@PathParam("id") long boneId) {


        return Response.ok("").build();
    }

    @GET
    @Path("{id}/quiztests")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getQuizTestsAboutBone(@PathParam("id") long boneId) {


        return Response.ok("").build();
    }
}
