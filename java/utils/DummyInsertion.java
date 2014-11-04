package utils;

import com.sun.javaws.exceptions.InvalidArgumentException;
import dao.*;
import models.*;
import models.utils.Sex;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.awt.image.BufferedImage;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Scanner;

import static org.junit.Assert.fail;

/**
 * Created by rafaganabreu on 29/10/14.
 */
public class DummyInsertion {

    public void run() {
        insertTeachers();
        insertOrganizations();

        insertBoneSets();
        insertBones();
        insertBoneParts();
        relateNeighbors();

        insertQuestions();
        insertQuizTests();
        insertStudents();
        insertClasses();
    }

    private void insertQuizTests() {
        QuizTestDao qtDao = new QuizTestDao();
        qtDao.get().startConnection(EntityManagerUtil.ATLAS_PU);

        QuizTest qt1 = new QuizTest();
        QuizTest qt2 = new QuizTest();
        QuizTest qt3 = new QuizTest();
        QuizTest qt4 = new QuizTest();

        //São de domínio público
        QuizTest qt5 = new QuizTest();
        QuizTest qt6 = new QuizTest();
        QuizTest qt7 = new QuizTest();
        QuizTest qt8 = new QuizTest();
        QuizTest qt9 = new QuizTest();
        QuizTest qt10 = new QuizTest();

        qt1.setDifficultLevel(200);
        qt2.setDifficultLevel(1);
        qt3.setDifficultLevel(190);
        qt4.setDifficultLevel(120);
        qt5.setDifficultLevel(100);
        qt6.setDifficultLevel(200);
        qt7.setDifficultLevel(1);
        qt8.setDifficultLevel(190);
        qt9.setDifficultLevel(120);
        qt10.setDifficultLevel(100);

        qt1.setMaxQuestions(10);
        qt2.setMaxQuestions(10);
        qt3.setMaxQuestions(10);
        qt4.setMaxQuestions(10);
        qt5.setMaxQuestions(10);
        qt6.setMaxQuestions(20);
        qt7.setMaxQuestions(20);
        qt8.setMaxQuestions(20);
        qt9.setMaxQuestions(30);
        qt10.setMaxQuestions(30);

        TeacherDao tDao = new TeacherDao();
        tDao.get().setEntityManager(qtDao.get().getEntityManager());
        
        qt1.setAuthor(tDao.queryTeacher(1));
        qt2.setAuthor(tDao.queryTeacher(1));
        qt3.setAuthor(tDao.queryTeacher(2));
        qt4.setAuthor(tDao.queryTeacher(2));
        qt5.setAuthor(tDao.queryTeacher(1));

        QuestionDao qDao = new QuestionDao();
        qDao.get().setEntityManager(qtDao.get().getEntityManager());
        for(int i = 1000;i<=1019;i++) {
            Question question = (Question) qDao.get().findObject(Question.class,i);
            qt1.addQuestion(question);
            qt2.addQuestion(question);
            qt3.addQuestion(question);
            qt6.addQuestion(question);
            qt7.addQuestion(question);
        }

        qtDao.get().insertObject(qt1);
        qtDao.get().insertObject(qt2);
        qtDao.get().insertObject(qt3);
        qtDao.get().insertObject(qt4);
        qtDao.get().insertObject(qt5);
        qtDao.get().insertObject(qt1);
        qtDao.get().insertObject(qt6);
        qtDao.get().insertObject(qt7);
        qtDao.get().insertObject(qt8);
        qtDao.get().insertObject(qt9);
        qtDao.get().insertObject(qt10);

        qtDao.get().closeConnection();
    }

    private void insertQuestions() {
        executeSQLFile("InsertQuestions","AnatomicalAtlas");

        QuestionDao qDao = new QuestionDao();
        BoneSetDao bsDao = new BoneSetDao();
        TeacherDao tDao = new TeacherDao();

        qDao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        bsDao.get().setEntityManager(qDao.get().getEntityManager());
        tDao.get().setEntityManager(qDao.get().getEntityManager());

        BoneSet b1 = bsDao.queryBoneSet(1);
        Teacher t1 = tDao.queryTeacher(3);

        for(int i = 1000;i<=1019;i++) {
            Question question = (Question) qDao.get().findObject(Question.class,i);
            question.setFigure(loadImage("Foto", "jpg"));
            question.addCategory(b1);

            t1.addQuestion(question);

            qDao.get().changeOrInsertObject(question);
        }

        qDao.get().closeConnection();
    }

    private void insertClasses() {
        AbstractDao dao = new AbstractDao();
        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);

        OrganizationClass oc1 = new OrganizationClass();
        OrganizationClass oc2 = new OrganizationClass();
        OrganizationClass oc3 = new OrganizationClass();
        OrganizationClass oc4 = new OrganizationClass();
        OrganizationClass oc5 = new OrganizationClass();
        
        TeacherClass tc1 = new TeacherClass();
        TeacherClass tc2 = new TeacherClass();
        TeacherClass tc3 = new TeacherClass();
        TeacherClass tc4 = new TeacherClass();
        TeacherClass tc5 = new TeacherClass();
        
        oc1.setName("Classe teste");
        oc2.setName("Nome da classe");
        oc3.setName("Minha classe");
        oc4.setName("My Organization class");
        oc5.setName("Hello World Class");
        tc1.setName("Welcome class");
        tc2.setName("Free Class");
        tc3.setName("Class for Premium Students");
        tc4.setName("Jesus Class");
        tc5.setName("Class");
        
        oc1.setClassSize(10);
        oc2.setClassSize(20);
        oc3.setClassSize(30);
        oc4.setClassSize(40);
        oc5.setClassSize(50);
        tc1.setClassSize(1);
        tc2.setClassSize(2);
        tc3.setClassSize(3);
        tc4.setClassSize(4);
        tc5.setClassSize(5);

        dao.get().insertObject(oc1);
        dao.get().insertObject(oc2);
        dao.get().insertObject(oc3);
        dao.get().insertObject(oc4);
        dao.get().insertObject(oc5);
        dao.get().insertObject(tc1);
        dao.get().insertObject(tc2);
        dao.get().insertObject(tc3);
        dao.get().insertObject(tc4);
        dao.get().insertObject(tc5);

        StudentDao sDao = new StudentDao();
        sDao.get().setEntityManager(dao.get().getEntityManager());
        oc1.addClassStudent(sDao.queryStudent(1));
        oc1.addClassStudent(sDao.queryStudent(2));
        oc1.addClassStudent(sDao.queryStudent(3));
        oc1.addClassStudent(sDao.queryStudent(4));
        oc1.addClassStudent(sDao.queryStudent(5));
        tc1.addClassStudent(sDao.queryStudent(1));
        tc1.addClassStudent(sDao.queryStudent(2));
        tc1.addClassStudent(sDao.queryStudent(3));
        tc1.addClassStudent(sDao.queryStudent(4));
        tc1.addClassStudent(sDao.queryStudent(5));

        OrganizationDao oDao = new OrganizationDao();
        oDao.get().setEntityManager(dao.get().getEntityManager());
        oc1.setCreator(oDao.queryOrganization(1));
        oc2.setCreator(oDao.queryOrganization(2));
        oc3.setCreator(oDao.queryOrganization(3));
        oc4.setCreator(oDao.queryOrganization(4));
        oc5.setCreator(oDao.queryOrganization(5));

        TeacherDao tDao = new TeacherDao();
        tDao.get().setEntityManager(dao.get().getEntityManager());
        Teacher t1 = tDao.queryTeacher(1);

        tc1.setCreator(t1);
        tc2.setCreator(tDao.queryTeacher(2));
        tc3.setCreator(tDao.queryTeacher(3));
        tc4.setCreator(tDao.queryTeacher(4));
        tc5.setCreator(tDao.queryTeacher(5));

        t1.addMonitoratedClasses(oc1);
        t1.addMonitoratedClasses(oc2);
        t1.addMonitoratedClasses(oc3);
        t1.addMonitoratedClasses(oc4);
        t1.addMonitoratedClasses(oc5);

        dao.get().changeOrInsertObject(oc1);
        dao.get().changeOrInsertObject(oc2);
        dao.get().changeOrInsertObject(oc3);
        dao.get().changeOrInsertObject(oc4);
        dao.get().changeOrInsertObject(oc5);
        dao.get().changeOrInsertObject(tc1);
        dao.get().changeOrInsertObject(tc2);
        dao.get().changeOrInsertObject(tc3);
        dao.get().changeOrInsertObject(tc4);
        dao.get().changeOrInsertObject(tc5);

        dao.get().closeConnection();
    }

    private void insertStudents() {
        AbstractDao dao = new AbstractDao();
        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();
        Student s4 = new Student();
        Student s5 = new Student();

        try {
            s1.setBirthday(createDate("01/01/1993", df));
            s2.setBirthday(createDate("02/02/2003", df));
            s3.setBirthday(createDate("01/03/2004", df));
            s4.setBirthday(createDate("20/09/1500", df));
            s5.setBirthday(createDate("07/07/1997", df));
        } catch (ParseException e) {
            e.printStackTrace();
            fail();
        }

        s1.setCountry("Brasil");
        s2.setCountry("Noruega");
        s3.setCountry("Finlândia");
        s4.setCountry("Austrália");
        s5.setCountry("Cuba");

        s1.setName("João da Silva");
        s2.setName("Maria dos Santos");
        s3.setName("Pedro Abreu");
        s4.setName("Carlos Lacerda");
        s5.setName("Amarildo Roberto Pinto");

        s1.setResume("Best student ever");
        s2.setResume("Ser ou não ser eis a questão");
        s3.setResume("Penso, logo existo");
        s4.setResume("Mais mole que pegar em minhoquinha");
        s5.setResume(DummyText.LOREM_IPSUM);

        s1.setScholarity("Mestrado");
        s2.setScholarity("Doutorado");
        s3.setScholarity("Pós doutorado");
        s4.setScholarity("Pós graduado");
        s5.setScholarity("Graduado");

        s1.setSex(Sex.MALE);
        s2.setSex(Sex.FEMALE);
        s3.setSex(Sex.MALE);
        s4.setSex(Sex.FEMALE);
        s5.setSex(Sex.MALE);

        s1.setPhoto(loadImage("Foto", "jpg"));
        s2.setPhoto(loadImage("LennaSnow", "jpg"));
        s3.setPhoto(loadImage("Lenna", "png"));
        s4.setPhoto(loadImage("Itachi", "jpg"));
        s5.setPhoto(loadImage("Workstation", "jpg"));

        s1.setGeneralKnowledge(0.0f);
        s2.setGeneralKnowledge(0.0f);
        s3.setGeneralKnowledge(0.0f);
        s4.setGeneralKnowledge(0.0f);
        s5.setGeneralKnowledge(0.0f);

        /* ---------------------------------------------- */

        StudentLogin l1 = new StudentLogin();
        StudentLogin l2 = new StudentLogin();
        StudentLogin l3 = new StudentLogin();
        StudentLogin l4 = new StudentLogin();
        StudentLogin l5 = new StudentLogin();

        try {
            Date currentDate = createDate(df.format(new java.util.Date()), df);
            Date currentDateTime = createDate(df2.format(new java.util.Date()), df2);

            l1.setCreatedAt(currentDate);
            l2.setCreatedAt(currentDate);
            l3.setCreatedAt(currentDate);
            l4.setCreatedAt(currentDate);
            l5.setCreatedAt(currentDate);

            l1.setLastLoginAt(currentDateTime);
            l2.setLastLoginAt(currentDateTime);
            l3.setLastLoginAt(currentDateTime);
            l4.setLastLoginAt(currentDateTime);
            l5.setLastLoginAt(currentDateTime);

            l1.setUpdatedAt(currentDate);
            l2.setUpdatedAt(currentDate);
            l3.setUpdatedAt(currentDate);
            l4.setUpdatedAt(currentDate);
            l5.setUpdatedAt(currentDate);
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

        setPassword("SenhaF0rte*", l1);
        setPassword("RODOLPHO123@", l2);
        setPassword("frutas123&", l3);
        setPassword("t0d1nh0*", l4);
        setPassword("B&PiD", l5);

        s1.setLogin(l1);
        s2.setLogin(l2);
        s3.setLogin(l3);
        s4.setLogin(l4);
        s5.setLogin(l5);

        dao.get().changeOrInsertObject(s1);
        dao.get().changeOrInsertObject(s2);
        dao.get().changeOrInsertObject(s3);
        dao.get().changeOrInsertObject(s4);
        dao.get().changeOrInsertObject(s5);

        dao.get().closeConnection();

        /* ---------------------------------------------- */

        OrganizationDao oDao = new OrganizationDao();
        StudentDao sDao = new StudentDao();
        oDao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        sDao.get().setEntityManager(oDao.get().getEntityManager());

        s1 = sDao.queryStudent(1);
        s2 = sDao.queryStudent(2);
        s3 = sDao.queryStudent(3);
        //s4 = sDao.queryStudent(4);
        //s5 = sDao.queryStudent(5);

        Organization o1 = oDao.queryOrganization(1);
        Organization o2 = oDao.queryOrganization(2);

        EntityTransaction tx = oDao.get().getEntityManager().getTransaction();
        try {
            tx.begin();
            EntityManager em = oDao.get().getEntityManager();

            s1.setStudentOrganization(o1);
            s2.setStudentOrganization(o1);
            s3.setStudentOrganization(o2);
            //s4 e s5 não possuirão organization de propósito

            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        }

//        oDao.get().changeOrInsertObject(s1);
//        oDao.get().changeOrInsertObject(s2);
//        oDao.get().changeOrInsertObject(s3);

        oDao.get().closeConnection();

        /* ---------------------------------------------- */

        QuizTestDao qtDao = new QuizTestDao();
        qtDao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        sDao.get().setEntityManager(qtDao.get().getEntityManager());
        for(int i=0; i<100; i++) {
            Resolution r = new Resolution();

            int id = Math.abs(new Random().nextInt() % 10) + 1;
            QuizTest qt = (QuizTest) qtDao.get().findObject(QuizTest.class,id);

            r.setTotalCorrectAnswers(qt.getMaxQuestions() - 1);
            r.setTotalWrongAnswers(1);
            r.setRelatedQuiz(qt);
            id = Math.abs(new Random().nextInt() % 5) + 1;

            try {
                r.setOwner(sDao.queryStudent(id));
            } catch(NullPointerException e) {
                e.printStackTrace();
            }

            qtDao.get().insertObject(r);
        }

        qtDao.get().closeConnection();
    }

    public void insertTeachers() {
        AbstractDao dao = new AbstractDao();
        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

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

        t1.setPhoto(loadImage("Foto", "jpg"));
        t2.setPhoto(loadImage("LennaSnow", "jpg"));
        t3.setPhoto(loadImage("Lenna", "png"));
        t4.setPhoto(loadImage("Itachi", "jpg"));
        t5.setPhoto(loadImage("Workstation", "jpg"));

        /* ---------------------------------------------- */

        TeacherLogin l1 = new TeacherLogin();
        TeacherLogin l2 = new TeacherLogin();
        TeacherLogin l3 = new TeacherLogin();
        TeacherLogin l4 = new TeacherLogin();
        TeacherLogin l5 = new TeacherLogin();

        try {
            Date currentDate = createDate(df.format(new java.util.Date()), df);
            Date currentDateTime = createDate(df2.format(new java.util.Date()), df2);

            l1.setCreatedAt(currentDate);
            l2.setCreatedAt(currentDate);
            l3.setCreatedAt(currentDate);
            l4.setCreatedAt(currentDate);
            l5.setCreatedAt(currentDate);

            l1.setLastLoginAt(currentDateTime);
            l2.setLastLoginAt(currentDateTime);
            l3.setLastLoginAt(currentDateTime);
            l4.setLastLoginAt(currentDateTime);
            l5.setLastLoginAt(currentDateTime);

            l1.setUpdatedAt(currentDate);
            l2.setUpdatedAt(currentDate);
            l3.setUpdatedAt(currentDate);
            l4.setUpdatedAt(currentDate);
            l5.setUpdatedAt(currentDate);
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

        setPassword("SenhaF0rte*",l1);
        setPassword("RODOLPHO123@",l2);
        setPassword("frutas123&",l3);
        setPassword("t0d1nh0*",l4);
        setPassword("B&PiD",l5);

        t1.setLogin(l1);
        t2.setLogin(l2);
        t3.setLogin(l3);
        t4.setLogin(l4);
        t5.setLogin(l5);

        dao.get().changeOrInsertObject(t1);
        dao.get().changeOrInsertObject(t2);
        dao.get().changeOrInsertObject(t3);
        dao.get().changeOrInsertObject(t4);
        dao.get().changeOrInsertObject(t5);

        dao.get().closeConnection();
    }

    public void insertOrganizations() {
        Organization o1 = new Organization();
        Organization o2 = new Organization();
        Organization o3 = new Organization();
        Organization o4 = new Organization();
        Organization o5 = new Organization();
        
        o1.setAcronym("PUCPR");
        o2.setAcronym("UFPR");
        o3.setAcronym("UFRJ");
        o4.setAcronym("UFSC");
        o5.setAcronym("UTFPR");
        
        o1.setName("Pontifícia Universidade Católica do Paraná");
        o2.setName("Universidade Federal do Paraná");
        o3.setName("Universidade Federal do Rio de Janeiro");
        o4.setName("Universidade Federal de São Carlos");
        o5.setName("Universidade Tecnológica Federal do Paraná");

        o1.setCountry("Brasil");
        o2.setCountry("Noruega");
        o3.setCountry("Finlândia");
        o4.setCountry("Austrália");
        o5.setCountry("Cuba");

        TeacherDao tDao = new TeacherDao();
        tDao.get().startConnection(EntityManagerUtil.ATLAS_PU);

        tDao.get().insertObject(o1);
        tDao.get().insertObject(o2);
        tDao.get().insertObject(o3);
        tDao.get().insertObject(o4);
        tDao.get().insertObject(o5);

        /* ------------------------------------- */

        Teacher t1 = tDao.queryTeacher(1);
        Teacher t2 = tDao.queryTeacher(2);

        o1.setOwner(t1);
        o2.setOwner(t1);
        o3.setOwner(t1);
        o4.setOwner(t1);
        o5.setOwner(t2);

        Teacher t3 = tDao.queryTeacher(3);
        Teacher t4 = tDao.queryTeacher(4);
        Teacher t5 = tDao.queryTeacher(5);

        t1.addWorkingOrganization(o1);
        t1.addWorkingOrganization(o2);
        t1.addWorkingOrganization(o3);
        t1.addWorkingOrganization(o4);
        t2.addWorkingOrganization(o5);

        t3.addWorkingOrganization(o1);
        t4.addWorkingOrganization(o2);
        t5.addWorkingOrganization(o1);
        t5.addWorkingOrganization(o2);
        t5.addWorkingOrganization(o3);

        tDao.get().changeOrInsertObject(o1);
        tDao.get().changeOrInsertObject(o2);
        tDao.get().changeOrInsertObject(o3);
        tDao.get().changeOrInsertObject(o4);
        tDao.get().changeOrInsertObject(o5);

        tDao.get().closeConnection();
    }

    public void relateNeighbors() {
        executeSQLFile("InsertBoneNeighbors","AnatomicalAtlas");
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
            ImageIO.write(image, "png", baos);
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

    public void setPassword(String p, Login l) {
        try {
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] bSalt = new byte[8];
            byte[] bDigest;
            String sSalt, sDigest;

            random.nextBytes(bSalt);
            sSalt = Sha256SaltAuth.byteToBase64(bSalt);

            digest.reset();
            digest.update(bSalt);
            bDigest = digest.digest(p.getBytes("UTF-8"));
            sDigest = Sha256SaltAuth.byteToBase64(bDigest);

            l.setSalt(sSalt);
            l.setPasswordHash(sDigest);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
