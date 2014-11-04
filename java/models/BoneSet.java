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
public class BoneSet {
    private int idBoneSet;
    private String category;
    private String description;
    private String synonymous;
    private int totalBones;

    private Set<Bone> boneChildren = new HashSet<>();
    private Set<BoneSet> boneSetChildren = new HashSet<>();
    private BoneSet parent;
    private Set<Question> relatedQuestions = new HashSet<>();

    @Id
    @Column(name = "idBoneSet", nullable = false, insertable = true, updatable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdBoneSet() {
        return idBoneSet;
    }
    public void setIdBoneSet(int idBoneSet) {
        this.idBoneSet = idBoneSet;
    }

    @OneToMany(mappedBy = "parentBoneSet")
    @JsonManagedReference
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Set<Bone> getBoneChildren() { return boneChildren; }
    public void setBoneChildren(Set<Bone> sonBones) { this.boneChildren = sonBones; }

    @OneToMany(mappedBy = "parent")
    @JsonManagedReference
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Set<BoneSet> getBoneSetChildren() { return boneSetChildren; }
    public void setBoneSetChildren(Set<BoneSet> sonBonesSets) { this.boneSetChildren = sonBonesSets; }

    @ManyToOne
    @JoinColumn(name="BoneSet_idParent")
    @JsonBackReference
    public BoneSet getParent() { return parent; }
    public void setParent(BoneSet parent) {
        this.parent = parent;
        if(parent != null)  parent.getBoneSetChildren().add(this);
    }

    @ManyToMany(mappedBy = "categories", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Set<Question> getRelatedQuestions() {return relatedQuestions;}
    public void setRelatedQuestions(Set<Question> relatedQuestions) {this.relatedQuestions = relatedQuestions;}

    @Basic
    @Column(name = "Category", nullable = false, insertable = true, updatable = true, length = 45)
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
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
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @Column(name = "Synonymous", nullable = true, insertable = true, updatable = true, length = 128)
    public String getSynonymous() {
        return synonymous;
    }
    public void setSynonymous(String synonymous) {
        this.synonymous = synonymous;
    }

    @Basic
    @Column(name = "BoneNumber", nullable = false, insertable = true, updatable = true)
    public int getTotalBones() {
        return totalBones;
    }
    public void setTotalBones(int boneNumber) {
        this.totalBones = boneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BoneSet boneSet = (BoneSet) o;
        if (idBoneSet != boneSet.idBoneSet) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idBoneSet;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (synonymous != null ? synonymous.hashCode() : 0);
        result = 31 * result + totalBones;
        result = 31 * result + (parent != null ? parent.getIdBoneSet() : 0);

        return result;
    }
}
