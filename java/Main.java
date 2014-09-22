import controllers.BoneController;
import models.Bone;
import models.User;
import utils.EntityManagerUtil;
import utils.WebserviceResponseFactory;

import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafaganabreu on 21/09/14.
 */

@Stateless
public class Main {
    public static void main(String[] args) {
        new Main().testBoneQuery();
    }


    void testBoneQuery() {
        BoneController controller = new BoneController();
        List<Bone> bs = controller.getAllBones();
        Bone b = controller.getBone(1);
    }

    void test() {
        JsonArrayBuilder builder = Json.createArrayBuilder();

        ArrayList<User> users = new ArrayList<User>();
        users.add(new User());
        users.get(0).setEmail("rafagan@abreu.com");

        EntityManager em = EntityManagerUtil.pullEntityManager("AtlasPersistenceUnit");

        TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);

        for (User user : query.getResultList()) {
            builder.add(Json.createObjectBuilder().add("email",user.getEmail()));
        }

        JsonArray json = builder.build();
    }
}
