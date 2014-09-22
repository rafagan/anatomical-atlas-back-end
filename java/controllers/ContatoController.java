package controllers;

import dao.ContatoDao;
import dao.DaoManager;
import models.ContatoModel;
import utils.EntityManagerUtil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ContatoController {
    private Date formatarData(String data) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return new Date( formatter.parse(data).getTime() );
    }

    public void salvar(String nome, String apelido, String dtNascimento) throws Exception {
        ContatoModel contatoModel = new ContatoModel();
        contatoModel.setNome(nome);
        contatoModel.setApelido(apelido);
        contatoModel.setDtNascimento(formatarData(dtNascimento));

        new ContatoDao(new DaoManager().startConnection(EntityManagerUtil.ATLAS_PU)).salvar(contatoModel);
    }

    public void alterar(long id, String nome, String apelido, String dtNascimento) throws Exception {
        ContatoModel contatoModel = new ContatoModel();
        contatoModel.setId(id);
        contatoModel.setNome(nome);
        contatoModel.setApelido(apelido);
        contatoModel.setDtNascimento(formatarData(dtNascimento));

        new ContatoDao(new DaoManager().startConnection(EntityManagerUtil.ATLAS_PU)).alterar(contatoModel);
    }

    public List<ContatoModel> listaContatos() {
        return null;
    }

    public void excluir(int id) throws Exception {
        new ContatoDao(new DaoManager().startConnection(EntityManagerUtil.ATLAS_PU)).excluir(id);
    }

    public ContatoModel buscaContatoPorNome(String nome) throws Exception {
        return null;
    }
}