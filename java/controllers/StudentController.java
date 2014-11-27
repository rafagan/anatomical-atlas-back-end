package controllers;

import dao.StudentDao;
import models.Organization;
import models.QuizTest;
import models.Resolution;
import models.Student;
import utils.EntityManagerUtil;
import utils.WSResponseFactory;

import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by rafaganabreu on 23/10/14.
 */
public class StudentController extends AbstractController {
    private StudentDao sDao;

    public StudentController() {
        dao = sDao = new StudentDao();
    }

    public Response getAllStudents() {
        WSResponseFactory.WSResponse wResponse;
        wResponse = WSResponseFactory.normalListResponse();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<Student> students = sDao.queryStudents();

        for (Student s : students) {
            s.setLogin(null);
            s.setMyResolutions(null);
            s.setMyClasses(null);

            Organization org = s.getStudentOrganization();

            if(org == null) continue;

            org.setTeachers(null);
            org.setOwner(null);
            org.setOwnerOfClasses(null);
            org.setStudents(null);
        }

        wResponse.setResult(students);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getStudent(int studentId) {
        WSResponseFactory.WSResponse wResponse;

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        Student s = sDao.queryStudent(studentId);

        s.setLogin(null);
        s.setMyResolutions(null);
        s.setMyClasses(null);

        Organization org = s.getStudentOrganization();

        org.setTeachers(null);
        org.setOwner(null);
        org.setOwnerOfClasses(null);
        org.setStudents(null);

        wResponse = WSResponseFactory.normalSingleResponse(s);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getStudentResolutions(int studentId) {
        WSResponseFactory.WSResponse wResponse;
        wResponse = WSResponseFactory.normalListResponse();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<Resolution> resolutions = sDao.queryResolutions(studentId);

        for(Resolution rs : resolutions) {
            rs.setOwner(null);
            QuizTest qt = rs.getRelatedQuiz();

            qt.setQuestions(null);
            qt.setAuthor(null);
            qt.setResolutions(null);
        }

        wResponse.setResult(resolutions);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getStudentResolution(int studentId, int resolutionId) {
        WSResponseFactory.WSResponse wResponse;

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        Resolution rs = sDao.queryResolution(studentId,resolutionId);

        rs.setOwner(null);
        QuizTest qt = rs.getRelatedQuiz();

        qt.setQuestions(null);
        qt.setAuthor(null);
        qt.setResolutions(null);

        wResponse = WSResponseFactory.normalSingleResponse(rs);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }
}
