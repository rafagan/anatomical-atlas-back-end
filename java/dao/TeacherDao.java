package dao;

import models.Clazz;
import models.Organization;
import models.Teacher;
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
                        "SELECT t FROM Teacher AS t WHERE t.idTeacher = :id", Teacher.class);
        query.setParameter("id",id);
        Teacher teacher = null;

        try {
            teacher = query.getSingleResult();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return teacher;
    }

    public List<Organization> queryTeacherOrganizations(int id) {
        TypedQuery<Organization> query =
                dao.getEntityManager().createQuery(
                        "SELECT o FROM Organization AS o WHERE o.owner.idTeacher = :id", Organization.class);
        query.setParameter("id",id);
        List<Organization> teacherOrganizations = null;

        try {
            teacherOrganizations = query.getResultList();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return teacherOrganizations;
    }

    public List<Clazz> queryTeacherMonitoratedClasses(int id) {
        TypedQuery<Clazz> query =
                dao.getEntityManager().createQuery(
                        "SELECT c FROM Clazz AS c JOIN c.monitors AS t WHERE t.idTeacher = :id", Clazz.class);
        query.setParameter("id",id);
        List<Clazz> teacherClasses = null;

        try {
            teacherClasses = query.getResultList();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return teacherClasses;
    }
}
