package models;

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
public class Student {
    private int idStudent;
    private String name;
    private Float generalKnowledge;
    private byte[] photo;
    private String resume;
    private String sex;
    private Date birthday;
    private String country;
    private String scholarity;

    private Set<Clazz> myClasses = new HashSet<>();
    private Set<Resolution> myResolutions = new HashSet<>();

    @Id
    @Column(name = "idStudent", nullable = false, insertable = true, updatable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdStudent() {return idStudent;}
    public void setIdStudent(int idStudent) {this.idStudent = idStudent;}

    @ManyToMany(mappedBy = "classStudents", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    public Set<Clazz> getMyClasses() {return myClasses;}
    public void setMyClasses(Set<Clazz> myClasses) {this.myClasses = myClasses;}

    @OneToMany(mappedBy = "owner", cascade = {CascadeType.ALL})
    @JsonManagedReference
    public Set<Resolution> getMyResolutions() {return myResolutions;}
    public void setMyResolutions(Set<Resolution> myResolutions) {this.myResolutions = myResolutions;}

    @Basic
    @Column(name = "Name", nullable = false, insertable = true, updatable = true, length = 128)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "GeneralKnowledge", nullable = true, insertable = true, updatable = true, precision = 0)
    public Float getGeneralKnowledge() {
        return generalKnowledge;
    }
    public void setGeneralKnowledge(Float generalKnowledge) {
        this.generalKnowledge = generalKnowledge;
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
    @Type(type="text")
    public String getResume() {
        return resume;
    }
    public void setResume(String resume) {
        this.resume = resume;
    }

    @Basic
    @Column(name = "Sex", nullable = true, insertable = true, updatable = true, length = 6)
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
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

        Student student = (Student) o;

        if (idStudent != student.idStudent) return false;
        if (birthday != null ? !birthday.equals(student.birthday) : student.birthday != null) return false;
        if (country != null ? !country.equals(student.country) : student.country != null) return false;
        if (generalKnowledge != null ? !generalKnowledge.equals(student.generalKnowledge) : student.generalKnowledge != null)
            return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        if (!Arrays.equals(photo, student.photo)) return false;
        if (resume != null ? !resume.equals(student.resume) : student.resume != null) return false;
        if (scholarity != null ? !scholarity.equals(student.scholarity) : student.scholarity != null) return false;
        if (sex != null ? !sex.equals(student.sex) : student.sex != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idStudent;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (generalKnowledge != null ? generalKnowledge.hashCode() : 0);
        result = 31 * result + (photo != null ? Arrays.hashCode(photo) : 0);
        result = 31 * result + (resume != null ? resume.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (scholarity != null ? scholarity.hashCode() : 0);
        return result;
    }
}
