package src.dtos;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafaganabreu on 04/11/14.
 */
public class QuestionDto {
    private int idQuestion;
    private byte[] figure;
    private List<String> authorsName = new ArrayList<>();
    private List<Integer> authorsId = new ArrayList<>();
    private String statement;

    //TF
    private byte correctAnswerB;

    //MC
    private String correctAnswer;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String answerE;

    public int getId() {return idQuestion;}
    public void setId(int id) {this.idQuestion = id;}

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    //@JsonIgnore
    public byte[] getFigure() {return figure;}
    public void setFigure(byte[] figure) {this.figure = figure;}

    public List<String> getAuthorsName() {return authorsName;}
    public void setAuthorsName(List<String> authorsName) {this.authorsName = authorsName;}

    public List<Integer> getAuthorsId() {return authorsId;}
    public void setAuthorsId(List<Integer> authorsId) {this.authorsId = authorsId;}

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String getCorrectAnswer() {return correctAnswer;}
    public void setCorrectAnswer(String correctAnswer) {this.correctAnswer = correctAnswer;}

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public byte getCorrectAnswerB() {return correctAnswerB;}
    public void setCorrectAnswerB(byte correctAnswerB) {this.correctAnswerB = correctAnswerB;}

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String getStatement() {return statement;}
    public void setStatement(String statement) {this.statement = statement;}

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String getAnswerA() {return answerA;}
    public void setAnswerA(String answerA) {this.answerA = answerA;}

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String getAnswerB() {return answerB;}
    public void setAnswerB(String answerB) {this.answerB = answerB;}

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String getAnswerC() {return answerC;}
    public void setAnswerC(String answerC) {this.answerC = answerC;}

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String getAnswerD() {return answerD;}
    public void setAnswerD(String answerD) {this.answerD = answerD;}

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String getAnswerE() {return answerE;}
    public void setAnswerE(String answerE) {this.answerE = answerE;}
}
