package dao;

import models.*;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Set;

/**
 * Created by rafaganabreu on 01/10/14.
 */
public class TeacherDao extends AbstractDao {
    public List<Teacher> queryTeachers() {
        TypedQuery<Teacher> query =
                dao.getEntityManager().createQuery(
                        "SELECT t FROM Teacher AS t", Teacher.class);
        List<Teacher> teachers = null;

        try {
            teachers = query.getResultList();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return teachers;
    }

    public Teacher queryTeacher(int id) {
        TypedQuery<Teacher> query =
                dao.getEntityManager().createQuery(
                        "SELECT t FROM Teacher AS t " +
                                "WHERE t.idTeacher = :id", Teacher.class);
        query.setParameter("id",id);
        Teacher teacher = null;

        try {
            teacher = query.getSingleResult();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return teacher;
    }

    public List<Organization> queryOrganizations(int id) {
        TypedQuery<Organization> query =
                dao.getEntityManager().createQuery(
                        "SELECT o FROM Organization AS o " +
                                "WHERE o.owner.idTeacher = :id", Organization.class);
        query.setParameter("id",id);
        List<Organization> teacherOrganizations = null;

        try {
            teacherOrganizations = query.getResultList();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return teacherOrganizations;
    }

    public List<Clazz> queryMonitoratedClasses(int id) {
        TypedQuery<Clazz> query =
                dao.getEntityManager().createQuery(
                        "SELECT c FROM Clazz AS c " +
                                "JOIN c.monitors AS t " +
                                "ON t.idTeacher = :id", Clazz.class);
        query.setParameter("id",id);
        List<Clazz> teacherClasses = null;

        try {
            teacherClasses = query.getResultList();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return teacherClasses;
    }

    public List<Student> queryMonitoratedStudents(int id) {
        TypedQuery<Student> query =
                dao.getEntityManager().createQuery(
                        "SELECT s FROM Student AS s " +
                                "JOIN s.myClasses AS c " +
                                "JOIN c.monitors AS t " +
                                "WHERE t.idTeacher = :id", Student.class);
        query.setParameter("id",id);
        List<Student> teacherStudents = null;

        try {
            teacherStudents = query.getResultList();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return teacherStudents;
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
        List<Student> teacherStudents = null;

        try {
            teacherStudents = query.getResultList();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return teacherStudents;
    }

    public Clazz queryMonitoratedClass(int idTeacher, int idClass) {
        TypedQuery<Clazz> query =
                dao.getEntityManager().createQuery(
                        "SELECT c FROM Clazz AS c " +
                                "JOIN c.monitors AS t ON t.idTeacher = :id " +
                                "WHERE c.idClass = :idClass", Clazz.class);
        query.setParameter("id",idTeacher);
        query.setParameter("idClass",idClass);
        Clazz teacherClass = null;

        try {
            teacherClass = query.getSingleResult();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return teacherClass;
    }

    public List<Question> queryQuestions(int id) {
        TypedQuery<Question> query =
                dao.getEntityManager().createQuery(
                        "SELECT q FROM Question AS q " +
                                "JOIN q.authors AS t " +
                                "ON t.idTeacher = :id", Question.class);
        query.setParameter("id",id);
        List<Question> teacherQuestions = null;

        try {
            teacherQuestions = query.getResultList();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return teacherQuestions;
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
        Question teacherQuestion = null;

        try {
            teacherQuestion = query.getSingleResult();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return teacherQuestion;
    }

    public List<TrueOrFalse> queryTFQuestions(int id) {
        TypedQuery<TrueOrFalse> query =
                dao.getEntityManager().createQuery(
                        "SELECT q FROM TrueOrFalse AS q " +
                                "JOIN q.authors AS t " +
                                "ON t.idTeacher = :id", TrueOrFalse.class);
        query.setParameter("id",id);
        List<TrueOrFalse> teacherQuestions = null;

        try {
            teacherQuestions = query.getResultList();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return teacherQuestions;
    }

    public List<MultipleChoice> queryMCQuestions(int id) {
        TypedQuery<MultipleChoice> query =
                dao.getEntityManager().createQuery(
                        "SELECT q FROM MultipleChoice AS q " +
                                "JOIN q.authors AS t " +
                                "ON t.idTeacher = :id", MultipleChoice.class);
        query.setParameter("id",id);
        List<MultipleChoice> teacherQuestions = null;

        try {
            teacherQuestions = query.getResultList();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return teacherQuestions;
    }

    public List<TeacherClass> queryOwnerClasses(int id) {
        TypedQuery<TeacherClass> query =
                dao.getEntityManager().createQuery(
                        "SELECT c FROM TeacherClass AS c " +
                                "WHERE c.creator.idTeacher = :id", TeacherClass.class);
        query.setParameter("id",id);
        List<TeacherClass> teacherClass = null;

        try {
            teacherClass = query.getResultList();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return teacherClass;
    }

    public List<QuizTest> queryQuizTests(int id) {
        TypedQuery<QuizTest> query =
                dao.getEntityManager().createQuery(
                        "SELECT qt FROM QuizTest AS qt " +
                                "WHERE qt.author.idTeacher = :id", QuizTest.class);
        query.setParameter("id",id);
        List<QuizTest> quizTests = null;

        try {
            quizTests = query.getResultList();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return quizTests;
    }

    public QuizTest queryQuizTest(int teacherId, int quizTestId) {
        TypedQuery<QuizTest> query =
                dao.getEntityManager().createQuery(
                        "SELECT qt FROM QuizTest AS qt " +
                                "WHERE qt.author.idTeacher = :id AND qt.idQuizTest = :idQuizTest", QuizTest.class);
        query.setParameter("id",teacherId);
        query.setParameter("idQuizTest",quizTestId);
        QuizTest quizTest = null;

        try {
            quizTest = query.getSingleResult();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return quizTest;
    }
}
