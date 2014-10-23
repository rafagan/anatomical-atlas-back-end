package models;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by rafaganabreu on 21/09/14.
 */
@Entity
public class Bone {
    private int idBone;
    private String description;
    private String name;
    private String synonymous;

    private Set<BonePart> boneParts = new HashSet<BonePart>();
    private Set<Bone> neighbors = new HashSet<Bone>();
    private BoneSet parentBoneSet;

    @Id
    @Column(name = "idBone", nullable = false, insertable = true, updatable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdBone() {
        return idBone;
    }
    public void setIdBone(int idBone) {
        this.idBone = idBone;
    }

    @OneToMany(mappedBy="parentBone")
    @JsonManagedReference
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Set<BonePart> getBoneParts() { return boneParts; }
    public void setBoneParts(Set<BonePart> boneParts) { this.boneParts = boneParts; }

    @ManyToMany
    @JoinTable(
            name="BoneHasBone",
            joinColumns={@JoinColumn(name="Bone_idBone")},
            inverseJoinColumns={@JoinColumn(name="Bone_idNeighbor")}
    )
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Set<Bone> getNeighbors() { return neighbors; }
    public void setNeighbors(Set<Bone> neighbors) { this.neighbors = neighbors; }

    @ManyToOne
    @JoinColumn(name="BoneSet_idBoneSet")
    @JsonBackReference
    public BoneSet getParentBoneSet() { return parentBoneSet; }
    public void setParentBoneSet(BoneSet parent) { this.parentBoneSet = parent; }

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

        Bone bone = (Bone) o;

        if (idBone != bone.idBone) return false;
        if (description != null ? !description.equals(bone.description) : bone.description != null) return false;
        if (name != null ? !name.equals(bone.name) : bone.name != null) return false;
        if (synonymous != null ? !synonymous.equals(bone.synonymous) : bone.synonymous != null) return false;
        if (parentBoneSet != null ? !parentBoneSet.equals(bone.parentBoneSet) : bone.parentBoneSet != null) return false;
        if(boneParts != null ? !boneParts.equals(bone.boneParts) : bone.boneParts != null) return false;
        if(neighbors != null ? !neighbors.equals(bone.neighbors) : bone.neighbors != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idBone;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (synonymous != null ? synonymous.hashCode() : 0);
        result = 31 * result + (parentBoneSet != null ? parentBoneSet.getIdBoneSet() : 0);

        if(boneParts != null)
            for(BonePart p : boneParts)
                result = 31 * result + p.getIdBonePart();
        if(neighbors != null)
            for(Bone b : neighbors)
                result = 31 * result + b.getIdBone();

        return result;
    }
}
