package src.controllers;

import src.dao.OrganizationDao;
import models.*;
import src.utils.EntityManagerUtil;
import src.utils.WSRN;
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
        WSRN.Response wResponse = new WSRN.Response();

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
        WSRN.Response wResponse = new WSRN.Response();

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

        wResponse.setResult(o);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getOrganizationTeachers(int id) {
        WSRN.Response wResponse = new WSRN.Response();

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
        WSRN.Response wResponse = new WSRN.Response();

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
        WSRN.Response wResponse = new WSRN.Response();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        Student s = oDao.queryStudent(organizationId, studentId);

        s.setMyClasses(null);
        s.setMyResolutions(null);
        s.setStudentOrganization(null);
        s.setLogin(null);

        wResponse.setResult(s);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getOrganizationClasses(int organizationId) {
        WSRN.Response wResponse = new WSRN.Response();

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
        WSRN.Response wResponse = new WSRN.Response();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        OrganizationClass oc = oDao.queryClass(organizationId, classId);

        oc.setCreator(null);
        oc.setClassStudents(null);
        oc.setMonitors(null);

        wResponse.setResult(oc);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getOrganizationClassStudents(int organizationId, int classId) {
        WSRN.Response wResponse = new WSRN.Response();

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
