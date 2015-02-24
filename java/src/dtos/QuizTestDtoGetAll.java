package src.dtos;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rafaganabreu on 22/02/15.
 */
public class QuizTestDtoGetAll {
    private int idQuizTest;
    private int difficultLevel;
    private int maxQuestions;
    private String title;
    private Set<Integer> categories = new HashSet<>();

    public int getIdQuizTest() {return idQuizTest;}
    public void setIdQuizTest(int idQuizTest) {this.idQuizTest = idQuizTest;}

    public int getDifficultLevel() {return difficultLevel;}
    public void setDifficultLevel(int difficultLevel) {this.difficultLevel = difficultLevel;}

    public int getMaxQuestions() {return maxQuestions;}
    public void setMaxQuestions(int maxQuestions) {this.maxQuestions = maxQuestions;}

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}


    public Set<Integer> getCategories() {return categories;}
    public void setCategories(Set<Integer> categories) {this.categories = categories;}
}
