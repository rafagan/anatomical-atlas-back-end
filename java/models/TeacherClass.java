package models;

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
    public void setCreator(Teacher creator) { this.creator = creator; }
}
