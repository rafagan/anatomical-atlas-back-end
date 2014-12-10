package dtos;

import java.util.List;

/**
 * Created by rafaganabreu on 09/12/14.
 */
public class MultipleChoiceDto {
    public String figure;
    public String statement;
    public String correctAnswer;
    public String answerA;
    public String answerB;
    public String answerC;
    public String answerD;
    public String answerE;
    public List<Integer> categories;

    public MultipleChoiceDto() {}
}
