package dao;

import src.utils.EntityManagerUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

/**
 * Created by rafaganabreu on 25/07/14.
 */
public class DaoManager {
    private EntityManager em;

    public DaoManager startConnection(String persistenceUnitName) {
        if(em != null)
            closeConnection();
        em = EntityManagerUtil.pullEntityManager(persistenceUnitName);

        return this;
    }

    public EntityManager getEntityManager() {
        return em;
    }
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    public DaoManager insertObject(Object obj) {
        EntityTransaction tx = getEntityManager().getTransaction();
        try {
            tx.begin();
            getEntityManager().persist(obj);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        }

        return this;
    }

    public Object findObject(Class clss, int id) {
        Object obj = null;
        EntityTransaction tx = getEntityManager().getTransaction();
        try {
            tx.begin();
            obj = em.find(clss,id);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        }

        return obj;
    }

    public <T> T findEntity(Class<T> clss, String queryString, Map<String, T> parameters) {
        TypedQuery<T> query = getEntityManager().createQuery(queryString, clss);

        for(Map.Entry<String, T> item : parameters.entrySet()) {
            query.setParameter(item.getKey(),item.getValue());
        }

        T entity = null;
        try {
            entity = query.getSingleResult();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return entity;
    }

    public <T> T findEntity(TypedQuery<T> query) {
        T entity = null;
        try {
            entity = query.getSingleResult();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return entity;
    }

    public <T> List<T> findEntities(Class<T> clss, String queryString, Map<String, T> parameters) {
        TypedQuery<T> query = getEntityManager().createQuery(queryString, clss);

        for(Map.Entry<String, T> item : parameters.entrySet()) {
            query.setParameter(item.getKey(),item.getValue());
        }

        List<T> entities = null;
        try {
            entities = query.getResultList();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return entities;
    }

    public <T> List<T> findEntities(TypedQuery<T> query) {
        List<T> entities = null;
        try {
            entities = query.getResultList();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return entities;
    }

    public DaoManager removeObject(Class clss, int id) {
        EntityTransaction tx = getEntityManager().getTransaction();
        try {
            tx.begin();
            Object obj = em.find(clss,id);
            em.remove(obj);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        }

        return this;
    }

    protected DaoManager removeObject(Object obj) {
        EntityTransaction tx = getEntityManager().getTransaction();
        try {
            tx.begin();
            getEntityManager().remove(obj);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        }

        return this;
    }

    public DaoManager changeOrInsertObject(Object obj) {
        EntityTransaction tx = getEntityManager().getTransaction();
        try {
            tx.begin();
            getEntityManager().merge(obj);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        }

        return this;
    }

    public DaoManager closeConnection() {
        if (getEntityManager().isOpen())
            em.close();
        em = null;

        return this;
    }
}
