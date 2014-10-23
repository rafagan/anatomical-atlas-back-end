package resources;

import controllers.TeacherController;
import models.Organization;
import models.Teacher;
import models.utils.Sex;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class TeacherTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetAllTeachers() throws Exception {

    }

    @Test
    public void testInsertTeacher() throws Exception {

        Teacher t = new Teacher();

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            t.setBirthday(new Date(df.parse("20/01/1993").getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
            Assert.fail();
        }

        t.setCountry("Brasil");
        t.setName("Ráfagan Sebástian de Abreu");
        t.setResume("Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum formas humanitatis per seacula quarta decima et quinta decima. Eodem modo typi, qui nunc nobis videntur parum clari, fiant sollemnes in futurum.");
        t.setSex(Sex.MALE);
        t.setScholarity("Graduated");
        //t.setPhoto();

        Organization o1 = new Organization();
        o1.setName("PUCPR");
        o1.setOwner(t);
        Organization o2 = new Organization();
        o2.setName("UP");
        o2.setOwner(t);

        Set<Organization> orgs = new HashSet<>();
        orgs.add(o1);
        orgs.add(o2);
        t.setWorkingOrganizations(orgs);

        TeacherController tc = new TeacherController();
        tc.add(t);
    }

    @Test
    public void testGetTeacher() throws Exception {

    }

    @Test
    public void testGetTeacherOrganizations() throws Exception {

    }

    @Test
    public void testInsertOrganization() throws Exception {

    }

    @Test
    public void testGetTeacherClasses() throws Exception {

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