package src.resources;

import src.controllers.StudentController;
import src.dao.StudentDao;
import src.models.Resolution;
import src.models.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import src.utils.EntityManagerUtil;

import java.util.List;

import static org.junit.Assert.*;

public class StudentTest {
    StudentController sc;
    StudentDao dao;
    boolean idempotent = true;

    @Before
    public void setUp() throws Exception {
        sc = new StudentController();
        dao = new StudentDao();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetAllStudents() throws Exception {
        try {
            sc.getAllStudents();
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<Student> students = dao.queryStudents();

        //Testando Lazy Binding
        for (Student student : students) {
            student.getBirthday();
        }

        dao.get().closeConnection();
    }

    @Test
    public void testInsertStudent() throws Exception {
        if(idempotent) return;
    }

    @Test
    public void testGetStudent() throws Exception {
        try {
            sc.getStudent(1);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        try {
            dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
            Student r = dao.queryStudent(1);
            r.getCountry();
            dao.get().closeConnection();
        } catch(Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testGetStudentResolutions() throws Exception {
        try {
            sc.getAllStudents();
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<Resolution> resolutions = dao.queryResolutions(1);

        //Testando Lazy Binding
        for (Resolution resolution : resolutions) {
            resolution.getTotalCorrectAnswers();
        }

        dao.get().closeConnection();
    }

    @Test
    public void testInsertStudentResolution() throws Exception {
        if(idempotent) return;
    }

    @Test
    public void testGetStudentResolution() throws Exception {
        try {
            sc.getStudentResolution(3,10);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        try {
            dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
            Resolution r = dao.queryResolution(3,10);
            r.getTotalCorrectAnswers();
            dao.get().closeConnection();
        } catch(Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}