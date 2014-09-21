package models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by rafaganabreu on 21/09/14.
 */
@Entity
public class QuizTest {
    private int idQuizTest;
    private Byte difficultLevel;

    @Id
    @Column(name = "idQuizTest", nullable = false, insertable = true, updatable = true)
    public int getIdQuizTest() {
        return idQuizTest;
    }

    public void setIdQuizTest(int idQuizTest) {
        this.idQuizTest = idQuizTest;
    }

    @Basic
    @Column(name = "DifficultLevel", nullable = true, insertable = true, updatable = true)
    public Byte getDifficultLevel() {
        return difficultLevel;
    }

    public void setDifficultLevel(Byte difficultLevel) {
        this.difficultLevel = difficultLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuizTest quizTest = (QuizTest) o;

        if (idQuizTest != quizTest.idQuizTest) return false;
        if (difficultLevel != null ? !difficultLevel.equals(quizTest.difficultLevel) : quizTest.difficultLevel != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idQuizTest;
        result = 31 * result + (difficultLevel != null ? difficultLevel.hashCode() : 0);
        return result;
    }
}
