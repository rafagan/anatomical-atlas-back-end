package models;

import javax.persistence.*;

/**
 * Created by rafaganabreu on 21/09/14.
 */
@Entity
@Table(name = "Class", schema = "", catalog = "AnatomicalAtlas")
public class Clazz {
    private int idClass;

    @Id
    @Column(name = "idClass", nullable = false, insertable = true, updatable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Clazz clazz = (Clazz) o;

        if (idClass != clazz.idClass) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idClass;
    }
}
