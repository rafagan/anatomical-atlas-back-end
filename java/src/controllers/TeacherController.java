package src.controllers;

import src.dtos.QuestionDto;
import src.dao.TeacherDao;
import src.models.*;
import src.utils.EntityManagerUtil;
import src.utils.WSRN;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
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
        WSRN.Response wResponse = new WSRN.Response();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<Teacher> teachers = tDao.queryTeachers();

        for(Teacher t : teachers) {
            t.setWorkingOrganizations(null);
            t.setOwnerOfOrganizations(null);
            t.setOwnerOfClasses(null);
            t.setMonitoratedClasses(null);
            t.setMyQuizTests(null);
            t.setMyQuestions(null);
            t.setLogin(null);
        }

        wResponse.setResult(teachers);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getTeacher(int id) {
        WSRN.Response wResponse = new WSRN.Response();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        Teacher t = tDao.queryTeacher(id);

        t.setLogin(null);

        for(Clazz c : t.getMonitoratedClasses()) {
            c.setMonitors(null);
            c.setClassStudents(null);
        }

        for(Organization o : t.getOwnerOfOrganizations()) {
            o.setTeachers(null);
            o.setOwner(null);
            o.setOwnerOfClasses(null);
            o.setStudents(null);
        }

        for(Organization o : t.getWorkingOrganizations()) {
            o.setTeachers(null);
            o.setOwner(null);
            o.setOwnerOfClasses(null);
            o.setStudents(null);
        }

        for(TeacherClass tc : t.getOwnerOfClasses()) {
            tc.setMonitors(null);
            tc.setClassStudents(null);
            tc.setCreator(null);
        }

        for(QuizTest qt : t.getMyQuizTests()) {
            qt.setQuestions(null);
            qt.setAuthor(null);
            qt.setResolutions(null);
        }

        for(Question q : t.getMyQuestions()) {
            q.setQuizTests(null);
            q.setCategories(null);
            q.setAuthors(null);
        }

        wResponse.setResult(t);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getTeacherOrganizations(int id) {
        WSRN.Response wResponse = new WSRN.Response();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<Organization> organizations = tDao.queryOrganizations(id);

        for(Organization o : organizations) {
            o.setTeachers(null);
            o.setOwner(null);
            o.setOwnerOfClasses(null);
            o.setStudents(null);
        }

        wResponse.setResult(organizations);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getTeacherMonitoratedClasses(int id) {
        WSRN.Response wResponse = new WSRN.Response();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<Clazz> classes = tDao.queryMonitoratedClasses(id);

        for(Clazz c : classes) {
            c.setMonitors(null);
            c.setClassStudents(null);
        }

        wResponse.setResult(classes);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getTeacherMonitoratedStudents(int id) {
        WSRN.Response wResponse = new WSRN.Response();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<Student> students = tDao.queryMonitoratedStudents(id);

        for(Student s : students) {
            s.setMyClasses(null);
            s.setMyResolutions(null);
            s.setLogin(null);
            s.setStudentOrganization(null);
        }

        wResponse.setResult(students);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getTeacherMonitoratedClassStudents(int teacherId, int classId) {
        WSRN.Response wResponse = new WSRN.Response();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<Student> students = tDao.queryMonitoratedClassStudents(teacherId, classId);

        for(Student s : students) {
            s.setMyClasses(null);
            s.setMyResolutions(null);
            s.setLogin(null);
            s.setStudentOrganization(null);
        }

        wResponse.setResult(students);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getTeacherMonitoratedClass(int teacherId, int classId) {
        WSRN.Response wResponse = new WSRN.Response();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        Clazz c = tDao.queryMonitoratedClass(teacherId, classId);

        for(Student s : c.getClassStudents()) {
            s.setMyClasses(null);
            s.setMyResolutions(null);
            s.setStudentOrganization(null);
            s.setLogin(null);
        }

        for(Teacher t : c.getMonitors()) {
            t.setWorkingOrganizations(null);
            t.setOwnerOfOrganizations(null);
            t.setOwnerOfClasses(null);
            t.setMonitoratedClasses(null);
            t.setMyQuizTests(null);
            t.setMyQuestions(null);
            t.setLogin(null);
        }

        wResponse.setResult(c);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getTeacherQuestions(int teacherId) {
        WSRN.Response wResponse = new WSRN.Response();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<Question> questions = tDao.queryQuestions(teacherId);
        List<QuestionDto> dtos = new ArrayList<>();

        for(Question q : questions) {
            QuestionDto dto = new QuestionDto();

            dto.setId(q.getIdQuestion());
            dto.setFigure(q.getFigure());

            for(Teacher t : q.getAuthors()) {
                dto.getAuthorsId().add(t.getIdTeacher());
                dto.getAuthorsName().add(t.getName());
            }

            if(q instanceof TrueOrFalse) {
                TrueOrFalse tf = (TrueOrFalse) q;

                dto.setStatement(tf.getStatement());
                dto.setCorrectAnswerB(tf.getCorrectAnswer());
            } else if(q instanceof MultipleChoice) {
                MultipleChoice mc = (MultipleChoice) q;

                dto.setStatement(mc.getStatement());
                dto.setCorrectAnswer(mc.getCorrectAnswer());
                dto.setAnswerA(mc.getAnswerA());
                dto.setAnswerB(mc.getAnswerB());
                dto.setAnswerC(mc.getAnswerC());
                dto.setAnswerD(mc.getAnswerD());
                dto.setAnswerE(mc.getAnswerE());
            }

            dtos.add(dto);
        }

        wResponse.setResult(dtos);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getTeacherQuestion(int teacherId, int questionId) {
        WSRN.Response wResponse = new WSRN.Response();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        Question q = tDao.queryQuestion(teacherId, questionId);

        if(q == null) {
            Response r = Response.ok(wResponse).build();
            dao.get().closeConnection();

            return r;
        }

        QuestionDto dto = new QuestionDto();

        dto.setId(q.getIdQuestion());
        dto.setFigure(q.getFigure());

        for(Teacher t : q.getAuthors()) {
            dto.getAuthorsId().add(t.getIdTeacher());
            dto.getAuthorsName().add(t.getName());
        }

        if(q instanceof TrueOrFalse) {
            TrueOrFalse tf = (TrueOrFalse) q;

            dto.setStatement(tf.getStatement());
            dto.setCorrectAnswerB(tf.getCorrectAnswer());
        } else if(q instanceof MultipleChoice) {
            MultipleChoice mc = (MultipleChoice) q;

            dto.setStatement(mc.getStatement());
            dto.setCorrectAnswer(mc.getCorrectAnswer());
            dto.setAnswerA(mc.getAnswerA());
            dto.setAnswerB(mc.getAnswerB());
            dto.setAnswerC(mc.getAnswerC());
            dto.setAnswerD(mc.getAnswerD());
            dto.setAnswerE(mc.getAnswerE());
        }

        wResponse.setResult(dto);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getTeacherTrueOrFalseQuestions(int teacherId) {
        WSRN.Response wResponse = new WSRN.Response();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<TrueOrFalse> questions = tDao.queryTFQuestions(teacherId);

        for(Question q : questions) {
            q.setQuizTests(null);
            q.setCategories(null);
            q.setAuthors(null);
        }

        wResponse.setResult(questions);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getTeacherMultipleChoiceQuestions(int teacherId) {
        WSRN.Response wResponse = new WSRN.Response();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<MultipleChoice> questions = tDao.queryMCQuestions(teacherId);

        for(Question q : questions) {
            q.setQuizTests(null);
            q.setCategories(null);
            q.setAuthors(null);
        }

        wResponse.setResult(questions);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getTeacherOwnerClasses(int teacherId) {
        WSRN.Response wResponse = new WSRN.Response();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<TeacherClass> classes = tDao.queryOwnerClasses(teacherId);

        wResponse.setResult(classes);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getTeacherQuizTests(int teacherId) {
        WSRN.Response wResponse = new WSRN.Response();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        List<QuizTest> quizTests = tDao.queryQuizTests(teacherId);

        for(QuizTest qt : quizTests) {
            qt.setQuestions(null);
            qt.setAuthor(null);
            qt.setResolutions(null);
        }

        wResponse.setResult(quizTests);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }

    public Response getTeacherQuizTest(int teacherId, int quizTestId) {
        WSRN.Response wResponse = new WSRN.Response();

        dao.get().startConnection(EntityManagerUtil.ATLAS_PU);
        QuizTest quizTest = tDao.queryQuizTest(teacherId, quizTestId);

        if(quizTest == null) {
            Response r = Response.ok(wResponse).build();
            dao.get().closeConnection();
            return r;
        }

        quizTest.setResolutions(null);
        quizTest.setAuthor(null); //O requisitante sabe quem é o autor

        for(Question q : quizTest.getQuestions()){
            q.setQuizTests(null);
            q.setCategories(null);
            q.setAuthors(null);
            q.setFigure(null);
        }

        wResponse.setResult(quizTest);
        Response r = Response.ok(wResponse).build();
        dao.get().closeConnection();

        return r;
    }
}
