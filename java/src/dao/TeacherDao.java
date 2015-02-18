package src.dao;

import models.*;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by rafaganabreu on 01/10/14.
 */
public class TeacherDao extends AbstractDao {
    public List<Teacher> queryTeachers() {
        return dao.findEntities(getEM().createQuery("SELECT t FROM Teacher AS t", Teacher.class));
    }

    public Teacher queryTeacher(int id) {
        TypedQuery<Teacher> query =
                dao.getEntityManager().createQuery(
                        "SELECT t FROM Teacher AS t " +
                                "WHERE t.idTeacher = :id", Teacher.class);
        query.setParameter("id",id);

        return dao.findEntity(query);
    }

    public List<Organization> queryOrganizations(int id) {
        TypedQuery<Organization> query =
                dao.getEntityManager().createQuery(
                        "SELECT o FROM Organization AS o " +
                                "WHERE o.owner.idTeacher = :id", Organization.class);
        query.setParameter("id",id);

        return dao.findEntities(query);
    }

    public List<Clazz> queryMonitoratedClasses(int id) {
        TypedQuery<Clazz> query =
                dao.getEntityManager().createQuery(
                        "SELECT c FROM Clazz AS c " +
                                "JOIN c.monitors AS t " +
                                "ON t.idTeacher = :id", Clazz.class);
        query.setParameter("id",id);

        return dao.findEntities(query);
    }

    public List<Student> queryMonitoratedStudents(int id) {
        TypedQuery<Student> query =
                dao.getEntityManager().createQuery(
                        "SELECT s FROM Student AS s " +
                                "JOIN s.myClasses AS c " +
                                "JOIN c.monitors AS t " +
                                "WHERE t.idTeacher = :id", Student.class);
        query.setParameter("id",id);

        return dao.findEntities(query);
    }

    public List<Student> queryMonitoratedClassStudents(int idTeacher, int idClass) {
        TypedQuery<Student> query =
                dao.getEntityManager().createQuery(
                        "SELECT s FROM Student AS s " +
                                "JOIN s.myClasses AS c ON c.idClass = :idClass " +
                                "JOIN c.monitors AS t " +
                                "WHERE t.idTeacher = :id", Student.class);
        query.setParameter("id",idTeacher);
        query.setParameter("idClass",idClass);

        return dao.findEntities(query);
    }

    public Clazz queryMonitoratedClass(int idTeacher, int idClass) {
        TypedQuery<Clazz> query =
                dao.getEntityManager().createQuery(
                        "SELECT c FROM Clazz AS c " +
                                "JOIN c.monitors AS t ON t.idTeacher = :id " +
                                "WHERE c.idClass = :idClass", Clazz.class);
        query.setParameter("id",idTeacher);
        query.setParameter("idClass",idClass);

        return dao.findEntity(query);
    }

    public List<Question> queryQuestions(int id) {
        TypedQuery<Question> query =
                dao.getEntityManager().createQuery(
                        "SELECT q FROM Question AS q " +
                                "JOIN q.authors AS t " +
                                "ON t.idTeacher = :id", Question.class);
        query.setParameter("id",id);

        return dao.findEntities(query);
    }

    public Question queryQuestion(int teacherId, int questionId) {
        TypedQuery<Question> query =
                dao.getEntityManager().createQuery(
                        "SELECT q FROM Question AS q " +
                                "JOIN q.authors AS t " +
                                "ON t.idTeacher = :id " +
                                "WHERE q.idQuestion = :idQuestion", Question.class);
        query.setParameter("id",teacherId);
        query.setParameter("idQuestion",questionId);

        return dao.findEntity(query);
    }

    public List<TrueOrFalse> queryTFQuestions(int id) {
        TypedQuery<TrueOrFalse> query =
                dao.getEntityManager().createQuery(
                        "SELECT q FROM TrueOrFalse AS q " +
                                "JOIN q.authors AS t " +
                                "ON t.idTeacher = :id", TrueOrFalse.class);
        query.setParameter("id",id);

        return dao.findEntities(query);
    }

    public List<MultipleChoice> queryMCQuestions(int id) {
        TypedQuery<MultipleChoice> query =
                dao.getEntityManager().createQuery(
                        "SELECT q FROM MultipleChoice AS q " +
                                "JOIN q.authors AS t " +
                                "ON t.idTeacher = :id", MultipleChoice.class);
        query.setParameter("id",id);

        return dao.findEntities(query);
    }

    public List<TeacherClass> queryOwnerClasses(int id) {
        TypedQuery<TeacherClass> query =
                dao.getEntityManager().createQuery(
                        "SELECT c FROM TeacherClass AS c " +
                                "WHERE c.creator.idTeacher = :id", TeacherClass.class);
        query.setParameter("id",id);

        return dao.findEntities(query);
    }

    public List<QuizTest> queryQuizTests(int id) {
        TypedQuery<QuizTest> query =
                dao.getEntityManager().createQuery(
                        "SELECT qt FROM QuizTest AS qt " +
                                "WHERE qt.author.idTeacher = :id", QuizTest.class);
        query.setParameter("id",id);

        return dao.findEntities(query);
    }

    public QuizTest queryQuizTest(int teacherId, int quizTestId) {
        TypedQuery<QuizTest> query =
                dao.getEntityManager().createQuery(
                        "SELECT qt FROM QuizTest AS qt " +
                                "WHERE qt.author.idTeacher = :id AND qt.idQuizTest = :idQuizTest", QuizTest.class);
        query.setParameter("id",teacherId);
        query.setParameter("idQuizTest",quizTestId);

        return dao.findEntity(query);
    }
}
