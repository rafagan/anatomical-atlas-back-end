package controllers.dto;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafaganabreu on 04/11/14.
 */
public class QuestionDto {
    private int id;
    private byte[] figure;
    private List<String> authorsName = new ArrayList<>();
    private List<Integer> authorsId = new ArrayList<>();

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public byte[] getFigure() {return figure;}
    public void setFigure(byte[] figure) {this.figure = figure;}

    public List<String> getAuthorsName() {return authorsName;}
    public void setAuthorsName(List<String> authorsName) {this.authorsName = authorsName;}

    public List<Integer> getAuthorsId() {return authorsId;}
    public void setAuthorsId(List<Integer> authorsId) {this.authorsId = authorsId;}
}
