package dtos;

import java.util.List;

/**
 * Created by rafaganabreu on 09/12/14.
 */
public class TrueOrFalseDto {
    public byte correctAnswer;
    public byte[] figure;
    public String statement;
    public List<Integer> categories;

    public TrueOrFalseDto() {}
}
