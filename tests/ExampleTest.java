import org.junit.Test;

import static org.junit.Assert.assertEquals;


// http://www.vogella.com/tutorials/JUnit/article.html
/**
 * Created by rafaganabreu on 22/09/14.
 */
public class ExampleTest {
    @Test
    public void helloShouldBeSad() {
        String hello = "Hello World";
        assertEquals("Hello World",hello);
        //fail("Oi");
    }

    @Test
    public void byeShouldBeSad() {
        String hello = "Bye";
        assertEquals("Bye",hello);
        //fail("Oi");
    }
}
