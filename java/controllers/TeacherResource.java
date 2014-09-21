package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("teachers")
public class TeacherResource {
    private static final String CONTENT_TYPE_APPLICATION_JSON = MediaType.APPLICATION_JSON + ";charset=utf-8";

    @Context
    HttpServletRequest request;

    @GET
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getAllTeachers() {
        return Response.ok("").build();
    }

    @POST
    @Consumes(CONTENT_TYPE_APPLICATION_JSON)
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response insertTeacher(/*FixedPinpoint fixedPinpoint,*/) {
        return Response.ok("").build();
    }

    @GET
    @Path("{id}")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getTeacher(@PathParam("id") long teacherId) {
        return Response.ok("").build();
    }

    //Organizations which he is owner
    @GET
    @Path("{id}/organizations")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getTeacherOrganizations(@PathParam("id") long teacherId) {
        return Response.ok("").build();
    }

    @POST
    @Path("{id}/organizations")
    @Consumes(CONTENT_TYPE_APPLICATION_JSON)
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response insertOrganization(@PathParam("id") long teacherId /*FixedPinpoint fixedPinpoint,*/) {
        return Response.ok("").build();
    }

    @GET
    @Path("{id}/classes")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getTeacherClasses(@PathParam("id") long teacherId) {
        return Response.ok("").build();
    }

    @POST
    @Path("{id}/classes")
    @Consumes(CONTENT_TYPE_APPLICATION_JSON)
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response insertTeacherClass(@PathParam("id") long teacherId /*FixedPinpoint fixedPinpoint,*/) {
        return Response.ok("").build();
    }

    @GET
    @Path("{id}/classes/students")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getTeacherStudents(@PathParam("id") long teacherId) {
        return Response.ok("").build();
    }

    @GET
    @Path("{id1}/classes/{id2}/students")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getTeacherClassStudents(@PathParam("id1") long teacherId,
                                            @PathParam("id2") long classId) {
        return Response.ok("").build();
    }

    @POST
    @Path("{id1}/classes/{id2}/students")
    @Consumes(CONTENT_TYPE_APPLICATION_JSON)
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response insertStudentInTeacherClass(@PathParam("id1") long teacherId,
                                         @PathParam("id2") long classId /*FixedPinpoint fixedPinpoint,*/) {
        return Response.ok("").build();
    }

    @GET
    @Path("{id1}/classes/{id2}")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getTeacherClass(@PathParam("id1") long teacherId, @PathParam("id2") long classId) {
        return Response.ok("").build();
    }

    @GET
    @Path("{id}/questions")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getTeacherQuestions(@PathParam("id") long teacherId) {
        return Response.ok("").build();
    }

    @GET
    @Path("{id1}/question/{id2}")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getTeacherQuestion(@PathParam("id1") long teacherId,@PathParam("id2") long questionId) {
        return Response.ok("").build();
    }

    @GET
    @Path("{id}/questions/trueorfalse")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getTeacherTrueOrFalseQuestions(@PathParam("id") long teacherId) {
        return Response.ok("").build();
    }

    //Verificar se a questão será pública ou não
    @POST
    @Path("{id}/questions/trueorfalse")
    @Consumes(CONTENT_TYPE_APPLICATION_JSON)
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response insertTeacherTrueOrFalseQuestion(@PathParam("id") long teacherId /*FixedPinpoint fixedPinpoint*/) {
        return Response.ok("").build();
    }

    @GET
    @Path("{id}/questions/multiplechoice")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getTeacherMultipleChoiceQuestions(@PathParam("id") long teacherId) {
        return Response.ok("").build();
    }

    //Verificar se a questão será pública ou não
    @POST
    @Path("{id}/questions/multiplechoice")
    @Consumes(CONTENT_TYPE_APPLICATION_JSON)
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response insertTeacherMultipleChoiceQuestion(@PathParam("id") long teacherId /*FixedPinpoint fixedPinpoint*/) {
        return Response.ok("").build();
    }
}
