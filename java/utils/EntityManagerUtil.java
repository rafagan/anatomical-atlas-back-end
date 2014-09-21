package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
    private static EntityManagerFactory emf;
    public static EntityManager getEntityManager(String dbName) {
        if (emf == null){
            emf = Persistence.createEntityManagerFactory(dbName);
        }
        return emf.createEntityManager();
    }

    public static void closeFactiory() {
        emf.close();
        emf = null;
    }
}