package resources;

import models.User;
import services.UserService;
import utils.EntityManagerUtil;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by rafaganabreu on 20/09/14.
 */
@Path("/users")
public class HelloDatabase {
    private UserService userService;

    @Path("/all")
    @GET
    @Produces("application/json")
    public JsonArray getAll() {
        JsonArrayBuilder builder = Json.createArrayBuilder();

        EntityManager em = EntityManagerUtil.pullEntityManager("TestPersistenceUnit");
        TypedQuery<User> query = em.createQuery("SELECT u FROM User AS u", User.class);

        for (User user : query.getResultList()) {
            builder.add(Json.createObjectBuilder().add("email",user.getEmail()));
        }

        em.close();

        return builder.build();
    }
}
