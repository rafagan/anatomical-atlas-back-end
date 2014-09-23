package dao;

/**
 * Created by rafaganabreu on 23/09/14.
 */
public class AbstractDao {
    protected DaoManager dao = new DaoManager();

    public DaoManager getDao() {
        return dao;
    }
}
