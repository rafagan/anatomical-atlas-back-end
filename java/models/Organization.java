package models;

import org.codehaus.jackson.annotate.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by rafaganabreu on 21/09/14.
 */
@Entity
public class Organization {
    private int idOrganization;
    private String name;

    private Set<Teacher> teachers = new HashSet<>();
    private Teacher owner;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idOrganization", nullable = false, insertable = true, updatable = true)
    public int getIdOrganization() { return this.idOrganization; }
    public void setIdOrganization(int idOrganization) { this.idOrganization = idOrganization; }

    @ManyToMany(mappedBy = "workingOrganizations", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    public Set<Teacher> getTeachers() { return teachers; }
    public void setTeachers(Set<Teacher> teachers) { this.teachers = teachers; }

    @ManyToOne
    @JoinColumn(name="Teacher_idResponsible")
    @JsonBackReference
    public Teacher getOwner() { return owner; }
    public void setOwner(Teacher owner) { this.owner = owner; }

    @Basic
    @Column(name = "Name", nullable = false, insertable = true, updatable = true, length = 128)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (idOrganization != that.idOrganization) return false;
        if (teachers != null ? !teachers.equals(that.teachers) : that.teachers != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (owner != null ? !owner.equals(that.owner) : that.owner != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idOrganization;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (owner != null ? owner.hashCode() : 0);

        if(teachers != null)
            for(Teacher t : teachers)
                result = 31 * result + t.getIdTeacher();
        else
            result *= 31;


        return result;
    }
}
