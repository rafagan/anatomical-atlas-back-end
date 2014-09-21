package models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by rafaganabreu on 21/09/14.
 */
@Entity
public class Bone {
    private int idBone;
    private String description;
    private String name;
    private String synonymous;

    @Id
    @Column(name = "idBone", nullable = false, insertable = true, updatable = true)
    public int getIdBone() {
        return idBone;
    }

    public void setIdBone(int idBone) {
        this.idBone = idBone;
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
    @Column(name = "Name", nullable = false, insertable = true, updatable = true, length = 128)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Synonymous", nullable = true, insertable = true, updatable = true, length = 128)
    public String getSynonymous() {
        return synonymous;
    }

    public void setSynonymous(String synonymous) {
        this.synonymous = synonymous;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bone bone = (Bone) o;

        if (idBone != bone.idBone) return false;
        if (description != null ? !description.equals(bone.description) : bone.description != null) return false;
        if (name != null ? !name.equals(bone.name) : bone.name != null) return false;
        if (synonymous != null ? !synonymous.equals(bone.synonymous) : bone.synonymous != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idBone;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (synonymous != null ? synonymous.hashCode() : 0);
        return result;
    }
}
