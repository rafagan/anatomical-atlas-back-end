package src.dao;

import models.*;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafaganabreu on 23/10/14.
 */
public class OrganizationDao extends AbstractDao {
    public List<Organization> queryOrganizations() {
        return dao.findEntities(getEM().createQuery("SELECT q FROM Organization AS q", Organization.class));
    }

    public Organization queryOrganization(int id) {
        TypedQuery<Organization> query =
                dao.getEntityManager().createQuery(
                        "SELECT o FROM Organization AS o " +
                                "WHERE o.idOrganization = :id", Organization.class);
        query.setParameter("id",id);

        return dao.findEntity(query);
    }

    public List<Teacher> queryTeachers(int id) {
        TypedQuery<Teacher> query =
                dao.getEntityManager().createQuery(
                        "SELECT t FROM Teacher AS t " +
                                "JOIN t.workingOrganizations AS o " +
                                "ON o.idOrganization = :id", Teacher.class);
        query.setParameter("id",id);

        return dao.findEntities(query);
    }

    public List<Student> queryStudents(int id) {
        TypedQuery<Student> query =
                dao.getEntityManager().createQuery(
                        "SELECT s FROM Student AS s " +
                                "WHERE s.studentOrganization.idOrganization = :id", Student.class);
        query.setParameter("id",id);

        return dao.findEntities(query);
    }

    public Student queryStudent(int organizationId, int studentId) {
        TypedQuery<Student> query =
                dao.getEntityManager().createQuery(
                        "SELECT s FROM Student AS s " +
                                "WHERE s.studentOrganization.idOrganization = :id " +
                                "AND s.idStudent = :idStudent", Student.class);
        query.setParameter("id",organizationId);
        query.setParameter("idStudent",studentId);

        return dao.findEntity(query);
    }

    public List<OrganizationClass> queryClasses(int id) {
        TypedQuery<OrganizationClass> query =
                dao.getEntityManager().createQuery(
                        "SELECT c FROM OrganizationClass AS c " +
                                "WHERE c.creator.idOrganization = :id", OrganizationClass.class);
        query.setParameter("id",id);

        return dao.findEntities(query);
    }

    public OrganizationClass queryClass(int organizationId, int classId) {
        TypedQuery<OrganizationClass> query =
                dao.getEntityManager().createQuery(
                        "SELECT c FROM OrganizationClass AS c " +
                                "WHERE c.creator.idOrganization = :id " +
                                "AND c.idClass = :idClass", OrganizationClass.class);
        query.setParameter("id",organizationId);
        query.setParameter("idClass",classId);

        return dao.findEntity(query);
    }

    public List<Student> queryStudentsInOrganizationClass(int organizationId, int classId) {
        List <Student> l = new ArrayList<>();
        l.addAll(queryClass(organizationId, classId).getClassStudents());
        return l;
    }
}
