package src.models;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by rafaganabreu on 21/09/14.
 */
@Entity
public class Bone {
    private int idBone;
    private String description;
    private String name;
    private String synonymous;
    private int totalBoneParts;

    private Set<BonePart> boneParts = new TreeSet<>(new BonePart.BonePartComparator());
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

    @OneToMany(mappedBy="parentBone", cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Set<BonePart> getBoneParts() { return boneParts; }
    public void setBoneParts(Set<BonePart> boneParts) {
        Hibernate.initialize(boneParts);
        this.boneParts = boneParts; }

    @ManyToMany
    @JoinTable(
            name="BoneHasBone",
            joinColumns={@JoinColumn(name="Bone_idBone")},
            inverseJoinColumns={@JoinColumn(name="Bone_idNeighbor")}
    )
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonManagedReference
    public Set<Bone> getNeighbors() { return neighbors; }
    public void setNeighbors(Set<Bone> neighbors) { this.neighbors = neighbors; }

    public void addNeighbor(Bone neighbor) {
        if(neighbor == null) return;

        neighbors.add(neighbor);
        neighbor.getNeighbors().add(this);
    }

    @ManyToOne
    @JoinColumn(name="BoneSet_idBoneSet")
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonBackReference
    public BoneSet getParentBoneSet() { return parentBoneSet; }
    public void setParentBoneSet(BoneSet parent) {
        this.parentBoneSet = parent;
        if(parent != null) parent.getBoneChildren().add(this);
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

    @Basic
    @Column(name = "BonePartNumber", nullable = true, insertable = true, updatable = true, columnDefinition="int default '0'")
    public int getTotalBoneParts() {
        return totalBoneParts;
    }
    public void setTotalBoneParts(int bonePartNumber) {
        this.totalBoneParts = bonePartNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bone bone = (Bone) o;
        if (idBone != bone.idBone) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idBone;
        result = 31 * result + totalBoneParts;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (synonymous != null ? synonymous.hashCode() : 0);
        result = 31 * result + (parentBoneSet != null ? parentBoneSet.getIdBoneSet() : 0);

        return result;
    }

    public static class BoneComparator implements Comparator<Bone> {
        @Override
        public int compare(Bone o1, Bone o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }
}
