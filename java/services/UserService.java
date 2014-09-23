package services;

import models.UserModelExample;

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

    public List<UserModelExample> getAll(){
        TypedQuery<UserModelExample> query = em.createQuery("SELECT u FROM UserModelExample u", UserModelExample.class);
        return query.getResultList();
    }
}
