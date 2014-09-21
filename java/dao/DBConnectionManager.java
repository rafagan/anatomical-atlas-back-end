package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by rafaganabreu on 25/07/14.
 */
public class DBConnectionManager {
    private EntityManagerFactory emf;
    private EntityManager em;

    public void startConnection(String persistenceUnitName) {
        if(emf == null && em == null) {
            emf = Persistence.createEntityManagerFactory(persistenceUnitName);
            em = emf.createEntityManager();
        }
    }

    public void insertObject(Object obj) {
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
    }

    public Object findObject(Class clss, long id) {
        em.getTransaction().begin();
        Object obj = em.find(clss,id);
        em.getTransaction().commit();

        return obj;
    }

    public void removeObject(Class clss, long id) {
        em.getTransaction().begin();
        Object obj = em.find(clss,id);
        em.remove(obj);
        em.getTransaction().commit();
    }

    public void changeOrInsertObject(Object obj) {
        em.getTransaction().begin();
        em.merge(obj);
        em.getTransaction().commit();
    }

    public void closeConnection() {
        em.close();
        emf.close();
        em = null;
        emf = null;
    }
}
