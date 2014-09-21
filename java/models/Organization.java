package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by rafaganabreu on 21/09/14.
 */
@Entity
public class Organization {
    private int idOrganization;

    @Id
    @Column(name = "idOrganization", nullable = false, insertable = true, updatable = true)
    public int getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(int idOrganization) {
        this.idOrganization = idOrganization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (idOrganization != that.idOrganization) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idOrganization;
    }
}
