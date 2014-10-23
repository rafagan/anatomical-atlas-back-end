package controllers;

import dao.TeacherDao;
import models.Teacher;
import utils.EntityManagerUtil;
import utils.WebserviceResponseFactory;

import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by rafaganabreu on 01/10/14.
 */
public class TeacherController extends AbstractController {
    private TeacherDao tDao;

    public TeacherController() {
        dao = tDao = new TeacherDao();
    }

    public Response getAllTeachers() {
        WebserviceResponseFactory.WebserviceResponse wResponse;
        wResponse = WebserviceResponseFactory.normalListResponse();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<Teacher> teachers = tDao.queryTeachers();

        wResponse.setResult(teachers);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getTeacher(int id) {
        WebserviceResponseFactory.WebserviceResponse wResponse;

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        Teacher teacher = tDao.queryTeacher(id);

        wResponse = WebserviceResponseFactory.normalSingleResponse(teacher);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getTeacherOrganizations(int teacherId) {
        return Response.ok("").build();
    }

    public Response getTeacherClasses(int teacherId) {
        return Response.ok("").build();
    }

    public Response getTeacherStudents(int teacherId) {
        return Response.ok("").build();
    }

    public Response getTeacherClassStudents(int teacherId, int classId) {
        return Response.ok("").build();
    }

    public Response getTeacherClass(int teacherId, int classId) {
        return Response.ok("").build();
    }

    public Response getTeacherQuestions(int teacherId) {
        return Response.ok("").build();
    }

    public Response getTeacherQuestion(int teacherId, int questionId) {
        return Response.ok("").build();
    }

    public Response getTeacherTrueOrFalseQuestions(int teacherId) {
        return Response.ok("").build();
    }

    public Response getTeacherMultipleChoiceQuestions(int teacherId) {
        return Response.ok("").build();
    }
}
