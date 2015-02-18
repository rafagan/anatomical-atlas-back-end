package src;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import src.dtos.Wrapper;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import src.utils.ImageUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by rafaganabreu on 21/09/14.
 */
public class Main {
    public static void main(String[] args) {
        new Main().test();
    }

    void test() {
        try {
            Client client = Client.create();
            WebResource webResource2 = client.resource("http://rafagan.com.br/api/questions/98305");
            ClientResponse response2 = webResource2.accept("application/json").get(ClientResponse.class);
            if (response2.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response2.getStatus());
            }

            String output2 = response2.getEntity(String.class);
            ObjectMapper mapper = new ObjectMapper();
            Wrapper map = mapper.readValue(output2,new TypeReference<Wrapper>(){});

            BufferedImage newImg = ImageUtils.decodeToImage(new String(map.result.getFigure()));
            System.out.println(newImg);
            File outputfile = new File("image.png");
            ImageIO.write(newImg, "png", outputfile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}