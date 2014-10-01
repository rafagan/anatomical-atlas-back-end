package models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Arrays;

/**
 * Created by rafaganabreu on 21/09/14.
 */
@Entity
public class MultipleChoice {
    private int questionIdQuestion;
    private String correctAnswer;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String answerE;
    private String statement;
    private byte[] figure;

    @Id
    @Column(name = "Question_idQuestion", nullable = false, insertable = true, updatable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getQuestionIdQuestion() {
        return questionIdQuestion;
    }

    public void setQuestionIdQuestion(int questionIdQuestion) {
        this.questionIdQuestion = questionIdQuestion;
    }

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
    public String getAnswerA() {
        return answerA;
    }

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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MultipleChoice that = (MultipleChoice) o;

        if (questionIdQuestion != that.questionIdQuestion) return false;
        if (answerA != null ? !answerA.equals(that.answerA) : that.answerA != null) return false;
        if (answerB != null ? !answerB.equals(that.answerB) : that.answerB != null) return false;
        if (answerC != null ? !answerC.equals(that.answerC) : that.answerC != null) return false;
        if (answerD != null ? !answerD.equals(that.answerD) : that.answerD != null) return false;
        if (answerE != null ? !answerE.equals(that.answerE) : that.answerE != null) return false;
        if (correctAnswer != null ? !correctAnswer.equals(that.correctAnswer) : that.correctAnswer != null)
            return false;
        if (!Arrays.equals(figure, that.figure)) return false;
        if (statement != null ? !statement.equals(that.statement) : that.statement != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = questionIdQuestion;
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
