package database;

import controllers.TeacherController;
import models.Organization;
import models.Teacher;
import models.utils.Sex;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by rafaganabreu on 01/10/14.
 */
public class TeacherTest {

    @Test
    public void shouldInsertValuesOnTeacherTable() {

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

        Set<Organization> orgs = new HashSet<>();
        orgs.add(new Organization());
        orgs.add(new Organization());
        orgs.add(new Organization());
        orgs.add(new Organization());
        orgs.add(new Organization());
        t.setWorkingOrganizations(orgs);

        TeacherController tc = new TeacherController();

        //tc.add(new Organization());
        tc.add(t);
    }
}
