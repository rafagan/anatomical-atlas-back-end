package resources;

import controllers.TeacherController;
import models.Teacher;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("teachers")
public class TeacherResource extends AbstractResource {
    TeacherController teacherController = new TeacherController();

    @GET
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getAllTeachers() {
        return teacherController.getAllTeachers();
    }

    @POST
    @Consumes(CONTENT_TYPE_APPLICATION_JSON)
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response insertTeacher(Teacher teacher)
    {
        return teacherController.add(teacher);
    }

    @GET
    @Path("{id}")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getTeacher(@PathParam("id") int teacherId) {
        return teacherController.getTeacher(teacherId);
    }

    //Organizations which he is owner
    @GET
    @Path("{id}/organizations")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getTeacherOrganizations(@PathParam("id") int teacherId) {
        return teacherController.getTeacherOrganizations(teacherId);
    }

    @POST
    @Path("{id}/organizations")
    @Consumes(CONTENT_TYPE_APPLICATION_JSON)
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response insertOrganization(@PathParam("id") long teacherId) {
        return Response.ok("").build();
    }

    @GET
    @Path("{id}/classes")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getTeacherClasses(@PathParam("id") int teacherId) {
        return teacherController.getTeacherClasses(teacherId);
    }

    @POST
    @Path("{id}/classes")
    @Consumes(CONTENT_TYPE_APPLICATION_JSON)
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response insertTeacherClass(@PathParam("id") int teacherId) {
        return Response.ok("").build();
    }

    @GET
    @Path("{id}/classes/students")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getTeacherStudents(@PathParam("id") int teacherId) {
        return teacherController.getTeacherStudents(teacherId);
    }

    @GET
    @Path("{id1}/classes/{id2}/students")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getTeacherClassStudents(@PathParam("id1") int teacherId,
                                            @PathParam("id2") int classId) {
        return teacherController.getTeacherClassStudents(teacherId,classId);
    }

    @POST
    @Path("{id1}/classes/{id2}/students")
    @Consumes(CONTENT_TYPE_APPLICATION_JSON)
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response insertStudentInTeacherClass(@PathParam("id1") int teacherId,
                                         @PathParam("id2") int classId) {
        return Response.ok("").build();
    }

    @GET
    @Path("{id1}/classes/{id2}")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getTeacherClass(@PathParam("id1") int teacherId, @PathParam("id2") int classId) {
        return teacherController.getTeacherClass(teacherId, classId);
    }

    @GET
    @Path("{id}/questions")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getTeacherQuestions(@PathParam("id") int teacherId) {
        return teacherController.getTeacherQuestions(teacherId);
    }

    @GET
    @Path("{id1}/question/{id2}")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getTeacherQuestion(@PathParam("id1") int teacherId,@PathParam("id2") int questionId) {
        return teacherController.getTeacherQuestion(teacherId,questionId);
    }

    @GET
    @Path("{id}/questions/trueorfalse")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getTeacherTrueOrFalseQuestions(@PathParam("id") int teacherId) {
        return teacherController.getTeacherTrueOrFalseQuestions(teacherId);
    }

    //Verificar se a questão será pública ou não
    @POST
    @Path("{id}/questions/trueorfalse")
    @Consumes(CONTENT_TYPE_APPLICATION_JSON)
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response insertTeacherTrueOrFalseQuestion(@PathParam("id") long teacherId) {
        return Response.ok("").build();
    }

    @GET
    @Path("{id}/questions/multiplechoice")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getTeacherMultipleChoiceQuestions(@PathParam("id") int teacherId) {
        return teacherController.getTeacherMultipleChoiceQuestions(teacherId);
    }

    //Verificar se a questão será pública ou não
    @POST
    @Path("{id}/questions/multiplechoice")
    @Consumes(CONTENT_TYPE_APPLICATION_JSON)
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response insertTeacherMultipleChoiceQuestion(@PathParam("id") long teacherId) {
        return Response.ok("").build();
    }
}
