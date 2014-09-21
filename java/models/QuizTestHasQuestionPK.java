package models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by rafaganabreu on 21/09/14.
 */
public class QuizTestHasQuestionPK implements Serializable {
    private int questionIdQuestion;
    private int quizTestIdQuizTest;

    @Column(name = "Question_idQuestion", nullable = false, insertable = true, updatable = true)
    @Id
    public int getQuestionIdQuestion() {
        return questionIdQuestion;
    }

    public void setQuestionIdQuestion(int questionIdQuestion) {
        this.questionIdQuestion = questionIdQuestion;
    }

    @Column(name = "QuizTest_idQuizTest", nullable = false, insertable = true, updatable = true)
    @Id
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

        QuizTestHasQuestionPK that = (QuizTestHasQuestionPK) o;

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
