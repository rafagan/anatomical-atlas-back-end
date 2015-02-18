package src.models;

import org.codehaus.jackson.annotate.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by rafaganabreu on 01/10/14.
 */
@Entity
public class TeacherClass extends Clazz {
    Teacher creator;

    @ManyToOne
    @JoinColumn(name="Teacher_idTeacher")
    @JsonBackReference
    public Teacher getCreator() { return creator; }
    public void setCreator(Teacher creator) {
        this.creator = creator;
        if(creator != null) {
            creator.getOwnerOfClasses().add(this);
            creator.addMonitoratedClasses(this);
        }
    }

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
