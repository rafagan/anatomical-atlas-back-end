package models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by rafaganabreu on 21/09/14.
 */
public class QuestionReferencesBoneSetPK implements Serializable {
    private int questionIdQuestion;
    private int boneSetIdBoneSet;

    @Column(name = "Question_idQuestion", nullable = false, insertable = true, updatable = true)
    @Id
    public int getQuestionIdQuestion() {
        return questionIdQuestion;
    }

    public void setQuestionIdQuestion(int questionIdQuestion) {
        this.questionIdQuestion = questionIdQuestion;
    }

    @Column(name = "BoneSet_idBoneSet", nullable = false, insertable = true, updatable = true)
    @Id
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

        QuestionReferencesBoneSetPK that = (QuestionReferencesBoneSetPK) o;

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
