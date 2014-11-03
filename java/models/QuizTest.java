package models;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by rafaganabreu on 21/09/14.
 */
@Entity
public class QuizTest {
    private int idQuizTest;
    private int difficultLevel;
    private int maxQuestions;

    private Set<Question> questions = new HashSet<>();
    private Teacher author;
    private Set<Resolution> resolutions = new HashSet<>();

    @Id
    @Column(name = "idQuizTest", nullable = false, insertable = true, updatable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdQuizTest() {
        return idQuizTest;
    }
    public void setIdQuizTest(int idQuizTest) {
        this.idQuizTest = idQuizTest;
    }

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name="QuizTestHasQuestion",
            joinColumns={@JoinColumn(name="QuizTest_idQuizTest")},
            inverseJoinColumns={@JoinColumn(name="Question_idQuestion")}
    )
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Set<Question> getQuestions() {return questions;}
    public void setQuestions(Set<Question> questions) {this.questions = questions;}
    public void addQuestion(Question question) {
        if(question == null) return;

        questions.add(question);
        question.getQuizTests().add(this);
    }

    @ManyToOne
    @JoinColumn(name="Teacher_idCreator")
    @JsonBackReference
    public Teacher getAuthor() {return author;}
    public void setAuthor(Teacher author) {
        this.author = author;
        if(author != null) author.getMyQuizTests().add(this);
    }

    @OneToMany(mappedBy = "relatedQuiz")
    @JsonManagedReference
    public Set<Resolution> getResolutions() {return resolutions;}
    public void setResolutions(Set<Resolution> resolutions) {this.resolutions = resolutions;}

    @Basic
    @Column(name = "DifficultLevel", nullable = true, insertable = true, updatable = true)
    public int getDifficultLevel() {return difficultLevel;}
    public void setDifficultLevel(int difficultLevel) {this.difficultLevel = difficultLevel;}

    @Basic
    @Column(name = "MaxQuestions", nullable = false, insertable = true, updatable = true)
    public int getMaxQuestions() {
        return maxQuestions;
    }
    public void setMaxQuestions(int totalQuestions) {
        this.maxQuestions = totalQuestions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuizTest quizTest = (QuizTest) o;
        if (idQuizTest != quizTest.idQuizTest) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idQuizTest;
        result = 31 * result + difficultLevel;
        result = 31 * result + maxQuestions;

        return result;
    }
}
