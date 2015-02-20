package src.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Created by rafaganabreu on 21/09/14.
 */
@Entity
public class TrueOrFalse extends Question {
    private byte correctAnswer;

    @Basic
    @Column(name = "CorrectAnswer", nullable = false, insertable = true, updatable = true)
    public byte getCorrectAnswer() {
        return correctAnswer;
    }
    public void setCorrectAnswer(byte correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean equals(Object o) {
        if(!super.equals(o))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (int) correctAnswer;

        return result;
    }
}
