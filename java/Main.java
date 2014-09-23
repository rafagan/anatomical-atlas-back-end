import controllers.BoneController;
import models.Bone;
import models.UserModelExample;
import utils.EntityManagerUtil;

import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafaganabreu on 21/09/14.
 */

@Stateless
public class Main {
    public static void main(String[] args) {
        new Main().test();
    }

    void test() {
        JsonArrayBuilder builder = Json.createArrayBuilder();

        ArrayList<UserModelExample> users = new ArrayList<UserModelExample>();
        users.add(new UserModelExample());
        users.get(0).setEmail("rafagan@abreu.com");

        EntityManager em = EntityManagerUtil.pullEntityManager("AtlasPersistenceUnit");

        TypedQuery<UserModelExample> query = em.createQuery("SELECT u FROM UserModelExample u", UserModelExample.class);

        for (UserModelExample user : query.getResultList()) {
            builder.add(Json.createObjectBuilder().add("email",user.getEmail()));
        }

        JsonArray json = builder.build();
    }
}
