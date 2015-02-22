package src.dtos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafaganabreu on 22/02/15.
 */
public class QuizTestDto {
    private int idQuizTest;
    private int difficultLevel;
    private int maxQuestions;
    private String title;
    private List<Integer> categories = new ArrayList<>();

    public int getIdQuizTest() {return idQuizTest;}
    public void setIdQuizTest(int idQuizTest) {this.idQuizTest = idQuizTest;}

    public int getDifficultLevel() {return difficultLevel;}
    public void setDifficultLevel(int difficultLevel) {this.difficultLevel = difficultLevel;}

    public int getMaxQuestions() {return maxQuestions;}
    public void setMaxQuestions(int maxQuestions) {this.maxQuestions = maxQuestions;}

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}


    public List<Integer> getCategories() {return categories;}
    public void setCategories(List<Integer> categories) {this.categories = categories;}
}
