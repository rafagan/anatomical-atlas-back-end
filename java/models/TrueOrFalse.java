package models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Arrays;

/**
 * Created by rafaganabreu on 21/09/14.
 */
@Entity
public class TrueOrFalse extends Question {
    private byte correctAnswer;
    private String statement;
    private byte[] figure;

    @Basic
    @Column(name = "CorrectAnswer", nullable = false, insertable = true, updatable = true)
    public byte getCorrectAnswer() {
        return correctAnswer;
    }
    public void setCorrectAnswer(byte correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @Basic
    @Column(name = "Statement", nullable = false, insertable = true, updatable = true)
    @Type(type="text")
    public String getStatement() {
        return statement;
    }
    public void setStatement(String statement) {
        this.statement = statement;
    }

    @Basic
    @Column(name = "Figure", nullable = true, insertable = true, updatable = true)
    public byte[] getFigure() {
        return figure;
    }
    public void setFigure(byte[] figure) {
        this.figure = figure;
    }

    @Override
    public boolean equals(Object o) {
        if(!super.equals(o))
            return false;

        TrueOrFalse that = (TrueOrFalse) o;

        if (correctAnswer != that.correctAnswer) return false;
        if (!Arrays.equals(figure, that.figure)) return false;
        if (statement != null ? !statement.equals(that.statement) : that.statement != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (int) correctAnswer;
        result = 31 * result + (statement != null ? statement.hashCode() : 0);
        result = 31 * result + (figure != null ? Arrays.hashCode(figure) : 0);
        return result;
    }
}
