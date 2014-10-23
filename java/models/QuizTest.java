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
    private Byte difficultLevel;

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

    @ManyToOne
    @JoinColumn(name="Teacher_idQuestionOwner")
    @JsonBackReference
    public Teacher getAuthor() {return author;}
    public void setAuthor(Teacher author) {this.author = author;}

    @OneToMany(mappedBy = "relatedQuiz")
    @JsonManagedReference
    public Set<Resolution> getResolutions() {return resolutions;}
    public void setResolutions(Set<Resolution> resolutions) {this.resolutions = resolutions;}

    @Basic
    @Column(name = "DifficultLevel", nullable = true, insertable = true, updatable = true)
    public Byte getDifficultLevel() {return difficultLevel;}
    public void setDifficultLevel(Byte difficultLevel) {this.difficultLevel = difficultLevel;}

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
