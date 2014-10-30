import insert.InsertTest;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by rafaganabreu on 21/09/14.
 */
public class Main {
    public static void main(String[] args) {
        new Main().test();
    }

    void test() {
        //new InsertTest().run();

        System.out.println(new SimpleDateFormat("yyyy/MM/dd").format(new Date().getTime()));
    }
}