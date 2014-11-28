import com.sun.javaws.exceptions.InvalidArgumentException;
import utils.DummyInsertion;
import utils.PasswordHash;
import utils.Sha256SaltAuth;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by rafaganabreu on 21/09/14.
 */
public class Main {
    public static void main(String[] args) {
        new Main().test();
    }

    void test() {
        new DummyInsertion().run();
    }
}