package utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by rafaganabreu on 29/10/14.
 */
public class testAuthentication {
    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    @Test
    public void testHash() {
        Hash h = Hash.MD5;
        String passwordHash = h.diggest("password");
        String passwordHash2 = h.diggest("Rodolpho");
        System.out.println(passwordHash + " " + passwordHash2);
    }

    public enum Hash {
        MD5("MD5"), SHA1("SHA-1"), SHA256("SHA-256");

        private String choose;

        private Hash(String choose) {
            this.choose = choose;
        }

        public byte[] diggest(byte[] dados) {
            try {
                MessageDigest algorithm = MessageDigest.getInstance(choose);
                return algorithm.digest(dados);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException("Unable to generate password!", e);
            }
        }

        public String diggest(String valor) {
            return byteArrayToString(diggest(stringToByteArray(valor)));
        }

        private String byteArrayToString(byte[] byteArray) {
            StringBuilder sb = new StringBuilder();
            for (byte b : byteArray) {
                int value = b & 0xFF;
                if (value < 16)
                    sb.append("0");
                sb.append(Integer.toString(value, 16));
            }
            return sb.toString();
        }

        private byte[] stringToByteArray(String valor) {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            try (DataOutputStream dos = new DataOutputStream(bos)) {
                dos.writeUTF(valor);
            } catch (Exception e) {
                assert (false); // Nunca ocorre com ByteArrays
            }
            return bos.toByteArray();
        }
    }
}
