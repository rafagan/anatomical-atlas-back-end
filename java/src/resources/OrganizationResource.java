package src.resources;

import src.controllers.OrganizationController;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("v1/organizations")
public class OrganizationResource extends AbstractResource {
    OrganizationController controller = new OrganizationController();

    @GET
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getAllOrganizations() {
        return controller.getAllOrganizations();
    }

    @GET
    @Path("{id}")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getOrganization(@PathParam("id") int organizationId) {
        return controller.getOrganization(organizationId);
    }

    @GET
    @Path("{id}/teachers")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getOrganizationTeachers(@PathParam("id") int organizationId) {
        return controller.getOrganizationTeachers(organizationId);
    }

    @POST
    @Path("{id}/teachers")
    @Consumes(CONTENT_TYPE_APPLICATION_JSON)
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response insertTeacherInOrganization(@PathParam("id") int organizationId) {
        return Response.ok("").build();
    }

    @GET
    @Path("{id}/students")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getOrganizationStudents(@PathParam("id") int organizationId) {
        return controller.getOrganizationStudents(organizationId);
    }

    @POST
    @Path("{id}/students")
    @Consumes(CONTENT_TYPE_APPLICATION_JSON)
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response insertStudentInOrganization(@PathParam("id") int organizationId) {
        return Response.ok("").build();
    }

    @GET
    @Path("{id1}/students/{id2}")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getOrganizationStudent(@PathParam("id1") int organizationId,
                                           @PathParam("id2") int studentId) {
        return controller.getOrganizationStudent(organizationId,studentId);
    }

    @GET
    @Path("{id}/classes")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getOrganizationClasses(@PathParam("id") int organizationId) {
        return controller.getOrganizationClasses(organizationId);
    }

    @POST
    @Path("{id}/classes")
    @Consumes(CONTENT_TYPE_APPLICATION_JSON)
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response insertOrganizationClass(@PathParam("id") int classId) {
        return Response.ok("").build();
    }

    @GET
    @Path("{id1}/classes/{id2}")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getOrganizationClass(@PathParam("id1") int organizationId,@PathParam("id2") int classId) {
        return controller.getOrganizationClass(organizationId,classId);
    }

    @GET
    @Path("{id1}/classes/{id2}/students")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getOrganizationClassStudents(@PathParam("id1") int organizationId,
                                                 @PathParam("id2") int classId) {
        return controller.getOrganizationClassStudents(organizationId,classId);
    }

    @POST
    @Path("{id1}/classes/{id2}/students")
    @Consumes(CONTENT_TYPE_APPLICATION_JSON)
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response insertStudentInOrganizationClass(@PathParam("id1") int organizationId,
                                                     @PathParam("id2") int classId) {
        return Response.ok("").build();
    }
}
