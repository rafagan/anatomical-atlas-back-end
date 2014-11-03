package models;

import models.utils.Sex;
import org.codehaus.jackson.annotate.JsonBackReference;
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

    private Set<Organization> workingOrganizations = new HashSet<>();
    private Set<Organization> ownerOfOrganizations = new HashSet<>();
    private Set<TeacherClass> ownerOfClasses = new HashSet<>();
    private Set<Clazz> monitoratedClasses = new HashSet<>();
    private Set<QuizTest> myQuizTests = new HashSet<>();
    private Set<Question> myQuestions = new HashSet<>();
    private TeacherLogin login;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idTeacher", nullable = false, insertable = true, updatable = true)
    public int getIdTeacher() { return this.idTeacher; }
    private void setIdTeacher(int idTeacher) { this.idTeacher = idTeacher; }

    @ManyToMany
    @JoinTable(
            name="TeacherWorkAtOrganization",
            joinColumns={@JoinColumn(name="Teacher_idEmployee")},
            inverseJoinColumns={@JoinColumn(name="Organization_idOrganizaton")}
    )
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Set<Organization> getWorkingOrganizations() { return workingOrganizations; }
    public void setWorkingOrganizations(Set<Organization> workingOrganizations) { this.workingOrganizations = workingOrganizations; }
    public void addWorkingOrganization(Organization organization) {
        if(organization == null) return;

        workingOrganizations.add(organization);
        organization.getTeachers().add(this);
    }

    @OneToMany(mappedBy = "owner")
    @JsonManagedReference
    public Set<Organization> getOwnerOfOrganizations() { return ownerOfOrganizations; }
    public void setOwnerOfOrganizations(Set<Organization> ownerOfOrganizations) { this.ownerOfOrganizations = ownerOfOrganizations; }

    @OneToMany(mappedBy = "creator")
    @JsonManagedReference
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Set<TeacherClass> getOwnerOfClasses() { return ownerOfClasses; }
    public void setOwnerOfClasses(Set<TeacherClass> ownerOfClasses) { this.ownerOfClasses = ownerOfClasses; }

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name="TeacherMonitoratesClass",
            joinColumns={@JoinColumn(name="Teacher_idTeacher")},
            inverseJoinColumns={@JoinColumn(name="Class_idClass")}
    )
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Set<Clazz> getMonitoratedClasses() {return monitoratedClasses;}
    public void setMonitoratedClasses(Set<Clazz> monitoratedClasses) {this.monitoratedClasses = monitoratedClasses;}
    public void addMonitoratedClasses(Clazz clazz) {
        if(clazz == null) return;

        monitoratedClasses.add(clazz);
        clazz.getMonitors().add(this);
    }

    @OneToMany(mappedBy = "author")
    @JsonManagedReference
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Set<QuizTest> getMyQuizTests() {return myQuizTests;}
    public void setMyQuizTests(Set<QuizTest> quizTestsAuthor) {this.myQuizTests = quizTestsAuthor;}

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name="TeacherAuthoredQuestion",
            joinColumns={@JoinColumn(name="Teacher_idTeacher")},
            inverseJoinColumns={@JoinColumn(name="Question_idQuestion")}
    )
    public Set<Question> getMyQuestions() {return myQuestions;}
    public void setMyQuestions(Set<Question> questionsAuthor) {this.myQuestions = questionsAuthor;}
    public void addQuestion(Question question) {
        if(question == null) return;

        myQuestions.add(question);
        question.getAuthors().add(this);
    }

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="Login_idLogin")
    @JsonBackReference
    public TeacherLogin getLogin() {return login;}
    public void setLogin(TeacherLogin login) {
        this.login = login;
        if(login != null) login.setOwner(this);
    }

    @Basic
    @Column(name = "Name", nullable = false, insertable = true, updatable = true, length = 128)
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    @Basic
    @Column(name = "Photo", nullable = true, insertable = true, updatable = true, length = 16777217)
    public byte[] getPhoto() {return photo;}
    public void setPhoto(byte[] photo) {this.photo = photo;}

    @Basic
    @Column(name = "Resume", nullable = true, insertable = true, updatable = true)
    @Type(type = "text")
    public String getResume() {return resume;}
    public void setResume(String resume) {this.resume = resume;}

    @Basic
    @Column(name = "Sex", nullable = true, insertable = true, updatable = true, columnDefinition = "enum('MALE','FEMALE')")
    @Enumerated(EnumType.STRING)
    public Sex getSex() {return sex;}
    public void setSex(Sex sex) {this.sex = sex;}

    @Basic
    @Column(name = "Birthday", nullable = true, insertable = true, updatable = true)
    public Date getBirthday() {return birthday;}
    public void setBirthday(Date birthday) {this.birthday = birthday;}

    @Basic
    @Column(name = "Country", nullable = true, insertable = true, updatable = true, length = 128)
    public String getCountry() {return country;}
    public void setCountry(String country) {this.country = country;}

    @Basic
    @Column(name = "Scholarity", nullable = false, insertable = true, updatable = true, length = 128)
    public String getScholarity() {return scholarity;}
    public void setScholarity(String scholarity) {this.scholarity = scholarity;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher teacher = (Teacher) o;
        if (idTeacher != teacher.idTeacher) return false;

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

        return result;
    }
}
