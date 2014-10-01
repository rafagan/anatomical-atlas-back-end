package models;

import javax.persistence.*;

/**
 * Created by rafaganabreu on 21/09/14.
 */
@Entity
public class Question {
    private int idQuestion;
    private byte publicDomain;

    @Id
    @Column(name = "idQuestion", nullable = false, insertable = true, updatable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    @Basic
    @Column(name = "PublicDomain", nullable = false, insertable = true, updatable = true)
    public byte getPublicDomain() {
        return publicDomain;
    }

    public void setPublicDomain(byte publicDomain) {
        this.publicDomain = publicDomain;
    }

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
