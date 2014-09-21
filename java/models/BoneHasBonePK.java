package models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by rafaganabreu on 21/09/14.
 */
public class BoneHasBonePK implements Serializable {
    private int boneIdBone;
    private int boneIdNeighbor;

    @Column(name = "Bone_idBone", nullable = false, insertable = true, updatable = true)
    @Id
    public int getBoneIdBone() {
        return boneIdBone;
    }

    public void setBoneIdBone(int boneIdBone) {
        this.boneIdBone = boneIdBone;
    }

    @Column(name = "Bone_idNeighbor", nullable = false, insertable = true, updatable = true)
    @Id
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

        BoneHasBonePK that = (BoneHasBonePK) o;

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
