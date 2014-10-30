package controllers;

import dao.StudentDao;
import models.Resolution;
import models.Student;
import utils.EntityManagerUtil;
import utils.WebserviceResponseFactory;

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
        WebserviceResponseFactory.WebserviceResponse wResponse;
        wResponse = WebserviceResponseFactory.normalListResponse();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<Student> students = sDao.queryStudents();

        wResponse.setResult(students);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getStudent(int studentId) {
        WebserviceResponseFactory.WebserviceResponse wResponse;

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        Student student = sDao.queryStudent(studentId);

        wResponse = WebserviceResponseFactory.normalSingleResponse(student);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getStudentResolutions(int studentId) {
        WebserviceResponseFactory.WebserviceResponse wResponse;
        wResponse = WebserviceResponseFactory.normalListResponse();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<Resolution> resolutions = sDao.queryResolutions(studentId);

        wResponse.setResult(resolutions);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getStudentResolution(int studentId, int resolutionId) {
        WebserviceResponseFactory.WebserviceResponse wResponse;

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        Resolution resolution = sDao.queryResolution(studentId,resolutionId);

        wResponse = WebserviceResponseFactory.normalSingleResponse(resolution);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }
}
