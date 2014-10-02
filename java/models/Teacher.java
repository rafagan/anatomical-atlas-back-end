package models;

import models.utils.Sex;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Date;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by rafaganabreu on 21/09/14.
 */
@Entity
public class Teacher {
    private int idTeacher;
    private String name;
    private byte[] photo;
    private String resume;
    private Sex sex;
    private Date birthday;
    private String country;
    private String scholarity;

    //Organizações em que trabalha
    private Set<Organization> workingOrganizations = new HashSet<>();
    private Set<Organization> ownerOfOrganizations = new HashSet<>();
    private Set<TeacherClass> ownerOfClasses = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idTeacher", nullable = false, insertable = true, updatable = true)
    public int getIdTeacher() { return this.idTeacher; }
    public void setIdTeacher(int idTeacher) { this.idTeacher = idTeacher; }

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name="TeacherWorkAtOrganization",
            joinColumns={@JoinColumn(name="Teacher_idEmployee")},
            inverseJoinColumns={@JoinColumn(name="Organization_idOrganizaton")}
    )
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Set<Organization> getWorkingOrganizations() { return workingOrganizations; }
    public void setWorkingOrganizations(Set<Organization> workingOrganizations) { this.workingOrganizations = workingOrganizations; }

    @OneToMany(mappedBy = "owner")
    @JsonManagedReference
    public Set<Organization> getOwnerOfOrganizations() { return ownerOfOrganizations; }
    public void setOwnerOfOrganizations(Set<Organization> ownerOfOrganizations) { this.ownerOfOrganizations = ownerOfOrganizations; }

    @OneToMany(mappedBy = "creator")
    @JsonManagedReference
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Set<TeacherClass> getOwnerOfClasses() { return ownerOfClasses; }
    public void setOwnerOfClasses(Set<TeacherClass> ownerOfClasses) { this.ownerOfClasses = ownerOfClasses; }

    @Basic
    @Column(name = "Name", nullable = false, insertable = true, updatable = true, length = 128)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Photo", nullable = true, insertable = true, updatable = true)
    public byte[] getPhoto() {
        return photo;
    }
    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Basic
    @Column(name = "Resume", nullable = true, insertable = true, updatable = true)
    @Type(type = "text")
    public String getResume() {
        return resume;
    }
    public void setResume(String resume) {
        this.resume = resume;
    }

    @Basic
    @Column(name = "Sex", nullable = true, insertable = true, updatable = true, columnDefinition = "enum('MALE','FEMALE')")
    @Enumerated(EnumType.STRING)
    public Sex getSex() {
        return sex;
    }
    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "Birthday", nullable = true, insertable = true, updatable = true)
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "Country", nullable = true, insertable = true, updatable = true, length = 128)
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "Scholarity", nullable = false, insertable = true, updatable = true, length = 128)
    public String getScholarity() {
        return scholarity;
    }
    public void setScholarity(String scholarity) {
        this.scholarity = scholarity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher teacher = (Teacher) o;

        if (idTeacher != teacher.idTeacher) return false;
        if (birthday != null ? !birthday.equals(teacher.birthday) : teacher.birthday != null) return false;
        if (country != null ? !country.equals(teacher.country) : teacher.country != null) return false;
        if (name != null ? !name.equals(teacher.name) : teacher.name != null) return false;
        if (!Arrays.equals(photo, teacher.photo)) return false;
        if (resume != null ? !resume.equals(teacher.resume) : teacher.resume != null) return false;
        if (scholarity != null ? !scholarity.equals(teacher.scholarity) : teacher.scholarity != null) return false;
        if (sex != null ? !sex.equals(teacher.sex) : teacher.sex != null) return false;
        if (workingOrganizations != null ? !workingOrganizations.equals(teacher.workingOrganizations) : teacher.workingOrganizations != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTeacher;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (photo != null ? Arrays.hashCode(photo) : 0);
        result = 31 * result + (resume != null ? resume.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (scholarity != null ? scholarity.hashCode() : 0);

        if(workingOrganizations != null)
            for(Organization org : workingOrganizations)
                result = 31 * result + org.getIdOrganization();
        else
            result *= 31;

        return result;
    }
}
