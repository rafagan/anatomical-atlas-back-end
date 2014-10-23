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
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Question {
    private int idQuestion;
    private byte publicDomain;

    private Set<QuizTest> quizTests = new HashSet<>();
    private Set<BoneSet> categories = new HashSet<>();
    private Set<Teacher> authors = new HashSet<>();

    @Id
    @Column(name = "idQuestion", nullable = false, insertable = true, updatable = true)
    @GeneratedValue(strategy = GenerationType.TABLE)
    public int getIdQuestion() {return idQuestion;}
    public void setIdQuestion(int idQuestion) {this.idQuestion = idQuestion;}

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name="QuestionReferencesBoneSet",
            joinColumns={@JoinColumn(name="Question_idQuestion")},
            inverseJoinColumns={@JoinColumn(name="BoneSet_idBoneSet")}
    )
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Set<BoneSet> getCategories() {return categories;}
    public void setCategories(Set<BoneSet> categories) {this.categories = categories;}

    @ManyToMany(mappedBy = "questions", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    public Set<QuizTest> getQuizTests() {return quizTests;}
    public void setQuizTests(Set<QuizTest> quizTests) {this.quizTests = quizTests;}


    @ManyToMany(mappedBy = "myQuestions", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    public Set<Teacher> getAuthors() {return authors;}
    public void setAuthors(Set<Teacher> authors) {this.authors = authors;}

    @Basic
    @Column(name = "PublicDomain", nullable = false, insertable = true, updatable = true)
    public byte getPublicDomain() {return publicDomain;}
    public void setPublicDomain(byte publicDomain) {this.publicDomain = publicDomain;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        if (idQuestion != question.idQuestion) return false;
        if (publicDomain != question.publicDomain) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idQuestion;
        result = 31 * result + (int) publicDomain;
        return result;
    }
}
