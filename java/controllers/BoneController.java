package controllers;

import dao.BoneDao;
import dao.ContatoDao;
import dao.DaoManager;
import models.Bone;
import models.ContatoModel;
import utils.EntityManagerUtil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by rafaganabreu on 22/09/14.
 */
public class BoneController {
    private BoneDao dao = new BoneDao();

    public List<Bone> getAllBones() {
        return dao.queryBones();
    }

    public Bone getBone(int id) {
        return dao.queryBone(id);
    }
}
