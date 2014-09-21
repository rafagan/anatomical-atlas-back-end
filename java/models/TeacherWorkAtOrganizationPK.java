package models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by rafaganabreu on 21/09/14.
 */
public class TeacherWorkAtOrganizationPK implements Serializable {
    private int teacherIdEmployee;
    private int organizationIdOrganization;

    @Column(name = "Teacher_idEmployee", nullable = false, insertable = true, updatable = true)
    @Id
    public int getTeacherIdEmployee() {
        return teacherIdEmployee;
    }

    public void setTeacherIdEmployee(int teacherIdEmployee) {
        this.teacherIdEmployee = teacherIdEmployee;
    }

    @Column(name = "Organization_idOrganization", nullable = false, insertable = true, updatable = true)
    @Id
    public int getOrganizationIdOrganization() {
        return organizationIdOrganization;
    }

    public void setOrganizationIdOrganization(int organizationIdOrganization) {
        this.organizationIdOrganization = organizationIdOrganization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeacherWorkAtOrganizationPK that = (TeacherWorkAtOrganizationPK) o;

        if (organizationIdOrganization != that.organizationIdOrganization) return false;
        if (teacherIdEmployee != that.teacherIdEmployee) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = teacherIdEmployee;
        result = 31 * result + organizationIdOrganization;
        return result;
    }
}
