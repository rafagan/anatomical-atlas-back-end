import javax.ejb.Stateless;

/**
 * Created by rafaganabreu on 21/09/14.
 */

@Stateless
public class Main {
    public static void main(String[] args) {
        new Main().test();
    }

    void test() {
//        JsonArrayBuilder builder = Json.createArrayBuilder();
//
//        ArrayList<UserModelExample> users = new ArrayList<UserModelExample>();
//        users.add(new UserModelExample());
//        users.get(0).setEmail("rafagan@abreu.com");
//
//        EntityManager em = EntityManagerUtil.pullEntityManager("AtlasPersistenceUnit");
//
//        TypedQuery<UserModelExample> query = em.createQuery("SELECT u FROM UserModelExample u", UserModelExample.class);
//
//        for (UserModelExample user : query.getResultList()) {
//            builder.add(Json.createObjectBuilder().add("email",user.getEmail()));
//        }
//
//        JsonArray json = builder.build();
    }
}
