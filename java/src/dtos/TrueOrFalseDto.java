package src.dtos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafaganabreu on 09/12/14.
 */
public class TrueOrFalseDto {
    public byte correctAnswer;
    public String figure;
    public String statement;
    public List<Integer> categories = new ArrayList<>();

    public TrueOrFalseDto() {}
}
