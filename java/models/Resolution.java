package models;

import org.codehaus.jackson.annotate.JsonBackReference;

import javax.persistence.*;

/**
 * Created by rafaganabreu on 21/09/14.
 */
@Entity
public class Resolution {
    private int idResolution;
    private int totalCorrectAnswers;
    private int totalWrongAnswers;
    private int totalQuestions;

    private Student owner;
    private QuizTest relatedQuiz;

    @Id
    @Column(name = "idResolution", nullable = false, insertable = true, updatable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdResolution() {
        return idResolution;
    }
    public void setIdResolution(int idResolution) {
        this.idResolution = idResolution;
    }

    @ManyToOne
    @JoinColumn(name="Student_idStudent")
    @JsonBackReference
    public Student getOwner() {return owner;}
    public void setOwner(Student owner) {
        this.owner = owner;
        owner.getMyResolutions().add(this);
    }

    @ManyToOne
    @JoinColumn(name="QuizTest_idQuizTest")
    @JsonBackReference
    public QuizTest getRelatedQuiz() {return relatedQuiz;}
    public void setRelatedQuiz(QuizTest relatedQuiz) {
        this.relatedQuiz = relatedQuiz;
        relatedQuiz.getResolutions().add(this);
    }

    @Basic
    @Column(name = "TotalCorrectAnswers", nullable = false, insertable = true, updatable = true)
    public int getTotalCorrectAnswers() {
        return totalCorrectAnswers;
    }
    public void setTotalCorrectAnswers(int totalCorrectAnswers) {
        this.totalCorrectAnswers = totalCorrectAnswers;
    }

    @Basic
    @Column(name = "TotalWrongAnswers", nullable = false, insertable = true, updatable = true)
    public int getTotalWrongAnswers() {
        return totalWrongAnswers;
    }
    public void setTotalWrongAnswers(int totalWrongAnswers) {
        this.totalWrongAnswers = totalWrongAnswers;
    }

    @Basic
    @Column(name = "TotalQuestions", nullable = false, insertable = true, updatable = true)
    public int getTotalQuestions() {
        return totalQuestions;
    }
    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resolution that = (Resolution) o;

        if (idResolution != that.idResolution) return false;
        if (totalCorrectAnswers != that.totalCorrectAnswers) return false;
        if (totalQuestions != that.totalQuestions) return false;
        if (totalWrongAnswers != that.totalWrongAnswers) return false;
        if (owner != null ? !owner.equals(that.owner) : that.owner != null) return false;
        if (relatedQuiz != null ? !relatedQuiz.equals(that.relatedQuiz) : that.relatedQuiz != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idResolution;
        result = 31 * result + totalCorrectAnswers;
        result = 31 * result + totalWrongAnswers;
        result = 31 * result + totalQuestions;
        result = 31 * result + owner.getIdStudent();
        result = 31 * result + relatedQuiz.getIdQuizTest();
        return result;
    }
}
