package resources;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/*
GetStudentResolutions, PostStudentResolution: /students/resolutions
GetStudentResolution: /students/resolutions/{id}
 */

@Path("students")
public class StudentResource extends AbstractResource {
    @GET
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getAllStudens() {
        return Response.ok("").build();
    }

    @POST
    @Consumes(CONTENT_TYPE_APPLICATION_JSON)
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response insertStudent(/*FixedPinpoint fixedPinpoint,*/) {
        return Response.ok("").build();
    }

    @GET
    @Path("{id}")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getStudent(@PathParam("id") long studentId) {
        return Response.ok("").build();
    }

    @GET
    @Path("{id}/resolutions")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getStudentResolutions(@PathParam("id") long studentId) {
        return Response.ok("").build();
    }

    @POST
    @Path("{id}/resolutions")
    @Consumes(CONTENT_TYPE_APPLICATION_JSON)
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response insertStudentResolution(@PathParam("id") long resolutionId /*FixedPinpoint fixedPinpoint,*/) {
        return Response.ok("").build();
    }

    @GET
    @Path("{id1}/resolutions/{id2}")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getStudentResolution(@PathParam("id1") long studentId,
                                         @PathParam("id2") long resolutionId) {
        return Response.ok("").build();
    }
}
