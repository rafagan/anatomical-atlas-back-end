package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by rafaganabreu on 21/09/14.
 */
@Entity
public class Organization {
    private int idOrganization;

    private Set<Teacher> teachers = new HashSet<>();

    public Organization() {}

    @Id
    @Column(name = "idOrganization", nullable = false, insertable = true, updatable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdOrganization() {
        return idOrganization;
    }
    private void setIdOrganization(int idOrganization) {
        this.idOrganization = idOrganization;
    }

    @ManyToMany(mappedBy = "workingOrganizations", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    public Set<Teacher> getTeachers() { return teachers; }
    public void setTeachers(Set<Teacher> teachers) { this.teachers = teachers; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (idOrganization != that.idOrganization) return false;
        if (teachers != null ? !teachers.equals(that.teachers) : that.teachers != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idOrganization;
        result = 31 * result + (teachers != null ? teachers.hashCode() : 0);

        return result;
    }
}
