import models.User;
import services.UserService;
import utils.EntityManagerUtil;

import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;

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

        ArrayList<User> users = new ArrayList<User>();
        users.add(new User());
        users.get(0).setEmail("rafagan@abreu.com");

        EntityManager em = EntityManagerUtil.getEntityManager("AtlasPersistenceUnit");

        TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);

        for (User user : query.getResultList()) {
            builder.add(Json.createObjectBuilder().add("email",user.getEmail()));
        }

        JsonArray json = builder.build();
    }
}
