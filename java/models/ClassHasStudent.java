package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * Created by rafaganabreu on 21/09/14.
 */
@Entity
@IdClass(ClassHasStudentPK.class)
public class ClassHasStudent {
    private int classIdClass;
    private int studentIdStudent;

    @Id
    @Column(name = "Class_idClass", nullable = false, insertable = true, updatable = true)
    public int getClassIdClass() {
        return classIdClass;
    }

    public void setClassIdClass(int classIdClass) {
        this.classIdClass = classIdClass;
    }

    @Id
    @Column(name = "Student_idStudent", nullable = false, insertable = true, updatable = true)
    public int getStudentIdStudent() {
        return studentIdStudent;
    }

    public void setStudentIdStudent(int studentIdStudent) {
        this.studentIdStudent = studentIdStudent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClassHasStudent that = (ClassHasStudent) o;

        if (classIdClass != that.classIdClass) return false;
        if (studentIdStudent != that.studentIdStudent) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = classIdClass;
        result = 31 * result + studentIdStudent;
        return result;
    }
}
