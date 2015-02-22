package src.dtos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafaganabreu on 22/02/15.
 */
public class PublicQuizTestDto {
    private String title;
    private int difficult;
    private int maxQuestions;
    private boolean automatic;
    private List<Integer> questions = new ArrayList<>();

    public PublicQuizTestDto() {}

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public int getDifficult() {return difficult;}
    public void setDifficult(int difficult) {this.difficult = difficult;}

    public int getMaxQuestions() {return maxQuestions;}
    public void setMaxQuestions(int maxQuestions) {this.maxQuestions = maxQuestions;}

    public boolean isAutomatic() {return automatic;}
    public void setAutomatic(boolean automatic) {this.automatic = automatic;}

    public List<Integer> getQuestions() {return questions;}
    public void setQuestions(List<Integer> questions) {this.questions = questions;}
}
