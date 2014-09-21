package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * Created by rafaganabreu on 21/09/14.
 */
@Entity
@IdClass(QuestionReferencesBoneSetPK.class)
public class QuestionReferencesBoneSet {
    private int questionIdQuestion;
    private int boneSetIdBoneSet;

    @Id
    @Column(name = "Question_idQuestion", nullable = false, insertable = true, updatable = true)
    public int getQuestionIdQuestion() {
        return questionIdQuestion;
    }

    public void setQuestionIdQuestion(int questionIdQuestion) {
        this.questionIdQuestion = questionIdQuestion;
    }

    @Id
    @Column(name = "BoneSet_idBoneSet", nullable = false, insertable = true, updatable = true)
    public int getBoneSetIdBoneSet() {
        return boneSetIdBoneSet;
    }

    public void setBoneSetIdBoneSet(int boneSetIdBoneSet) {
        this.boneSetIdBoneSet = boneSetIdBoneSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuestionReferencesBoneSet that = (QuestionReferencesBoneSet) o;

        if (boneSetIdBoneSet != that.boneSetIdBoneSet) return false;
        if (questionIdQuestion != that.questionIdQuestion) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = questionIdQuestion;
        result = 31 * result + boneSetIdBoneSet;
        return result;
    }
}
