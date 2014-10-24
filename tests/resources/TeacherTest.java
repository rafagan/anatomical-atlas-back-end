package resources;

import controllers.TeacherController;
import dao.TeacherDao;
import models.Clazz;
import models.Organization;
import models.Teacher;
import models.utils.Sex;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.EntityManagerUtil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.Assert.*;

public class TeacherTest {
    TeacherController tc;
    TeacherDao dao;
    boolean idempotent = true;

    @Before
    public void setUp() throws Exception {
        tc = new TeacherController();
        dao = new TeacherDao();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetAllTeachers() throws Exception {
        try {
            tc.getAllTeachers();
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<Teacher> teachers = dao.queryTeachers();

        if(teachers.size() == 0)
            fail("Não encontrou nenhum Teacher no banco");

        //Testando Lazy Binding
        for (Teacher teacher : teachers) {
            teacher.getBirthday();
        }

        dao.get().closeConnection();
    }

    @Test
    public void testInsertTeacher() throws Exception {
        if(idempotent)
            return;

        Teacher t = new Teacher();

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            t.setBirthday(new Date(df.parse("20/01/1993").getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
            fail();
        }

        try {
            t.setCountry("Brasil");
            t.setName("Ráfagan Sebástian de Abreu");
            t.setResume("Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum formas humanitatis per seacula quarta decima et quinta decima. Eodem modo typi, qui nunc nobis videntur parum clari, fiant sollemnes in futurum.");
            t.setSex(Sex.MALE);
            t.setScholarity("Graduated");

            String path = Paths.get("").toAbsolutePath().toString() + "/resources/img/Foto.jpg";
            BufferedImage image = ImageIO.read(new File(path));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", baos);
            baos.flush();
            byte[] imageInByte = baos.toByteArray();
            baos.close();
            t.setPhoto(imageInByte);

//            Organization o1 = new Organization();
//            o1.setName("PUCPR");
//            o1.setOwner(t);
//            Organization o2 = new Organization();
//            o2.setName("UP");
//            o2.setOwner(t);
//
//            Set<Organization> orgs = new HashSet<>();
//            orgs.add(o1);
//            orgs.add(o2);
//            t.setWorkingOrganizations(orgs);

            tc.add(t);
        } catch(Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testGetTeacher() throws Exception {
        try {
            tc.getTeacher(1);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        try {
            dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
            Teacher t = dao.queryTeacher(1);
            t.getCountry();
            dao.get().closeConnection();
        } catch(Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testGetTeacherOrganizations() throws Exception {
        try {
            tc.getTeacherOrganizations(1);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        try {
            dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
            List<Organization> orgs = dao.queryTeacherOrganizations(2);

            for(Organization org : orgs)
                org.getCountry();

            dao.get().closeConnection();
        } catch(Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testInsertOrganization() throws Exception {

    }

    @Test
    public void testGetTeacherClasses() throws Exception {
        try {
            tc.getTeacherMonitoratedClasses(1);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        try {
            dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
            List<Clazz> classes = dao.queryTeacherMonitoratedClasses(1);

            for(Clazz c : classes)
                c.getName();

            dao.get().closeConnection();
        } catch(Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testInsertTeacherClass() throws Exception {

    }

    @Test
    public void testGetTeacherStudents() throws Exception {

    }

    @Test
    public void testGetTeacherClassStudents() throws Exception {

    }

    @Test
    public void testInsertStudentInTeacherClass() throws Exception {

    }

    @Test
    public void testGetTeacherClass() throws Exception {

    }

    @Test
    public void testGetTeacherQuestions() throws Exception {

    }

    @Test
    public void testGetTeacherQuestion() throws Exception {

    }

    @Test
    public void testGetTeacherTrueOrFalseQuestions() throws Exception {

    }

    @Test
    public void testInsertTeacherTrueOrFalseQuestion() throws Exception {

    }

    @Test
    public void testGetTeacherMultipleChoiceQuestions() throws Exception {

    }

    @Test
    public void testInsertTeacherMultipleChoiceQuestion() throws Exception {

    }
}