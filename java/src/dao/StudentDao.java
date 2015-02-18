package src.dao;

import models.Resolution;
import models.Student;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by rafaganabreu on 23/10/14.
 */
public class StudentDao extends AbstractDao {
    public List<Student> queryStudents() {
        return dao.findEntities(getEM().createQuery("SELECT s FROM Student AS s", Student.class));
    }

    public Student queryStudent(int id) {
        TypedQuery<Student> query =
                dao.getEntityManager().createQuery(
                        "SELECT s FROM Student AS s " +
                                "WHERE s.idStudent = :id", Student.class);
        query.setParameter("id",id);

        return dao.findEntity(query);
    }

    public List<Resolution> queryResolutions(int id) {
        TypedQuery<Resolution> query =
                dao.getEntityManager().createQuery(
                        "SELECT r FROM Resolution AS r " +
                                "WHERE r.owner.idStudent = :id", Resolution.class);
        query.setParameter("id",id);

        return dao.findEntities(query);
    }

    public Resolution queryResolution(int studentId, int resolutionId) {
        TypedQuery<Resolution> query =
                dao.getEntityManager().createQuery(
                        "SELECT r FROM Resolution AS r " +
                                "WHERE r.owner.idStudent = :id AND r.idResolution = :idResolution", Resolution.class);
        query.setParameter("id",studentId);
        query.setParameter("idResolution",resolutionId);

        return dao.findEntity(query);
    }
}
