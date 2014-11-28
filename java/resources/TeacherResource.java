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
    @Path("{id}/monitorated_classes")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getTeacherMonitoratedClasses(@PathParam("id") int teacherId) {
        return teacherController.getTeacherMonitoratedClasses(teacherId);
    }

    @GET
    @Path("{id}/ownerClasses")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getTeacherOwnerClasses(@PathParam("id") int teacherId) {
        return teacherController.getTeacherOwnerClasses(teacherId);
    }

    @POST
    @Path("{id}/monitorated_classes")
    @Consumes(CONTENT_TYPE_APPLICATION_JSON)
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response insertTeacherMonitoratedClass(@PathParam("id") int teacherId) {
        return Response.ok("").build();
    }

    @GET
    @Path("{id}/monitorated_classes/students")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getTeacherMonitoratedStudents(@PathParam("id") int teacherId) {
        return teacherController.getTeacherMonitoratedStudents(teacherId);
    }

    @GET
    @Path("{id1}/monitorated_classes/{id2}/students")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getTeacherMonitoratedClassStudents(@PathParam("id1") int teacherId,
                                                       @PathParam("id2") int classId) {
        return teacherController.getTeacherMonitoratedClassStudents(teacherId, classId);
    }

    @POST
    @Path("{id1}/monitorated_classes/{id2}/students")
    @Consumes(CONTENT_TYPE_APPLICATION_JSON)
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response insertStudentInTeacherMonitoratedClass(@PathParam("id1") int teacherId,
                                                           @PathParam("id2") int classId) {
        return Response.ok("").build();
    }

    @GET
    @Path("{id1}/monitorated_classes/{id2}")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getTeacherMonitoratedClass(@PathParam("id1") int teacherId, @PathParam("id2") int classId) {
        return teacherController.getTeacherMonitoratedClass(teacherId, classId);
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
        return teacherController.getTeacherQuestion(teacherId, questionId);
    }

    @GET
    @Path("{id}/questions/true_or_false")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getTeacherTrueOrFalseQuestions(@PathParam("id") int teacherId) {
        return teacherController.getTeacherTrueOrFalseQuestions(teacherId);
    }

    @POST
    @Path("{id}/questions/true_or_false")
    @Consumes(CONTENT_TYPE_APPLICATION_JSON)
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response insertTeacherTrueOrFalseQuestion(@PathParam("id") long teacherId) {
        return Response.ok("").build();
    }

    @GET
    @Path("{id}/questions/multiple_choice")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getTeacherMultipleChoiceQuestions(@PathParam("id") int teacherId) {
        return teacherController.getTeacherMultipleChoiceQuestions(teacherId);
    }

    @POST
    @Path("{id}/questions/multiple_choice")
    @Consumes(CONTENT_TYPE_APPLICATION_JSON)
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response insertTeacherMultipleChoiceQuestion(@PathParam("id") long teacherId) {
        return Response.ok("").build();
    }

    @GET
    @Path("{id}/quiz_tests")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getTeacherQuizTests(@PathParam("id") int teacherId) {
        return teacherController.getTeacherQuizTests(teacherId);
    }

    @GET
    @Path("{id1}/quiz_tests/{id2}")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getTeacherQuizTest(@PathParam("id1") int teacherId, @PathParam("id2") int quizTestId) {
        return teacherController.getTeacherQuizTest(teacherId, quizTestId);
    }
}
