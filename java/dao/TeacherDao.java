package dao;

import models.Teacher;
import javax.persistence.TypedQuery;
import java.util.List;

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
}
