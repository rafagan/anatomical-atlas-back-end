package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * Created by rafaganabreu on 21/09/14.
 */
@Entity
@IdClass(QuizTestHasQuestionPK.class)
public class QuizTestHasQuestion {
    private int questionIdQuestion;
    private int quizTestIdQuizTest;

    @Id
    @Column(name = "Question_idQuestion", nullable = false, insertable = true, updatable = true)
    public int getQuestionIdQuestion() {
        return questionIdQuestion;
    }

    public void setQuestionIdQuestion(int questionIdQuestion) {
        this.questionIdQuestion = questionIdQuestion;
    }

    @Id
    @Column(name = "QuizTest_idQuizTest", nullable = false, insertable = true, updatable = true)
    public int getQuizTestIdQuizTest() {
        return quizTestIdQuizTest;
    }

    public void setQuizTestIdQuizTest(int quizTestIdQuizTest) {
        this.quizTestIdQuizTest = quizTestIdQuizTest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuizTestHasQuestion that = (QuizTestHasQuestion) o;

        if (questionIdQuestion != that.questionIdQuestion) return false;
        if (quizTestIdQuizTest != that.quizTestIdQuizTest) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = questionIdQuestion;
        result = 31 * result + quizTestIdQuizTest;
        return result;
    }
}
