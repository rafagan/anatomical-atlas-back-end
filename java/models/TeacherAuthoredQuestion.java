package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * Created by rafaganabreu on 21/09/14.
 */
@Entity
@IdClass(TeacherAuthoredQuestionPK.class)
public class TeacherAuthoredQuestion {
    private int teacherIdTeacher;
    private int questionIdQuestion;

    @Id
    @Column(name = "Teacher_idTeacher", nullable = false, insertable = true, updatable = true)
    public int getTeacherIdTeacher() {
        return teacherIdTeacher;
    }

    public void setTeacherIdTeacher(int teacherIdTeacher) {
        this.teacherIdTeacher = teacherIdTeacher;
    }

    @Id
    @Column(name = "Question_idQuestion", nullable = false, insertable = true, updatable = true)
    public int getQuestionIdQuestion() {
        return questionIdQuestion;
    }

    public void setQuestionIdQuestion(int questionIdQuestion) {
        this.questionIdQuestion = questionIdQuestion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeacherAuthoredQuestion that = (TeacherAuthoredQuestion) o;

        if (questionIdQuestion != that.questionIdQuestion) return false;
        if (teacherIdTeacher != that.teacherIdTeacher) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = teacherIdTeacher;
        result = 31 * result + questionIdQuestion;
        return result;
    }
}
