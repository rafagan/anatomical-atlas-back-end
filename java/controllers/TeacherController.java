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
}
