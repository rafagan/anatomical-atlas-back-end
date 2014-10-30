package models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Arrays;

/**
 * Created by rafaganabreu on 21/09/14.
 */
@Entity
public class MultipleChoice extends Question {
    private String correctAnswer;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String answerE;
    private String statement;
    private byte[] figure;

    @Basic
    @Column(name = "CorrectAnswer", nullable = false, insertable = true, updatable = true, length = 2)
    public String getCorrectAnswer() {
        return correctAnswer;
    }
    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @Basic
    @Column(name = "AnswerA", nullable = false, insertable = true, updatable = true)
    @Type(type="text")
    public String getAnswerA() {return answerA;}
    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    @Basic
    @Column(name = "AnswerB", nullable = false, insertable = true, updatable = true)
    @Type(type="text")
    public String getAnswerB() {
        return answerB;
    }
    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    @Basic
    @Column(name = "AnswerC", nullable = true, insertable = true, updatable = true)
    @Type(type="text")
    public String getAnswerC() {
        return answerC;
    }
    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    @Basic
    @Column(name = "AnswerD", nullable = true, insertable = true, updatable = true)
    @Type(type="text")
    public String getAnswerD() {
        return answerD;
    }
    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    @Basic
    @Column(name = "AnswerE", nullable = true, insertable = true, updatable = true)
    @Type(type="text")
    public String getAnswerE() {
        return answerE;
    }
    public void setAnswerE(String answerE) {
        this.answerE = answerE;
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
        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (correctAnswer != null ? correctAnswer.hashCode() : 0);
        result = 31 * result + (answerA != null ? answerA.hashCode() : 0);
        result = 31 * result + (answerB != null ? answerB.hashCode() : 0);
        result = 31 * result + (answerC != null ? answerC.hashCode() : 0);
        result = 31 * result + (answerD != null ? answerD.hashCode() : 0);
        result = 31 * result + (answerE != null ? answerE.hashCode() : 0);
        result = 31 * result + (statement != null ? statement.hashCode() : 0);
        result = 31 * result + (figure != null ? Arrays.hashCode(figure) : 0);
        return result;
    }
}
