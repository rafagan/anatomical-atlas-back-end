package services;

import models.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by rafaganabreu on 20/09/14.
 */
@Stateless
public class UserService {
    @PersistenceContext
    private EntityManager em;

    public List<User> getAll(){
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }
}
