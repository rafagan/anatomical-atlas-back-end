package src.models;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Comparator;

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
    public void setParentBone(Bone parentBone) {
        this.parentBone = parentBone;
        if(parentBone != null) parentBone.getBoneParts().add(this);
    }

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
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
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

        return true;
    }

    @Override
    public int hashCode() {
        int result = idBonePart;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (synonymous != null ? synonymous.hashCode() : 0);
        return result;
    }

    public static class BonePartComparator implements Comparator<BonePart> {
        @Override
        public int compare(BonePart o1, BonePart o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }
}
