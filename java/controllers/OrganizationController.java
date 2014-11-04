package controllers;

import dao.OrganizationDao;
import models.*;
import utils.EntityManagerUtil;
import utils.WSResponseFactory;

import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by rafaganabreu on 23/10/14.
 */
public class OrganizationController extends AbstractController {
    OrganizationDao oDao;

    public OrganizationController() {
        dao = oDao = new OrganizationDao();
    }

    public Response getAllOrganizations() {
        WSResponseFactory.WSResponse wResponse;
        wResponse = WSResponseFactory.normalListResponse();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<Organization> organizations = oDao.queryOrganizations();

        wResponse.setResult(organizations);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getOrganization(int id) {
        WSResponseFactory.WSResponse wResponse;

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        Organization o = oDao.queryOrganization(id);

        wResponse = WSResponseFactory.normalSingleResponse(o);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getOrganizationTeachers(int id) {
        WSResponseFactory.WSResponse wResponse;
        wResponse = WSResponseFactory.normalListResponse();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<Teacher> teachers = oDao.queryTeachers(id);

        wResponse.setResult(teachers);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getOrganizationStudents(int id) {
        WSResponseFactory.WSResponse wResponse;
        wResponse = WSResponseFactory.normalListResponse();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<Student> students = oDao.queryStudents(id);

        wResponse.setResult(students);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getOrganizationStudent(int organizationId, int studentId) {
        WSResponseFactory.WSResponse wResponse;

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        Student s = oDao.queryStudent(organizationId, studentId);

        wResponse = WSResponseFactory.normalSingleResponse(s);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getOrganizationClasses(int organizationId) {
        WSResponseFactory.WSResponse wResponse;
        wResponse = WSResponseFactory.normalListResponse();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<OrganizationClass> classes = oDao.queryClasses(organizationId);

        wResponse.setResult(classes);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getOrganizationClass(int organizationId, int classId) {
        WSResponseFactory.WSResponse wResponse;

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        Clazz c = oDao.queryClass(organizationId, classId);

        wResponse = WSResponseFactory.normalSingleResponse(c);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getOrganizationClassStudents(int organizationId, int classId) {
        WSResponseFactory.WSResponse wResponse;
        wResponse = WSResponseFactory.normalListResponse();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<Student> students = oDao.queryStudentsInOrganizationClass(organizationId, classId);

        wResponse.setResult(students);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }
}
