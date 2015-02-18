package src.models;

import org.codehaus.jackson.annotate.JsonManagedReference;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * Created by rafaganabreu on 26/10/14.
 */
@Entity
public class TeacherLogin extends Login {
    private Teacher owner;

    @OneToOne(mappedBy = "login")
    @JsonManagedReference
    public Teacher getOwner() {return owner;}
    public void setOwner(Teacher owner) {this.owner = owner;}

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
