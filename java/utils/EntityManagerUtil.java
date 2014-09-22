package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
    public static String ATLAS_PU = "AtlasPersistenceUnit";

    private static EntityManagerFactory emf;
    public static EntityManager pullEntityManager(String persistenceUnitName) {
        if (emf == null){
            emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        }
        return emf.createEntityManager();
    }

    public static void closeFactiory() {
        emf.close();
        emf = null;
    }
}