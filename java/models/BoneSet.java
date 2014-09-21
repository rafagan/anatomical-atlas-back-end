package models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by rafaganabreu on 21/09/14.
 */
@Entity
public class BoneSet {
    private int idBoneSet;
    private String category;
    private String description;
    private String synonymous;
    private int boneNumber;

    @Id
    @Column(name = "idBoneSet", nullable = false, insertable = true, updatable = true)
    public int getIdBoneSet() {
        return idBoneSet;
    }

    public void setIdBoneSet(int idBoneSet) {
        this.idBoneSet = idBoneSet;
    }

    @Basic
    @Column(name = "Category", nullable = false, insertable = true, updatable = true, length = 45)
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Basic
    @Column(name = "Description", nullable = false, insertable = true, updatable = true, length = 65535)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "Synonymous", nullable = true, insertable = true, updatable = true, length = 128)
    public String getSynonymous() {
        return synonymous;
    }

    public void setSynonymous(String synonymous) {
        this.synonymous = synonymous;
    }

    @Basic
    @Column(name = "BoneNumber", nullable = false, insertable = true, updatable = true)
    public int getBoneNumber() {
        return boneNumber;
    }

    public void setBoneNumber(int boneNumber) {
        this.boneNumber = boneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BoneSet boneSet = (BoneSet) o;

        if (boneNumber != boneSet.boneNumber) return false;
        if (idBoneSet != boneSet.idBoneSet) return false;
        if (category != null ? !category.equals(boneSet.category) : boneSet.category != null) return false;
        if (description != null ? !description.equals(boneSet.description) : boneSet.description != null) return false;
        if (synonymous != null ? !synonymous.equals(boneSet.synonymous) : boneSet.synonymous != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idBoneSet;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (synonymous != null ? synonymous.hashCode() : 0);
        result = 31 * result + boneNumber;
        return result;
    }
}
