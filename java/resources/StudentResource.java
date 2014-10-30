package resources;

import controllers.StudentController;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/*
GetStudentResolutions, PostStudentResolution: /students/resolutions
GetStudentResolution: /students/resolutions/{id}
 */

@Path("students")
public class StudentResource extends AbstractResource {
    StudentController studentController = new StudentController();

    @GET
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getAllStudents() {
        return studentController.getAllStudents();
    }

    @POST
    @Consumes(CONTENT_TYPE_APPLICATION_JSON)
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response insertStudent() {
        return Response.ok("").build();
    }

    @GET
    @Path("{id}")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getStudent(@PathParam("id") int studentId) {
        return studentController.getStudent(studentId);
    }

    @GET
    @Path("{id}/resolutions")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getStudentResolutions(@PathParam("id") int studentId) {
        return studentController.getStudentResolutions(studentId);
    }

    @POST
    @Path("{id}/resolutions")
    @Consumes(CONTENT_TYPE_APPLICATION_JSON)
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response insertStudentResolution(@PathParam("id") int resolutionId) {
        return Response.ok("").build();
    }

    @GET
    @Path("{id1}/resolutions/{id2}")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getStudentResolution(@PathParam("id1") int studentId,
                                         @PathParam("id2") int resolutionId) {
        return studentController.getStudentResolution(studentId,resolutionId);
    }
}
