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

        for(Organization o : organizations) {
            Teacher to = o.getOwner();

            to.setWorkingOrganizations(null);
            to.setOwnerOfOrganizations(null);
            to.setOwnerOfClasses(null);
            to.setMonitoratedClasses(null);
            to.setMyQuizTests(null);
            to.setMyQuestions(null);
            to.setLogin(null);

            for(Student s : o.getStudents()) {
                s.setMyClasses(null);
                s.setMyResolutions(null);
                s.setStudentOrganization(null);
                s.setLogin(null);
            }

            for(Teacher t : o.getTeachers()) {
                t.setWorkingOrganizations(null);
                t.setOwnerOfOrganizations(null);
                t.setOwnerOfClasses(null);
                t.setMonitoratedClasses(null);
                t.setMyQuizTests(null);
                t.setMyQuestions(null);
                t.setLogin(null);
            }

            for(OrganizationClass oc : o.getOwnerOfClasses()) {
                oc.setCreator(null);
                oc.setClassStudents(null);
                oc.setMonitors(null);
            }
        }

        wResponse.setResult(organizations);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getOrganization(int id) {
        WSResponseFactory.WSResponse wResponse;

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        Organization o = oDao.queryOrganization(id);

        Teacher to = o.getOwner();

        to.setWorkingOrganizations(null);
        to.setOwnerOfOrganizations(null);
        to.setOwnerOfClasses(null);
        to.setMonitoratedClasses(null);
        to.setMyQuizTests(null);
        to.setMyQuestions(null);
        to.setLogin(null);

        for(Student s : o.getStudents()) {
            s.setMyClasses(null);
            s.setMyResolutions(null);
            s.setStudentOrganization(null);
            s.setLogin(null);
        }

        for(Teacher t : o.getTeachers()) {
            t.setWorkingOrganizations(null);
            t.setOwnerOfOrganizations(null);
            t.setOwnerOfClasses(null);
            t.setMonitoratedClasses(null);
            t.setMyQuizTests(null);
            t.setMyQuestions(null);
            t.setLogin(null);
        }

        for(OrganizationClass oc : o.getOwnerOfClasses()) {
            oc.setCreator(null);
            oc.setClassStudents(null);
            oc.setMonitors(null);
        }

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

        for(Teacher t : teachers) {
            t.setWorkingOrganizations(null);
            t.setOwnerOfOrganizations(null);
            t.setOwnerOfClasses(null);
            t.setMonitoratedClasses(null);
            t.setMyQuizTests(null);
            t.setMyQuestions(null);
            t.setLogin(null);
        }

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

        for(Student s : students) {
            s.setMyClasses(null);
            s.setMyResolutions(null);
            s.setStudentOrganization(null);
            s.setLogin(null);
        }

        wResponse.setResult(students);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getOrganizationStudent(int organizationId, int studentId) {
        WSResponseFactory.WSResponse wResponse;

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        Student s = oDao.queryStudent(organizationId, studentId);

        s.setMyClasses(null);
        s.setMyResolutions(null);
        s.setStudentOrganization(null);
        s.setLogin(null);

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

        for(OrganizationClass oc : classes) {
            oc.setCreator(null);
            oc.setClassStudents(null);
            oc.setMonitors(null);
        }

        wResponse.setResult(classes);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getOrganizationClass(int organizationId, int classId) {
        WSResponseFactory.WSResponse wResponse;

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        OrganizationClass oc = oDao.queryClass(organizationId, classId);

        oc.setCreator(null);
        oc.setClassStudents(null);
        oc.setMonitors(null);

        wResponse = WSResponseFactory.normalSingleResponse(oc);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getOrganizationClassStudents(int organizationId, int classId) {
        WSResponseFactory.WSResponse wResponse;
        wResponse = WSResponseFactory.normalListResponse();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<Student> students = oDao.queryStudentsInOrganizationClass(organizationId, classId);

        for(Student s : students) {
            s.setMyClasses(null);
            s.setMyResolutions(null);
            s.setStudentOrganization(null);
            s.setLogin(null);
        }

        wResponse.setResult(students);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }
}
