package controllers;

import dao.TeacherDao;
import models.*;
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

    public Response getTeacherOrganizations(int id) {
        WebserviceResponseFactory.WebserviceResponse wResponse;
        wResponse = WebserviceResponseFactory.normalListResponse();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<Organization> organizations = tDao.queryOrganizations(id);

        wResponse.setResult(organizations);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getTeacherMonitoratedClasses(int id) {
        WebserviceResponseFactory.WebserviceResponse wResponse;
        wResponse = WebserviceResponseFactory.normalListResponse();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<Clazz> classes = tDao.queryMonitoratedClasses(id);

        wResponse.setResult(classes);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getTeacherMonitoratedStudents(int id) {
        WebserviceResponseFactory.WebserviceResponse wResponse;
        wResponse = WebserviceResponseFactory.normalListResponse();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<Student> students = tDao.queryMonitoratedStudents(id);

        wResponse.setResult(students);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getTeacherMonitoratedClassStudents(int teacherId, int classId) {
        WebserviceResponseFactory.WebserviceResponse wResponse;
        wResponse = WebserviceResponseFactory.normalListResponse();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<Student> students = tDao.queryMonitoratedClassStudents(teacherId, classId);

        wResponse.setResult(students);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getTeacherMonitoratedClass(int teacherId, int classId) {
        WebserviceResponseFactory.WebserviceResponse wResponse;

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        Clazz c = tDao.queryMonitoratedClass(teacherId, classId);

        wResponse = WebserviceResponseFactory.normalSingleResponse(c);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getTeacherQuestions(int teacherId) {
        WebserviceResponseFactory.WebserviceResponse wResponse;
        wResponse = WebserviceResponseFactory.normalListResponse();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<Question> questions = tDao.queryQuestions(teacherId);

        wResponse.setResult(questions);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getTeacherQuestion(int teacherId, int questionId) {
        WebserviceResponseFactory.WebserviceResponse wResponse;

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        Question qt = tDao.queryQuestion(teacherId, questionId);

        wResponse = WebserviceResponseFactory.normalSingleResponse(qt);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getTeacherTrueOrFalseQuestions(int teacherId) {
        WebserviceResponseFactory.WebserviceResponse wResponse;
        wResponse = WebserviceResponseFactory.normalListResponse();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<TrueOrFalse> questions = tDao.queryTFQuestions(teacherId);

        wResponse.setResult(questions);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getTeacherMultipleChoiceQuestions(int teacherId) {
        WebserviceResponseFactory.WebserviceResponse wResponse;
        wResponse = WebserviceResponseFactory.normalListResponse();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<MultipleChoice> questions = tDao.queryMCQuestions(teacherId);

        wResponse.setResult(questions);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getTeacherOwnerClasses(int teacherId) {
        WebserviceResponseFactory.WebserviceResponse wResponse;
        wResponse = WebserviceResponseFactory.normalListResponse();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<TeacherClass> classes = tDao.queryOwnerClasses(teacherId);

        wResponse.setResult(classes);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getTeacherQuizTests(int teacherId) {
        WebserviceResponseFactory.WebserviceResponse wResponse;
        wResponse = WebserviceResponseFactory.normalListResponse();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<QuizTest> quizTests = tDao.queryQuizTests(teacherId);

        wResponse.setResult(quizTests);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getTeacherQuizTest(int teacherId, int quizTestId) {
        WebserviceResponseFactory.WebserviceResponse wResponse;

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        QuizTest qt = tDao.queryQuizTest(teacherId, quizTestId);

        wResponse = WebserviceResponseFactory.normalSingleResponse(qt);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }
}
