package models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by rafaganabreu on 21/09/14.
 */
public class ClassHasStudentPK implements Serializable {
    private int classIdClass;
    private int studentIdStudent;

    @Column(name = "Class_idClass", nullable = false, insertable = true, updatable = true)
    @Id
    public int getClassIdClass() {
        return classIdClass;
    }

    public void setClassIdClass(int classIdClass) {
        this.classIdClass = classIdClass;
    }

    @Column(name = "Student_idStudent", nullable = false, insertable = true, updatable = true)
    @Id
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

        ClassHasStudentPK that = (ClassHasStudentPK) o;

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
