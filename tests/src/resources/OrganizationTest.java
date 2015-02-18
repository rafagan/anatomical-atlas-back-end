package src.resources;

import src.controllers.OrganizationController;
import src.dao.OrganizationDao;
import src.models.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import src.utils.EntityManagerUtil;

import java.util.List;

import static org.junit.Assert.*;

public class OrganizationTest {
    OrganizationController oc;
    OrganizationDao od;

    @Before
    public void setUp() throws Exception {
        oc = new OrganizationController();
        od = new OrganizationDao();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetAllOrganizations() throws Exception {
        try {
            oc.getAllOrganizations();
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        od.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<Organization> organizations = od.queryOrganizations();

        //Testando Lazy Binding
        for (Organization organization : organizations) {
            organization.getCountry();
        }

        od.get().closeConnection();
    }

    @Test
    public void testGetOrganization() throws Exception {
        try {
            oc.getOrganization(1);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        try {
            od.get().startConnection(EntityManagerUtil.ATLAS_PU);
            Organization o = od.queryOrganization(2);
            o.getName();
            od.get().closeConnection();
        } catch(Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testGetOrganizationTeachers() throws Exception {
        try {
            oc.getOrganizationTeachers(2);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        od.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<Teacher> teachers = od.queryTeachers(1);

        //Testando Lazy Binding
        for (Teacher teacher : teachers) {
            teacher.getCountry();
        }

        od.get().closeConnection();
    }

    @Test
    public void testInsertTeacherInOrganization() throws Exception {

    }

    @Test
    public void testGetOrganizationStudents() throws Exception {
        try {
            oc.getOrganizationStudents(2);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        od.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<Student> students = od.queryStudents(1);

        //Testando Lazy Binding
        for (Student student : students) {
            student.getCountry();
        }

        od.get().closeConnection();
    }

    @Test
    public void testInsertStudentInOrganization() throws Exception {

    }

    @Test
    public void testGetOrganizationStudent() throws Exception {
        try {
            oc.getOrganizationStudent(1,1);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        try {
            od.get().startConnection(EntityManagerUtil.ATLAS_PU);
            Student s = od.queryStudent(1, 1);
            s.getName();
            od.get().closeConnection();
        } catch(Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testGetOrganizationClasses() throws Exception {
        try {
            oc.getOrganizationClasses(2);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        od.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<OrganizationClass> classes = od.queryClasses(1);

        //Testando Lazy Binding
        for (Clazz clazz : classes) {
            clazz.getName();
        }

        od.get().closeConnection();
    }

    @Test
    public void testInsertOrganizationClass() throws Exception {

    }

    @Test
    public void testGetOrganizationClass() throws Exception {
        try {
            oc.getOrganizationClass(1,1);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        try {
            od.get().startConnection(EntityManagerUtil.ATLAS_PU);
            Clazz c = od.queryClass(2, 2);
            c.getName();
            od.get().closeConnection();
        } catch(Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testGetOrganizationClassStudents() throws Exception {
        try {
            oc.getOrganizationClassStudents(1,1);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        od.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<Student> students = od.queryStudentsInOrganizationClass(1,1);

        //Testando Lazy Binding
        for (Student student : students) {
            student.getCountry();
        }

        od.get().closeConnection();
    }

    @Test
    public void testInsertStudentInOrganizationClass() throws Exception {

    }
}