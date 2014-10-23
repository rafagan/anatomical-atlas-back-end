package models;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.codehaus.jackson.map.annotate.JsonSerialize;

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
    private String acronym;
    private String country;

    private Set<Teacher> teachers = new HashSet<>();
    private Teacher owner;
    private Set<OrganizationClass> ownerOfClasses = new HashSet<>();

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

    @OneToMany(mappedBy = "creator")
    @JsonManagedReference
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Set<OrganizationClass> getOwnerOfClasses() { return ownerOfClasses; }
    public void setOwnerOfClasses(Set<OrganizationClass> ownerOfClasses) { this.ownerOfClasses = ownerOfClasses; }

    @Basic
    @Column(name = "Name", nullable = false, insertable = true, updatable = true, length = 128)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Basic
    @Column(name = "Acronym", nullable = true, insertable = true, updatable = true, length = 128)
    public String getAcronym() { return acronym; }
    public void setAcronym(String acronym) { this.acronym = acronym; }

    @Basic
    @Column(name = "Country", nullable = false, insertable = true, updatable = true, length = 128)
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (idOrganization != that.idOrganization) return false;
        if (teachers != null ? !teachers.equals(that.teachers) : that.teachers != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (acronym != null ? !acronym.equals(that.name) : that.acronym != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (owner != null ? !owner.equals(that.owner) : that.owner != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idOrganization;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (acronym != null ? acronym.hashCode() : 0);
        result = 31 * result + (owner != null ? owner.hashCode() : 0);

        if(teachers != null)
            for(Teacher t : teachers)
                result = 31 * result + t.getIdTeacher();

        return result;
    }
}
