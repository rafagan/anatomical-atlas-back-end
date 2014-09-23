package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * Created by rafaganabreu on 21/09/14.
 */
@Entity
@IdClass(BoneHasBonePK.class)
public class BoneHasBone {
    private int boneIdBone;
    private int boneIdNeighbor;

    @Id
    @Column(name = "Bone_idBone", nullable = false, insertable = true, updatable = true)
    public int getBoneIdBone() {
        return boneIdBone;
    }
    public void setBoneIdBone(int boneIdBone) {
        this.boneIdBone = boneIdBone;
    }

    @Id
    @Column(name = "Bone_idNeighbor", nullable = false, insertable = true, updatable = true)
    public int getBoneIdNeighbor() {
        return boneIdNeighbor;
    }
    public void setBoneIdNeighbor(int boneIdNeighbor) {
        this.boneIdNeighbor = boneIdNeighbor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BoneHasBone that = (BoneHasBone) o;

        if (boneIdBone != that.boneIdBone) return false;
        if (boneIdNeighbor != that.boneIdNeighbor) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = boneIdBone;
        result = 31 * result + boneIdNeighbor;
        return result;
    }
}
