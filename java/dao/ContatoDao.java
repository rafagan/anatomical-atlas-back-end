package dao;

import models.ContatoModel;

public class ContatoDao {
    DaoManager dao;

    public ContatoDao(DaoManager dao) {
        this.dao = dao;
    }

    public void salvar(ContatoModel contatoModel) {
        dao.insertObject(contatoModel);
    }
    public void alterar(ContatoModel contatoModel) {
        dao.changeOrInsertObject(contatoModel);
    }
    public void excluir(int id) {
        dao.removeObject(ContatoModel.class,id);
    }
}
