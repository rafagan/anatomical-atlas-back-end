package models;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by rafaganabreu on 21/09/14.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "Class", schema = "", catalog = "AnatomicalAtlas")
public abstract class Clazz {
    protected int idClass;
    protected String name;
    protected int numberOfStudents;

    private Set<Teacher> monitors = new HashSet<>();
    private Set<Student> classStudents = new HashSet<>();

    @Id
    @Column(name = "idClass", nullable = false, insertable = true, updatable = true)
    @GeneratedValue(strategy = GenerationType.TABLE)
    public int getIdClass() {
        return idClass;
    }
    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    @ManyToMany(mappedBy = "monitoratedClasses", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    public Set<Teacher> getMonitors() { return monitors; }
    public void setMonitors(Set<Teacher> monitors) { this.monitors = monitors; }

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name="ClassHasStudent",
            joinColumns={@JoinColumn(name="Class_idClass")},
            inverseJoinColumns={@JoinColumn(name="Student_idStudent")}
    )
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Set<Student> getClassStudents() {return classStudents;}
    public void setClassStudents(Set<Student> classStudents) {this.classStudents = classStudents;}
    public void addClassStudent(Student student) {
        classStudents.add(student);
        student.getMyClasses().add(this);
    }

    @Basic
    @Column(name = "Name", nullable = false, insertable = true, updatable = true, length = 128)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Basic
    @Column(name = "NumberOfStudents", nullable = true, insertable = true, updatable = true)
    public int getNumberOfStudents() {
        return numberOfStudents;
    }
    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Clazz clazz = (Clazz) o;

        if (idClass != clazz.idClass) return false;
        if (numberOfStudents != clazz.numberOfStudents) return false;
        if (name != null ? !name.equals(clazz.name) : clazz.name != null) return false;
        if (monitors != null ? !monitors.equals(clazz.monitors) : clazz.monitors != null) return false;
        if (classStudents != null ? !classStudents.equals(clazz.classStudents) : clazz.classStudents != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idClass;
        result = 31 * result + numberOfStudents;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        if(monitors != null)
            for(Teacher t : monitors)
                result = 31 * result + t.getIdTeacher();
        if(classStudents != null)
            for(Student c : classStudents)
                result = 31 * result + c.getIdStudent();

        return result;
    }
}
