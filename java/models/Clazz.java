package models;

import javax.persistence.*;

/**
 * Created by rafaganabreu on 21/09/14.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "Class", schema = "", catalog = "AnatomicalAtlas")
public abstract class Clazz {
    private int idClass;
    private String name;

    @Id
    @Column(name = "idClass", nullable = false, insertable = true, updatable = true)
    @GeneratedValue(strategy = GenerationType.TABLE)
    public int getIdClass() {
        return idClass;
    }
    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    @Basic
    @Column(name = "Name", nullable = false, insertable = true, updatable = true, length = 128)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

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
        int result = idClass;
        result = 31 * result + (name != null ? name.hashCode() : 0);

        return result;
    }
}
