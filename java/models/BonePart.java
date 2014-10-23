package models;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Created by rafaganabreu on 21/09/14.
 */
@Entity
public class BonePart {
    private int idBonePart;
    private String description;
    private String name;
    private String synonymous;
    private Bone parentBone;

    @Id
    @Column(name = "idBonePart", nullable = false, insertable = true, updatable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdBonePart() {
        return idBonePart;
    }
    public void setIdBonePart(int idBonePart) { this.idBonePart = idBonePart; }

    @ManyToOne
    @JoinColumn(name="Bone_idBone")
    @JsonBackReference
    public Bone getParentBone() { return parentBone; }
    public void setParentBone(Bone parentBone) { this.parentBone = parentBone; }

    @Basic
    @Column(name = "Description", nullable = false, insertable = true, updatable = true)
    @Type(type="text")
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

        BonePart bonePart = (BonePart) o;

        if (idBonePart != bonePart.idBonePart) return false;
        if (description != null ? !description.equals(bonePart.description) : bonePart.description != null)
            return false;
        if (name != null ? !name.equals(bonePart.name) : bonePart.name != null) return false;
        if (synonymous != null ? !synonymous.equals(bonePart.synonymous) : bonePart.synonymous != null) return false;
        if (parentBone != null ? !parentBone.equals(bonePart.parentBone) : bonePart.parentBone != null) return false;


        return true;
    }

    @Override
    public int hashCode() {
        int result = idBonePart;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (synonymous != null ? synonymous.hashCode() : 0);
        result = 31 * result + (parentBone != null ? parentBone.getIdBone() : 0);
        return result;
    }
}
