package controllers;


import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("organizations")
public class Organization {
    private static final String CONTENT_TYPE_APPLICATION_JSON = MediaType.APPLICATION_JSON + ";charset=utf-8";

    @Context
    HttpServletRequest request;

    @GET
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getAllOrganizations() {
        return Response.ok("").build();
    }

    @GET
    @Path("{id}")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getOrganization(@PathParam("id") long organizationId) {
        return Response.ok("").build();
    }

    @GET
    @Path("{id}/teachers")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getOrganizationTeachers(@PathParam("id") long organizationId) {
        return Response.ok("").build();
    }

    //Add new teacher to organization
    @POST
    @Path("{id}/teachers")
    @Consumes(CONTENT_TYPE_APPLICATION_JSON)
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response insertTeacherInOrganization(@PathParam("id") long organizationId /*FixedPinpoint fixedPinpoint,*/) {
        return Response.ok("").build();
    }

    @GET
    @Path("{id}/students")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getOrganizationStudents(@PathParam("id") long organizationId) {
        return Response.ok("").build();
    }

    @POST
    @Path("{id}/students")
    @Consumes(CONTENT_TYPE_APPLICATION_JSON)
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response insertStudentInOrganization(@PathParam("id") long organizationId /*FixedPinpoint fixedPinpoint,*/) {
        return Response.ok("").build();
    }

    @GET
    @Path("{id1}/students/{id2}")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getOrganizationStudent(@PathParam("id1") long organizationId,
                                           @PathParam("id2") long studentId) {
        return Response.ok("").build();
    }

    @GET
    @Path("{id}/classes")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getOrganizationClasses(@PathParam("id") long organizationId) {
        return Response.ok("").build();
    }

    @POST
    @Path("{id}/classes")
    @Consumes(CONTENT_TYPE_APPLICATION_JSON)
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response insertOrganizationClass(@PathParam("id") long classId /*FixedPinpoint fixedPinpoint,*/) {
        return Response.ok("").build();
    }

    @GET
    @Path("{id1}/classes/{id2}")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getOrganizationClass(@PathParam("id1") long organizationId,@PathParam("id2") long classId) {
        return Response.ok("").build();
    }

    @GET
    @Path("{id1}/classes/{id2}/students")
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response getOrganizationClassStudents(@PathParam("id1") long organizationId,
                                                 @PathParam("id2") long classId) {
        return Response.ok("").build();
    }

    @POST
    @Path("{id1}/classes/{id2}/students")
    @Consumes(CONTENT_TYPE_APPLICATION_JSON)
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public Response insertStudentInOrganizationClass(@PathParam("id1") long organizationId,
                                                     @PathParam("id2") long classId /*FixedPinpoint fixedPinpoint,*/) {
        return Response.ok("").build();
    }
}
