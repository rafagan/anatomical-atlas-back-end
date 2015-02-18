package src.dao;

import javax.persistence.EntityManager;

/**
 * Created by rafaganabreu on 23/09/14.
 */
//Dou essa volta para evitar acoplamento de um gerenciador de conexões com o banco e os filhos de AbstractDao
public class AbstractDao {
    protected DaoManager dao = new DaoManager();

    public DaoManager get() {
        return dao;
    }
    public EntityManager getEM() { return dao.getEntityManager(); }
}
