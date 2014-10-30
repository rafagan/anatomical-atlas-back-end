package insert;

import com.sun.javaws.exceptions.InvalidArgumentException;
import models.Teacher;
import models.TeacherLogin;
import models.utils.Sex;
import utils.ConnectionDataBaseUtil;
import utils.DummyText;
import utils.UserAuthentication;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import static org.junit.Assert.fail;

/**
 * Created by rafaganabreu on 29/10/14.
 */
public class InsertTest {

    public void run() {
        insertBoneSets();
        insertBones();
        insertBoneParts();
        relateNeighbors();

        insertTeachers();
        insertOrganizations();

    }

    public void insertTeachers() {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        Teacher t1 = new Teacher();
        Teacher t2 = new Teacher();
        Teacher t3 = new Teacher();
        Teacher t4 = new Teacher();
        Teacher t5 = new Teacher();

        try {
            t1.setBirthday(createDate("01/01/1993",df));
            t2.setBirthday(createDate("02/02/2003",df));
            t3.setBirthday(createDate("01/03/2004",df));
            t4.setBirthday(createDate("20/09/1500",df));
            t5.setBirthday(createDate("07/07/1997",df));
        } catch (ParseException e) {
            e.printStackTrace();
            fail();
        }

        t1.setCountry("Brasil");
        t2.setCountry("Noruega");
        t3.setCountry("Finlândia");
        t4.setCountry("Austrália");
        t5.setCountry("Cuba");

        t1.setName("João da Silva");
        t2.setName("Maria dos Santos");
        t3.setName("Pedro Abreu");
        t4.setName("Carlos Lacerda");
        t5.setName("Amarildo Roberto Pinto");

        t1.setResume("Best teacher ever");
        t2.setResume("Ser ou não ser eis a questão");
        t3.setResume("Penso, logo existo");
        t4.setResume("Mais mole que pegar em minhoquinha");
        t5.setResume(DummyText.LOREM_IPSUM);

        t1.setScholarity("Mestrado");
        t2.setScholarity("Doutorado");
        t3.setScholarity("Pós doutorado");
        t4.setScholarity("Pós graduado");
        t5.setScholarity("Graduado");

        t1.setSex(Sex.MALE);
        t2.setSex(Sex.FEMALE);
        t3.setSex(Sex.MALE);
        t4.setSex(Sex.FEMALE);
        t5.setSex(Sex.MALE);

        t1.setPhoto(loadImage("Foto","jpg"));
        t2.setPhoto(loadImage("LennaSnow", "jpg"));
        t3.setPhoto(loadImage("Lenna", "jpg"));
        t4.setPhoto(loadImage("Itachi", "jpg"));
        t5.setPhoto(loadImage("Workstation", "jpg"));

        TeacherLogin l1 = new TeacherLogin();
        TeacherLogin l2 = new TeacherLogin();
        TeacherLogin l3 = new TeacherLogin();
        TeacherLogin l4 = new TeacherLogin();
        TeacherLogin l5 = new TeacherLogin();

        l1.setIdLogin(1000);
        l2.setIdLogin(1001);
        l3.setIdLogin(1002);
        l4.setIdLogin(1003);
        l5.setIdLogin(1004);

        try {
            Date currentDate = createDate(new java.util.Date().toString(), df);

            l1.setCreatedAt(currentDate);
            l2.setCreatedAt(currentDate);
            l3.setCreatedAt(currentDate);
            l4.setCreatedAt(currentDate);
            l5.setCreatedAt(currentDate);

            l1.setLastLoginAt(currentDate);
            l2.setLastLoginAt(currentDate);
            l3.setLastLoginAt(currentDate);
            l4.setLastLoginAt(currentDate);
            l5.setLastLoginAt(currentDate);
        } catch (ParseException e) {
            e.printStackTrace();
            fail();
        }

        try {
            l1.setEmail(validateEmail("joao@me.com"));
            l2.setEmail(validateEmail("tiosheila@gmail.com"));
            l3.setEmail(validateEmail("jose.messias@outlook.com.br"));
            l4.setEmail(validateEmail("amarildo@abreu.com.br"));
            l5.setEmail(validateEmail("celio1959595@suquinho.com"));
        } catch (InvalidArgumentException e) {
            e.printStackTrace();
        }

        t1.setLogin(l1);
        t2.setLogin(l2);
        t3.setLogin(l3);
        t4.setLogin(l4);
        t5.setLogin(l5);
    }

    public void insertOrganizations() {

    }

    public void relateNeighbors() {

    }

    public void insertBoneParts() {
        executeSQLFile("InsertBoneParts","AnatomicalAtlas");
    }

    public void insertBoneSets() {
        executeSQLFile("InsertBoneSets","AnatomicalAtlas");
    }

    public void insertBones() {
        executeSQLFile("InsertBones","AnatomicalAtlas");
    }

    public void executeSQLFile(String fileName, String dbName) {
        Statement st = null;

        try {
            String path = System.getProperty("user.dir") + "/resources/" + fileName + ".sql";
            InputStream is = new FileInputStream(path);

            Connection c = ConnectionDataBaseUtil.getConnection(dbName);

            Scanner s = new Scanner(is);
            s.useDelimiter("/\\*[\\s\\S]*?\\*/|--[^\\r\\n]*|;");

            st = c.createStatement();
            while (s.hasNext())
            {
                String line = s.next().trim();

                if (!line.isEmpty())
                    st.execute(line);
            }
        } catch (FileNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public byte[] loadImage(String imageName, String format) {
        byte[] imageInByte = null;

        try {
            String path = System.getProperty("user.dir") + "/resources/img/" + imageName + "." + format;
            BufferedImage image = ImageIO.read(new File(path));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, format, baos);
            baos.flush();
            imageInByte = baos.toByteArray();
            baos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return imageInByte;
    }

    public Date createDate(String date, SimpleDateFormat df) throws ParseException {
        return new Date(df.parse(date).getTime());
    }

    public String validateEmail(String email) throws InvalidArgumentException {
        if(!UserAuthentication.validateEmail(email))
            throw new InvalidArgumentException(new String[]{"Email inválido: " + email});

        return email;
    }
}
