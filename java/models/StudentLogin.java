package models;

import org.codehaus.jackson.annotate.JsonManagedReference;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * Created by rafaganabreu on 26/10/14.
 */
@Entity
public class StudentLogin extends Login {
    private Student owner;

    @OneToOne(mappedBy = "login")
    @JsonManagedReference
    public Student getOwner() {return owner;}
    public void setOwner(Student owner) {this.owner = owner;}

    @Override
    public boolean equals(Object o) {
        if(!super.equals(o)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();

        return result;
    }
}
